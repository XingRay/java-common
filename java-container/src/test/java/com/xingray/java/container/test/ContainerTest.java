package com.xingray.java.container.test;


import com.xingray.java.container.container.Container;
import com.xingray.java.container.container.Containers;
import org.junit.jupiter.api.Test;

public class ContainerTest {

    @Test
    public void sizeTest() {
        Container<Integer, String> stringContainer = Containers.empty();
        int size = stringContainer.size();
        System.out.println(size);
        assert size == 0;
    }

    @Test
    public void findTest() {
        String value = Containers.ofValues("aaa", "bbbb", "cccc").find(v -> v.length() == 4);
        System.out.println(value);
        assert value.equals("bbbb");
    }


}
