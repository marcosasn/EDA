package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;
	
	public SingleLinkedListImpl() {
		head = new SingleLinkedListNode<T>();
	}
	
	@Override
	public boolean isEmpty() {
		if (head.isNIL()) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int size() {
		int cont = 0;
		SingleLinkedListNode<T> aux = head;
		
		if (isEmpty()) {
			return cont;
		}
		
		while (!(aux.isNIL())) {
			cont ++;
			aux = aux.next;
			
		}
		return cont;
	}

	@Override
	public T search(T element) {
		SingleLinkedListNode<T> aux = head;
		
		while (!(aux.isNIL()) && !aux.getData().equals(element)) {
			aux = aux.next;
		}
		return aux.data;
	}

	@Override
	public void insert(T element) {
		SingleLinkedListNode<T> aux = head;
		
		if (head.isNIL()) {
			SingleLinkedListNode<T> newHead = new SingleLinkedListNode<T>(element, new SingleLinkedListNode<T>());
			newHead.next = head;
			head = newHead;
			
		} else {
			while (!(aux.next.isNIL())) {
				aux = aux.next;
			}
		}
		SingleLinkedListNode<T> newNode = new SingleLinkedListNode<T>(element, new SingleLinkedListNode<T>());
		newNode.next = aux.next;
		aux.next = newNode;
	}

	@Override
	public void remove(T element) {
		if (!head.isNIL() && head.getData().equals(element)) {
			head = head.next;
		}
		else {
			SingleLinkedListNode<T> aux = head;
			SingleLinkedListNode<T> previous =  new SingleLinkedListNode<T>();
			while (!(aux.isNIL()) && !aux.getData().equals(element)) {
				previous = aux;
				aux = aux.next;
			}
			if (!aux.isNIL()) {
				previous.next = aux.next;
			}
		}

	}
	
	@Override
	public T[] toArray(){
		T[] result = (T[]) new Object[size()];
		SingleLinkedListNode<T> aux = head;
		int cont = 0;
		
		while (!aux.isNIL()) {
			result[cont] = aux.getData();
			aux = aux.next;
			cont++;
		}
		return result;
	}
}