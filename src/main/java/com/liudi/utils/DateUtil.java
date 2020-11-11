package com.liudi.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @author liudi
 * @version 2020/11/11 下午8:10
 */
public class DateUtil {

    /**
     * 格式化时间
     * @param date
     * @return
     */
    public static String getDateString(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(date);
    }
}
