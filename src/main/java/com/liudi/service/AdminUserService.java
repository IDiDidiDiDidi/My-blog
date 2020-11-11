package com.liudi.service;

import com.liudi.pojo.AdminUser;
import com.liudi.utils.PageResult;
import com.liudi.utils.PageUtil;

public interface AdminUserService {

    /**
     * 分页功能
     *
     * @param pageUtil
     * @return
     */
    PageResult getAdminUserPage(PageUtil pageUtil);

    /**
     * 登陆功能
     *
     * @return
     */
    AdminUser updateTokenAndLogin(String userName, String password);
}
