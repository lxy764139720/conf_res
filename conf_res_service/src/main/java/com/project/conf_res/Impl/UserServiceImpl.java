package com.project.conf_res.Impl;

import com.project.conf_res.UserService;
import com.project.conf_res.dao.UserDao;
import com.project.conf_res.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User login(String account, String password) {
        User user = this.userDao.selectByAccount(account);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public void changePassword(User user) {
        this.userDao.update(user);
    }
}
