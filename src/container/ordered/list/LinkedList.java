package container.ordered.list;

import java.util.NoSuchElementException;

/**
 * Michael Dorst
 * CISP 430 Data Structures
 * M Dixon
 */
public class LinkedList<E extends Comparable<E>> implements Iterable<E> {
  
  public class Iterator<E extends Comparable<E>> implements java.util.Iterator<E> {
    
    private Node<E> lastReturned;
    private Node<E> next;
    private Node<E> previous;
    
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
      return (lastReturned = previous).value;
    }
    
    public E previous() {
      if (!hasPrevious()) {
        throw new NoSuchElementException();
      }
      next = previous;
      previous = previous.previous;
      return (lastReturned = next).value;
    }
    
    @Override
    public void remove() {
      if (lastReturned == null) {
        throw new IllegalStateException();
      } else {
        lastReturned.previous.next = lastReturned.next;
        lastReturned.next.previous = lastReturned.previous;
        lastReturned = null;
      }
    }
    
    Iterator(Node<E> n) {
      next = n;
    }
  }
  
  private class Node<E extends Comparable<E>> {
    public E value;
    public Node<E> next;
    public Node<E> previous;
    
    Node(){}
    Node(E value) {
      this.value = value;
    }
  }
  
  Node<E> head;
  
  @Override
  public java.util.Iterator<E> iterator() {
    return new Iterator<>(head);
  }
  
  public LinkedList() {
    this(0, null);
  }
  
  public LinkedList(int nodes) {
    this(nodes, null);
  }
  
  public LinkedList(int nodes, E value) {
    head = new Node<>();
    Node<E> n = head;
    for (int i = 0; i < nodes; i++) {
      n.next = new Node<>(value);
      n = n.next;
    }
  }
  
  public LinkedList(Iterable<E> collection) {
    head = new Node<>();
    Node<E> n = head;
    for(E e : collection) {
      n.next = new Node<>(e);
      n = n.next;
    }
  }
}
