package com.liudi.service;

import com.liudi.pojo.AdminUser;

public interface AdminUserService {

    AdminUser login(String userName, String password);

    AdminUser getUserDetailById(Integer loginUserId);

    Boolean updatePassword(Integer loginUserId, String originalPassword, String newPassword);

    Boolean updateName(Integer loginUserId, String loginUserName, String nickName);
}
