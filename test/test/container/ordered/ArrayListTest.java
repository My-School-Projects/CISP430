package test.container.ordered;

import container.ordered.ArrayList;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Michael Dorst
 * CISP 430 Data Structures
 * M Dixon
 *
 * ArrayListTest.java
 */
public class ArrayListTest {
  
  ArrayList<String> array;
  
  @Before
  public void setUp() throws Exception {
    array = new ArrayList<>(100);
    for(int i = 0; i < 100; i++) {
      array.set(i, ""+i);
    }
  }
  
  @Test
  public void testSet() throws Exception {
    for(int i = 0; i < 100; i++) {
      assertThat(array.set(i, ""), is(""+i));
    }
  }
  
  @Test
  public void testGet() throws Exception {
    for(int i = 0; i < 100; i++) {
      assertThat(array.get(i), is(""+i));
    }
  }
  
  @Test
  public void testDefaultConstructor() throws Exception {
    array = new ArrayList<>();
    assertThat(array.size(), is(0));
    assertTrue(array.capacity() >= 10);
  }
  
  @Test
  public void testIntConstructor() throws Exception {
    array = new ArrayList<>(100);
    assertThat(array.size(), is(0));
    assertTrue(array.capacity() >= 100);
  }
  
  @Test
  public void testIntAndValueConstructor() throws Exception {
    array = new ArrayList<>(100, "hello");
    assertThat(array.size(), is(100));
    for(int i = 0; i < 100; i++) {
      assertThat(array.get(i), is("hello"));
    }
  }
  
  @Test
  public void testCollectionConstructor() throws Exception {
    java.util.List<String> a = new java.util.ArrayList<>(100);
    for(int i = 0; i < 100; i++) {
      a.add(i, "" + i);
    }
    array = new ArrayList<>(a);
    assertThat(array.size(), is(100));
    for(int i = 0; i < 100; i++) {
      assertThat(array.get(i), is(""+i));
    }
  }
}
