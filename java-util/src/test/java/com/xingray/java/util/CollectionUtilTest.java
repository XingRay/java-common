package com.xingray.java.util;

import com.xingray.java.base.interfaces.Mapper;
import com.xingray.java.util.collection.CollectionUtil;
import com.xingray.java.util.entity.User;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class CollectionUtilTest {

    @Test
    public void iteratorToArrayTest01() {
        List<User> userList = Arrays.asList(new User(1L, "aaa"), new User(2L, "bbb"));
        String[] nameArray = CollectionUtil.toArray(userList, new String[userList.size()], new Mapper<User, String>() {
            @Override
            public String map(User user) {
                return user.getUsername();
            }
        });
        System.out.println(StringUtil.toString(nameArray, "\t"));
        assert nameArray.length == 2;
    }
}
