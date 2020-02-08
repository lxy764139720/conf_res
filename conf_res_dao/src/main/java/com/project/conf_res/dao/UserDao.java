package com.project.conf_res.dao;

import com.project.conf_res.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userDao")
public interface UserDao {
    void insert(User user);

    void delete(int id);

    void update(User user);

    User selectById(int id);

    User selectByAccount(String account);

    List<User> selectAll();
}
