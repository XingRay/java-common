package com.xingray.java.util;

import org.junit.jupiter.api.Test;

class DateTimeUtilTest {

    @Test
    void testYmdNumberToSeconds() {
        Long seconds = DateTimeUtil.ymdNumberToSeconds(20200101);
        assert seconds == 1577836800;
    }

    @Test
    void testYmdNumberToSeconds02() {
        Long seconds = DateTimeUtil.ymdNumberToSeconds(20200101, DateTimeUtil.ZONE_ID_BEIJING);
        assert seconds == 1577808000;
    }
}