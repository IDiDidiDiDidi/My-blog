package com.liudi.service;

import com.liudi.pojo.AdminUser;

public interface AdminUserService {

    AdminUser login(String userName, String password);

}
