package com.project.conf_res.controller;

import com.project.conf_res.AdministratorService;
import com.project.conf_res.entity.Administrator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller("administratorController")
@RequestMapping("/administrator")
public class AdministratorController {
    @Autowired
    private AdministratorService administratorService;

    @RequestMapping("/detail")
    public String detail() {
        return "administrator_detail.jsp";
    }

    @RequestMapping("/to_change_password")
    public String toChangePassword(HttpSession session, Map<String, Object> map) {
        return "administrator_change_password.jsp";
    }

    @RequestMapping("/change_password")
    public String changePassword(HttpSession session, @RequestParam String old, @RequestParam String new1, @RequestParam String new2) {
        Administrator administrator = (Administrator) session.getAttribute("ADMINISTRATOR");
        if (administrator.getPassword().equals(old) && new1.equals(new2)) {
            administrator.setPassword(new1);
            this.administratorService.changePassword(administrator);
            session.setAttribute("ADMINISTRATOR", administrator);
            return "redirect:/reservation/administrator_table";
        }
        return "redirect:/administrator/to_change_password";
    }
}
