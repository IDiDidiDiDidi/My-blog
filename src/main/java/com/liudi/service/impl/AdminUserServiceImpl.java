package com.liudi.service.impl;

import com.liudi.dao.AdminUserDao;
import com.liudi.pojo.AdminUser;
import com.liudi.service.AdminUserService;
import com.liudi.utils.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author liudigit
 * @version 2020/11/11 下午8:26
 */
@Service("adminUserService")
@Slf4j
public class AdminUserServiceImpl implements AdminUserService {

    @Autowired
    private AdminUserDao adminUserDao;

    @Override
    public PageResult getAdminUserPage(PageUtil pageUtil) {
        List<AdminUser> users = adminUserDao.findAdminUsers(pageUtil);
        log.info(">>>>>>>>>>>>>>>>users:{}", users);
        //数据总条数 用于计算分页数据
        int total = adminUserDao.adminUserCount(pageUtil);

        log.info(">>>>>>>>>>>>total:{}", total);
        PageResult pageResult = new PageResult(users, total, pageUtil.getLimit(), pageUtil.getPage());
        return pageResult;
    }

    @Override
    public AdminUser updateTokenAndLogin(String userName, String password) {
        String md5Encode = MD5Util.MD5Encode(password, "UTF-8");
        log.info(">>>>>>>>>>>>password:{}", password);
        log.info(">>>>>>>>>>>>md5Encode:{}", md5Encode);
        AdminUser adminUser = adminUserDao.getAdminUserByNameAndPwd(userName,  md5Encode);
        log.info(">>>>>>>>>>>>>>>adminUser:{}", adminUser);
        if (adminUser != null) {
            String token = this.getNewToken(System.currentTimeMillis() + "", adminUser.getId());
            if (adminUserDao.updateUserToken(adminUser.getId(), token) > 0) {
                adminUser.setUserToken(token);
                return adminUser;
            }
        }
        return null;
    }

    private String getNewToken(String sessionId, Long userId) {
        String src = sessionId + userId + NumberUtil.genRandomNum(4);
        return SystemUtil.genToken(src);
    }
}
