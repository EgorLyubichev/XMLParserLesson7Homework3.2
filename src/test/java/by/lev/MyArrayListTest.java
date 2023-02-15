package by.lev;

import org.testng.annotations.Test;
import parser.XMLParser;
import parser.XMLTag;
import utilities.Iterator;
import utilities.ListADT;
import utilities.MyArrayList;

import java.lang.reflect.Field;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MyArrayListTest {

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

        assertEquals(listADT.size(),3);
    }

    @Test
    public void testMyArrayListAddToIndex() {
        ListADT<String> listADT = new MyArrayList<>();

        listADT.add("Two");
        listADT.add("Three");
        listADT.add(0, "One");

        assertEquals(listADT.size(),3);
    }

    @Test
    public void testMyArrayListAddToIndexAndGetThisElementInTheSpecifiedLocation() {
        ListADT<String> listADT = new MyArrayList<>();

        listADT.add("Two");
        listADT.add("Three");
        listADT.add(0, "One");

        assertEquals(listADT.get(0),"One");
    }

    @Test
    public void testMyArrayListAddToIndexWithCapacity() {
        ListADT<String> listADT = new MyArrayList<>(2);

        listADT.add("Two");
        listADT.add("Three");
        listADT.add(0, "One");

        assertEquals(listADT.size(),3);
    }

    @Test
    public void testMyArrayListAddAll() {
        ListADT<String> listToAdd = new MyArrayList<>();
        listToAdd.add("Four");
        listToAdd.add("Five");
        listToAdd.add("Six");

        ListADT<String> list = new MyArrayList<>();
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

        assertEquals(list.toArray(), checkList.toArray());
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
    public void testIterator() {
        ListADT<String> list = new MyArrayList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");

        ListADT<String> checkList = new MyArrayList<>();

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            checkList.add(iterator.next());
        }

        assertEquals(list.toArray(), checkList.toArray());
    }

    @Test
    public void testGetNameFromRoot(){
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
