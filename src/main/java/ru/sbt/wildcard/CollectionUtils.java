package ru.sbt.wildcard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionUtils {

    public static <T> void addAll(List<? extends T> source, List<? super T> destination) {
        if ((source == null) || (destination == null)) {
            return;
        }
        for (T t : source) {
            destination.add(t);
        }
    }

    public static <T> List<? extends T> newArrayList() {
        List<? extends T> result = new ArrayList<>();
        return result;
    }


    public static <T> int indexOf(List<? extends T> source, T o) {
        int result = -1;
        for (int i = 0; i < source.size(); i++) {
            if (o.equals(source.get(i))) {
                result = i;
                break;
            }
        }
        return result;
    }

    public static <T> List<T> limit(List<T> source, int size) {
        // TODO: 02.08.16
        return null;
    }

    public static <T> void add(List<? super T> source, T o) {
        source.add(o);
    }

    public static <T> void removeAll(List<? super T> removeFrom, List<? extends T> c2) {
        if ((removeFrom == null) || (c2 == null)) {
            return;
        }
        for (T t : c2) {
            if (indexOf(removeFrom, t) != -1) {
                removeFrom.remove(indexOf(removeFrom, t));
            }
        }
    }

    public static <T> boolean containsAll(List<T> c1, List<T> c2) {
        if ((c1 == null) || (c2 == null)) {
            return false;
        }
        if (c1.size() < c2.size()) {
            return false;
        }
        for (T t : c2) {
            if (indexOf(c1, t) == -1) {
                return false;
            }
        }
        return true;
    }

    public static <T> boolean containsAny(List<? extends T> c1, List<? extends T> c2) {
        if ((c1 == null) || (c2 == null)) {
            return false;
        }
        for (T t : c2) {
            if (indexOf(c1, t) >= 0) {
                return true;
            }
        }
        return false;
    }

    public static <T extends Comparable<? super T>> List<T> range(List<T> list, T min, T max) {
        return range(list, min, max, null);
    }

    public static <T extends Comparable<? super T>> List<T> range(List<T> list, T min, T max, Comparator<T> comparator) {
        Collections.sort(list, comparator);
        int minIndex = list.indexOf(min);
        int maxIndex = list.indexOf(max);
        if (minIndex > maxIndex) {
            int temp = minIndex;
            minIndex = maxIndex;
            maxIndex = temp;
        }
        return list.subList(minIndex, (maxIndex + 1));
    }

}