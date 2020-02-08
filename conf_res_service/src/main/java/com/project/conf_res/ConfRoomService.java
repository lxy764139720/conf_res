package com.project.conf_res;

import com.project.conf_res.entity.ConfRoom;

import java.util.List;

public interface ConfRoomService {
    void add(ConfRoom confRoom);

    void remove(int id);

    void edit(ConfRoom confRoom);

    ConfRoom get(int id);

    List<ConfRoom> getAll();
}
