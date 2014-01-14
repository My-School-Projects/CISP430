package container.ordered;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Michael Dorst
 * CISP 430 Data Structures
 * M Dixon
 *
 * ArrayListIterator.java
 */
public class ArrayListIterator<E> implements Iterator<E> {

  /**
   * Data members
   */
  
  private ArrayList<E> list;
  private int position;
  
  /**
   * Iterator
   */
  
  @Override
  public boolean hasNext() {
    return position < list.size()-1;
  }
  
  @Override
  public E next() {
    if(hasNext()) {
      return list.get(position++);
    } else {
      throw new NoSuchElementException();
    }
  }
  
  @Override
  public void remove() {
    throw new UnsupportedOperationException();
  }

  /**
   * Constructors
   */
  
  public ArrayListIterator(ArrayList<E> list) {
    this.list = list;
  }
}
