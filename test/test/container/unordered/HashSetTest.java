package test.container.unordered;

import container.unordered.HashSet;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Michael Dorst
 * CISP 430 Data Structures
 * M Dixon
 *
 * HashSetTest.java
 */
public class HashSetTest {
  HashSet<String> hash;
  
  @Before
  public void setUp() throws Exception {
    hash = new HashSet<>();
  }
  
  @Test
  public void testAdd() throws Exception {
    assertFalse(hash.contains("hello"));
    hash.add("hello");
    assertTrue(hash.contains("hello"));
  }
  
  @Test
  public void testDefaultConstructor() throws Exception {
    hash = new HashSet<>();
    assertThat(hash.size(), is(1024));
  }
}
