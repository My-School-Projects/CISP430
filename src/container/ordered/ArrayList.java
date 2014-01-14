package container.ordered;

import java.util.Collection;
import java.util.Iterator;

/**
 * Michael Dorst
 * CISP 430 Data Structures
 * M Dixon
 *
 * ArrayList.java
 */
public class ArrayList<E> implements Iterable<E> {
  
  /**
   * Data declarations
   */
  private Object[] data;
  private int size;
  
  /**
   * Methods
   */
  
  @SuppressWarnings("unchecked")
  public E set(int index, E element) {
    if(index >= size) {
      size = index+1;
    }
    if(index >= capacity()) {
      Object[] temp = new Object[index];
      for(int i = 0; i < data.length; i++) {
        temp[i] = data[i];
      }
      data = temp;
    }
    Object temp = data[index];
    data[index] = element;
    return (E) temp;
  }
  
  @SuppressWarnings("unchecked")
  public E get(int index) {
    return (E) data[index];
  }
  
  public int size() {
    return size;
  }
  
  public int capacity() {
    return data.length;
  }
  
  /**
   * Iterable
   */
  
  @Override
  public Iterator<E> iterator() {
    return new ArrayListIterator<>(this);
  }
  
  /**
   * Constructors
   */
  public ArrayList() {
    this(10);
  }
  public ArrayList(int size) {
    data = new Object[size];
  }
  public ArrayList(int size, E value) {
    this(size);
    for(int i = 0; i < size; i++) {
      data[i] = value;
    }
    this.size = size;
  }
  public ArrayList(Collection<? extends E> collection) {
    this(collection.size());
    {
      int i = 0;
      for(E element : collection)
        data[i++] = element;
    }
    size = collection.size();
  }
}
