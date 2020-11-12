package com.liudi.dao;

import com.liudi.pojo.AdminUser;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class AdminUserDaoTest extends TestCase {

    @Autowired
    AdminUserDao adminUserDao;

    @Test
    public void testFindAdminUsersByNP() {


        AdminUser user = adminUserDao.getAdminUserByToken("bb2790f4ac2208c2bbdd7bd7f905d4ea");

        log.info(">>>>>>>>>>>>>>>>>>User:{}", user);
    }
}