package com.project.conf_res.controller;

import com.project.conf_res.ConfRoomService;
import com.project.conf_res.entity.ConfRoom;
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

    @RequestMapping("/to_add")
    public String to_add(Map<String, Object> map) {
        map.put("ROOM", new ConfRoom()); //与下面add函数参数名称保持一致
        return "confroom_add.jsp";
    }

    @RequestMapping("/add")
    public String add(ConfRoom ROOM) {
//        ConfRoom confRoom = new ConfRoom();
//        confRoom.setName((String) ROOM.get("name"));
//        confRoom.setMember((Integer) ROOM.get("member"));
//        confRoom.setLocation((String) ROOM.get("location"));
//        confRoom.setState("开放");
        ROOM.setState("开放");
        this.confRoomService.add(ROOM); //与上面传入jsp页面的参数名称保持一致
        return "redirect:list";
    }
}
