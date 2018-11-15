package io.lvlvforever.util;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * @author lvlvforever
 * @createTime 2018-11-12 23:13
 * @description 一个有关日期和时间的工具集
 * 使用Java8相关的日期时间API
 *
 */
public class DateUtil {
    public static final String DEFAULT_PATTEN = "yyyy-MM-dd HH:mm:ss";

    public static Long parseDateToTimestamp(String date, String pattern) {
        LocalDateTime localDateTime = LocalDateTime.parse(date, DateTimeFormatter.ofPattern(pattern));
        return localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    public static Long parseDateToTimestampWithDefaultPattern(String date) {
        return parseDateToTimestamp(date, DEFAULT_PATTEN);
    }
}
