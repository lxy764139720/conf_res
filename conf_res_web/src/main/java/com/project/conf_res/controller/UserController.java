package com.project.conf_res.controller;

import com.project.conf_res.UserService;
import com.project.conf_res.entity.Administrator;
import com.project.conf_res.entity.User;
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
import java.util.List;
import java.util.Map;

@Controller("userController")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/list")
    public String list(Map<String, Object> map) {
        map.put("LIST", this.userService.getAllForList());
        return "user_list.jsp";
    }

    @RequestMapping("/to_add")
    public String toAdd(Map<String, Object> map) {
        map.put("USER", new User());
        return "user_add.jsp";
    }

    @RequestMapping("/add")
    public String add(@Valid User USER, BindingResult result, RedirectAttributes model) {
        List<String> msgList = new ArrayList<>();
        if (result.hasErrors()) {
            List<FieldError> errList = result.getFieldErrors();
            for (int i = 0; i < errList.size(); ++i) {
                msgList.add(errList.get(i).getDefaultMessage());
            }
            model.addFlashAttribute("MESSAGE", msgList);
            return "redirect:/reservation/to_add";
        } else if (this.userService.getByAccount(USER.getAccount()) == null) {
            this.userService.add(USER);
        }
        return "redirect:/user/list";
    }

    @RequestMapping(value = "/remove", params = "id")
    public String remove(int id){
        this.userService.remove(id);
        return "redirect:/user/list";
    }

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
