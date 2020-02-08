package com.project.conf_res;

import com.project.conf_res.entity.AuditLog;

import java.time.LocalDateTime;
import java.util.List;

public interface AuditLogService {
    void add(AuditLog auditLog);

    void remove(int id);

    void edit(AuditLog auditLog);

    AuditLog getById(int id);

    List<AuditLog> getByUid(int uid);

    List<AuditLog> getByRid(int rid);

    List<AuditLog> getAll();
}
