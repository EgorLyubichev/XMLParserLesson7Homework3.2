package by.lev;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.Iterator;
import utilities.ListADT;
import utilities.MyDLL;

import java.util.NoSuchElementException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import static org.testng.internal.junit.ArrayAsserts.assertArrayEquals;

public class MyDLLTest {

    ListADT<String> list;

    @BeforeMethod
    public void initializeList() {
        list = new MyDLL<>();
    }

    @Test
    public void testIsEmpty() {
        assertTrue(list.isEmpty());
    }

    @Test
    public void testIsNotEmpty() {
        list.add("One");
        assertFalse(list.isEmpty());
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void testToArrayNullInParameter() {
        list.toArray(null);
    }

    @Test
    public void testToArrayWithArrayInParameter() {
        String[] expected = {"One", "Two", "Three"};
        assertArrayEquals(list.toArray(expected), expected);
    }

    @Test
    public void testContains() {
        list.add("One");
        list.add("Two");
        list.add("Three");
        assertTrue(list.contains("Three"));
    }

    @Test
    public void testDontContains() {
        list.add("One");
        list.add("Two");
        list.add("Three");
        assertFalse(list.contains("Four"));
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void testDontContainsNull() {
        list.add("One");
        list.add("Two");
        list.add("Three");
        list.contains(null);
    }

    @Test
    public void testIterator() {
        list.add("One");
        list.add("Two");
        list.add("Three");

        ListADT<String> expected = new MyDLL<>();

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            expected.add(iterator.next());
        }
        assertArrayEquals(list.toArray(), expected.toArray());
    }

    @Test(expectedExceptions = NoSuchElementException.class)
    public void testIteratorIfIsNotNext() {
        Iterator<String> iterator = list.iterator();
        iterator.next();
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void testAddNull() {
        list.add(null);
    }

    @Test
    public void testAddAll() {
        ListADT<String> toAdd = new MyDLL<>();
        toAdd.add("One");
        toAdd.add("Two");
        toAdd.add("Three");
        list.addAll(toAdd);

        assertArrayEquals(list.toArray(), toAdd.toArray());
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void testAddAllNull() {
        list.addAll(null);
    }

    @Test
    public void testAddAllEmpty() {
        assertTrue(list.addAll(new MyDLL<String>()));
    }

    @Test
    public void testRemoveByElementGetArrayWithoutTheElement() {
        list.add("One");
        list.add("Two");
        list.add("Three");

        list.remove("One");

        String[] expected = {"Two", "Three"};

        assertArrayEquals(list.toArray(), expected);
    }

    @Test
    public void testRemoveByElementGetActualSize() {
        list.add("One");
        list.add("Two");
        list.add("Three");

        list.remove("One");

        assertEquals(list.size(), 2);
    }

    @Test
    public void testRemoveByIndex() {
        list.add("One");
        list.add("Two");
        list.add("Three");

        list.remove(0);

        String[] expected = {"Two", "Three"};

        assertArrayEquals(list.toArray(), expected);
    }

    @Test(expectedExceptions = IndexOutOfBoundsException.class)
    public void testRemoveByNegativeIndex(){
        list.remove(-1);
    }

    @Test(expectedExceptions = IndexOutOfBoundsException.class)
    public void testRemoveByIndexFromEmptyList(){
        list.remove(1);
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void testRemoveNull() {
        list.add("One");
        list.add("Two");
        list.add("Three");

        list.remove(null);
    }

    @Test
    public void testClear() {
        list.add("One");
        list.add("Two");
        list.add("Three");

        list.clear();

        assertTrue(list.isEmpty());
    }

    @Test
    public void testAddByIndex() {
        list.add("One");
        list.add("Three");

        list.add(1, "Two");

        String[] expected = {"One", "Two", "Three"};

        assertArrayEquals(list.toArray(), expected);
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void testAddByIndexNull() {
        list.add("One");
        list.add("Three");

        list.add(1, null);
    }

    @Test
    public void testAddByZeroIndex() {
        list.add("Two");
        list.add("Three");

        list.add(0, "One");

        String[] expected = {"One", "Two", "Three"};

        assertArrayEquals(list.toArray(), expected);
    }

    @Test(expectedExceptions = IndexOutOfBoundsException.class)
    public void testAddByNegativeIndex(){
        list.add(-1, "One");
    }

    @Test
    public void testGet(){
        list.add("One");
        list.add("Two");
        list.add("Three");

        assertEquals(list.get(0), "One");
    }

    @Test (expectedExceptions = IndexOutOfBoundsException.class)
    public void testGetByNegativeIndex(){
        list.add("One");
        list.add("Two");
        list.add("Three");

        list.get(-1);
    }

    @Test
    public void testSet(){
        list.add("Four");
        list.add("Two");
        list.add("Three");

        list.set(0, "One");

        String[]expected = {"One", "Two", "Three"};

        assertArrayEquals(list.toArray(), expected);
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void testSetNull(){
        list.add("One");
        list.add("Two");
        list.add("Three");

        list.set(0, null);
    }

    @Test(expectedExceptions = IndexOutOfBoundsException.class)
    public void testSetNegativeIndex(){
        list.add("One");
        list.add("Two");
        list.add("Three");

        list.set(-1, "Zero");
    }

    @Test(expectedExceptions = IndexOutOfBoundsException.class)
    public void testSetNoExistIndex(){
        list.add("One");
        list.add("Two");
        list.add("Three");

        list.set(3, "Four");
    }



}


