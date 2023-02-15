package by.lev;

import exceptions.EmptyQueueException;
import org.testng.annotations.Test;
import utilities.Iterator;
import utilities.MyQueue;
import utilities.QueueADT;

import java.util.NoSuchElementException;

import static org.testng.AssertJUnit.assertArrayEquals;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class MyQueueTest {

    @Test
    public void testNewMyQueueIsEmpty() {
        QueueADT<String> queue = new MyQueue<>();
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testNewMyQueueSizeEqualsZero() {
        QueueADT<String> queue = new MyQueue<>();
        assertEquals(queue.size(), 0);
    }

    @Test
    public void testNewMyQueueIsNotEmpty() {
        QueueADT<String> queue = new MyQueue<>();
        queue.enqueue("One");
        assertFalse(queue.isEmpty());
    }

    @Test
    public void testNewMyQueueSizeEqualsOne() {
        QueueADT<String> queue = new MyQueue<>();
        queue.enqueue("One");
        assertEquals(queue.size(), 1);
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void testEnqueueNull() {
        QueueADT<String> queue = new MyQueue<>();
        queue.enqueue(null);

    }

    /**
     * Очередь не может быть полной - метод isFull() всегда возвращает false, при том, что
     * мы не можем указать capacity очереди (не предусмотрено реализацией в данном случае)
     * Следовательно, мы не можем на практическом примере проверить
     * throw new RuntimeException("Queue is full");
     * из метода src/main/java/utilities/MyQueue.java enqueue()
     **/

    @Test
    public void testDequeObject() {
        QueueADT<String> queue = new MyQueue<>();
        queue.enqueue("One");
        queue.enqueue("Two");
        queue.enqueue("Three");

        assertEquals(queue.dequeue(), "One");
    }

    @Test
    public void testDequeOneObjectSizeMinusOne() {
        QueueADT<String> queue = new MyQueue<>();
        queue.enqueue("One");
        queue.enqueue("Two");
        queue.enqueue("Three");
        queue.dequeue();
        assertEquals(queue.size(), 2);
    }

    @Test(expectedExceptions = EmptyQueueException.class)
    public void testDequeFromEmptyMyQueue() {
        QueueADT<String> queue = new MyQueue<>();
        queue.dequeue();
    }

    @Test
    public void testQueueAfterDequeueMethodAndEqualsMethod() {
        QueueADT<String> queue = new MyQueue<>();
        queue.enqueue("One");
        queue.enqueue("Two");
        queue.enqueue("Three");
        queue.dequeue();
        QueueADT<String> expected = new MyQueue<>();
        expected.enqueue("Two");
        expected.enqueue("Three");
        assertTrue(queue.equals(expected));
    }

    @Test
    public void testPeek() {
        QueueADT<String> queue = new MyQueue<>();
        queue.enqueue("One");
        queue.enqueue("Two");
        queue.enqueue("Three");

        assertEquals(queue.peek(), "One");
    }

    @Test(expectedExceptions = EmptyQueueException.class)
    public void testPeekFromEmptyMyQueue() {
        QueueADT<String> queue = new MyQueue<>();
        queue.peek();
    }

    @Test
    public void testDequeueAll() {
        QueueADT<String> queue = new MyQueue<>();
        queue.enqueue("One");
        queue.enqueue("Two");
        queue.enqueue("Three");

        queue.dequeueAll();

        assertTrue(queue.isEmpty());
    }

    @Test(expectedExceptions = NoSuchElementException.class)
    public void testNextElementFromIteratorWhenMyQueueIsEmpty() {
        QueueADT<String> queue = new MyQueue<>();
        Iterator<String> iterator = queue.iterator();
        iterator.next();
    }

    @Test
    public void testNoEqualsMyQueuesBySize() {
        QueueADT<String> queue1 = new MyQueue<>();
        queue1.enqueue("One");
        queue1.enqueue("Two");
        queue1.enqueue("Three");

        QueueADT<String> queue2 = new MyQueue<>();
        queue2.enqueue("One");
        queue2.enqueue("Two");

        assertFalse(queue1.equals(queue2));
    }

    @Test
    public void testNoEqualsMyQueuesByElements() {
        QueueADT<String> queue1 = new MyQueue<>();
        queue1.enqueue("One");
        queue1.enqueue("Two");
        queue1.enqueue("Three");

        QueueADT<String> queue2 = new MyQueue<>();
        queue2.enqueue("One");
        queue2.enqueue("Two");
        queue2.enqueue("Four");

        assertFalse(queue1.equals(queue2));
    }

    @Test
    public void testToArray() {
        QueueADT<String> queue = new MyQueue<>();
        queue.enqueue("One");
        queue.enqueue("Two");
        queue.enqueue("Three");

        String[] expected = {"One", "Two", "Three"};

        assertArrayEquals(queue.toArray(), expected);
    }

    @Test (expectedExceptions = NullPointerException.class)
    public void testToArrayWithHolderAsNull(){
        QueueADT<String> queue = new MyQueue<>();
        queue.toArray(null);
    }

    /*
     * Проверить работу метода toArray(E[] holder) в полной мере не возможно в данном
     * случае, т.к. метод ссылается на приватное поле elements.
     * */

}
