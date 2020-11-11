package com.liudi.service.impl;

import com.liudi.pojo.AdminUser;
import com.liudi.service.AdminUserService;
import com.liudi.utils.PageResult;
import com.liudi.utils.PageUtil;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @author liudi
 * @version 2020/11/11 下午8:26
 */
@Service("adminUserService")
public class AdminUserServiceImpl implements AdminUserService {
    @Override
    public PageResult getAdminUserPage(PageUtil pageUtil) {
        return null;
    }

    @Override
    public AdminUser updateTokenAndLogin(String userName, String password) {
        return null;
    }
}
