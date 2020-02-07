package com.project.conf_res.Impl;

import com.project.conf_res.AdministratorService;
import com.project.conf_res.dao.AdministratorDao;
import com.project.conf_res.entity.Administrator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("administratorService")
public class AdministratorImpl implements AdministratorService {
    @Autowired
    private AdministratorDao administratorDao;

    @Override
    public Administrator login(String account, String password) {
        Administrator administrator = this.administratorDao.selectByAccount(account);
        if (administrator != null) {
            if (administrator.getPassword().equals(password)) {
                return administrator;
            }
        }
        return null;
    }

    @Override
    public void changePassword(Administrator administrator) {
        this.administratorDao.update(administrator);
    }
}
