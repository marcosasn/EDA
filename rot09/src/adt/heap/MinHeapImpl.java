package adt.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinHeapImpl<T extends Comparable<T>> implements MinHeap<T> {

	private static final int INITIAL_SIZE = 20;
	private static final int INCREASING_FACTOR = 10;
	private static final int ZERO = 0;
	
	private T[] heap;
	private int size;
	
	@SuppressWarnings("unchecked")
	public MinHeapImpl() {
		heap = (T[]) new Comparable[INITIAL_SIZE];
		size = ZERO;
	}
	
	@Override
	public boolean isEmpty() {
		return size == ZERO;
	}

	@Override
	public void insert(T element) {
		if (size >= heap.length) { 
			heap = Arrays.copyOf(heap, heap.length + INCREASING_FACTOR);
		}
		/*else if (isEmpty()) {
			heap[ZERO] = element;
			size++;
		}*/

		else {
			int i = size;
			while (i > ZERO && heap[parent(i)].compareTo(element) > ZERO) {
				heap[i] = heap[parent(i)];
				i = parent(i);
			}
			
			heap[i] = element;
			size++;
		}
	}

	protected int parent(int indice) {
		return (indice - 1) / 2;
	}

	protected int left(int indice) {
		return (2 * indice) + 1;
	}

	protected int right(int indice) {
		return (2 * indice) + 2;
	}

	@Override
	public T extractRootElement() {
		if (isEmpty()) {
			return null;
		}

		T root = rootElement();
		Util.swap(heap, ZERO, size - 1);
		size--;
		heapify(ZERO);
		return root;
	}

	@Override
	public T rootElement() {
		if (isEmpty()) {
			return null;
		}
		return heap[ZERO];
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] heapsort(T[] array) {
		List<T> result = new ArrayList<T>();
		buildHeap(array);
		
		while(!isEmpty()) {
			result.add(extractRootElement());
		}
		return (T[]) result.toArray(new Comparable[array.length]);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void buildHeap(T[] array) {
		size = array.length;
		heap = (T[]) new Comparable[array.length]; 
	
		for (int i = 0; i < array.length; i++) { 
			heap[i] = array[i];
		}
		for (int i = ((array.length - 1) / 2); i >= 0; i--) {
			heapify(i);
		}
	}

	private void heapify(int position){
		int left = left(position);
		int right = right(position); 
		int largest = position;
		
		if ((left <= size-1)) {
			if (heap[left].compareTo(heap[position]) < ZERO) { 
				largest = left;
			}
			/*else { 
				largest = position;
			}*/
		}
		
		if ((right <= size - 1)) {
			if (heap[right].compareTo(heap[largest]) < ZERO) {
				largest = right;
			}
		}
		
		if (largest != position){ 
			Util.swap(heap, position, largest);
			heapify(largest);
		}
	}
	
	@Override
	public T[] toArray() {
		/*T[] result = (T[]) new Comparable[size];
		
		for(int i = 0; i < result.length; i++) { 
			result[i] = heap[i];
		}
		return result;*/
		return heap.clone();
	}
}
