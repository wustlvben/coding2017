package TestCollection;

import static util.Print.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import Collection.Concrete.Queue;
import junit.framework.TestCase;

public class QueueTest extends TestCase {

	Queue<Integer> myQueue;
	
	@Before
	public void setUp() throws Exception {
		myQueue= new Queue<Integer>();
	}

	@After
	public void tearDown() throws Exception {
		myQueue = null;
	}

	@Test
	public void testIsEmpty() {
		assertEquals(0, myQueue.size());
	}

	@Test
	public void testEnQueue() {
		for (int i = 0; i < 10; i++) {
			assertEquals(i, myQueue.size());
			myQueue.enQueue(i);
			int expected = i;
			int actual = myQueue.get(i);
			assertEquals(expected, actual);
		}
	}

	@Test
	public void testDeQueue() {
		testEnQueue();
		int size = myQueue.size();
		for (int i = 0; i < size ; i++) {
			assertEquals(size-i, myQueue.size());
			int expect = i;
			int actual = myQueue.deQueue();
			assertEquals(expect, actual);
		}
	}

	@Test
	public void testelement() {
		
		int expected = 0;
		int element1 = 0;
		int repeated = 0;
		
		for (int i = 0; i < 10; i++) {
			myQueue.enQueue(i);
			expected = i;
			
			element1 = myQueue.element();
			assertEquals(expected, element1);
			
			for (int j = 0; j < i; j++) {
				repeated = myQueue.element();
				assertEquals(expected, repeated);
			}
			myQueue.deQueue();
		}
		
	}

	@Test
	public void testSize() {
		for (int i = 0; i < 10000; i++) {
			assertEquals(i, myQueue.size());
			myQueue.enQueue(i);
		}
	}

	@Test
	public void testAdd() {
		for (int i = 0; i < 10; i++) {
			myQueue.add(i);
			Integer actual = new Integer(myQueue.get(i));
			Integer expected = new Integer(i);
			assertEquals(expected, actual);
		}
	}


}
