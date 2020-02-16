package com.project.conf_res.controller;

import com.project.conf_res.AdministratorService;
import com.project.conf_res.UserService;
import com.project.conf_res.entity.Administrator;
import com.project.conf_res.entity.User;
import com.project.conf_res.global.Contant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller("globalController")
public class GlobalController {
    @Autowired
    private UserService userService;
    @Autowired
    private AdministratorService administratorService;

    @RequestMapping("/to_login")
    public String to_login() {
        return "login.jsp";
    }

    @RequestMapping("/login")
    public String login(HttpSession session, @RequestParam String account, @RequestParam String password, @RequestParam String role) {
        if (role.equals("用户")) {
            User user = this.userService.login(account, password);
            if (user != null) {
                session.setAttribute("USER", user);
                return "redirect:/reservation/user_table";
            }
        }
        if (role.equals("管理员")) {
            Administrator administrator = this.administratorService.login(account, password);
            if (administrator != null) {
                session.setAttribute("ADMINISTRATOR", administrator);
                return "redirect:/reservation/administrator_table";
            }
        }
        return "redirect:to_login";
    }

    @RequestMapping("/quit")
    public String quit(HttpSession session) {
        session.setAttribute("USER", null);
        session.setAttribute("ADMINISTRATOR", null);
        return "redirect:to_login";
    }

}
