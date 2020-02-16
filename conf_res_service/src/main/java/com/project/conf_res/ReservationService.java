package com.project.conf_res;

import com.project.conf_res.entity.Reservation;

import java.time.LocalDate;
import java.util.List;

public interface ReservationService {
    void add(Reservation reservation);

    void remove(int id);

    void removeOverdue();

    void edit(Reservation reservation);

    Reservation getById(int id);

    List<Reservation> getByUid(int uid);

    List<Reservation> getByRid(int rid);

    List<Reservation> getForTable(int rid, int weekId);

    List<Reservation> getPending();

    List<Reservation> getAll();
}
