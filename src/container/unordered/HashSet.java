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
   * Constructors
   */
  public HashSet() {
    this(1024);
  }
  public HashSet(int size) {
    table = new ArrayList<>(size);
  }
}
