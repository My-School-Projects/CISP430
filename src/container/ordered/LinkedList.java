package container.ordered;

import java.lang.reflect.Array;
import java.util.Collection;

/**
 * Michael Dorst
 * CISP 430 Data Structures
 * M Dixon
 * 
 * LinkedList.java
 */

public class LinkedList<E extends Comparable<E>> implements Collection<E> {
  
  class Node<E extends Comparable<E>> {
    public E value;
    public Node<E> next;
    public Node<E> previous;
    
    Node(){}
    Node(E value) {
      this.value = value;
    }
  }
  
  /**
   * Data declarations
   */
  private Node<E> head;
  private Node<E> tail;
  private int size;
  
  /**
   * Collection
   */
  
  @Override
  public int size() {
    return size;
  }
  
  @Override
  public boolean isEmpty() {
    return size == 0;
  }
  
  @Override
  public boolean add(E e) {
    if (isEmpty()) {
      head = tail = new Node<>(e);
    } else {
      tail.next = new Node<>(e);
      tail.next.previous = tail;
      tail = tail.next;
    }
    size += 1;
    return true;
  }
  
  @Override
  public void clear() {
    head = tail = null;
    size = 0;
  }
  
  @Override
  public LinkedListIterator<E> iterator() {
    return new LinkedListIterator<>(head);
  }
  
  @Override
  public Object[] toArray() {
    Object[] a = new Object[size];
    int i = 0;
    for(E e : this) {
      a[i++] = e;
    }
    return a;
  }
  
  @Override
  public <T> T[] toArray(T[] a) {
    if (a.length < size) {
      @SuppressWarnings("unchecked")
      T[] _a = (T[]) Array.newInstance(a.getClass().getComponentType(), size);
      a = _a;
    }
    {
      int i = 0;
      for(E e : this) {
        a[i++] = (T) e;
      }
    }
    if (a.length > size) {
      a[size] = null;
    }
    return a;
  }
  
  @Override
  public boolean remove(Object o) {
    throw new UnsupportedOperationException();
  }
  
  @Override
  public boolean contains(Object o) {
    throw new UnsupportedOperationException();
  }
  
  @Override
  public boolean containsAll(Collection<?> c) {
    throw new UnsupportedOperationException();
  }
  
  @Override
  public boolean addAll(Collection<? extends E> c) {
    throw new UnsupportedOperationException();
  }
  
  @Override
  public boolean removeAll(Collection<?> c) {
    throw new UnsupportedOperationException();
  }
  
  @Override
  public boolean retainAll(Collection<?> c) {
    throw new UnsupportedOperationException();
  }
  
  /**
   * Constructors
   */
  public LinkedList() {}
  
  public LinkedList(int nodes) {
    this(nodes, null);
  }
  
  public LinkedList(int size, E value) {
    this.size = size;
    head = new Node<>();
    Node<E> n = head;
    for (int i = 0; i < size; i++) {
      n.next = new Node<>(value);
      n = n.next;
    }
    tail = n.previous;
    head = head.next;
  }
  
  public LinkedList(Collection<? extends E> collection) {
    size = collection.size();
    head = new Node<>();
    Node<E> n = head;
    for(E e : collection) {
      n.next = new Node<>(e);
      n = n.next;
    }
    tail = n.previous;
    head = head.next;
  }
}
