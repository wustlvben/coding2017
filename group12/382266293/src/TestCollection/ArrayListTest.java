package TestCollection;

import static util.Print.*;
import java.util.Date;
import java.util.NoSuchElementException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Collection.Iterator;
import Collection.List;
import Collection.Concrete.ArrayList;
import junit.framework.TestCase;

public class ArrayListTest extends TestCase {

	ArrayList<Integer> myAL;
	@Before
	public void setUp() throws Exception {
		myAL = new ArrayList<Integer>();
		assertEquals(true,myAL.isEmpty());
		
	}

	@After
	public void tearDown() throws Exception {
		myAL = null;
	}

	@Test
	public void testArrayList() {
		List bt = new ArrayList();
		assertEquals(bt.size(), 0);
		bt.add(new Date());
		assertEquals(1, bt.size());
		
	}

	@Test
	public void testAddE() {
		myAL.add(5);
		assertEquals(1,myAL.size());
		assertEquals(false,myAL.isEmpty());
	}

	@Test
	public void testAddIntE() {
		myAL.add(5);
		myAL.add(5);
		myAL.add(5);
		myAL.add(1,10);
		
		int c = myAL.get(1);
		assertEquals(10,c);
		
		assertEquals(4,myAL.size());
		myAL.add(4,15);
		int a = myAL.get(0);
		Integer b = myAL.get(1);
		c =  myAL.get(2);
		int d = myAL.get(3);
		int e = myAL.get(4);
		assertEquals(5,a);
		assertEquals(new Integer(10),b);
		assertEquals(5,c);
		assertEquals(5,d);
		assertEquals(15,e);
	}

	@Test
	public void testRemove() {
		
		int res;
		int a;
		for(int i = 0; i < 10; i++) {
			myAL.add(i);
		}

		for(int i = myAL.size()-1; i >= 0; i--) {
			a = myAL.get(i);
			res = myAL.remove(i);
			assertEquals(a,res);
		}

	}

	@Test
	public void testSize() {
		assertEquals(0,myAL.size());
	}

	@Test
	public void testGet() {
		myAL.add(5);
		myAL.add(new Integer(10));
		Integer a = myAL.get(0);
		assertEquals(a,new Integer(5));
		int b = myAL.get(1);
		assertEquals(b,10);
	}
	
	@Test
	public void testGrow() {
		int j;
		for(int i = 0; i<200; i++) {
			myAL.add(5);
			j = myAL.get(i);
			assertEquals(5,j);
		}
		assertEquals(200,myAL.size());
	}
	

	@Test
	public void testIterator() {
		for(int i = 0; i<10; i++) {
			myAL.add(i);
		}
		Iterator<Integer> it = myAL.iterator();
		println(myAL);
		for(int i = 0; it.hasNext(); i++){
			int res = it.next();
			assertEquals(i,res);
		}
		
	    try {
			it.next();
	    } catch (NoSuchElementException ex) {
	        assertEquals(ex.getClass(),NoSuchElementException.class);
	    }
	}
	

}
