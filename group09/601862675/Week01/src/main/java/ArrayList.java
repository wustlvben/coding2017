import java.util.Arrays;

public class ArrayList implements List{

    private Object[] elements;

    private static final int INITIAL_SIZE = 16;

    private static final int MAX_SIZE = 48;

    private int size = 0;

    private int capacity = 0;

    public ArrayList() {
        elements = new Object[INITIAL_SIZE];
        capacity = INITIAL_SIZE;
    }

    public void add(int index, Object obj) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("");
        }
        testGrow();
        System.arraycopy(elements, index, elements, index+1, size - index);
        elements[index] = obj;
        size++;
    }

    public void add(Object obj) {
        testGrow();
        elements[size++] = obj;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("List: [ ");
        for (int i = 0; i < size; ++ i) {
            builder.append(elements[i]).append(" ");
        }
        builder.append("]");
        return builder.toString();
    }

    private void testGrow() {
        if (size == capacity) {
            if (size == MAX_SIZE) {
                throw new IndexOutOfBoundsException();
            }
            int newCapacity = capacity*2 > MAX_SIZE ? MAX_SIZE : capacity*2;
            grow(newCapacity);
        }
    }

    private void grow(int newLength) {
        Object[] newElements = new Object[newLength];
        System.arraycopy(elements, 0, newElements, 0, elements.length);
        elements = newElements;
        capacity = newLength;
    }

    public Object get(int i) {
        if (i < 0 || i >= size) {
            throw new IllegalArgumentException();
        }

        return elements[i];
    }

    public Iterator iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator{

        private int pos = 0;

        public boolean hasNext() {
            return pos < size();
        }

        public Object next() {
            return elements[pos++];
        }
    }
}
