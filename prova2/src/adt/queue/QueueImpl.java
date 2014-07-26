package adt.queue;

public class QueueImpl<T> implements Queue<T> {

	private T[] queue;
	private int tail = -1;
	private int head = 0;
		
	public QueueImpl(int size) {
		queue = (T[]) new Object[size];
	}

	@Override
	public T head() {
		return queue[head];
		
	}

	@Override
	public boolean isEmpty() {
		if (tail == -1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isFull() {
		if (tail == queue.length-1) {
			return true;
		}
		return false;
	}
	
	private void shiftLeft(){
		for (int i = 0; i < queue.length-1; i++) {
			queue[i] = queue[i+1];
		}
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (isFull()) {
			throw new QueueOverflowException();
		}
		queue[++tail] = element;
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (isEmpty()) {
			throw new QueueUnderflowException();
		}
		T result = queue[head];
		shiftLeft();
		return result;
	}
}
