package adt;

/**
 *
 * @author Ng Siang Sheng
 */
public class Stack<T> implements StackInterface<T> {
  private T[] array;
  private int indexTop;
  private static final int DEFAULT_CAPACITY = 50;

  public Stack() {
    this(DEFAULT_CAPACITY);
  }

  public Stack(int initialCapacity) {
    array = (T[]) new Object[initialCapacity];
    indexTop = -1;
  }

  @Override
  public void push(T newEntry) {
    indexTop++;

    if (indexTop < array.length) {
      array[indexTop] = newEntry;
    }
  }

  @Override
  public T peek() {
    T top = null;

    if (!isEmpty()) {
      top = array[indexTop];
    }

    return top;
  } 

  @Override
  public T pop() {
    T top = null;

    if (!isEmpty()) {
      top = array[indexTop];
      array[indexTop] = null;
      indexTop--;
    }

    return top;
  } 

  @Override
  public boolean isEmpty() {
    return indexTop < 0;
  } 


}
