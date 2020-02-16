package com.project.conf_res;

import com.project.conf_res.entity.ConfRoom;
import com.project.conf_res.global.Contant;

import java.util.List;

public interface ConfRoomService {
    void add(ConfRoom confRoom);

    void remove(int id);

    void edit(ConfRoom confRoom);

    ConfRoom getById(int id);

    ConfRoom getByName(String name);

    List<ConfRoom> getAllOpen();

    List<ConfRoom> getAll();
}
