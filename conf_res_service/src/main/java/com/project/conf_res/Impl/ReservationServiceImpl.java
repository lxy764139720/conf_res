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
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("reservationService")
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    private ReservationDao reservationDao;

    @Override
    public void add(Reservation reservation) {
        reservation.setResTime(LocalDateTime.now());
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
    public List<Reservation> getExist(LocalDate date, String time, int rid) {
        return this.reservationDao.selectExist(date, time, rid);
    }

    @Override
    public List<Reservation> getOtherPending(int id) {
        return this.reservationDao.selectOtherPending(id);
    }

    @Override
    public List<Reservation> getForTable(int rid, int weekId) {
        LocalDate monday = this.getWeekDate().get("mondayDate");
        LocalDate sunday = this.getWeekDate().get("sundayDate");
        return this.reservationDao.selectForTable(rid, monday.plusDays(7 * weekId), sunday.plusDays(7 * weekId));
    }

    @Override
    public List<Reservation> getPending() {
        return this.reservationDao.selectPending(LocalDate.now());
    }

    @Override
    public List<Reservation> getAll() {
        return this.reservationDao.selectAll(LocalDate.now());
    }

    public Map<String, LocalDate> getWeekDate() {
        Map<String, LocalDate> map = new HashMap<>();
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        ZoneId zoneId = ZoneId.systemDefault();
        Calendar cal = Calendar.getInstance();
        cal.setFirstDayOfWeek(Calendar.MONDAY);// 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
        if (dayWeek == 1) {
            dayWeek = 8;
        }

        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - dayWeek);// 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
        LocalDate weekBegin = cal.getTime().toInstant().atZone(zoneId).toLocalDate();

        cal.add(Calendar.DATE, 4 + cal.getFirstDayOfWeek());
        LocalDate weekEnd = cal.getTime().toInstant().atZone(zoneId).toLocalDate();

        map.put("mondayDate", weekBegin);
        map.put("sundayDate", weekEnd);
        return map;
    }
}
