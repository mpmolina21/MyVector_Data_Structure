/**
 * Data Structure Coding Challenge - designed data structure behaves like a dynamically allocated vector that changes by
 * adding elements, removing elements, and re-sizing implemented list.
 * CS 108-2
 * @date 4/18/2020
 * @author Maria Paula Molina
 */


public class MyVector<E> extends MyAbstractList<E> {
    E[] mylist;

    int capacity;
    int size = 0;
    int capacityIncrement = 5;

    @SuppressWarnings("unchecked")
    public MyVector() {
        mylist = (E[]) new Object[10];
        capacity = 10;
    }

    @SuppressWarnings("unchecked")
    public MyVector (int capacity) {
        mylist = (E[]) new Object[capacity];
        this.capacity = capacity;
    }

    @SuppressWarnings("unchecked")
    public MyVector (int capacity, int capacityIncrement) {
        mylist = (E[]) new Object[capacity];
        this.capacity = capacity;
        this.capacityIncrement = capacityIncrement;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getIncrement() {
        return capacityIncrement;
    }

    /**
     * Appends the specified element to the end of this list,
     * The list capacity should be resized based on a capacity
     * increment variable once the current capacity is filled (capacity == size).
     * @param data
     * @return boolean
     */

    @Override
    @SuppressWarnings("unchecked")
    public boolean add(E data) {
        boolean resized = false;

        if (size == capacity) {

            E[] biggerList = (E[]) new Object[capacity + capacityIncrement];
            for (int i = 0; i < capacity; i ++) {
                biggerList[i] = mylist[i];
            }
            mylist = biggerList;
            capacity += capacityIncrement;
            resized = true;
        }

        mylist[size] = data;
        size ++;

        return resized;

    }

    /**
     * Inserts the specified element at the specified position in this list.
     * Shifts the element currently at that position (if any) and any subsequent
     * elements by adding one to their indices.
     * The list capacity should be resized based on a capacity
     * increment variable once the current capacity is filled (capacity == size).
     * @param index - index at which the specified element is to be inserted
     * @param data - element to be inserted
     * @return boolean
     * @throws IndexOutOfBoundsException - if the index is out of range (index < 0 || index > size())
     */

    @Override
    @SuppressWarnings("unchecked")
    public boolean add(int index, E data) throws IndexOutOfBoundsException {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("Index Out of Bounds when inserting element");
        }
        boolean resized = false;

        if (size == capacity) {


            E[] biggerList = (E[]) new Object[capacity + capacityIncrement];
            for (int i = 0; i < capacity; i ++) {
                biggerList[i] = mylist[i];
            }
            mylist = biggerList;
            capacity += capacityIncrement;
            resized = true;
        }
        for (int i = size - 1; i >= index; i --) {
            mylist[i + 1] = mylist[i];
        }

        mylist[index] = data;
        size ++;
        return resized;

    }

    /**
     * Removes all of the elements from this list
     */

    @SuppressWarnings("unchecked")
    @Override
    public void clear() {
        size = 0;
    }

    /**
     * Returns the element at the specified position in this list
     * @param index
     * @return E
     */

    @Override
    public E get(int index){
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index Out of Bounds when accessing element");
        }
        return mylist[index];
    }

    /**
     * Returns true if this list contains no elements
     * @return boolean
     */

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Removes the  element at the specified position in this list.
     * Shifts any subsequent elements by subtracting one from their indices.
     * @param index - index of the element to be removed
     * @return E - the element that was removed from the list
     * IndexOutOfBoundsException - if the index is out of range (index < 0 || index >= size())
     */

    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index Out of Bounds when removing element");
        }
        E removed = mylist[index];

        for (int i = index; i < mylist.length - 1; i++) {
            mylist[i] = mylist[i + 1];
        }

        size --;

        return removed;


    }

    /**
     * Trims the capacity of this MyVector instance to be the list's current size. An application
     * can use this operation to minimize the storage of a MyVector instance.
     */

    @Override
    @SuppressWarnings("unchecked")
    public void trimToSize() {
        E[] smallerList = (E[]) new Object[size];
        for (int i = 0; i < size; i ++) {
            smallerList[i] = mylist[i];
        }
        mylist = smallerList;
        capacity = size;

    }

    /**
     * Returns the number of elements in this list
     * @return int
     */

    @Override
    public int size(){
        return size;
    }

    @Override
    public String toString() {
        String output = "[";
        for(int i = 0; i < size; i++){
            if (i == size - 1) {
                output += mylist[i] + "]";
            }
            else {
                output += mylist[i] +  ", ";
            }
        }

        return output;
    }
}