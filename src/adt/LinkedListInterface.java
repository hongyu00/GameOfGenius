/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

/**
 *
 * @author Tan Siaw Ching
 */
public interface LinkedListInterface<T> {
    
    public void insert(T newItem);

    public void removeAt(int index);

    public int getLength();
    
    public T getEntry(int givenPosition);
}
