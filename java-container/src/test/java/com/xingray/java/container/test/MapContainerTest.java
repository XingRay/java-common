package com.xingray.java.container.test;

import com.xingray.java.container.container.Containers;
import com.xingray.java.container.interfaces.container.Container;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class MapContainerTest {

    @Test
    public void mergeTest() {
        Container<String, Integer> source = Containers.of(Map.of("a", 1, "bb", 2));
        Container<String, Integer> target = Containers.of(Map.of("a", 2, "ccc", 4));
        Container<String, Integer> merged = source.merge(target, Integer::sum);
        System.out.println(merged);
        Map<String, Integer> mergedMap = merged.toMap();
        assert mergedMap.get("a").equals(3);
        assert mergedMap.get("bb").equals(2);
        assert mergedMap.get("ccc").equals(4);
    }
}
