package com.project.conf_res;

import com.project.conf_res.entity.User;

import java.util.List;

public interface UserService {
    User getByAccount(String account);

    void add(User user);

    void remove(int id);

    User login(String account, String password);

    void changePassword(User user);

    List<User> getAllForList();  //附加查询每个用户的预约数量
}
