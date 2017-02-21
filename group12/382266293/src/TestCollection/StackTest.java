package TestCollection;

import static util.Print.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Collection.Concrete.Stack;
import junit.framework.TestCase;

public class StackTest extends TestCase {

	Stack<Integer> myStack;
	
	@Before
	public void setUp() throws Exception {
		myStack= new Stack<Integer>();
	}

	@After
	public void tearDown() throws Exception {
		myStack = null;
	}

	@Test
	public void testIsEmpty() {
		assertEquals(0, myStack.size());
	}

	@Test
	public void testPush() {
		for (int i = 0; i < 10; i++) {
			assertEquals(i, myStack.size());
			myStack.push(i);
		}
	}

	@Test
	public void testPop() {
		testPush();
		int size = myStack.size();
		for (int i = size; i > 0; i--) {
			assertEquals(i, myStack.size());
			int expect = i-1;
			assertEquals(i, myStack.size());
			int actual = myStack.pop();
			assertEquals(expect, actual);
		}
	}

	@Test
	public void testPeek() {
		
		int expected = 0;
		int peek1 = 0;
		int repeated = 0;
		
		for (int i = 0; i < 10; i++) {
			myStack.push(i);
			expected = i;
			
			peek1 = myStack.peek();
			assertEquals(expected, peek1);
			
			for (int j = 0; j < i; j++) {
				repeated = myStack.peek();
				assertEquals(expected, repeated);
			}
		}
		
	}

	@Test
	public void testSize() {
		for (int i = 0; i < 10000; i++) {
			assertEquals(i, myStack.size());
			myStack.push(i);
		}
	}

	@Test
	public void testAdd() {
		for (int i = 0; i < 10; i++) {
			myStack.add(i);
			Integer actual = new Integer(myStack.get(i));
			Integer expected = new Integer(i);
			assertEquals(expected, actual);
		}
	}

	@Test
	public void testPopPushAndPeek() {
		for (int i = 0; i < 10; i++) {
			int expected = i;
			myStack.push(i);
			int a = 0;
			myStack.push(a);
			myStack.pop();
			int actual = myStack.peek();
			assertEquals(expected, actual);
		}
	}

}
