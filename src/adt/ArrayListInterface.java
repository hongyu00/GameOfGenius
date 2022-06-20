package adt;

/**
 *
 * @author Chew Hong Yu
 */
public interface ArrayListInterface<T> {
   public boolean add(T newEntry);

    public void clear();

    public T getEntry(int givenPosition);

    public boolean contains(T anEntry);

    public int getLength();

}
