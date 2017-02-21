package Collection.Concrete;

import Collection.AbstractList;

public class Stack<E> extends AbstractList<E> {
	
	private ArrayList<E> myList;

	public Stack() {
		this.myList = new ArrayList<E>();
	}

	public void push(E e){
		myList.addLast(e);
	}
	
	public E pop(){
		return myList.removeLast();
	}
	
	public E peek(){
		return myList.getLast();
	}

	public int size(){
		return myList.size();
	}

	@Override
	public void add(E e) {
		push(e);
	}

	@Override
	public E get(int index) {
		return myList.get(index);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((myList == null) ? 0 : myList.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stack other = (Stack) obj;
		if (myList == null) {
			if (other.myList != null)
				return false;
		} else if (!myList.equals(other.myList))
			return false;
		return true;
	}
	
}
