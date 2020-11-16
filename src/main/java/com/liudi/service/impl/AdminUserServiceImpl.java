package com.liudi.service.impl;

import com.liudi.dao.AdminUserMapper;
import com.liudi.pojo.AdminUser;
import com.liudi.service.AdminUserService;
import com.liudi.utils.MD5Util;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 *
 * @author liudi
 * @version 2020/11/16 上午11:22
 */

@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Resource
    private AdminUserMapper adminUserMapper;

    @Override
    public AdminUser login(String userName, String password) {
        String passwordMd5 = MD5Util.MD5Encode(password, "UTF-8");
        return adminUserMapper.login(userName, passwordMd5);
    }
}
