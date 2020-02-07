package com.project.conf_res.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("reservationController")
@RequestMapping("/reservation")
public class ReservationController {

    @RequestMapping("/administrator_table")
    public String administratorTable() {
        return "reservation_administrator_table.jsp";
    }

    @RequestMapping("/user_table")
    public String userTable() {
        return "reservation_user_table.jsp";
    }
}
