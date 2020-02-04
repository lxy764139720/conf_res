package com.project.conf_res.dao;

import com.project.conf_res.entity.AuditLog;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository("auditLogDao")
public interface AuditLogDao {
    void insert(AuditLog auditLog);

    void delete(Integer id);

    void deleteOverdue(LocalDateTime date);

    void update(AuditLog auditLog);

    AuditLog selectById(Integer id);

    List<AuditLog> selectByUid(Integer uid);

    List<AuditLog> selectByRid(Integer rid);

    List<AuditLog> selectAll();
}
