package adt;

/**
 *
 * @author Derek Chong
 */
public interface ListInterface<T> {
    
   public boolean add(T newEntry);

    public T getEntry(int givenPosition);
    
    public void clear();
}
