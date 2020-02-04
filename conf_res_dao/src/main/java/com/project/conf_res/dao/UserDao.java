package com.project.conf_res.dao;

import com.project.conf_res.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userDao")
public interface UserDao {
    void insert(User user);

    void delete(Integer id);

    void update(User user);

    User selectById(Integer id);

    List<User> selectAll();
}
