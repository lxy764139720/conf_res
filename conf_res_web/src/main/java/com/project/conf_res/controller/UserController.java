package com.project.conf_res.controller;

import com.project.conf_res.UserService;
import com.project.conf_res.entity.Administrator;
import com.project.conf_res.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller("userController")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/detail")
    public String detail() {
        return "user_detail.jsp";
    }

    @RequestMapping("/to_change_password")
    public String toChangePassword(HttpSession session, Map<String, Object> map) {
        return "user_change_password.jsp";
    }

    @RequestMapping("/change_password")
    public String changePassword(HttpSession session, @RequestParam String old, @RequestParam String new1, @RequestParam String new2) {
        User user = (User) session.getAttribute("USER");
        if (user.getPassword().equals(old) && new1.equals(new2)) {
            user.setPassword(new1);
            this.userService.changePassword(user);
            session.setAttribute("USER", user);
            return "redirect:/reservation/user_table";
        }
        return "redirect:/user/to_change_password";
    }
}
