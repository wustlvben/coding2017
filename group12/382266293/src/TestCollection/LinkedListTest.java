package TestCollection;

import static util.Print.*;
import java.util.Date;
import java.util.NoSuchElementException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sun.jndi.url.iiopname.iiopnameURLContextFactory;
import com.sun.org.apache.regexp.internal.recompile;
import com.sun.swing.internal.plaf.basic.resources.basic;

import Collection.Iterator;
import Collection.List;
import Collection.Concrete.ArrayList;
import Collection.Concrete.LinkedList;
import junit.framework.TestCase;
import sun.awt.ModalityListener;

public class LinkedListTest extends TestCase {

	LinkedList<String> myLL;
	
	@Before
	public void setUp() throws Exception {
		myLL = new LinkedList<String>();
		assertEquals(true,myLL.isEmpty());
	}

	@After
	public void tearDown() throws Exception {
		myLL = null;
	}

	@Test
	public void testLinkedList() {
		List bt = new LinkedList();
		assertEquals(bt.size(), 0);
		bt.add(new Date());
		assertEquals(1, bt.size());
		
	}

	@Test
	public void testAddE() {
		myLL.add("s");
		assertEquals(1,myLL.size());
		assertEquals(false,myLL.isEmpty());
	}

	@Test
	public void testAddStringE() {
		String a;
		for (int i = 0 ; i < 30; i++) {
			a = "" + i;
			myLL.add(a);
			assertEquals(myLL.get(i),a);
		}
		for (int i = 0 ; i < 30; i++) {
			a = "" + i;
			assertEquals(myLL.get(i),a);
		}
	}
	
	@Test
	public void testAddIndex() {
		String a;
		for (int i = 0 ; i < 30; i++) {
			a = "" + i;
			myLL.add(a);
		}
		
		String ss = "ss";
		myLL.add(3,ss);
		assertEquals(myLL.get(3), ss);
		assertEquals(myLL.get(2), "2");
		assertEquals(myLL.get(4), "3");
		
	}
	
	public void testAddFirst() {
		String a;
		for (int i = 0 ; i < 20; i++) {
			a = "" + i;
			myLL.add(a);
		}
		
		String ss = "bba";
		myLL.addFirst(ss);
		assertEquals(ss,myLL.get(0));
		assertEquals(21, myLL.size());
		
		;
		for (int i = 1 ; i < myLL.size(); i++) {
			a = (i-1) + "";
			assertEquals(a, myLL.get(i));
		}		
	}
	
	public void testAddLast() {
		String a;
		for (int i = 0 ; i < 25; i++) {
			a = "" + i;
			myLL.add(a);
		}
		
		String ss = "25";
		myLL.addLast(ss);
		int size = myLL.size();
		assertEquals(26, size);

		for (int i = 0 ; i < size; i++) {
			a = i + "";
			assertEquals(a, myLL.get(i));
		}		
	}
	
	@Test
	public void testRemoveFirst() {
		
		String a = "";
		String result = "";
		for(int i = 0; i < 10; i++) {
			myLL.add(i+"");
		}
		
		myLL.removeFirst();
		assertEquals(9, myLL.size());

		for(int i = 0; i < myLL.size(); i++) {
			a = i+1 + "";
			assertEquals(a, myLL.get(i));
		}
		
		int size = myLL.size();
		for(int i = 0; i < size; i++) {
			a = i+1 +"";
			result = myLL.removeFirst();
			assertEquals(a, result);
		}
		
		assertEquals(0, myLL.size());
	}
	
	@Test
	public void testRemoveLast() {
		
		String a = "";
		String result = "";
		for(int i = 0; i < 10; i++) {
			myLL.add(i+"");
		}
		
		myLL.removeLast();
		assertEquals(9, myLL.size());

		for(int i = 0; i < myLL.size(); i++) {
			a = i + "";
			assertEquals(a, myLL.get(i));
		}
		
		int size = myLL.size();
		for(int i = 0; i < size; i++) {
			a = myLL.size()-1 +"";
			result = myLL.removeLast();
			assertEquals(a, result);
		}
		
		assertEquals(0, myLL.size());
		
	}
	

	@Test
	public void testRemove() {
		
		String res = "";
		String a = "";
		for(int i = 0; i < 10; i++) {
			myLL.add(i+"");
		}

		for(int i = myLL.size()-1; i >= 0; i--) {
			a = myLL.get(i);
			res = myLL.remove(i);
			assertEquals(i, myLL.size());
			assertEquals(a,res);
		}
	}

	@Test
	public void testSize() {
		assertEquals(0,myLL.size());
	}

	@Test
	public void testIterator() {
		for(int i = 0; i<10; i++) {
			myLL.add(i+"");
		}
		Iterator<String> it = myLL.iterator();
		
		for(int i = 0; it.hasNext(); i++){
			String res = it.next();
			assertEquals(i+"",res);
		}
		
	    try {
			it.next();
	    } catch (NoSuchElementException ex) {
	        assertEquals(ex.getClass(),NoSuchElementException.class);
	    }
	}
	

}
