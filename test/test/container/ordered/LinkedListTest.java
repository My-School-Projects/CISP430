package test.container.ordered;

import container.ordered.LinkedList;
import container.ordered.LinkedListIterator;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

/**
 * Michael Dorst
 * CISP 430 Data Structures
 * M Dixon
 * 
 * LinkedListTest.java
 */
public class LinkedListTest {
  
  List<String> arrayList;
  LinkedList<String> emptyList;
  LinkedList<String> list;
  
  @Before
  public void setUp() throws Exception {
    arrayList = new ArrayList<>();
    for(int i = 0; i < 15; i++) {
      arrayList.add("example string 2");
    }
    list = new LinkedList<>();
    for(int i = 0; i < 100; i++) {
      list.add(""+i);
    }
    emptyList = new LinkedList<>();
  }
  
  @Test
  public void testAdd() throws Exception {
    assertThat(list.size(), is(100));
    LinkedListIterator<String> iter = list.iterator();
    for(int i = 0; i < 100; i++) {
      assertThat(iter.next(), is(""+i));
    }
    assertThat(iter.hasNext(), is(false));
  }
  
  @Test
  public void testClear() throws Exception {
    assertThat(list.size(), is(100));
    list.clear();
    assertThat(list.size(), is(0));
    for(String s : list) {
      fail("list should be empty");
    }
    assertThat(list.iterator().hasNext(), is(false));
    assertThat(list.iterator().hasPrevious(), is(false));
  }
  
  @Test
  public void testForeach() throws Exception {
    int i = 0;
    for(String s : list) {
      assertThat(s, is(""+i));
      i += 1;
    }
  }
  
  @Test
  public void testToArray_Raw() throws Exception {
    Object[] a = list.toArray();
    assertThat(a.length, is(100));
    int i = 0;
    for(Object e : a) {
      assertThat(e, is(instanceOf(String.class)));
      assertThat((String) e, is(""+i++));
    }
  }
  
  @Test
  public void testToArray_Generic() throws Exception {
    String[] a = new String[100];
    list.toArray(a);
    {
      int i = 0;
      for(String s : a) {
        assertThat(s, is(""+i++));
      }
    }
    a = list.toArray(new String[99]);
    {
      int i = 0;
      for(String s : a) {
        assertThat(s, is(""+i++));
      }
    }
    a = list.toArray(new String[101]);
    {
      for(int i = 0; i < 100; i++) {
        assertThat(a[i], is(""+i));
      }
      assertThat(a[100], is(equalTo(null)));
    }
  }
  
  @Test
  public void testDefaultConstructor() throws Exception {
    LinkedList<String> list = new LinkedList<>();
    assertThat(list.isEmpty(), is(true));
    assertThat(list.size(), is(0));
    LinkedListIterator<String> iter = list.iterator();
    assertThat(iter.hasNext(), is(false));
    assertThat(iter.hasPrevious(), is(false));
  }
  
  @Test
  public void testSizeConstructor() throws Exception {
    LinkedList<String> list = new LinkedList<>(5);
    assertThat(list.size(), is(5));
    LinkedListIterator<String> iter = list.iterator();
    assertThat(iter.hasPrevious(), is(false));
    for(int i = 0; i < 5; i++) {
      assertThat(iter.hasNext(), is(true));
      assertThat(iter.next(), is(equalTo(null)));
      assertThat(iter.hasPrevious(), is(true));
    }
  }
  
  @Test
  public void testSizeAndValueConstructor() throws Exception {
    LinkedList<String> list = new LinkedList<>(10, "example string 1");
    assertThat(list.size(), is(10));
    LinkedListIterator<String> iter = list.iterator();
    assertThat(iter.hasPrevious(), is(false));
    for(int i = 0; i < 10; i++) {
      assertThat(iter.hasNext(), is(true));
      assertThat(iter.next(), is(equalTo("example string 1")));
      assertThat(iter.hasPrevious(), is(true));
    }
  }
  
  @Test
  public void testCopyConstructor() throws Exception {
    LinkedList<String> list = new LinkedList<>(arrayList);
    assertThat(list.size(), is(15));
    LinkedListIterator<String> iter = list.iterator();
    assertThat(iter.hasPrevious(), is(false));
    for(int i = 0; i < 15; i++) {
      assertThat(iter.hasNext(), is(true));
      assertThat(iter.next(), is(equalTo("example string 2")));
      assertThat(iter.hasPrevious(), is(true));
    }
  }
}
