package container.ordered;

import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * Michael Dorst
 * CISP 430 Data Structures
 * M Dixon
 * 
 * LinkedListIterator.java
 */
public class LinkedListIterator<E> implements ListIterator<E> {
  
  private LinkedList<E>.Node<E> lastReturned;
  private LinkedList<E>.Node<E> next;
  private LinkedList<E>.Node<E> previous;
  private int index;
  
  @Override
  public boolean hasNext() {
    return next != null;
  }
  
  public boolean hasPrevious() {
    return previous != null;
  }
  
  @Override
  public E next() {
    if (!hasNext()) {
      throw new NoSuchElementException();
    }
    previous = next;
    next = next.next;
    index++;
    return (lastReturned = previous).value;
  }
  
  public E previous() {
    if (!hasPrevious()) {
      throw new NoSuchElementException();
    }
    next = previous;
    previous = previous.previous;
    index--;
    return (lastReturned = next).value;
  }
  
  @Override
  public int nextIndex() {
    return index+1;
  }
  
  @Override
  public int previousIndex() {
    return index-1;
  }
  
  @Override
  public void remove() {
    throw new UnsupportedOperationException();
  }
  
  @Override
  public void set(E e) {
    //TODO: add test for set
    //TODO: implement set
  }
  
  @Override
  public void add(E e) {
    throw new UnsupportedOperationException();
  }
  
  LinkedListIterator(LinkedList<E>.Node<E> n) {
    next = n;
  }
}
