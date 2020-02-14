package com.project.conf_res.controller;

import com.project.conf_res.AuditLogService;
import com.project.conf_res.ConfRoomService;
import com.project.conf_res.ReservationService;
import com.project.conf_res.entity.AuditLog;
import com.project.conf_res.entity.ConfRoom;
import com.project.conf_res.entity.Reservation;
import com.project.conf_res.entity.User;
import com.project.conf_res.global.Contant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
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
    public String administratorTable() {
        return "reservation_administrator_table.jsp";
    }

    @RequestMapping("/user_table")
    public String userTable() {
        return "reservation_user_table.jsp";
    }

    @RequestMapping("/user_list")
    public String user_list(Map<String, Object> map) {
        map.put("LIST", this.reservationService.getAll());
        return "reservation_user_list.jsp";
    }

    @RequestMapping("/to_confroom")
    public String toConfRoom(Map<String, Object> map) {
        map.put("LIST", this.confRoomService.getAll());
        return "confroom_user_list.jsp";
    }

    @RequestMapping(value = "/to_add", params = "id")
    public String toAdd(int id, HttpSession session, Map<String, Object> map) {
        Reservation reservation = new Reservation();
        reservation.setRid(id);
        reservation.setRoom(this.confRoomService.get(id));
        map.put("RESERVATION", reservation);
        map.put("TIME", Contant.getTime());
        return "reservation_add.jsp";
    }

    @RequestMapping("/add")
    public String add(HttpSession session, Reservation RESERVATION) {
        RESERVATION.setUser((User) session.getAttribute("USER"));
        RESERVATION.setUid(RESERVATION.getUser().getId());
        this.reservationService.add(RESERVATION);
        return "redirect:/reservation/user_list";
    }

    @RequestMapping(value = "/to_edit", params = "id")
    public String toEdit(int id, Map<String, Object> map) {
        Reservation reservation = this.reservationService.getById(id);
        reservation.setRoom(this.confRoomService.get(reservation.getRid()));
        map.put("RESERVATION", reservation);
        map.put("TIME", Contant.getTime());
        return "reservation_edit.jsp";
    }

    @RequestMapping(value = "/user_detail", params = "id")
    public String user_detail(int id, Map<String, Object> map) {
        Reservation reservation = this.reservationService.getById(id);
        reservation.setRoom(this.confRoomService.get(reservation.getRid()));
        AuditLog auditLog = this.auditLogService.getById(reservation.getRid());
        map.put("RESERVATION", reservation);
        map.put("AUDITLOG", auditLog);
        return "reservation_user_detail.jsp";
    }

    @RequestMapping("/edit")
    public String edit(HttpSession session, Reservation RESERVATION) {
        this.reservationService.edit(RESERVATION);
        return "redirect:/reservation/list";
    }

    @RequestMapping(value = "/remove", params = "id")
    public String remove(int id) {
        this.reservationService.remove(id);
        return "redirect:/reservation/list";
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

    @RequestMapping(value = "/administrator_detail", params = "id")
    public String administrator_detail(int id, Map<String, Object> map) {
        Reservation reservation = this.reservationService.getById(id);
        reservation.setRoom(this.confRoomService.get(reservation.getRid()));
        map.put("RESERVATION", reservation);
        map.put("AUDITLOG", new AuditLog());
        return "reservation_administrator_detail.jsp";
    }
}
