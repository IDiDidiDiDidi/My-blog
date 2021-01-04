package com.liudi.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * Created with IntelliJ IDEA.
 *
 * @author liudi
 * @version 2020/11/16 下午7:58
 */
public class OtherTest {
    private static final Logger log = LoggerFactory.getLogger(OtherTest.class);

    @Test
    public void test1() {
        Long stuReportId = null;
        if(stuReportId == null ) {
            System.out.println("null");
        } else {
            System.out.println("1111");
        }
    }

    @Test
    public void test2() {
        String courseSns = "001235/1992021／P132131／1231/465465";
        String replace = courseSns.trim().replace("／", "/");
        System.out.println(replace);
        String[] split = replace.trim().split("/");
        for (String s : split) {
            System.out.println(s);
        }
    }


    @Test
    public void testFile() throws FileNotFoundException {
        // 获取程序jar包所在路径，也就是target文件夹
        String filePath = new File(ResourceUtils.getURL("classpath:").getPath()).getParent();
        // target上一层路径  用了个 getParentFile() 方法
        String filePath1 = new File(ResourceUtils.getURL("classpath:").getPath()).getParentFile().getParent();
        log.info(filePath);
        // user.dir：用户的当前工作目录
        log.info(System.getProperty("user.dir"));
        // 用户主目录
        log.info(System.getProperty("user.home"));
    }
}
