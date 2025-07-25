package com.kata;

import com.kata.interfaces.List;
import static org.junit.jupiter.api.Assertions.*;

public class ListTest {
    
    public static void testList(List<Integer> list) {
        list.append(5);
        list.append(7);
        list.append(9);

        assertEquals(9, list.get(2));
        assertEquals(7, list.removeAt(1));
        assertEquals(2, list.getLength());

        list.append(11);
        assertEquals(9, list.removeAt(1));
        assertNull(list.remove(9));
        assertEquals(5, list.removeAt(0));
        assertEquals(11, list.removeAt(0));
        assertEquals(0, list.getLength());

        list.prepend(5);
        list.prepend(7);
        list.prepend(9);

        assertEquals(5, list.get(2));
        assertEquals(9, list.get(0));
        assertEquals(9, list.remove(9));
        assertEquals(2, list.getLength());
        assertEquals(7, list.get(0));
    }
}