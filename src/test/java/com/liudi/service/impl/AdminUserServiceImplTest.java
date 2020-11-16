package com.liudi.service.impl;

import com.liudi.dao.AdminUserMapper;
import com.liudi.pojo.AdminUser;
import com.liudi.utils.MD5Util;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminUserServiceImplTest extends TestCase {

    @Resource
    private AdminUserMapper adminUserMapper;

    @Test
    public void testLogin() {

        String passwordMd5 = MD5Util.MD5Encode("123456", "UTF-8");
        log.info(">>>>>>>>>>>>pwd:{}", passwordMd5);
        AdminUser admin = adminUserMapper.login("admin", passwordMd5);
        log.info(">>>>>>>>>>>>>>>adminUser:{}", admin);


    }
}