import org.junit.Test;
import ru.sbt.wildcard.CollectionUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestCollectionUtils {

    @Test
    public void testAddAll() {
        List<String> listSource = new ArrayList<>();
        listSource.add("1111");
        listSource.add("2222");
        List<String> listDestination = new ArrayList<>();
        CollectionUtils.addAll(listSource, listDestination);
        for (int i = 0; i < listSource.size(); i++) {
            assertEquals(listSource.get(i), listDestination.get(i));
        }
    }

    @Test
    public void testCreateNewList() {
        List<Number> list1 = (List<Number>) CollectionUtils.newArrayList();
        List<String> list2 = (List<String>) CollectionUtils.newArrayList();
        list1.add(34);
        list2.add("111");
        assertEquals(34, list1.get(0));
        assertEquals("111", list2.get(0));
    }

    @Test
    public void testAdd() {
        List<Number> list = new ArrayList<>();
        list.add(6);
        assertEquals(6, list.get(0));
    }

    @Test
    public void testIndexOf() {
        List<String> listSource = new ArrayList<>();
        listSource.add("1111");
        listSource.add("2222");
        assertEquals(0, CollectionUtils.indexOf(listSource, "1111"));
        assertEquals(1, CollectionUtils.indexOf(listSource, "2222"));
        assertEquals(-1, CollectionUtils.indexOf(listSource, "1122"));
    }

    @Test
    public void testRemoveAll() {
        List<String> listSource = new ArrayList<>();
        listSource.add("1111");
        listSource.add("2222");
        listSource.add("3333");
        List<String> list = new ArrayList<>();
        list.add("1111");
        list.add("2222");
        CollectionUtils.removeAll(listSource, list);
        assertEquals(1, listSource.size());
        assertEquals(0, CollectionUtils.indexOf(listSource, "3333"));
    }

    @Test
    public void testContainsAll() {
        List<String> list1 = new ArrayList<>();
        list1.add("1111");
        list1.add("2222");
        list1.add("3333");
        List<String> list2 = new ArrayList<>();
        list2.add("1111");
        list2.add("2222");
        assertTrue(CollectionUtils.containsAll(list1, list2));
        list2.add("4444");
        assertFalse(CollectionUtils.containsAll(list1, list2));
        list2.remove(2);
        list2.add("3333");
        assertTrue(CollectionUtils.containsAll(list1, list2));
    }

    @Test
    public void testContainsAny() {
        List<String> list1 = new ArrayList<>();
        list1.add("1111");
        list1.add("2222");
        list1.add("3333");
        List<String> list2 = new ArrayList<>();
        list2.add("4444");
        assertFalse(CollectionUtils.containsAny(list1, list2));
        list2.add("3333");
        assertTrue(CollectionUtils.containsAny(list1, list2));
    }

    @Test
    public void testRange() {
        List<String> list = new ArrayList<>();
        list.add("5555");
        list.add("2222");
        list.add("3333");
        list.add("1111");
        list.add("4444");
        List<String> resultRang = CollectionUtils.range(list, "2222", "4444");
        assertEquals("2222", resultRang.get(0));
        assertEquals("3333", resultRang.get(1));
        assertEquals("4444", resultRang.get(2));
    }

    @Test
    public void testRangeWithComparator() {
        List<String> list = new ArrayList<>();
        list.add("5555");
        list.add("2222");
        list.add("3333");
        list.add("1111");
        list.add("4444");
        List<String> resultRang = CollectionUtils.range(list, "2222", "4444", new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return -1 * o1.compareTo(o2);
            }
        });
        assertEquals("4444", resultRang.get(0));
        assertEquals("3333", resultRang.get(1));
        assertEquals("2222", resultRang.get(2));
    }
}