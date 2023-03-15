package Portfolio_Challenge.Lists;

import Portfolio_Challenge.Lists.LinkedList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {

    private LinkedList linkedList;

    @BeforeEach
    public void setup() {
        linkedList = new LinkedList();
        linkedList.addFirst("One");
        linkedList.addLast("Two");
        linkedList.addLast("Three");
    }

    @Test
    public void testToString() {
        String expected = "Contents:{One,Two,Three}";
        String actual = linkedList.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void testIsEmpty() {
        assertFalse(linkedList.isEmpty());
    }

    @Test
    public void testSize() {
        int expected = 3;
        int actual = linkedList.size();
        assertEquals(expected, actual);
    }

    @Test
    public void testContains() {
        assertFalse(linkedList.contains("Hello"));
        assertTrue(linkedList.contains("Two"));
    }

    @Test
    public void testAddFirst() {
        boolean added = linkedList.addFirst("BeforeOne");
        assertTrue(added);
        int expectedSize = 4;
        int actualSize = linkedList.size();
        assertEquals(expectedSize, actualSize);
        String expectedString = "Contents:{BeforeOne,One,Two,Three}";
        String actualString = linkedList.toString();
        assertEquals(expectedString, actualString);
    }

    @Test
    public void testAddLast() {
        boolean added = linkedList.addLast("AfterThree");
        assertTrue(added);
        int expectedSize = 4;
        int actualSize = linkedList.size();
        assertEquals(expectedSize, actualSize);
        String expectedString = "Contents:{One,Two,Three,AfterThree}";
        String actualString = linkedList.toString();
        assertEquals(expectedString, actualString);
    }

    @Test
    public void testAdd() {
        boolean added1 = linkedList.add(0, "BeforeOne");
        boolean added2 = linkedList.add(3, "BeforeThree");
        assertTrue(added1);
        assertTrue(added2);
        String expectedString = "Contents:{BeforeOne,One,Two,BeforeThree,Three}";
        String actualString = linkedList.toString();
        assertEquals(expectedString, actualString);
    }

    @Test
    public void testFirst() {
        String expected = "One";
        String actual = linkedList.first();
        assertEquals(expected, actual);
    }

    @Test
    public void testLast() {
        String expected = "Three";
        String actual = linkedList.last();
        assertEquals(expected, actual);
    }


    @Test
    public void testGet() {
        String expected1 = "One";
        String actual1 = linkedList.get(0);
        assertEquals(expected1, actual1);

        String expected2 = "Three";
        String actual2 = linkedList.get(2);
        assertEquals(expected2, actual2);
    }

    @Test
    public void testRemoveFirst() {
        String expected = "One";
        String actual = linkedList.removeFirst();
        assertEquals(expected, actual);
        expected = "Two";
        actual = linkedList.first();
        assertEquals(expected, actual);
    }

    @Test
    public void testRemoveLast() {
        String expected = "Three";
        String actual = linkedList.removeLast();
        assertEquals(expected, actual);
        expected = "Two";
        actual = linkedList.last();
        assertEquals(expected, actual);
    }

    @Test
    public void testRemoveElement() {
        boolean removed = linkedList.remove("Two");
        assertTrue(removed);
        String expectedString = "Contents:{One,Three}";
        String actualString = linkedList.toString();
        assertEquals(expectedString, actualString);
    }

    @Test
    public void testRemoveIndex() {
        String expected = "Three";
        String actual = linkedList.remove(2);
        assertEquals(expected, actual);
        String expectedString = "Contents:{One,Two}";
        String actualString = linkedList.toString();
        assertEquals(expectedString, actualString);
    }

    @Test
    public void testPush() {
        String expected = "BeforeOne";
        String actual = linkedList.push("BeforeOne");
        assertEquals(expected, actual);
        String expectedString = "Contents:{BeforeOne,One,Two,Three}";
        String actualString = linkedList.toString();
        assertEquals(expectedString, actualString);
    }

    @Test
    public void testTop() {
        String expected = "One";
        String actual = linkedList.top();
        assertEquals(expected, actual);
    }

    @Test
    public void testPop() {
        String expected = "One";
        String actual = linkedList.pop();
        assertEquals(expected, actual);
        String expectedString = "Contents:{Two,Three}";
        String actualString = linkedList.toString();
        assertEquals(expectedString, actualString);
    }

    @Test
    public void testEnQueue() {
        boolean added = linkedList.enqueue("AfterThree");
        assertTrue(added);
    }

    @Test
    public void testDeQueue() {
        String expected = "One";
        String actual = linkedList.dequeue();
        assertEquals(expected, actual);
    }
}
