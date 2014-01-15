package container.unordered;

import container.ordered.ArrayList;
import container.ordered.LinkedList;

/**
 * Michael Dorst
 * CISP 430 Data Structures
 * M Dixon
 *
 * HashSet.java
 */
public class HashSet<E> {
  
  /**
   * Data members
   */
  private ArrayList<LinkedList<E>> table;
  
  /**
   * Methods
   */
  
  public int size() {
    return table.size();
  }
  
  public void add(E element) {
    LinkedList<E> bucket = table.get(element.hashCode()%size());
    if(bucket.contains(element))
      return;
    bucket.add(element);
  }
  
  public boolean contains(E element) {
    LinkedList<E> bucket = table.get(element.hashCode()%size());
    for(E e : bucket)
      if(e.hashCode() == element.hashCode())
        return true;
    return false;
  }
  
  /**
   * Constructors
   */
  public HashSet() {
    this(1024);
  }
  public HashSet(int size) {
    table = new ArrayList<>(size);
    for(int i = 0; i < size; i++) {
      table.set(i, new LinkedList<E>());
    }
  }
}
