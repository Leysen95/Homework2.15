package me.skypro.Homework_2._5.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegerArrayListTest {

    private IntegerArrayList list;

    @BeforeEach
    public void setUp() {
        list = new IntegerArrayList(10);
    }

    @Test
    void add() {
        assertEquals(Integer.valueOf(1), list.add(1));
        assertEquals(1, list.size());
        assertEquals(Integer.valueOf(1), list.get(0));
    }

    @Test
    void testAdd() {
        list.add(1);
        list.add(0, 2);
        assertEquals(2, list.size());
        assertEquals(Integer.valueOf(2), list.get(0));
        assertEquals(Integer.valueOf(1), list.get(1));
    }

    @Test
    void set() {
        list.add(1);
        list.set(0, 2);
        assertEquals(Integer.valueOf(2), list.get(0));
    }

    @Test
    void remove() {
        list.add(1);
        list.add(2);
        assertEquals(2, (int) list.remove(2));
        assertEquals(2, list.size());
        assertFalse(list.contains(2));
        assertNotEquals(4, (int) list.remove(4));

    }

    @Test
    void testRemove() {
        list.add(1);
        list.add(2);
        assertEquals(Integer.valueOf(1), list.remove(0));
        assertFalse(list.contains(1));
        assertEquals(1, list.size());
    }

    @Test
    void contains() {
        list.add(1);
        assertTrue(list.contains(1));
        assertFalse(list.contains(2));
    }

    @Test
    void indexOf() {
        int target = 87;
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        list.add(target);

        int index = list.indexOf(target);
        assertNotEquals(index, -1);
    }

    @Test
    void lastIndexOf() {
        list.add(1);
        list.add(2);
        list.add(1);
        assertEquals(2, list.lastIndexOf(1));
        assertEquals(-1, list.lastIndexOf(3));
    }

    @Test
    void get() {
        list.add(1);
        assertEquals(Integer.valueOf(1), list.get(0));
    }

    @Test
    void testEquals() {
        IntegerArrayList anotherList = new IntegerArrayList(10);
        anotherList.add(1);
        anotherList.add(2);
        list.add(1);
        list.add(2);
        assertTrue(list.equals(anotherList));

        anotherList.add(3);
        assertFalse(list.equals(anotherList));
    }

    @Test
    void size() {
        assertEquals(0, list.size());
        list.add(1);
        assertEquals(1, list.size());
    }

    @Test
    void isEmpty() {
        assertTrue(list.isEmpty());
        list.add(1);
        assertFalse(list.isEmpty());
    }

    @Test
    void clear() {
        list.add(1);
        list.clear();
        assertTrue(list.isEmpty());
    }

    @Test
    void toArray() {
        list.add(1);
        list.add(2);
        Integer[] expectedArray = { 1, 2 };
        assertArrayEquals(expectedArray, list.toArray());
    }
}