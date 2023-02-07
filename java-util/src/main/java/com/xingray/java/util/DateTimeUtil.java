package com.xingray.java.util;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {

    public static final String DEFAULT_DATE_PATTERN = "yyyy/MM/dd";
    public static final String DEFAULT_SEPARATOR = "/";
    public static final int DAY_IN_SECONDS = 24 * 3600;
    public static final int DAY_IN_MILLS = DAY_IN_SECONDS * 1000;
    public static final ZoneId ZONE_ID_GMT = ZoneId.of("+00:00");

    public static final ZoneId ZONE_ID_BEIJING = ZoneId.of("+08:00");

    public static boolean isValidDate(int year, int month, int day) {
        if (month < 1 || month > 12) {
            return false;
        }
        int lastDay = switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 4, 6, 9, 11 -> 30;
            default -> {
                if (isLeapYear(year)) {
                    yield 29;
                } else {
                    yield 28;
                }
            }
        };
        return day >= 1 && day <= lastDay;
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static boolean isValidDateInterval(int startYear,
                                              int startMonth,
                                              int startDay,
                                              int endYear,
                                              int endMonth,
                                              int endDay) {
        if (!isValidDate(startYear, startMonth, startDay) || !isValidDate(endYear, endMonth, endDay)) {
            return false;
        }
        if (startYear < endYear) {
            return true;
        } else if (startYear > endYear) {
            return false;
        }

        if (startMonth < endMonth) {
            return true;
        } else if (startMonth > endMonth) {
            return false;
        }

        return startDay <= endDay;
    }


    public static int[] millsToYmd(long mills, ZoneId zoneId) {
        LocalDate localDate = millsToLocalDate(mills, zoneId);
        return new int[]{localDate.getYear(), localDate.getMonthValue(), localDate.getDayOfMonth()};
    }

    public static int[] millsToYmd(long mills, String zoneId) {
        return millsToYmd(mills, ZoneId.of(zoneId));
    }

    public static int[] millsToYmd(long mills) {
        return millsToYmd(mills, ZONE_ID_GMT);
    }

    public static int[] secondsToYmd(long seconds, ZoneId zoneId) {
        LocalDate localDate = secondsToLocalDate(seconds, zoneId);
        return new int[]{localDate.getYear(), localDate.getMonthValue(), localDate.getDayOfMonth()};
    }

    public static int[] secondsToYmd(long seconds, String zoneId) {
        return secondsToYmd(seconds, ZoneId.of(zoneId));
    }

    public static int[] secondsToYmd(long seconds) {
        return secondsToYmd(seconds, ZONE_ID_GMT);
    }

    public static LocalDate millsToLocalDate(long mills, ZoneId zoneId) {
        Instant instant = Instant.ofEpochMilli(mills);
        return LocalDate.ofInstant(instant, zoneId);
    }

    public static LocalDate millsToLocalDate(long mills, String zoneId) {
        return millsToLocalDate(mills, ZoneId.of(zoneId));
    }

    public static LocalDate millsToLocalDate(long mills) {
        return millsToLocalDate(mills, ZONE_ID_GMT);
    }

    public static LocalDate secondsToLocalDate(long seconds, ZoneId zoneId) {
        Instant instant = Instant.ofEpochSecond(seconds);
        return LocalDate.ofInstant(instant, zoneId);
    }

    public static LocalDate secondsToLocalDate(long seconds, String zoneId) {
        return secondsToLocalDate(seconds, ZoneId.of(zoneId));
    }

    public static LocalDate secondsToLocalDate(long seconds) {
        return secondsToLocalDate(seconds, ZONE_ID_GMT);
    }

    public static long localDateTimeToSeconds(LocalDateTime localDateTime, ZoneId zoneId) {
        ZonedDateTime zonedDateTime = localDateTime.atZone(zoneId);
        return zonedDateTime.toInstant().getEpochSecond();
    }

    public static long localDateTimeToSeconds(LocalDateTime localDateTime, String zoneId) {
        return localDateTimeToSeconds(localDateTime, ZoneId.of(zoneId));
    }

    public static long localDateTimeToSeconds(LocalDateTime localDateTime) {
        return localDateTimeToSeconds(localDateTime, ZONE_ID_GMT);
    }

    public static long localDateToSeconds(LocalDate localDate, ZoneId zoneId) {
        LocalDateTime localDateTime = localDate.atTime(0, 0, 0, 0);
        return localDateTimeToSeconds(localDateTime, zoneId);
    }

    public static long localDateToSeconds(LocalDate localDate, String zoneId) {
        return localDateToSeconds(localDate, ZoneId.of(zoneId));
    }

    public static long localDateToSeconds(LocalDate localDate) {
        return localDateToSeconds(localDate, ZONE_ID_GMT);
    }

    public static long ymdToSeconds(int year,
                                    int month,
                                    int day,
                                    ZoneId zoneId) {
        LocalDateTime localDateTime = LocalDateTime.of(year, month, day, 0, 0, 0, 0);
        return localDateTimeToSeconds(localDateTime, zoneId);
    }

    public static long ymdToSeconds(int year,
                                    int month,
                                    int day,
                                    String zoneId) {
        return ymdToSeconds(year, month, day, ZoneId.of(zoneId));
    }

    public static long ymdToSeconds(int year,
                                    int month,
                                    int day) {
        return ymdToSeconds(year, month, day, ZONE_ID_GMT);
    }
    //========================================//

    public static long localDateTimeToMills(LocalDateTime localDateTime, ZoneId zoneId) {
        ZonedDateTime zonedDateTime = localDateTime.atZone(zoneId);
        return zonedDateTime.toInstant().toEpochMilli();
    }

    public static long localDateTimeToMills(LocalDateTime localDateTime, String zoneId) {
        return localDateTimeToMills(localDateTime, ZoneId.of(zoneId));
    }

    public static long localDateTimeToMills(LocalDateTime localDateTime) {
        return localDateTimeToMills(localDateTime, ZONE_ID_GMT);
    }

    public static long localDateToMills(LocalDate localDate, ZoneId zoneId) {
        LocalDateTime localDateTime = localDate.atTime(0, 0, 0, 0);
        return localDateTimeToMills(localDateTime, zoneId);
    }

    public static long localDateToMills(LocalDate localDate, String zoneId) {
        return localDateToMills(localDate, ZoneId.of(zoneId));
    }

    public static long localDateToMills(LocalDate localDate) {
        return localDateToMills(localDate, ZONE_ID_GMT);
    }

    public static long ymdToMills(int year,
                                  int month,
                                  int day,
                                  ZoneId zoneId) {
        LocalDateTime localDateTime = LocalDateTime.of(year, month, day, 0, 0, 0, 0);
        return localDateTimeToMills(localDateTime, zoneId);
    }

    public static long ymdToMills(int year,
                                  int month,
                                  int day,
                                  String zoneId) {
        return ymdToMills(year, month, day, ZoneId.of(zoneId));
    }

    public static long ymdToMills(int year,
                                  int month,
                                  int day) {
        return ymdToMills(year, month, day, ZONE_ID_GMT);
    }


    public static long ymdStringToMillsValue(String s, String separator, ZoneId zoneId) {
        int[] ints = StringUtil.toInts(s, separator);
        return ymdToMills(ints[0], ints[1], ints[2], zoneId);
    }

    public static long ymdStringToMillsValue(String s, String separator, String zoneId) {
        return ymdStringToMillsValue(s, separator, ZoneId.of(zoneId));
    }

    public static long ymdStringToMillsValue(String s, ZoneId zoneId) {
        return ymdStringToMillsValue(s, DEFAULT_SEPARATOR, zoneId);
    }

    public static long ymdStringToMillsValue(String s, String separator) {
        return ymdStringToMillsValue(s, separator, ZONE_ID_GMT);
    }

    public static long ymdStringToMillsValue(String s) {
        return ymdStringToMillsValue(s, DEFAULT_SEPARATOR);
    }


    public static long ymdStringToSecondsValue(String s, String separator, ZoneId zoneId) {
        int[] ints = StringUtil.toInts(s, separator);
        return ymdToSeconds(ints[0], ints[1], ints[2], zoneId);
    }

    public static long ymdStringToSecondsValue(String s, String separator, String zoneId) {
        return ymdStringToSecondsValue(s, separator, ZoneId.of(zoneId));
    }

    public static long ymdStringToSecondsValue(String s, ZoneId zoneId) {
        return ymdStringToSecondsValue(s, DEFAULT_SEPARATOR, zoneId);
    }

    public static long ymdStringToSecondsValue(String s, String separator) {
        return ymdStringToSecondsValue(s, separator, ZONE_ID_GMT);
    }

    public static long ymdStringToSecondsValue(String s) {
        return ymdStringToSecondsValue(s, DEFAULT_SEPARATOR, ZONE_ID_GMT);
    }

    public static Long ymdStringToMills(String s, String sep, ZoneId zoneId) {
        Integer[] integers = StringUtil.toIntegers(s, sep);
        if (integers == null || integers.length < 3) {
            return null;
        }
        for (Integer i : integers) {
            if (i == null) {
                return null;
            }
        }

        return ymdToMills(integers[0], integers[1], integers[2], zoneId);
    }

    public static Long ymdStringToMills(String s, String sep, String zoneId) {
        return ymdStringToMills(s, sep, ZoneId.of(zoneId));
    }

    public static Long ymdStringToMills(String s, ZoneId zoneId) {
        return ymdStringToMills(s, DEFAULT_SEPARATOR, zoneId);
    }

    public static Long ymdStringToMills(String s, String sep) {
        return ymdStringToMills(s, sep, ZONE_ID_GMT);
    }

    public static Long ymdStringToMills(String s) {
        return ymdStringToMills(s, DEFAULT_SEPARATOR, ZONE_ID_GMT);
    }

    public static Long ymdStringToSeconds(String s, String sep, ZoneId zoneId) {
        Integer[] integers = StringUtil.toIntegers(s, sep);
        if (integers == null || integers.length < 3) {
            return null;
        }
        for (Integer i : integers) {
            if (i == null) {
                return null;
            }
        }

        return ymdToSeconds(integers[0], integers[1], integers[2], zoneId);
    }

    public static Long ymdStringToSeconds(String s, String sep, String zoneId) {
        return ymdStringToSeconds(s, sep, ZoneId.of(zoneId));
    }

    public static Long ymdStringToSeconds(String s, ZoneId zoneId) {
        return ymdStringToSeconds(s, DEFAULT_SEPARATOR, zoneId);
    }

    public static Long ymdStringToSeconds(String s, String sep) {
        return ymdStringToSeconds(s, sep, ZONE_ID_GMT);
    }

    public static Long ymdStringToSeconds(String s) {
        return ymdStringToSeconds(s, DEFAULT_SEPARATOR, ZONE_ID_GMT);
    }

    /**
     * 数字转为时间戳
     *
     * @param ymdNumber 日期数字，如 20200101表示2020年1月1日
     * @param zoneId    时区
     * @return 时间戳
     */
    public static Long ymdNumberToSeconds(int ymdNumber, ZoneId zoneId) {
        int y;
        int m;
        int d;

        d = ymdNumber % 100;
        ymdNumber /= 100;
        m = ymdNumber % 100;
        y = ymdNumber / 100;

        return ymdToSeconds(y, m, d, zoneId);
    }

    public static Long ymdNumberToSeconds(int ymdNumber) {
        return ymdNumberToSeconds(ymdNumber, ZONE_ID_GMT);
    }

    public static String millsToYmdString(Long mills, String separator, ZoneId zoneId) {
        if (mills == null) {
            return null;
        }

        int[] ints = millsToYmd(mills, zoneId);
        return ints[0] + separator + ints[1] + separator + ints[2];
    }

    public static String millsToYmdString(Long mills, String separator, String zoneId) {
        return millsToYmdString(mills, separator, ZoneId.of(zoneId));
    }

    public static String millsToYmdString(Long mills, ZoneId zoneId) {
        return millsToYmdString(mills, DEFAULT_SEPARATOR, zoneId);
    }

    public static String millsToYmdString(Long mills, String separator) {
        return millsToYmdString(mills, separator, ZONE_ID_GMT);
    }

    public static String millsToYmdString(Long mills) {
        return millsToYmdString(mills, DEFAULT_SEPARATOR, ZONE_ID_GMT);
    }

    public static String secondsToYmdString(Long seconds, String separator, ZoneId zoneId) {
        if (seconds == null) {
            return null;
        }
        return millsToYmdString(seconds * 1000, separator, zoneId);
    }

    public static String secondsToYmdString(Long seconds, String separator, String zoneId) {
        return secondsToYmdString(seconds, separator, ZoneId.of(zoneId));
    }

    public static String secondsToYmdString(Long seconds, ZoneId zoneId) {
        return secondsToYmdString(seconds, DEFAULT_SEPARATOR, zoneId);
    }

    public static String secondsToYmdString(Long seconds, String separator) {
        return secondsToYmdString(seconds, separator, ZONE_ID_GMT);
    }

    public static String secondsToYmdString(Long seconds) {
        return secondsToYmdString(seconds, DEFAULT_SEPARATOR, ZONE_ID_GMT);
    }

    public static String millsValueToDateString(long mills, DateTimeFormatter formatter, ZoneId zoneId) {
        Instant instant = Instant.ofEpochMilli(mills);
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zoneId);
        return localDateTime.format(formatter);
    }

    public static String millsValueToDateString(long mills, DateTimeFormatter formatter, String zoneId) {
        return millsValueToDateString(mills, formatter, ZoneId.of(zoneId));
    }

    public static String millsValueToDateString(long mills, String format, ZoneId zoneId) {
        return millsValueToDateString(mills, DateTimeFormatter.ofPattern(format), zoneId);
    }

    public static String millsValueToDateString(long mills, String format, String zoneId) {
        return millsValueToDateString(mills, DateTimeFormatter.ofPattern(format), ZoneId.of(zoneId));
    }

    public static String millsValueToDateString(long mills, ZoneId zoneId) {
        return millsValueToDateString(mills, DateTimeFormatter.BASIC_ISO_DATE, zoneId);
    }

    public static String millsValueToDateString(long mills, String format) {
        return millsValueToDateString(mills, DateTimeFormatter.ofPattern(format), ZONE_ID_GMT);
    }

    public static String millsValueToDateString(long mills) {
        return millsValueToDateString(mills, DateTimeFormatter.BASIC_ISO_DATE, ZONE_ID_GMT);
    }

    public static String millsToDateString(Long mills, DateTimeFormatter formatter, ZoneId zoneId) {
        if (mills == null) {
            return null;
        }

        return millsValueToDateString(mills, formatter, zoneId);
    }

    public static String millsToDateString(Long mills, DateTimeFormatter formatter, String zoneId) {
        return millsToDateString(mills, formatter, ZoneId.of(zoneId));
    }

    public static String millsToDateString(Long mills, String format, ZoneId zoneId) {
        return millsToDateString(mills, DateTimeFormatter.ofPattern(format), zoneId);
    }

    public static String millsToDateString(Long mills, String format, String zoneId) {
        return millsToDateString(mills, DateTimeFormatter.ofPattern(format), ZoneId.of(zoneId));
    }

    public static String millsToDateString(Long mills, ZoneId zoneId) {
        return millsToDateString(mills, DateTimeFormatter.BASIC_ISO_DATE, zoneId);
    }

    public static String millsToDateString(Long mills, String format) {
        return millsToDateString(mills, DateTimeFormatter.ofPattern(format), ZONE_ID_GMT);
    }

    public static String millsToDateString(Long mills) {
        return millsToDateString(mills, DateTimeFormatter.BASIC_ISO_DATE, ZONE_ID_GMT);
    }

    public static String secondsValueToDateString(long seconds, DateTimeFormatter formatter, ZoneId zoneId) {
        Instant instant = Instant.ofEpochSecond(seconds);
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zoneId);
        return localDateTime.format(formatter);
    }

    public static String secondsValueToDateString(long seconds, DateTimeFormatter formatter, String zoneId) {
        return secondsValueToDateString(seconds, formatter, ZoneId.of(zoneId));
    }

    public static String secondsValueToDateString(long seconds, String format, ZoneId zoneId) {
        return secondsValueToDateString(seconds, DateTimeFormatter.ofPattern(format), zoneId);
    }

    public static String secondsValueToDateString(long seconds, String format, String zoneId) {
        return secondsValueToDateString(seconds, DateTimeFormatter.ofPattern(format), ZoneId.of(zoneId));
    }

    public static String secondsValueToDateString(long seconds, ZoneId zoneId) {
        return secondsValueToDateString(seconds, DateTimeFormatter.BASIC_ISO_DATE, zoneId);
    }

    public static String secondsValueToDateString(long seconds, String format) {
        return secondsValueToDateString(seconds, DateTimeFormatter.ofPattern(format), ZONE_ID_GMT);
    }

    public static String secondsValueToDateString(long seconds) {
        return secondsValueToDateString(seconds, DateTimeFormatter.BASIC_ISO_DATE, ZONE_ID_GMT);
    }

    public static String secondsToDateString(Long seconds, DateTimeFormatter formatter, ZoneId zoneId) {
        if (seconds == null) {
            return null;
        }
        return secondsValueToDateString(seconds, formatter, zoneId);
    }

    public static String secondsToDateString(Long seconds, DateTimeFormatter formatter, String zoneId) {
        return secondsToDateString(seconds, formatter, ZoneId.of(zoneId));
    }

    public static String secondsToDateString(Long seconds, String format, ZoneId zoneId) {
        return secondsToDateString(seconds, DateTimeFormatter.ofPattern(format), zoneId);
    }

    public static String secondsToDateString(Long seconds, String format, String zoneId) {
        return secondsToDateString(seconds, DateTimeFormatter.ofPattern(format), ZoneId.of(zoneId));
    }

    public static String secondsToDateString(Long seconds, ZoneId zoneId) {
        return secondsToDateString(seconds, DateTimeFormatter.BASIC_ISO_DATE, zoneId);
    }

    public static String secondsToDateString(Long seconds, String format) {
        return secondsToDateString(seconds, DateTimeFormatter.ofPattern(format), ZONE_ID_GMT);
    }

    public static String secondsToDateString(Long seconds) {
        return secondsToDateString(seconds, DateTimeFormatter.BASIC_ISO_DATE, ZONE_ID_GMT);
    }

    public static long getTodayMills(ZoneId zoneId) {
        LocalDate localDate = LocalDate.ofInstant(Instant.now(), zoneId);
        LocalDateTime localDateTime = localDate.atTime(0, 0, 0, 0);
        return localDateTime.atZone(zoneId).toInstant().toEpochMilli();
    }

    public static long getTodayMills(String zoneId) {
        return getTodayMills(ZoneId.of(zoneId));
    }

    public static long getTodayMills() {
        return getTodayMills(ZONE_ID_GMT);
    }

    public static long getTodaySeconds(ZoneId zoneId) {
        LocalDate localDate = LocalDate.ofInstant(Instant.now(), zoneId);
        LocalDateTime localDateTime = localDate.atTime(0, 0, 0, 0);
        return localDateTime.atZone(zoneId).toInstant().getEpochSecond();
    }

    public static long getTodaySeconds(String zoneId) {
        return getTodaySeconds(ZoneId.of(zoneId));
    }

    public static long getTodaySeconds() {
        return getTodaySeconds(ZONE_ID_GMT);
    }

    public static String todayToDateString(DateTimeFormatter formatter, ZoneId zoneId) {
        return LocalDate.ofInstant(Instant.now(), zoneId).format(formatter);
    }

    public static String todayToDateString(DateTimeFormatter formatter, String zoneId) {
        return todayToDateString(formatter, ZoneId.of(zoneId));
    }

    public static String todayToDateString(String format, ZoneId zoneId) {
        return LocalDate.ofInstant(Instant.now(), zoneId).format(DateTimeFormatter.ofPattern(format));
    }

    public static String todayToDateString(String format, String zoneId) {
        return todayToDateString(DateTimeFormatter.ofPattern(format), ZoneId.of(zoneId));
    }

    public static String todayToDateString(DateTimeFormatter formatter) {
        return todayToDateString(formatter, ZONE_ID_GMT);
    }

    public static String todayToDateString() {
        return todayToDateString(DateTimeFormatter.BASIC_ISO_DATE, ZONE_ID_GMT);
    }

    // =====================================================//

    public static LocalTime millsToLocalTime(long mills, ZoneId zoneId) {
        Instant instant = Instant.ofEpochMilli(mills);
        return LocalTime.ofInstant(instant, zoneId);
    }

    public static LocalTime millsToLocalTime(long mills, String zoneId) {
        return millsToLocalTime(mills, ZoneId.of(zoneId));
    }

    public static LocalTime millsToLocalTime(long mills) {
        return millsToLocalTime(mills, ZONE_ID_GMT);
    }

    public static LocalTime secondsToLocalTime(long seconds, ZoneId zoneId) {
        Instant instant = Instant.ofEpochSecond(seconds);
        return LocalTime.ofInstant(instant, zoneId);
    }

    public static LocalTime secondsToLocalTime(long seconds, String zoneId) {
        return secondsToLocalTime(seconds, ZoneId.of(zoneId));
    }

    public static LocalTime secondsToLocalTime(long seconds) {
        return secondsToLocalTime(seconds, ZONE_ID_GMT);
    }

    // ============================================================//

    public static ZonedDateTime secondsToZonedDateTime(long seconds, ZoneId zoneId) {
        Instant instant = Instant.ofEpochSecond(seconds);
        return ZonedDateTime.ofInstant(instant, zoneId);
    }

    public static ZonedDateTime secondsToZonedDateTime(long seconds, String zoneId) {
        return secondsToZonedDateTime(seconds, ZoneId.of(zoneId));
    }

    public static ZonedDateTime secondsToZonedDateTime(long seconds) {
        return secondsToZonedDateTime(seconds, ZONE_ID_GMT);
    }

    public static ZonedDateTime millsToZonedDateTime(long mills, ZoneId zoneId) {
        Instant instant = Instant.ofEpochMilli(mills);
        return ZonedDateTime.ofInstant(instant, zoneId);
    }

    public static ZonedDateTime millsToZonedDateTime(long mills, String zoneId) {
        return millsToZonedDateTime(mills, ZoneId.of(zoneId));
    }

    public static ZonedDateTime millsToZonedDateTime(long mills) {
        return millsToZonedDateTime(mills, ZONE_ID_GMT);
    }

    // ==============================================================//

    public static int[] millsToHMS(long mills, ZoneId zoneId) {
        LocalTime localTime = millsToLocalTime(mills, zoneId);
        return new int[]{localTime.getHour(), localTime.getMinute(), localTime.getSecond()};
    }

    public static int[] millsToHMS(long mills, String zoneId) {
        return millsToHMS(mills, ZoneId.of(zoneId));
    }

    public static int[] millsToHMS(long mills) {
        return millsToHMS(mills, ZONE_ID_GMT);
    }

    public static int[] secondsToHMS(long seconds, ZoneId zoneId) {
        LocalTime localTime = secondsToLocalTime(seconds, zoneId);
        return new int[]{localTime.getHour(), localTime.getMinute(), localTime.getSecond()};
    }

    public static int[] secondsToHMS(long seconds, String zoneId) {
        return secondsToHMS(seconds, ZoneId.of(zoneId));
    }

    public static int[] secondsToHMS(long seconds) {
        return secondsToHMS(seconds, ZONE_ID_GMT);
    }

    public static long nowMills() {
        return Instant.now().toEpochMilli();
    }

    public static long nowSecond() {
        return Instant.now().getEpochSecond();
    }

    public static long startMillsOfSameDay(long mills, ZoneId zoneId) {
        Instant instant = Instant.ofEpochMilli(mills);
        LocalDateTime localDateTime = LocalDate.ofInstant(instant, zoneId).atTime(0, 0, 0, 0);
        return localDateTime.atZone(zoneId).toInstant().toEpochMilli();
    }

    public static long startMillsOfSameDay(long mills, String zoneId) {
        return startMillsOfSameDay(mills, ZoneId.of(zoneId));
    }

    public static long startMillsOfSameDay(long mills) {
        return startMillsOfSameDay(mills, ZONE_ID_GMT);
    }

    public static long endMillsOfSameDay(long mills, ZoneId zoneId) {
        Instant instant = Instant.ofEpochMilli(mills);
        LocalDateTime localDateTime = LocalDate.ofInstant(instant, zoneId).atTime(23, 59, 59, 999999999);
        return localDateTime.atZone(zoneId).toInstant().toEpochMilli();
    }

    public static long endMillsOfSameDay(long mills, String zoneId) {
        return endMillsOfSameDay(mills, ZoneId.of(zoneId));
    }

    public static long endMillsOfSameDay(long mills) {
        return endMillsOfSameDay(mills, ZONE_ID_GMT);
    }

    public static long startSecondsOfSameDay(long seconds, ZoneId zoneId) {
        Instant instant = Instant.ofEpochSecond(seconds);
        LocalDateTime localDateTime = LocalDate.ofInstant(instant, zoneId).atTime(0, 0, 0, 0);
        return localDateTime.atZone(zoneId).toInstant().getEpochSecond();
    }

    public static long startSecondsOfSameDay(long seconds, String zoneId) {
        return startSecondsOfSameDay(seconds, ZoneId.of(zoneId));
    }

    public static long startSecondsOfSameDay(long seconds) {
        return startSecondsOfSameDay(seconds, ZONE_ID_GMT);
    }

    public static long endSecondsOfSameDay(long seconds, ZoneId zoneId) {
        Instant instant = Instant.ofEpochSecond(seconds);
        LocalDateTime localDateTime = LocalDate.ofInstant(instant, zoneId).atTime(23, 59, 59, 999999999);
        return localDateTime.atZone(zoneId).toInstant().getEpochSecond();
    }

    public static long endSecondsOfSameDay(long seconds, String zoneId) {
        return endSecondsOfSameDay(seconds, ZoneId.of(zoneId));
    }

    public static long endSecondsOfSameDay(long seconds) {
        return endSecondsOfSameDay(seconds, ZONE_ID_GMT);
    }


    public static boolean isSameDayOfMills(long mills1, long mills2, ZoneId zoneId) {
        if (Math.abs(mills1 - mills2) > DAY_IN_MILLS) {
            return false;
        }

        LocalDate localDate1 = millsToLocalDate(mills1, zoneId);
        LocalDate localDate2 = millsToLocalDate(mills2, zoneId);

        return localDate1.isEqual(localDate2);
    }

    public static boolean isSameDayOfMills(long mills1, long mills2, String zoneId) {
        return isSameDayOfMills(mills1, mills2, ZoneId.of(zoneId));
    }

    public static boolean isSameDayOfMills(long mills1, long mills2) {
        return isSameDayOfMills(mills1, mills2, ZONE_ID_GMT);
    }

    public static boolean isSameDayOfSeconds(long seconds1, long seconds2, ZoneId zoneId) {
        if (Math.abs(seconds1 - seconds2) > DAY_IN_SECONDS) {
            return false;
        }

        LocalDate localDate1 = secondsToLocalDate(seconds1, zoneId);
        LocalDate localDate2 = secondsToLocalDate(seconds2, zoneId);

        return localDate1.isEqual(localDate2);
    }

    public static boolean isSameDayOfSeconds(long seconds1, long seconds2, String zoneId) {
        return isSameDayOfSeconds(seconds1, seconds2, ZoneId.of(zoneId));
    }

    public static boolean isSameDayOfSeconds(long seconds1, long seconds2) {
        return isSameDayOfSeconds(seconds1, seconds2, ZONE_ID_GMT);
    }


    // ====================================================================//

    public static long startMillsOfYear(int year, ZoneId zoneId) {
        LocalDateTime localDateTime = LocalDateTime.of(year, 1, 1, 0, 0, 0, 0);
        return localDateTime.atZone(zoneId).toInstant().toEpochMilli();
    }

    public static long startMillsOfYear(int year, String zoneId) {
        return startMillsOfYear(year, ZoneId.of(zoneId));
    }

    public static long startMillsOfYear(int year) {
        return startMillsOfYear(year, ZONE_ID_GMT);
    }

    public static long endMillsOfYear(int year, ZoneId zoneId) {
        LocalDateTime localDateTime = LocalDateTime.of(year, 12, 31, 23, 59, 59, 999999999);
        return localDateTime.atZone(zoneId).toInstant().toEpochMilli();
    }

    public static long endMillsOfYear(int year, String zoneId) {
        return endMillsOfYear(year, ZoneId.of(zoneId));
    }

    public static long endMillsOfYear(int year) {
        return endMillsOfYear(year, ZONE_ID_GMT);
    }

    public static long startSecondsOfYear(int year, ZoneId zoneId) {
        LocalDateTime localDateTime = LocalDateTime.of(year, 1, 1, 0, 0, 0, 0);
        return localDateTime.atZone(zoneId).toInstant().getEpochSecond();
    }

    public static long startSecondsOfYear(int year, String zoneId) {
        return startSecondsOfYear(year, ZoneId.of(zoneId));
    }

    public static long startSecondsOfYear(int year) {
        return startSecondsOfYear(year, ZONE_ID_GMT);
    }

    public static long endSecondsOfYear(int year, ZoneId zoneId) {
        LocalDateTime localDateTime = LocalDateTime.of(year, 12, 31, 23, 59, 59, 999999999);
        return localDateTime.atZone(zoneId).toInstant().getEpochSecond();
    }

    public static long endSecondsOfYear(int year, String zoneId) {
        return endSecondsOfYear(year, ZoneId.of(zoneId));
    }

    public static long endSecondsOfYear(int year) {
        return endSecondsOfYear(year, ZONE_ID_GMT);
    }

}
