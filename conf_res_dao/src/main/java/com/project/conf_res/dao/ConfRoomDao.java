package com.project.conf_res.dao;

import com.project.conf_res.entity.ConfRoom;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("confRoomDao")
public interface ConfRoomDao {
    void insert(ConfRoom confRoom);

    void delete(int id);

    void update(ConfRoom confRoom);

    ConfRoom selectById(int id);

    ConfRoom selectByName(String Name);

    List<ConfRoom> selectAllOpen();

    List<ConfRoom> selectAll();
}
