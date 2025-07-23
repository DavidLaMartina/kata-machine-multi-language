package com.kata;

import com.kata.interfaces.List;
import com.kata.types.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

public class AlgorithmTest {
    
    private String getCurrentDay() {
        return System.getProperty("kata.current.day", "day1");
    }
    
    @Test
    public void testArrayList() throws Exception {
        String currentDay = getCurrentDay();
        Class<?> arrayListClass = Class.forName("com.kata." + currentDay + ".ArrayList");
        Constructor<?> constructor = arrayListClass.getConstructor();
        
        @SuppressWarnings("unchecked")
        List<Integer> list = (List<Integer>) constructor.newInstance();
        
        ListTest.testList(list);
    }
    
    @Test
    public void testSinglyLinkedList() throws Exception {
        String currentDay = getCurrentDay();
        Class<?> listClass = Class.forName("com.kata." + currentDay + ".SinglyLinkedList");
        Constructor<?> constructor = listClass.getConstructor();
        
        @SuppressWarnings("unchecked")
        List<Integer> list = (List<Integer>) constructor.newInstance();
        
        ListTest.testList(list);
    }
    
    @Test
    public void testDoublyLinkedList() throws Exception {
        String currentDay = getCurrentDay();
        Class<?> listClass = Class.forName("com.kata." + currentDay + ".DoublyLinkedList");
        Constructor<?> constructor = listClass.getConstructor();
        
        @SuppressWarnings("unchecked")
        List<Integer> list = (List<Integer>) constructor.newInstance();
        
        ListTest.testList(list);
    }
    
    @Test
    public void testQueue() throws Exception {
        String currentDay = getCurrentDay();
        Class<?> queueClass = Class.forName("com.kata." + currentDay + ".Queue");
        Constructor<?> constructor = queueClass.getConstructor();
        Object queue = constructor.newInstance();
        
        Method enqueue = queueClass.getMethod("enqueue", Object.class);
        Method deque = queueClass.getMethod("deque");
        Method peek = queueClass.getMethod("peek");
        
        enqueue.invoke(queue, 5);
        enqueue.invoke(queue, 7);
        enqueue.invoke(queue, 9);
        
        assertEquals(5, peek.invoke(queue));
        assertEquals(5, deque.invoke(queue));
        assertEquals(7, deque.invoke(queue));
        assertEquals(9, peek.invoke(queue));
        assertEquals(9, deque.invoke(queue));
    }
    
    @Test
    public void testStack() throws Exception {
        String currentDay = getCurrentDay();
        Class<?> stackClass = Class.forName("com.kata." + currentDay + ".Stack");
        Constructor<?> constructor = stackClass.getConstructor();
        Object stack = constructor.newInstance();
        
        Method push = stackClass.getMethod("push", Object.class);
        Method pop = stackClass.getMethod("pop");
        Method peek = stackClass.getMethod("peek");
        
        push.invoke(stack, 5);
        push.invoke(stack, 7);
        push.invoke(stack, 9);
        
        assertEquals(9, peek.invoke(stack));
        assertEquals(9, pop.invoke(stack));
        assertEquals(7, pop.invoke(stack));
        assertEquals(5, peek.invoke(stack));
        assertEquals(5, pop.invoke(stack));
    }
    
    @Test
    public void testBinarySearch() throws Exception {
        String currentDay = getCurrentDay();
        Class<?> binarySearchClass = Class.forName("com.kata." + currentDay + ".BinarySearchList");
        Method binarySearch = binarySearchClass.getMethod("binarySearch", int[].class, int.class);
        
        int[] arr = {1, 3, 4, 69, 71, 81, 90, 99, 420, 1337, 69420};
        
        assertTrue((Boolean) binarySearch.invoke(null, arr, 69));
        assertFalse((Boolean) binarySearch.invoke(null, arr, 1336));
        assertTrue((Boolean) binarySearch.invoke(null, arr, 69420));
        assertFalse((Boolean) binarySearch.invoke(null, arr, 69421));
        assertTrue((Boolean) binarySearch.invoke(null, arr, 1));
        assertFalse((Boolean) binarySearch.invoke(null, arr, 0));
    }
    
    @Test
    public void testLinearSearch() throws Exception {
        String currentDay = getCurrentDay();
        Class<?> linearSearchClass = Class.forName("com.kata." + currentDay + ".LinearSearchList");
        Method linearSearch = linearSearchClass.getMethod("linearSearch", int[].class, int.class);
        
        int[] foo = {1, 3, 4, 69, 71, 81, 90, 99, 420, 1337, 69420};
        
        assertTrue((Boolean) linearSearch.invoke(null, foo, 69));
        assertFalse((Boolean) linearSearch.invoke(null, foo, 1336));
        assertTrue((Boolean) linearSearch.invoke(null, foo, 69420));
        assertFalse((Boolean) linearSearch.invoke(null, foo, 69421));
        assertTrue((Boolean) linearSearch.invoke(null, foo, 1));
        assertFalse((Boolean) linearSearch.invoke(null, foo, 0));
    }
    
    @Test
    public void testTwoCrystalBalls() throws Exception {
        String currentDay = getCurrentDay();
        Class<?> crystalBallsClass = Class.forName("com.kata." + currentDay + ".TwoCrystalBalls");
        Method twoCrystalBalls = crystalBallsClass.getMethod("twoCrystalBalls", boolean[].class);
        
        int idx = 25;
        boolean[] data = new boolean[100];
        for (int i = idx; i < 100; ++i) {
            data[i] = true;
        }
        
        assertEquals(idx, (Integer) twoCrystalBalls.invoke(null, (Object) data));
        assertEquals(-1, (Integer) twoCrystalBalls.invoke(null, (Object) new boolean[821]));
    }
    
    @Test
    public void testBubbleSort() throws Exception {
        String currentDay = getCurrentDay();
        Class<?> bubbleSortClass = Class.forName("com.kata." + currentDay + ".BubbleSort");
        Method bubbleSort = bubbleSortClass.getMethod("bubbleSort", int[].class);
        
        int[] arr = {9, 3, 7, 4, 69, 420, 42};
        bubbleSort.invoke(null, (Object) arr);
        
        int[] expected = {3, 4, 7, 9, 42, 69, 420};
        assertArrayEquals(expected, arr);
    }
}