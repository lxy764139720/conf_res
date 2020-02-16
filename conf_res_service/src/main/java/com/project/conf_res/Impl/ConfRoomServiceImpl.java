package com.project.conf_res.Impl;

import com.project.conf_res.ConfRoomService;
import com.project.conf_res.dao.ConfRoomDao;
import com.project.conf_res.entity.ConfRoom;
import com.project.conf_res.global.Contant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("confRoomService")
public class ConfRoomServiceImpl implements ConfRoomService {
    @Autowired
    private ConfRoomDao confRoomDao;

    @Override
    public void add(ConfRoom confRoom) {
        confRoom.setState("开放");
        this.confRoomDao.insert(confRoom);
    }

    @Override
    public void remove(int id) {
        this.confRoomDao.delete(id);
    }

    @Override
    public void edit(ConfRoom confRoom) {
        this.confRoomDao.update(confRoom);
    }

    @Override
    public ConfRoom getById(int id) {
        return this.confRoomDao.selectById(id);
    }

    @Override
    public ConfRoom getByName(String name){return this.confRoomDao.selectByName(name);}

    @Override
    public List<ConfRoom> getAllOpen(){return this.confRoomDao.selectAllOpen();}

    @Override
    public List<ConfRoom> getAll() {
        return this.confRoomDao.selectAll();
    }
}
