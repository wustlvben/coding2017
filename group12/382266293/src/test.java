import java.util.ArrayList;
import static util.Print.*;


import javax.print.attribute.standard.PrinterLocation;

import Collection.Concrete.Stack;
import util.Print;

public class test {
	public static void main(String args[]) {
		
		Stack myStack = new Stack();
		for (int i = 0; i < 10; i++) {
			myStack.push(i);
		}
		println(myStack);
		
		int size = myStack.size();
		for (int i = size; i > 0; i--) {
			print("");
			int actual = (int) myStack.pop();
			println(i+" // "+ actual);
		}
		
	}
}
