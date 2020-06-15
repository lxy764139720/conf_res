package com.project.conf_res.dao;

import com.project.conf_res.entity.Reservation;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository("reservationDao")
public interface ReservationDao {
    void insert(Reservation reservation);

    void delete(int id);

    void deleteOverdue(LocalDate date);

    void update(Reservation reservation);

    Reservation selectById(int id);

    List<Reservation> selectByUid(@Param("uid") int uid, @Param("date") LocalDate date);

    List<Reservation> selectByRid(@Param("rid") int rid, @Param("date") LocalDate date);
    // 获取该时间该会议室已审核通过的预约
    List<Reservation> selectExist(@Param("date") LocalDate date, @Param("time") String time, @Param("rid") int rid);
    // 通过id获取在该时间该会议室其他待审核的预约
    List<Reservation> selectOtherPending(int id);

    List<Reservation> selectForTable(@Param("rid") int rid, @Param("date1") LocalDate monday, @Param("date2") LocalDate sunday);

    List<Reservation> selectPending(LocalDate date);

    List<Reservation> selectAll(LocalDate date);
}
