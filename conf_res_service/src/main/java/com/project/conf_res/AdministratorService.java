package com.project.conf_res;

import com.project.conf_res.entity.Administrator;

public interface AdministratorService {
    Administrator login(String id, String password);

    void changePassword(Administrator administrator);
}
