package adt.queue;

import adt.stack.Stack;
import adt.stack.StackImpl;
import adt.stack.StackOverflowException;
import adt.stack.StackUnderflowException;

public class QueueUsingStack<T> implements Queue<T> {

	private Stack<T> stack1;
	private Stack<T> stack2;
	
	public QueueUsingStack(int size) {
		stack1 = new StackImpl<T>(size);
		stack2 = new StackImpl<T>(size);
	}
	
	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (isFull()) {
			throw new QueueOverflowException(); 
		}
		copyStack(stack1, stack2);
		
		try {
			stack1.push(element);
		} catch (StackOverflowException e) {
			throw new QueueOverflowException();
		}
		
		copyStack(stack2, stack1);

	}

	private void copyStack(Stack<T> stack1, Stack<T> stack2) {
		while(true) {
			try {
				stack2.push(stack1.pop());
			} catch (StackOverflowException | StackUnderflowException e) {
				break;
			}
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		T result;
		try {
			result = stack1.pop();
		} catch(StackUnderflowException e) {
			throw new QueueUnderflowException();
		}
		return result;
	}

	@Override
	public T head() {
		return stack1.top();
	}

	@Override
	public boolean isEmpty() {
		return stack1.isEmpty();
	}

	@Override
	public boolean isFull() {
		return stack1.isFull();
	}
}
