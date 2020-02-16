package com.project.conf_res.controller;

import com.project.conf_res.ConfRoomService;
import com.project.conf_res.ReservationService;
import com.project.conf_res.entity.ConfRoom;
import com.project.conf_res.entity.Reservation;
import com.project.conf_res.global.Contant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Controller("restfulController")
public class RestfulController {
    @Autowired
    private ConfRoomService confRoomService;
    @Autowired
    private ReservationService reservationService;


    @RequestMapping("/reservation_list/{room_name}/{week}")
    public List<Reservation> list(@PathVariable("room_name") String roomName, @PathVariable("week") String week) {
        int roomId = this.confRoomService.getByName(roomName).getId();
        int weekId = Integer.parseInt(week); //0、1、2、3
        return this.reservationService.getForTable(roomId, weekId);
    }

    @RequestMapping("/confroom_list")
    public List<ConfRoom> confRoomList() {
        return this.confRoomService.getAllOpen();
    }

    @RequestMapping("/week_list")
    public List<String> weekList() {
        return Contant.getWeek();
    }
}
