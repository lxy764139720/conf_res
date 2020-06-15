package com.project.conf_res.controller;

import com.project.conf_res.AuditLogService;
import com.project.conf_res.ReservationService;
import com.project.conf_res.entity.Administrator;
import com.project.conf_res.entity.AuditLog;
import com.project.conf_res.entity.Reservation;
import com.project.conf_res.global.Contant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Controller("auditController")
@RequestMapping("/audit")
public class AuditController {
    @Autowired
    private ReservationService reservationService;
    @Autowired
    private AuditLogService auditLogService;

    @RequestMapping("/list")
    public String list(Map<String, Object> map) {
        map.put("LIST", this.auditLogService.getAll());
        return "auditLog_list.jsp";
    }

    private void audit(HttpSession session, int rid, String info, String result) {
        Reservation reservation = this.reservationService.getById(rid);
        reservation.setState(result);
        this.reservationService.edit(reservation);
        AuditLog auditLog = new AuditLog();
        auditLog.setUid(reservation.getUid());
        auditLog.setRid(reservation.getId());
        auditLog.setAid(((Administrator) session.getAttribute("ADMINISTRATOR")).getId());
        auditLog.setAuditResult(result);
        auditLog.setInfo(info);
        this.auditLogService.add(auditLog);
        if (result.equals(Contant.AUDIT_RESULT_PASS)) {
            List<Reservation> reservations = this.reservationService.getOtherPending(rid);
            for (int i = 0; i < reservations.size(); i++) {
                Reservation r = reservations.get(i);
                r.setState(Contant.AUDIT_RESULT_REJECT);
                this.reservationService.edit(r);
                AuditLog a = new AuditLog();
                a.setUid(r.getUid());
                a.setRid(r.getId());
                a.setAid(((Administrator) session.getAttribute("ADMINISTRATOR")).getId());
                a.setAuditResult(Contant.AUDIT_RESULT_REJECT);
                a.setInfo("已通过其他预约，自动拒绝");
                this.auditLogService.add(a);
            }
        }
    }

    @PostMapping("/pass")
    public String postPass(HttpSession session, int rid, @RequestParam(defaultValue = "无") String info) {
        this.audit(session, rid, info, Contant.AUDIT_RESULT_PASS);
        return "redirect:/audit/list";
    }

    @PostMapping("/reject")
    public String postReject(HttpSession session, int rid, @RequestParam(defaultValue = "无") String info) {
        this.audit(session, rid, info, Contant.AUDIT_RESULT_REJECT);
        return "redirect:/audit/list";
    }

    @GetMapping(value = "/pass", params = "rid")
    public String getPass(HttpSession session, int rid) {
        this.audit(session, rid, "无", Contant.AUDIT_RESULT_PASS);
        return "redirect:/audit/list";
    }

    @GetMapping(value = "/reject", params = "rid")
    public String getReject(HttpSession session, int rid) {
        this.audit(session, rid, "无", Contant.AUDIT_RESULT_REJECT);
        return "redirect:/audit/list";
    }

    @RequestMapping("/remove")
    public String remove() {
        this.reservationService.removeOverdue();
        return "redirect:/audit/list";
    }

    @RequestMapping(value = "/detail", params = "id")
    public String detail(int id, Map<String, Object> map) {
        map.put("AUDITLOG", this.auditLogService.getById(id));
        return "auditLog_detail.jsp";
    }

}
