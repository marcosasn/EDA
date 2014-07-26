package adt.heap;

import java.util.Arrays;

import sorting.Util;

public class MinHeapImpl<T extends Comparable<T>> implements MinHeap<T> {

	private static final int INITIAL_SIZE = 20;
	private static final int INCREASING_FACTOR = 10;
	private T[] heap;
	private int size;
	
	@SuppressWarnings("unchecked")
	public MinHeapImpl() {
		heap = (T[]) new Comparable[INITIAL_SIZE];
		size = 0;
	}
	
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public void insert(T element) {
		if (size >= heap.length) {
			heap = Arrays.copyOf(heap, heap.length + INCREASING_FACTOR);
		}
		else {
			int i = size;
			while (i > 0 && heap[parent(i)].compareTo(element) > 0) {
				heap[i] = heap[parent(i)];
				i = parent(i);
			}
			heap[i] = element;
			size++;
		}
	}
	
	private int parent(int i) {
		return (i-1)/2;
	}

	@Override
	public T extractRootElement() {
		if (this.rootElement() == null) {
			return null;
		}
		
		T root = this.rootElement();
		Util.swap(heap, 0, size-1);
		size--;
		this.heapify(0);
		return root;
	}

	@Override
	public T rootElement() {
		if (this.isEmpty()) {
			return null;
		}
		return heap[0];
	}

	@Override
	public T[] heapsort(T[] array) {
		T[] copy = array.clone();
		int i = 0;
		while(!this.isEmpty()) {
			copy[i++] = this.extractRootElement();
		}
		this.buildHeap(copy);
		return copy;
	}

	@Override
	public void buildHeap(T[] array) {
		heap = array.clone();
		size = heap.length;
		for (int i = (size-1)/2; i >= 0; i--) {
			heapify(i);
		}
	}

	private void heapify(int position) {
		int left = this.left(position);
		int right = this.right(position);
		int min = position;
		
		if (left <= size-1 && heap[left].compareTo(heap[position]) < 0) {
			min = left;
		}
		if (right <= size-1 && heap[right].compareTo(heap[min]) < 0) {
			min = right;
		}
		
		if (min != position) {
			Util.swap(heap, position, min);
			heapify(min);
		}
	}
	
	private int left(int i) {
		return 2 * i + 1;
	}
	
	private int right(int i) {
		return 2 * i + 2;
	}

	@Override
	public T[] toArray() {
		return heap.clone();
	}
}