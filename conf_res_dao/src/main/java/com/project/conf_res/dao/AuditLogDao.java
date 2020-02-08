package com.project.conf_res.dao;

import com.project.conf_res.entity.AuditLog;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository("auditLogDao")
public interface AuditLogDao {
    void insert(AuditLog auditLog);

    void delete(int id);

    void update(AuditLog auditLog);

    AuditLog selectById(int id);

    List<AuditLog> selectByUid(int uid);

    List<AuditLog> selectByRid(int rid);

    List<AuditLog> selectAll();
}
