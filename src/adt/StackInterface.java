package adt;
/**
 *
 * @author Ng Siang Sheng
 */
public interface StackInterface<T> {

  public void push(T newEntry);
  public T pop();
  public T peek();
  public boolean isEmpty();
}
