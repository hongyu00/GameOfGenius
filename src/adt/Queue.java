package adt;

/**
 *
 * @author Gan Jun Hong
 */
public class Queue<T> implements QueueInterface<T> {

    private T[] array;
    private int size;
    private int behind;
    private int front = 0;

    public Queue() {
        this(50);
    }

    public Queue(int initialCapacity) {
        size = initialCapacity;
        array = (T[]) new Object[initialCapacity];
        behind = -1;
        
    }

    @Override
    public void enqueue(T newEntry) {
        if (!isFull()) {
            behind++;
            array[behind] = newEntry;
        }
    }

    @Override
    public T getFront() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("The queue is full!");
        }
        T frontItem = array[front];
        return frontItem;
    }

    @Override
    public T dequeue() {

        if (isEmpty()) {
            throw new IndexOutOfBoundsException("The queue is empty!");
        }
        T removed = array[front++];
        if (front == size) {
            front = 0;

        }
        T removedItem = removed;
        return removedItem;

    }

    @Override
    public boolean isEmpty() {
        return front > behind;
    }
    

    @Override
    public boolean isFull() {
        return behind == array.length - 1;
    }
}