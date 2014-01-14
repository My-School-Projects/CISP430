package container.ordered;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

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
}
