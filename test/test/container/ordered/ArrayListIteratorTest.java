package test.container.ordered;

import container.ordered.ArrayList;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Michael Dorst
 * CISP 430 Data Structures
 * M Dixon
 *
 * ArrayListIteratorTest.java
 */
public class ArrayListIteratorTest {
  
  ArrayList<String> array;
  
  @Before
  public void setUp() throws Exception {
    array = new ArrayList<>(100);
    for(int i = 0; i < 100; i++) {
      array.set(i, ""+i);
    }
  }
  
  @Test
  public void testNext() throws Exception {
    int j = 0;
    for(Iterator<String> i = array.iterator(); i.hasNext();) {
      assertThat(i.next(), is(""+j++));
    }
  }
  
  @Test
  public void testForEach() throws Exception {
    int i = 0;
    for(String s : array) {
      assertThat(s, is(""+i++));
    }
  }
  
  @Test
  public void testHasNext() throws Exception {
    Iterator<String> i = array.iterator();
    for(int j = 0; j < 99; j++) {
      assertTrue(i.hasNext());
      i.next();
    }
    assertFalse(i.hasNext());
  }
}
