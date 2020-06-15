package com.project.conf_res.Impl;

import com.project.conf_res.UserService;
import com.project.conf_res.dao.UserDao;
import com.project.conf_res.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User getByAccount(String account) {
        return this.userDao.selectByAccount(account);
    }

    @Override
    public void add(User user) {
        user.setPassword("123456"); //默认密码
        this.userDao.insert(user);
    }

    @Override
    public void remove(int id) {
        this.userDao.delete(id);
    }

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

    @Override
    public List<User> getAllForList() {
        return this.userDao.selectAllForList();
    }
}
