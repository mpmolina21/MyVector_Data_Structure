/**
 * Data Structure Coding Challenge - designed data structure behaves like a dynamically allocated vector that changes by
 * adding elements, removing elements, and re-sizing implemented list.
 * CS 108-2
 * @date 4/18/2020
 * @author Maria Paula Molina
 */
public abstract class MyAbstractList<E> implements MyList<E> {

	protected int size;
	
	public MyAbstractList() {
	}

	@Override
	public boolean isEmpty() {
		return this.size == 0;
	}

	@Override
	public int size() {
		return this.size;
	}

}