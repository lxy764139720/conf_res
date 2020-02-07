package com.project.conf_res;

import com.project.conf_res.entity.User;

public interface UserService {
    User login(String account, String password);

    void changePassword(User user);
}
