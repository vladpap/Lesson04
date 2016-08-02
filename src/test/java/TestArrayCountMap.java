import org.junit.Test;
import ru.sbt.wildcard.ArrayCountMap;
import ru.sbt.wildcard.CountMap;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class TestArrayCountMap {

    @Test
    public void testAddAndSize() {
        CountMap<Integer> map = new ArrayCountMap<>();
        map.add(5);
        assertEquals(1, map.size());
        map.add(12);
        assertEquals(2, map.size());
        map.add(5);
        assertEquals(2, map.size());
    }

    @Test
    public void testGetCount() {
        CountMap<Integer> map = new ArrayCountMap<>();
        map.add(5);
        map.add(12);
        assertEquals(1, map.getCount(5));
        assertEquals(1, map.getCount(12));
        map.add(5);
        assertEquals(2, map.getCount(5));
    }

    @Test
    public void testAddAll() {
        CountMap<Integer> map = new ArrayCountMap<>();
        map.add(1);
        CountMap<Integer> map2 = new ArrayCountMap<>();
        map2.add(1);
        map2.add(1);
        map2.add(1);
        map2.add(1);
        assertEquals(1, map.getCount(1));
        map.addAll(map2);
        assertEquals(5, map.getCount(1));
    }

    @Test
    public void testRemove() {
        CountMap<Integer> map = new ArrayCountMap<>();
        int count;
        count = map.remove(1);
        assertEquals(0, count);
        map.add(1);
        map.add(1);
        count = map.remove(1);
        assertEquals(2, count);
        assertEquals(1, map.getCount(1));
        count = map.remove(1);
        assertEquals(1, count);
        assertEquals(0, map.getCount(1));
    }

    @Test
    public void testToMap() {
        CountMap<Integer> map = new ArrayCountMap<>();
        map.add(1);
        map.add(1);
        map.add(2);
        map.add(3);
        map.add(3);
        Map<Integer, Integer> newMap = new HashMap<>(map.toMap());
        assertEquals(3, newMap.size());
        assertEquals((Integer) 2, newMap.get(1));
        assertEquals((Integer) 1, newMap.get(2));
        assertEquals((Integer) 2, newMap.get(3));
    }

    @Test
    public void testToMap2() {
        CountMap<Integer> map = new ArrayCountMap<>();
        map.add(1);
        map.add(1);
        map.add(2);
        map.add(3);
        map.add(3);
        Map<Integer, Integer> newMap = new HashMap<>();
        map.toMap(newMap);
        assertEquals(3, newMap.size());
        assertEquals((Integer) 2, newMap.get(1));
        assertEquals((Integer) 1, newMap.get(2));
        assertEquals((Integer) 2, newMap.get(3));
    }
}