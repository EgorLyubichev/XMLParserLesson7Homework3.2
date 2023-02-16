package by.lev;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.MyDLLNode;

import static org.testng.Assert.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class MyDLLNodeTest {

    @Test
    public void testConstructorWithAllParameters(){
        MyDLLNode<String> node = new MyDLLNode<>("Node",
                new MyDLLNode<>("Prev"),
                new MyDLLNode<>("Next"));

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(node.getValue(), "Node");
        softAssert.assertEquals(node.getPrev().getValue(), "Prev");
        softAssert.assertEquals(node.getNext().getValue(), "Next");

        softAssert.assertAll();
    }

    @Test
    public void testSetPrev(){
        MyDLLNode<String> node = new MyDLLNode<>("Node");
        node.setPrev(new MyDLLNode<>("Prev"));

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(node.getValue(), "Node");
        softAssert.assertEquals(node.getPrev().getValue(), "Prev");
        softAssert.assertEquals(node.getNext(), null);

        softAssert.assertAll();
    }

    @Test
    public void testSetNext(){
        MyDLLNode<String> node = new MyDLLNode<>("Node");
        node.setNext(new MyDLLNode<>("Next"));

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(node.getValue(), "Node");
        softAssert.assertEquals(node.getPrev(), null);
        softAssert.assertEquals(node.getNext().getValue(), "Next");

        softAssert.assertAll();
    }

    @Test
    public void testSetValue(){
        MyDLLNode<String> node = new MyDLLNode<>("Node");

        node.setValue("ExpectedValue");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(node.getValue(), "ExpectedValue");
        softAssert.assertEquals(node.getPrev(), null);
        softAssert.assertEquals(node.getNext(), null);

        softAssert.assertAll();
    }

    @Test
    public void testEqualsMyDLLNodes(){
        MyDLLNode<String> firstNode = new MyDLLNode<>("Node");
        MyDLLNode<String> secondNode = new MyDLLNode<>("Node");

        assertTrue(firstNode.equals(secondNode));
    }

    @Test
    public void testEqualsDifferentMyDLLNodesByPrevAndNextFields(){
        MyDLLNode<String> firstNode = new MyDLLNode<>("Node",
                new MyDLLNode<>("Prev"),
                new MyDLLNode<>("Next"));
        MyDLLNode<String> secondNode = new MyDLLNode<>("Node");

        assertFalse(firstNode.equals(secondNode));
    }
    /*
    * Согласно коду, вышеуказанные объекты равны, хотя их содержимое различно.
    * Возможно, в данном случае следовало бы использовать не метод сравнения объектов,
    * а компаратор по значению value.
    * */

@Test
    public void testValueMatch(){
    MyDLLNode<String> node = new MyDLLNode<>("Value");
    assertTrue(node.valueMatch("Value"));
}

    @Test
    public void testValueMatchWithOtherValue(){
        MyDLLNode<String> node = new MyDLLNode<>("Value");
        assertFalse(node.valueMatch("Other Value"));
    }


}
