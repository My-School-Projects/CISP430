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
   * List
   */
  @SuppressWarnings("unchecked")
  E set(int index, E element) {
    Object temp = data[index];
    data[index] = element;
    return (E) temp;
  }
  
  @SuppressWarnings("unchecked")
  E get(int index) {
    return (E) data[index];
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
  ArrayList(Collection<? extends E> collection) {
    this(collection.size());
    {
      int i = 0;
      for(E element : collection)
        data[i++] = element;
    }
  }
}
