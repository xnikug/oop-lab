package oop.master;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class QueueTest {
    
    @Test
    void testEnqueueAndDequeue() {
        Queue<Integer> queue = new LinearQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.dequeue());
    }
    
    @Test
    void testPeek() {
        Queue<String> queue = new LinearQueue<>();
        queue.enqueue("A");
        assertEquals("A", queue.peek());
        assertFalse(queue.isEmpty());
    }
    
    @Test
    void testIsEmpty() {
        Queue<Integer> queue = new LinearQueue<>();
        assertTrue(queue.isEmpty());
        queue.enqueue(5);
        assertFalse(queue.isEmpty());
    }
    
    @Test
    void testSize() {
        Queue<Integer> queue = new LinearQueue<>();
        queue.enqueue(10);
        queue.enqueue(20);
        assertEquals(2, queue.size());
    }
}