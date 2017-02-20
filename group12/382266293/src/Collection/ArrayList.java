package Collection;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class ArrayList<E> implements List<E> {

	private E[] elements;
	private int size;
	private static final int INITIAL_SIZE = 16;
	private static final String PREFIX = "[";
	private static final String SUFFIX = "]";
	private static final String SEPERATOR = ",";

	public ArrayList() {
		elements = (E[]) new Object[INITIAL_SIZE];
		size = 0;
	}
	
	@Override
	public void add(E e) {
		checkCapacity();
		elements[size++] = e;
	}

	private void checkCapacity() {
		if (size>INITIAL_SIZE-1) 
			grow();
	}

	synchronized private void grow() {
		E[] target = (E[]) new Object[size*3/2];
		System.arraycopy(elements, 0, target, 0, size);
		elements = target;
	}
	
	@Override
	public void add(int index, E e) {
		checkCapacity();
		if (index == size) {
			add(e);
			return;
		}
		checkIndex(index);
		synchronized (this) {
			System.arraycopy(elements, index, elements, index+1, size-index+1);
			elements[index] = e;
			size++;
		}
	}
	
	@Override
	public E get(int index) {
		checkIndex(index);
			return elements[index];
	}
	
	@Override
	public boolean isEmpty() {
		if (size == 0)
			return true;
		return false;
	}
	
	@Override
	public E remove(int index) {
		checkIndex(index);
		if (index == size) {
			return elements[size--];
		}
		
		E result = elements[index];
		synchronized (this) {
			System.arraycopy(elements, index+1, elements, index, size-index-1);
			size--;
		}
		return result;
	}
	
	@Override
	public int size() {
		return size;
	}
	
	private void checkIndex(int i) {
		if(i<0 || i>size-1)
			throw new IndexOutOfBoundsException();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(PREFIX);
		for (int i = 0; i < size; i++) {
			sb.append(elements[i]);
			if (i < size-1)
				sb.append(SEPERATOR);
		}
		sb.append(SUFFIX);
		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(elements);
		result = prime * result + size;
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
		ArrayList other = (ArrayList) obj;
		if (!Arrays.equals(elements, other.elements))
			return false;
		if (size != other.size)
			return false;
		return true;
	}
	

	public Iterator<E> iterator(){
		return new ArrayListIterator<E>(this);
	}
	
	private class ArrayListIterator<E> implements Iterator<E> {

		private ArrayList<E> myArrayList;
		private int pos;
		
		public ArrayListIterator(ArrayList<E> arrayList) {
			myArrayList = arrayList;
			pos = 0;
		}

		@Override
		public boolean hasNext() {
			if (pos < size)
				return true;
			return false;
		}

		@Override
		public E next() {
			if (hasNext())
				return (E) elements[pos++];
			throw new NoSuchElementException();
		}
	}
	
}
