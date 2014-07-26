package adt.stack;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;

public class StackDoubleLinkedListImpl<T> implements Stack<T> {
	
	protected DoubleLinkedList<T> list;
	protected int size;
	
	public StackDoubleLinkedListImpl(int size) {
		this.size = size;
		list = new DoubleLinkedListImpl<>();
	}
	
	
	@Override
	public void push(T element) throws StackOverflowException {
		if (list.size() == size) {
			throw new StackOverflowException();
		}
		list.insertFirst(element);
	}

	@Override
	public T pop() throws StackUnderflowException {
		T element;
		if (isEmpty()) {
			throw new StackUnderflowException();
		}
		element = lastElement();
		list.removeFirst();
		return element;
	}

	@Override
	public T top() {
		return lastElement();
	}
	
	private T lastElement() {
		T[] array = list.toArray();
		return array[0];
	}

	@Override
	public boolean isEmpty() {
		if (list.isEmpty()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isFull() {
		if (list.size() == size) {
			return true;
		}
		return false;
	}
}