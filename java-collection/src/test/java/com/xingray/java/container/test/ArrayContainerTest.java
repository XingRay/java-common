package com.xingray.java.container.test;

import com.xingray.java.container.container.Container;
import com.xingray.java.container.container.Containers;
import org.junit.jupiter.api.Test;

public class ArrayContainerTest {

    @Test
    public void findAllTest01() {
        Container<Integer, String> container = Containers.ofValues("a", "bb", "ccc").findAll(e -> e.length() >= 4);
        System.out.println(container);
        assert container.size() == 0;
        String[] array = container.toArray();
        System.out.println(array);
    }

    @Test
    public void findAllTest02() {
        Container<Integer, String> container = Containers.ofValues("a", "bb", "ccc").findAll(e -> e.length() < 4);
        System.out.println(container);
        assert container.size() == 0;
        String[] array = container.toArray();
        System.out.println(array);
    }

    @Test
    public void findTest01() {
        String s = Containers.ofValues("a", "bb", "ccc").find(e -> e.length() == 3);
        System.out.println(s);
        assert s.equals("ccc");
    }
}
