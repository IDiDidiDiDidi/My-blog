package com.liudi.dao;

import com.liudi.pojo.AdminUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author liudi
 * @version 2020/11/11 下午8:46
 */
public interface AdminUserDao {

    /**
     * 根据参数查询用户
     *
     * @param param
     * @return
     */
    List<AdminUser> findAdminUsers(Map param);

    /**
     * 查询用户总数
     *
     * @param map
     * @return
     */
    int adminUserCount(Map map);

    /**
     * 根据账号密码查询用户
     *
     * @param userName
     * @param passward
     * @return
     */
    AdminUser getAdminUserByNameAndPwd(@Param("userName") String userName, @Param("passwordMD5") String passward);

    /**
     * 根据token 查询该用户
     *
     * @param token
     * @return
     */
    AdminUser getAdminUserByToken(String token);

    /**
     * 根据ID查用户
     *
     * @param id
     * @return
     */
    AdminUser getAdminUserById(Long id);

    /**
     * 根据用户名获取用户记录
     *
     * @return
     */
    AdminUser getAdminUserByUserName(String userName);

    /**
     * 新增用户记录
     *
     * @return
     */
    int addUser(AdminUser user);

    /**
     * 批量新增用户记录
     *
     * @return
     */
    int insertUsersBatch(@Param("adminUsers") List<AdminUser> adminUsers);

    /**
     * 修改密码
     *
     * @return
     */
    int updateUserPassword(@Param("userId") Long userId, @Param("newPassword") String newPassword);

    /**
     * 更新用户token值
     *
     * @param userId
     * @param newToken
     * @return
     */
    int updateUserToken(@Param("userId") Long userId, @Param("newToken") String newToken);

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    int deleteBatch(Object[] ids);

    /**
     * 查询所有用户列表
     *
     * @return
     */
    List<AdminUser> getAllAdminUsers();
}
