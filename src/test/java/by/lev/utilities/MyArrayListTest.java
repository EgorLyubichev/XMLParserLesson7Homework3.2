package by.lev.utilities;

import org.testng.Assert;
import org.testng.annotations.Test;
import parser.XMLParser;
import parser.XMLTag;
import utilities.Iterator;
import utilities.ListADT;
import utilities.MyArrayList;

import java.lang.reflect.Field;
import java.util.NoSuchElementException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import static org.testng.internal.junit.ArrayAsserts.assertArrayEquals;

public class MyArrayListTest {

    @Test
    public void testMyArrayListGet() {
        ListADT<String> list = new MyArrayList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");

        assertEquals(list.get(1), "Two");
    }

    @Test(expectedExceptions = IndexOutOfBoundsException.class)
    public void testMyArrayListGetMoreThanIndexValue() {
        ListADT<String> list = new MyArrayList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");
        list.get(3);
    }

    @Test(expectedExceptions = IndexOutOfBoundsException.class)
    public void testMyArrayListGetWithNegativeValue() {
        ListADT<String> list = new MyArrayList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");
        list.get(-1);
    }



    @Test
    public void testMyArrayListMethodClear() {
        ListADT<String> listADT = new MyArrayList<>();
        listADT.add("One");
        listADT.add("Two");
        listADT.add("Three");

        listADT.clear();

        assertTrue(listADT.isEmpty());
    }

    @Test
    public void testMyArrayListWithCapacity() {
        ListADT<String> listADT = new MyArrayList<>(1);
        listADT.add("One");
        listADT.add("Two");
        listADT.add("Three");

        assertEquals(listADT.size(), 3);
    }

    @Test
    public void testMyArrayListAddToIndex() {
        ListADT<String> listADT = new MyArrayList<>();

        listADT.add("Two");
        listADT.add("Three");
        listADT.add(0, "One");

        assertEquals(listADT.size(), 3);
    }

    @Test
    public void testMyArrayListAddToIndexAndGetThisElementInTheSpecifiedLocation() {
        ListADT<String> listADT = new MyArrayList<>();

        listADT.add("Two");
        listADT.add("Three");
        listADT.add(0, "One");

        assertEquals(listADT.get(0), "One");
    }

    @Test
    public void testMyArrayListAddToIndexWithCapacity() {
        ListADT<String> listADT = new MyArrayList<>(2);

        listADT.add("Two");
        listADT.add("Three");
        listADT.add(0, "One");

        assertEquals(listADT.size(), 3);
    }



    @Test(expectedExceptions = IndexOutOfBoundsException.class)
    public void testAddElementToNoExistIndex(){
        ListADT<String> list = new MyArrayList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");
        list.add(4, "Five");
    }

    @Test(expectedExceptions = IndexOutOfBoundsException.class)
    public void testAddElementToNegativeIndex(){
        ListADT<String> list = new MyArrayList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");
        list.add(-1, "Zero");
    }

    @Test
    public void testMyArrayListAddAll() {
        ListADT<String> listToAdd = new MyArrayList<>(3);
        listToAdd.add("Four");
        listToAdd.add("Five");
        listToAdd.add("Six");

        ListADT<String> list = new MyArrayList<>(3);
        list.add("One");
        list.add("Two");
        list.add("Three");

        list.addAll(listToAdd);

        ListADT<String> checkList = new MyArrayList<>();
        checkList.add("One");
        checkList.add("Two");
        checkList.add("Three");
        checkList.add("Four");
        checkList.add("Five");
        checkList.add("Six");

        Assert.assertEquals(list.toArray(), checkList.toArray());
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void testMyArrayListAddAllIfOneOfListsIsNull() {
        ListADT<String> listToAdd = null;


        ListADT<String> list = new MyArrayList<>(3);
        list.add("One");
        list.add("Two");
        list.add("Three");

        list.addAll(listToAdd);
    }

    @Test
    public void testRemoveElement() {
        ListADT<String> list = new MyArrayList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");

        list.remove("One");

        ListADT<String> checkList = new MyArrayList<>();
        checkList.add("Two");
        checkList.add("Three");

        assertEquals(list.toArray(), checkList.toArray());
    }

    @Test
    public void testRemoveElementByIndex() {
        ListADT<String> list = new MyArrayList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");

        list.remove(0);

        ListADT<String> checkList = new MyArrayList<>();
        checkList.add("Two");
        checkList.add("Three");

        assertEquals(list.toArray(), checkList.toArray());
    }

    @Test
    public void testMethodRemoveIfElementIsNull(){
        ListADT<String> list = new MyArrayList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");
        list.remove(null);

        assertEquals(list.size(), 3);
    }

    @Test
    public void testMethodRemoveIfElementIsNotInList(){
        ListADT<String> list = new MyArrayList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");
        list.remove("Four");

        assertEquals(list.size(), 3);
    }

    @Test
    public void testSetElement() {
        ListADT<String> list = new MyArrayList<>();
        list.add("Four");
        list.add("Two");
        list.add("Three");

        list.set(0, "One");

        ListADT<String> checkList = new MyArrayList<>();
        checkList.add("One");
        checkList.add("Two");
        checkList.add("Three");

        assertEquals(list.toArray(), checkList.toArray());
    }

    @Test
    public void testContains() {
        ListADT<String> list = new MyArrayList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");

        assertTrue(list.contains("One"));
    }

    @Test
    public void testContainsNull(){
        ListADT<String> list = new MyArrayList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");

        assertFalse(list.contains(null));
    }

    @Test
    public void testDoNotContainsElement(){
        ListADT<String> list = new MyArrayList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");

        assertFalse(list.contains("Four"));
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void testToArrayWithNullInParameter(){
        ListADT<String> list = new MyArrayList<>();
        list.toArray(null);
    }

    @Test
    public void testToArrayWithArrayInParameter(){
        ListADT<String> list = new MyArrayList<>();
        String[] array = {"One", "Two", "Three"};
        assertArrayEquals(list.toArray(array), array);
    }

    @Test
    public void testIterator() {
        ListADT<String> list = new MyArrayList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");

        ListADT<String> checkList = new MyArrayList<>();

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            checkList.add(iterator.next());
        }

        assertEquals(list.toArray(), checkList.toArray());
    }

    @Test(expectedExceptions = NoSuchElementException.class)
    public void testIteratorMethodNextIfNextElementDontExist(){
        ListADT<String> list = new MyArrayList<>();
        Iterator<String> iterator = list.iterator();
        iterator.next();
    }

    @Test
    public void testGetNameFromRoot() {
        XMLParser parser = new XMLParser("src/test/xmlfiles/true_simple_file.xml");
        parser.parseDocument();
        String xmlTageName;

        try {
            Field field = parser.getClass().getDeclaredField("root");
            field.setAccessible(true);
            XMLTag xmlTag = (XMLTag) field.get(parser);

            xmlTageName = xmlTag.getName();
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        assertEquals(xmlTageName, "bookstore");
    }

}
