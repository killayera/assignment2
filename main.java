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