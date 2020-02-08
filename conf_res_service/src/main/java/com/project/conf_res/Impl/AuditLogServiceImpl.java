package com.project.conf_res.Impl;

import com.project.conf_res.AuditLogService;
import com.project.conf_res.dao.AuditLogDao;
import com.project.conf_res.entity.AuditLog;
import com.project.conf_res.global.Contant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@Service("auditLogService")
public class AuditLogServiceImpl implements AuditLogService {
    @Autowired
    private AuditLogDao auditLogDao;

    @Override
    public void add(AuditLog auditLog) {
        auditLog.setAuditTime(LocalDateTime.now());
        auditLog.setAuditResult(Contant.AUDIT_RESULT_PENDING);
        this.auditLogDao.insert(auditLog);
    }

    @Override
    public void remove(int id) {
        this.auditLogDao.delete(id);
    }

    @Override
    public void edit(AuditLog auditLog) {
        this.auditLogDao.update(auditLog);
    }

    @Override
    public AuditLog getById(int id) {
        return this.auditLogDao.selectById(id);
    }

    @Override
    public List<AuditLog> getByUid(int uid) {
        return this.auditLogDao.selectByUid(uid);
    }

    @Override
    public List<AuditLog> getByRid(int rid) {
        return this.auditLogDao.selectByRid(rid);
    }

    @Override
    public List<AuditLog> getAll() {
        return this.auditLogDao.selectAll();
    }
}
