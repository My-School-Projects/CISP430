package container.ordered;

import java.util.Collection;

/**
 * Michael Dorst
 * CISP 430 Data Structures
 * M Dixon
 *
 * ArrayList.java
 */
public class ArrayList<E> {
  
  /**
   * Data declarations
   */
  Object[] data;
  int size;
  
  /**
   * Methods
   */
  
  @SuppressWarnings("unchecked")
  E set(int index, E element) {
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
  E get(int index) {
    return (E) data[index];
  }
  
  int size() {
    return size;
  }
  
  int capacity() {
    return data.length;
  }
  
  /**
   * Constructors
   */
  ArrayList() {
    this(10);
  }
  ArrayList(int size) {
    data = new Object[size];
  }
  ArrayList(int size, E value) {
    this(size);
    for(int i = 0; i < size; i++) {
      data[i] = value;
    }
    this.size = size;
  }
  ArrayList(Collection<? extends E> collection) {
    this(collection.size());
    {
      int i = 0;
      for(E element : collection)
        data[i++] = element;
    }
    size = collection.size();
  }
}
