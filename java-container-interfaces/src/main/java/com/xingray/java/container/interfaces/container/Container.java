package com.xingray.java.container.interfaces.container;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public interface Container<Index, Value> {
    Value get(Index index);

    void set(Index index, Value value);

    int size();

    default boolean hasElement() {
        return size() > 0;
    }

    default boolean isEmpty() {
        return size() == 0;
    }

    List<Value> toList();

    Value[] toArray();

    Map<Index, Value> toMap();

    Set<Value> toSet();

    Value find(Predicate<Value> predicate);

    Container<Index, Value> findAll(Predicate<Value> predicate);

    /**
     * 合并容器
     *
     * @param container  待合并的容器
     * @param biConsumer 两个值的合并策略，线性表的合并忽略这个策略，相当于addAll
     * @return 新的容器，包含两个容器合并后的结果
     */
    Container<Index, Value> merge(Container<Index, Value> container, BiFunction<Value, Value, Value> biConsumer);

    Container<Index, Value> copy();
}
