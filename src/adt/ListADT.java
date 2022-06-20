package adt;

/**
 *
 * @author Derek Chong
 */
public class ListADT<T> implements ListInterface<T> {

    private T[] array;
    private int length = 0;
    private static final int SIZE = 40;

    public ListADT() {
        this(SIZE);
    }

    public ListADT(int initialCapacity) {
        length = 0;
        array = (T[]) new Object[initialCapacity];
    }

    @Override
    public boolean add(T newEntry) {
        array[length++] = newEntry;

        return true;
    }

    @Override
    public T getEntry(int takePosition) {

        if ((takePosition < 0) || (takePosition >= length)) {
            throw new IndexOutOfBoundsException("...");
        }

        return (T) array[takePosition];
    }
    
    @Override
    public void clear() {
        length = 0;
    }

}
