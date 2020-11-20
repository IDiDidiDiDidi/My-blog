package com.liudi.dao;

import com.liudi.pojo.AdminUser;
import com.liudi.service.RedisService;
import com.liudi.utils.RedisKeyUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;
import org.springframework.test.context.junit4.SpringRunner;
 
import javax.annotation.Resource;
 
import java.util.Set;
import java.util.concurrent.TimeUnit;
 
import static org.junit.Assert.*;
 
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisConfigTest {
 
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
 
    @Autowired
    private RedisTemplate redisTemplate;
 
    @Resource
    private ValueOperations<String,Object> valueOperations;
 
    @Autowired
    private HashOperations<String, String, Object> hashOperations;
 
    @Autowired
    private ListOperations<String, Object> listOperations;
 
    @Autowired
    private SetOperations<String, Object> setOperations;
 
    @Autowired
    private ZSetOperations<String, Object> zSetOperations;
 
    @Resource
    private RedisService redisService;
 
    @Test
    public void testObj() throws Exception{
        AdminUser userVo = new AdminUser();
        userVo.setLoginUserName("上海");
        userVo.setNickName("测试dfas");
        userVo.setAdminUserId(123);
        ValueOperations<String,Object> operations = redisTemplate.opsForValue();
        redisService.expireKey("name",20, TimeUnit.SECONDS);
        String key = RedisKeyUtil.getKey("t_user","name",userVo.getLoginUserName());
        AdminUser vo = (AdminUser) operations.get(key);
        System.out.println(vo);
    }
 
    @Test
    public void testValueOption( )throws  Exception{
        AdminUser userVo = new AdminUser();
        userVo.setLoginUserName("上海");
        userVo.setNickName("jantent");
        userVo.setAdminUserId(23);
        valueOperations.set("test",userVo);
 
        System.out.println(valueOperations.get("test"));
    }
 
    @Test
    public void testSetOperation() throws Exception{
        AdminUser userVo = new AdminUser();
        userVo.setLoginUserName("北京");
        userVo.setNickName("jantent");
        userVo.setAdminUserId(23);
        AdminUser auserVo = new AdminUser();
        auserVo.setLoginUserName("n柜昂周");
        auserVo.setNickName("antent");
        auserVo.setAdminUserId(23);
        setOperations.add("user:test",userVo,auserVo);
        Set<Object> result = setOperations.members("user:test");
        System.out.println(result);
    }
 
    @Test
    public void HashOperations() throws Exception{
        AdminUser userVo = new AdminUser();
        userVo.setLoginUserName("北京");
        userVo.setNickName("jantent");
        userVo.setAdminUserId(23);
        hashOperations.put("hash:user",userVo.hashCode()+"",userVo);
        System.out.println(hashOperations.get("hash:user",userVo.hashCode()+""));
    }
 
    @Test
    public void  ListOperations() throws Exception{
        AdminUser userVo = new AdminUser();
        userVo.setLoginUserName("北京");
        userVo.setNickName("jantent");
        userVo.setAdminUserId(23);
//        listOperations.leftPush("list:user",userVo);
        System.out.println(listOperations.leftPop("list:user"));
        // pop之后 值会消失
//        System.out.println(listOperations.leftPop("list:user"));
    }
}