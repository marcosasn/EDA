package adt.stack;


public class StackImpl<T> implements Stack<T> {

	private T[] stack;
	private int top = -1;
	
	public StackImpl(int size) {
		stack = (T[])new Object[size];
	}
	
	@Override
	public T top() {
		return stack[top];
	}

	@Override
	public boolean isEmpty() {
		return top == -1;
	}

	@Override
	public boolean isFull() {
		return top == stack.length-1;
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if (isFull()) {
			throw new StackOverflowException();
		}
		stack[++top] = element;

	}

	@Override
	public T pop() throws StackUnderflowException {
		if (isEmpty()) {
			throw new StackUnderflowException();
		}
		return stack[--top];
	}
}
