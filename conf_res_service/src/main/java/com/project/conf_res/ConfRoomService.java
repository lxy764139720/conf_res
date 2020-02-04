package com.project.conf_res;

import com.project.conf_res.entity.ConfRoom;

import java.util.List;

public interface ConfRoomService {
    void add(ConfRoom confRoom);

    void remove(Integer id);

    void edit(ConfRoom confRoom);

    ConfRoom get(Integer id);

    List<ConfRoom> getAll();
}
