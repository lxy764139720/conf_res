package com.project.conf_res.controller;

import com.project.conf_res.ConfRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller("confRoomController")
@RequestMapping("/confroom")
public class ConfRoomController {
    @Autowired
    private ConfRoomService confRoomService;

    @RequestMapping("/list")
    public String list(Map<String, Object> map) {
        map.put("LIST", this.confRoomService.getAll());
        return "confroom_list.jsp";
    }
}
