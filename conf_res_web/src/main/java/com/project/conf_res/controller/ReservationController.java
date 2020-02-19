package com.project.conf_res.controller;

import com.project.conf_res.AuditLogService;
import com.project.conf_res.ConfRoomService;
import com.project.conf_res.ReservationService;
import com.project.conf_res.entity.AuditLog;
import com.project.conf_res.entity.Reservation;
import com.project.conf_res.entity.User;
import com.project.conf_res.global.Contant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller("reservationController")
@RequestMapping("/reservation")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;
    @Autowired
    private ConfRoomService confRoomService;
    @Autowired
    private AuditLogService auditLogService;

    @RequestMapping("/administrator_table")
    public String administratorTable(Map<String, Object> map) {
        return "reservation_administrator_table.jsp";
    }

    @RequestMapping("/user_table")
    public String userTable(Map<String, Object> map) {
        return "reservation_user_table.jsp";
    }

    @RequestMapping("/user_list")
    public String user_list(HttpSession session, Map<String, Object> map) {
        map.put("LIST", this.reservationService.getByUid(((User) session.getAttribute("USER")).getId()));
        return "reservation_user_list.jsp";
    }

    @RequestMapping(value = "/to_add", params = "id")
    public String toAdd(int id, HttpSession session, Map<String, Object> map) {
        if (map.get("RESERVATION") == null) {
            Reservation reservation = new Reservation();
            reservation.setRid(id);
            reservation.setRoom(this.confRoomService.getById(id));
            map.put("RESERVATION", reservation);
            map.put("TIME", Contant.getTime());
        }
        return "reservation_add.jsp";
    }

    @RequestMapping("/add")
    public String add(HttpSession session, @Valid Reservation RESERVATION, BindingResult result, RedirectAttributes model) {
        List<String> msgList = new ArrayList<>();
        if (result.hasErrors()) {
            List<FieldError> errList = result.getFieldErrors();
            for (int i = 0; i < errList.size(); ++i) {
                msgList.add(errList.get(i).getDefaultMessage());
            }
            model.addFlashAttribute("MESSAGE", msgList);
            return "redirect:/reservation/to_add?id=" + RESERVATION.getRid();
        } else if (!this.reservationService.getExist(RESERVATION.getDate(), RESERVATION.getTime()).isEmpty()) {
            msgList.add("请选择其他时段");
            model.addFlashAttribute("MESSAGE", msgList);
            return "redirect:/reservation/to_add?id=" + RESERVATION.getRid();
        } else {
            RESERVATION.setUser((User) session.getAttribute("USER"));
            RESERVATION.setUid(RESERVATION.getUser().getId());
            this.reservationService.add(RESERVATION);
            msgList.add("已提交申请");
            model.addFlashAttribute("MESSAGE", msgList);
            return "redirect:/reservation/user_list";
        }
    }

    @RequestMapping(value = "/to_edit", params = "id")
    public String toEdit(int id, Map<String, Object> map) {
        Reservation reservation = this.reservationService.getById(id);
        reservation.setRoom(this.confRoomService.getById(reservation.getRid()));
        map.put("RESERVATION", reservation);
        map.put("TIME", Contant.getTime());
        return "reservation_edit.jsp";
    }

    @RequestMapping("/edit")
    public String edit(HttpSession session, @Valid Reservation RESERVATION, BindingResult result, RedirectAttributes model) {
        List<String> msgList = new ArrayList<>();
        if (result.hasErrors()) {
            List<FieldError> errList = result.getFieldErrors();
            for (int i = 0; i < errList.size(); ++i) {
                msgList.add(errList.get(i).getDefaultMessage());
            }
            model.addFlashAttribute("MESSAGE", msgList);
            return "redirect:/reservation/to_edit?id=" + RESERVATION.getRid();
        } else if (!this.reservationService.getExist(RESERVATION.getDate(), RESERVATION.getTime()).isEmpty()) {
            msgList.add("请选择其他时段");
            model.addFlashAttribute("MESSAGE", msgList);
            return "redirect:/reservation/to_edit?id=" + RESERVATION.getRid();
        } else {
            RESERVATION.setUser((User) session.getAttribute("USER"));
            RESERVATION.setUid(RESERVATION.getUser().getId());
            this.reservationService.edit(RESERVATION);
            msgList.add("已修改申请");
            model.addFlashAttribute("MESSAGE", msgList);
            return "redirect:/reservation/user_list";
        }
    }

    @RequestMapping(value = "/user_detail", params = "id")
    public String user_detail(int id, Map<String, Object> map) {
        Reservation reservation = this.reservationService.getById(id);
        reservation.setRoom(this.confRoomService.getById(reservation.getRid()));
        AuditLog auditLog = this.auditLogService.getById(reservation.getRid());
        map.put("RESERVATION", reservation);
        map.put("AUDITLOG", auditLog);
        return "reservation_user_detail.jsp";
    }

    @RequestMapping(value = "/remove", params = "id")
    public String remove(int id) {
        this.reservationService.remove(id);
        return "redirect:/reservation/user_list";
    }

    @RequestMapping("/pending")
    public String pending(Map<String, Object> map) {
        map.put("LIST", this.reservationService.getPending());
        return "reservation_administrator_pending.jsp";
    }

    @RequestMapping("/administrator_list")
    public String administrator_list(Map<String, Object> map) {
        map.put("LIST", this.reservationService.getAll());
        return "reservation_administrator_list.jsp";
    }

    @RequestMapping(value = "/administrator_detail", params = "rid")
    public String administrator_detail(int rid, Map<String, Object> map) {
        Reservation reservation = this.reservationService.getById(rid);
        reservation.setRoom(this.confRoomService.getById(reservation.getRid()));
        map.put("RESERVATION", reservation);
        return "reservation_administrator_detail.jsp";
    }
}
