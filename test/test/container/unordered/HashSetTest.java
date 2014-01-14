package test.container.unordered;

import container.unordered.HashSet;
import org.junit.Before;

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
  public void setUp() {
    hash = new HashSet<>();
  }
}
