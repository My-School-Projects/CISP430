package test.container.ordered;

import container.ordered.LinkedList;
import container.ordered.LinkedListIterator;
import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

/**
 * Michael Dorst
 * CISP 430 Data Structures
 * M Dixon
 * 
 * LinkedListIteratorTest.java
 */
public class LinkedListIteratorTest {

  LinkedList<String> emptyList;
  LinkedList<String> list;
  
  @Before
  public void setUp() {
    list = new LinkedList<>();
    for(int i = 0; i < 100; i++) {
      list.add(""+i);
    }
    emptyList = new LinkedList<>();
  }
  
  @Test
  public void testHasNext() throws Exception {
    {
      LinkedListIterator i = list.iterator();
      for(int j = 0; j < 100; j++) {
        assertThat(i.hasNext(), is(true));
        i.next();
      }
      assertThat(i.hasNext(), is(false));
    }
  }
  
  @Test
  public void testHasPrevious() throws Exception {
    {
      LinkedListIterator i = list.iterator();
      assertThat(i.hasPrevious(), is(false));
      for(int j = 0; j < 100; j++) {
        i.next();
        assertThat(i.hasPrevious(), is(true));
      }
    }
  }
  
  @Test
  public void testNext() throws Exception {
    try {
      emptyList.iterator().next();
      fail("next() should throw an exception");
    } catch (NoSuchElementException e) {}
    {
      LinkedListIterator i = list.iterator();
      for(int j = 0; j < 100; j++) {
        i.next();
      }
      try {
        i.next();
        fail("next() should throw an exception");
      } catch (NoSuchElementException e) {}
    }
  }
  
  @Test
  public void testPrevious() throws Exception {
    try {
      emptyList.iterator().previous();
      fail("previous() should throw an exception");
    } catch (NoSuchElementException e) {}
    {
      LinkedListIterator i = list.iterator();
      for(int j = 0; j < 100; j++) {
        i.next();
      }
      assertThat(i.hasNext(), is(false));
      for(int j = 0; j < 100; j++) {
        assertThat(i.hasPrevious(), is(true));
        i.previous();
        assertThat(i.hasNext(), is(true));
      }
      assertThat(i.hasPrevious(), is(false));
      try {
        i.previous();
        fail("previous() should throw an exception");
    } catch (NoSuchElementException e) {}
    }
  }
  
  @Test
  public void testNextIndex() throws Exception {
    
  }
  
  @Test
  public void testPreviousIndex() throws Exception {
    
  }
  
  @Test
  public void testRemove() throws Exception {
    
  }
  
  @Test
  public void testSet() throws Exception {
    
  }
  
  @Test
  public void testAdd() throws Exception {
    
  }
}
