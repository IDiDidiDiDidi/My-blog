package com.liudi.test;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

/**
 * Created with IntelliJ IDEA.
 *
 * @author liudi
 * @version 2020/12/18 下午2:23
 */
public class MockTest {
    private static final Logger log = LoggerFactory.getLogger(MockTest.class);

    @Test
    void testMock() {
        //创建mock对象，参数可以是类，也可以是接口
        List<String> list = mock(List.class);

        //设置方法的预期返回值
        when(list.get(0)).thenReturn("helloWorld");

        String result = list.get(0);
        log.info(">>>> : {}", result);

        //验证方法调用(是否调用了get(0))
//        当 测试get(0) 的时候，他是通过的，是因为，上面使用过get(0),但从未使用过get(1)
        verify(list).get(0);

        //junit测试
        assertEquals("helloWorld", result);

        when(list.get(1)).thenThrow(new RuntimeException("test excpetion"));

        doReturn("secondHello").when(list).get(1);

        log.info(">>>> : {}", list.get(1));


        doNothing().doNothing().doThrow(new RuntimeException("void exception")).when(list).clear();
        list.clear();
        list.clear();
        //验证你之前是否是调用了两次clear
        verify(list,times(2)).clear();


    }
}
