package by.lev;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.Iterator;
import utilities.MyStack;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import static org.testng.internal.junit.ArrayAsserts.assertArrayEquals;

public class MyStackTest {

    @Test(expectedExceptions = NullPointerException.class)
    public void testMyStackPushNull() {
        MyStack<String> stack = new MyStack<>();
        stack.push(null);
    }

    @Test
    public void testMyStackPush() {
        MyStack<String> stack = new MyStack<>();
        stack.push("One");
        assertTrue(stack.contains("One"));
    }

    @Test(expectedExceptions = EmptyStackException.class)
    public void testPopFromEmptyMyStack() {
        MyStack<String> stack = new MyStack<>();
        stack.pop();
    }

    @Test
    public void testMyStackPop() {
        MyStack<String> stack = new MyStack<>();
        stack.push("One");
        stack.push("Two");
        stack.push("Three");
        Assert.assertEquals(stack.pop(), "Three");
    }

    @Test
    public void testMyStackPopCompareStacks() {
        MyStack<String> stack = new MyStack<>();
        stack.push("One");
        stack.push("Two");
        stack.push("Three");
        stack.pop();
        String[] expected = {"Two", "One"};

        assertArrayEquals(stack.toArray(), expected);
    }


    @Test(expectedExceptions = EmptyStackException.class)
    public void testPeekFromEmptyMyStack() {
        MyStack<String> stack = new MyStack<>();
        stack.peek();
    }

    @Test
    public void testMyStackPeek() {
        MyStack<String> stack = new MyStack<>();
        stack.push("One");
        stack.push("Two");
        stack.push("Three");
        assertEquals(stack.peek(), "Three");
    }

    @Test
    public void testMyStackPeekCompareStacks() {
        MyStack<String> stack = new MyStack<>();
        stack.push("One");
        stack.push("Two");
        stack.push("Three");
        stack.peek();
        String[] expected = {"Three", "Two", "One"};

        assertArrayEquals(stack.toArray(), expected);
    }

    @Test
    public void testMyStackClear() {
        MyStack<String> stack = new MyStack<>();
        stack.push("One");
        stack.push("Two");
        stack.push("Three");
        stack.clear();
        assertTrue(stack.isEmpty());
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void testMyStackToArrayWithNullIntoParameter() {
        MyStack<String> stack = new MyStack<>();
        stack.toArray(null);
    }

    @Test
    public void testMyStackToArrayWithArrayIntoParameter() {
        String[] array = {"One", "Two", "Three"};
        MyStack<String> stack = new MyStack<>();
        String[] expected = {"One", "Two", "Three"};
        assertArrayEquals(stack.toArray(array), expected);
    }

    /*
     * Метод toArray(E[] holder) невозможно полностью проверить,
     * т.к. поле elements приватное.
     * */

    @Test(expectedExceptions = NullPointerException.class)
    public void testMyStackContainsNull() {
        MyStack<String> stack = new MyStack<>();
        stack.contains(null);
    }

    /*
    * Метод contains невозможно полностью проверить, т.к. поле elements приватное.
    * */

    @Test
    public void testMyStackSearchNegative() {
        MyStack<String> stack = new MyStack<>();
        stack.push("One");
        stack.push("Two");
        stack.push("Three");
        assertEquals(stack.search(null), -1);
    }

    @Test
    public void testEmptyMyStackSearch() {
        MyStack<String> stack = new MyStack<>();
        assertEquals(stack.search("One"), -1);
    }

    @Test
    public void testMyStackSearchPositive() {
        MyStack<String> stack = new MyStack<>();
        stack.push("One");
        stack.push("Two");
        stack.push("Three");

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(stack.search("Three"), 1);
        softAssert.assertEquals(stack.search("Two"), 2);
        softAssert.assertEquals(stack.search("One"), 3);
        softAssert.assertAll();
    }

    @Test
    public void testMyStackEqualsPositive() {
        MyStack<String> stack1 = new MyStack<>();
        stack1.push("One");
        stack1.push("Two");
        stack1.push("Three");

        MyStack<String> stack2 = new MyStack<>();
        stack2.push("One");
        stack2.push("Two");
        stack2.push("Three");

        assertTrue(stack1.equals(stack2));
    }

    @Test
    public void testMyStackEqualsDifferentValues() {
        MyStack<String> stack1 = new MyStack<>();
        stack1.push("One");
        stack1.push("Two");
        stack1.push("Three");

        MyStack<String> stack2 = new MyStack<>();
        stack2.push("One");
        stack2.push("Two");
        stack2.push("Four");

        assertFalse(stack1.equals(stack2));
    }

    @Test
    public void testMyStackEqualsDifferentLength() {
        MyStack<String> stack1 = new MyStack<>();
        stack1.push("One");
        stack1.push("Two");
        stack1.push("Three");

        MyStack<String> stack2 = new MyStack<>();
        stack2.push("One");
        stack2.push("Two");

        assertFalse(stack1.equals(stack2));
    }

    @Test(expectedExceptions = NoSuchElementException.class)
    public void testMyStackIteratorNextWithEmptyMyStack(){
        MyStack<String> stack = new MyStack<>();
        Iterator<String> iterator = stack.iterator();
        iterator.next();
    }
}
