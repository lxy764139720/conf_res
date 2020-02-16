package com.project.conf_res.controller;

import com.project.conf_res.ConfRoomService;
import com.project.conf_res.entity.ConfRoom;
import com.project.conf_res.global.Contant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller("confRoomController")
@RequestMapping("/confroom")
public class ConfRoomController {
    @Autowired
    private ConfRoomService confRoomService;

    @RequestMapping("/administrator_list")
    public String administratorList(Map<String, Object> map) {
        map.put("LIST", this.confRoomService.getAll());
        return "confroom_administrator_list.jsp";
    }

    @RequestMapping("/user_list")
    public String userList(Map<String, Object> map) {
        map.put("LIST", this.confRoomService.getAll());
        return "confroom_user_list.jsp";
    }

    @RequestMapping("/to_add")
    public String to_add(Map<String, Object> map) {
        map.put("ROOM", new ConfRoom()); //与下面add函数参数名称保持一致
        return "confroom_add.jsp";
    }

    @RequestMapping("/add")
    public String add(ConfRoom ROOM) {
        if (this.confRoomService.getByName(ROOM.getName()) == null) {
            this.confRoomService.add(ROOM); //与上面传入jsp页面的参数名称保持一致
        }
        return "redirect:/confroom/administrator_list";
    }

    @RequestMapping(value = "/to_edit", params = "id")
    public String to_edit(int id, Map<String, Object> map) {
        map.put("ROOM", this.confRoomService.getById(id)); //与下面edit函数参数名称保持一致
        map.put("STATE", Contant.getRoomState());
        return "confroom_edit.jsp";
    }

    @RequestMapping("/edit")
    public String edit(ConfRoom ROOM) {
        this.confRoomService.edit(ROOM); //与上面传入jsp页面的参数名称保持一致
        return "redirect:/confroom/administrator_list";
    }

    @RequestMapping(value = "/remove", params = "id")
    public String remove(int id) {
        this.confRoomService.remove(id);
        return "redirect:/confroom/administrator_list";
    }
}
