package com.xingray.java.util.test;

import com.xingray.java.util.ObjectUtil;
import com.xingray.java.util.test.entity.User;
import org.junit.jupiter.api.Test;

public class ObjectUtilTest {

    @Test
    public void columnToStringTest() {
        String columnName = ObjectUtil.columnToString(User::getUsername);
        System.out.println(columnName);
        assert columnName.equals("username");
    }
}
