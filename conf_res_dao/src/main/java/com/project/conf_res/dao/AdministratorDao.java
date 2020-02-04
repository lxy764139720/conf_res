package com.project.conf_res.dao;

import com.project.conf_res.entity.Administrator;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("administratorDao")
public interface AdministratorDao {
    void insert(Administrator administrator);

    void delete(Integer id);

    void update(Administrator administrator);

    Administrator selectById(Integer id);

    List<Administrator> selectAll();
}
