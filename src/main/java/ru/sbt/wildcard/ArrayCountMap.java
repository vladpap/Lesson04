package ru.sbt.wildcard;


import java.util.*;

public class ArrayCountMap<E> implements CountMap<E> {
    private final Map<E, Integer> countMap;

    public ArrayCountMap() {
        countMap = new HashMap<>();
    }

    @Override
    public void add(E o) {
        this.addOfNumber(o, 1);
    }

    private void addOfNumber(E o, Integer integer) {
        int count = (countMap.get(o) == null ? 0 : countMap.get(o));
        count += integer;
        countMap.put(o, count);
    }

    @Override
    public void addAll(CountMap<? extends E> o) {
        Map<E, Integer> addMap = new HashMap<E, Integer>(o.toMap());
        for (Map.Entry<E, Integer> entry : addMap.entrySet()) {
            addOfNumber(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public int getCount(E o) {
        Integer count = countMap.get(o);
        return (count == null) ? 0 : count;
    }

    @Override
    public int remove(E o) {
        int count = 0;
        if (countMap.get(o) != null) {
            count = countMap.get(o);
            if (count > 1) {
                countMap.put(o, (count - 1));
            } else {
                countMap.remove(o);
            }
        }
        return count;
    }

    @Override
    public int size() {
        return countMap.size();
    }

    @Override
    public Map toMap() {
        return new HashMap<>(countMap);
    }

    @Override
    public void toMap(Map<? super E, Integer> destination) {
        if (destination == null) {
            return;
        }
        destination.putAll(countMap);
    }

}