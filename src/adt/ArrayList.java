/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;


/**
 *
 * @author Chew Hong Yu
 */
public class ArrayList<T> implements ArrayListInterface<T> {

    private T[] arr;
    private int length = 0;
    private static final int DEFAULTSIZE = 100;

    public ArrayList() {
        this(DEFAULTSIZE);
    }

    public ArrayList(int declaredSize) {
        length = 0;
        arr = (T[]) new Object[declaredSize];
    }

    @Override
    public boolean add(T newData) {
        arr[length] = newData;
        length++;
        return true;
    }

    @Override
    public void clear() {
        length = 0;
    }


    @Override
    public T getEntry(int requiredPosition) {
    T result = null;

    if ((requiredPosition >= 1) && (requiredPosition <= length)) {
      result = arr[requiredPosition - 1];
    }

    return result;
  }

    @Override
    public boolean contains(T data) {
        boolean found = false;
        for (int i = 0; !found && (i < length); i++) {
            if (data.equals(arr[i])) {
                found = true;
            }
        }

        return found;
    }

    @Override
    public int getLength() {
        return length;
    }

}
