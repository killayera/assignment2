// MyList interface
interface MyList<E> {
    void add(E element);
    E get(int index);
    void remove(int index);
    int size();
}

class MyArrayList<E> implements MyList<E> {
    private Object[] elements;
    private int size;
    public MyArrayList() {
        elements = new Object[10]; // Initial capacity of 10
        size = 0;
    }
    public void add(E element) {
        if (size == elements.length) {
            Object[] newElements = new Object[elements.length * 2];
            System.arraycopy(elements, 0, newElements, 0, size);
            elements = newElements;
        }
        elements[size++] = element;
    }
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        return (E) elements[index];
    }
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[--size] = null;
    }
    public int size() {
        return size;
    }
}
class MyLinkedList<E> implements MyList<E> {
    private class Node {
        E element;
        Node next;
        Node previous;

        Node(E element, Node next, Node previous) {
            this.element = element;
            this.next = next;
            this.previous = previous;
        }
    }