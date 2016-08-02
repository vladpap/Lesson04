package ru.sbt.wildcard;

import java.util.Map;

public interface CountMap<E> {

    void add(E o);

    void addAll(CountMap<? extends E> o);

    int getCount(E o);

    int remove(E o);

    int size();

    Map toMap();

    void toMap(Map<? super E, Integer> destination);

}