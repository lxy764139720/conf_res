package com.project.conf_res.Impl;

import com.project.conf_res.ReservationService;
import com.project.conf_res.dao.ReservationDao;
import com.project.conf_res.entity.Reservation;
import com.project.conf_res.global.Contant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@Service("reservationService")
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    private ReservationDao reservationDao;

    @Override
    public void add(Reservation reservation) {
        reservation.setResTime(LocalDateTime.now());
        reservation.setState(Contant.AUDIT_RESULT_PENDING);
        this.reservationDao.insert(reservation);
    }

    @Override
    public void remove(int id) {
        this.reservationDao.delete(id);
    }

    @Override
    public void removeOverdue() {
        this.reservationDao.deleteOverdue(LocalDate.now());
    }

    @Override
    public void edit(Reservation reservation) {
        this.reservationDao.update(reservation);
    }

    @Override
    public Reservation getById(int id) {
        return this.reservationDao.selectById(id);
    }

    @Override
    public List<Reservation> getByUid(int uid) {
        return this.reservationDao.selectByUid(uid, LocalDate.now());
    }

    @Override
    public List<Reservation> getByRid(int rid) {
        return this.reservationDao.selectByRid(rid, LocalDate.now());
    }

    @Override
    public List<Reservation> getAll() {
        return this.reservationDao.selectAll(LocalDate.now());
    }
}
