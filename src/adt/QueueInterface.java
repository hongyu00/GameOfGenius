package adt;
/**
 *
 * @author Gan Jun Hong
 */
public interface QueueInterface<T> {
  public void enqueue(T newEntry);
  public T dequeue();
  public T getFront();
  public boolean isEmpty();
  public boolean isFull();

}
