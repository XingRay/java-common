package com.xingray.java.container.test;

import com.xingray.java.container.container.Containers;
import com.xingray.java.container.interfaces.container.Container;
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

    @Test
    public void mergeTest() {
        Container<Integer, String> sourceContainer = Containers.ofValues("a", "bb", "ccc");
        System.out.println(sourceContainer);
        Container<Integer, String> targetContainer = Containers.ofValues("dddd", "eeeee");
        System.out.println(targetContainer);

        Container<Integer, String> mergedContainer = sourceContainer.merge(targetContainer, null);
        System.out.println(mergedContainer);
        String[] array = mergedContainer.toArray();
        assert array.length == 5;
        assert array[0].equals("a");
        assert array[1].equals("bb");
        assert array[2].equals("ccc");
        assert array[3].equals("dddd");
        assert array[4].equals("eeeee");
    }
}
