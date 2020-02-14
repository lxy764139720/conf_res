package com.project.conf_res.controller;

import com.project.conf_res.AuditLogService;
import com.project.conf_res.ReservationService;
import com.project.conf_res.entity.Administrator;
import com.project.conf_res.entity.AuditLog;
import com.project.conf_res.entity.Reservation;
import com.project.conf_res.global.Contant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
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

    @RequestMapping(value = "/pass", params = "id")
    public String pass(HttpSession session, int id, AuditLog auditLog) {
        Reservation reservation = this.reservationService.getById(id);
        reservation.setState(Contant.AUDIT_RESULT_PASS);
        this.reservationService.edit(reservation);
        auditLog.setUid(reservation.getUid());
        auditLog.setRid(reservation.getRid());
        auditLog.setAid(((Administrator) session.getAttribute("ADMINISTRATOR")).getId());
        auditLog.setAuditResult(Contant.AUDIT_RESULT_PASS);
        if (auditLog.getInfo() == null) {
            auditLog.setInfo("无");
        }
        this.auditLogService.add(auditLog);
        return "redirect:/audit/list";
    }

    @RequestMapping(value = "/reject", params = "id")
    public String reject(HttpSession session, int id, AuditLog auditLog) {
        Reservation reservation = this.reservationService.getById(id);
        reservation.setState(Contant.AUDIT_RESULT_REJECT);
        this.reservationService.edit(reservation);
        auditLog.setUid(reservation.getUid());
        auditLog.setRid(reservation.getRid());
        auditLog.setAid(((Administrator) session.getAttribute("ADMINISTRATOR")).getId());
        auditLog.setAuditResult(Contant.AUDIT_RESULT_REJECT);
        if (auditLog.getInfo() == null) {
            auditLog.setInfo("无");
        }
        this.auditLogService.add(auditLog);
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
