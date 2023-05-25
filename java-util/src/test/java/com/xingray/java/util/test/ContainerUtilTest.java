package com.xingray.java.util.test;

import com.xingray.java.util.StringUtil;
import com.xingray.java.util.collection.CollectionUtil;
import com.xingray.java.util.test.entity.User;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class ContainerUtilTest {

    @Test
    public void iteratorToArrayTest01() {
        List<User> userList = Arrays.asList(new User(1L, "aaa"), new User(2L, "bbb"));
        String[] nameArray = CollectionUtil.toArray(userList, new String[userList.size()], new Function<User, String>() {
            @Override
            public String apply(User user) {
                return user.getUsername();
            }
        });
        System.out.println(StringUtil.toString(nameArray, "\t"));
        assert nameArray.length == 2;
    }
}
