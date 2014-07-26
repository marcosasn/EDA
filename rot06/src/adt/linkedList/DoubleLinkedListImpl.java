package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {
	
	DoubleLinkedListNode<T> last;
	
	public DoubleLinkedListImpl() {
		last = new DoubleLinkedListNode<T>(null,
				new DoubleLinkedListNode<T>(null, null, null),
				new DoubleLinkedListNode<T>(null, null, null));
	}

	@Override
	public void insertFirst(T element) {
		if (last.isNIL()) {
			DoubleLinkedListNode<T> aux = last.previous;
			DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<T>(
					element, last, aux);

			last.previous = newNode;
			last = (DoubleLinkedListNode<T>) (head = newNode);
		} else {
			DoubleLinkedListNode<T> headNode = (DoubleLinkedListNode<T>) head;
			DoubleLinkedListNode<T> aux = headNode.previous;
			DoubleLinkedListNode<T> newHead = new DoubleLinkedListNode<T>(
					element, (DoubleLinkedListNode<T>) head, aux);
			aux.next = headNode.previous = newHead;
			head = newHead;
		}

	}

	@Override
	public void removeFirst() {
		if (!isEmpty()) {
			DoubleLinkedListNode<T> headNode = (DoubleLinkedListNode<T>) head;
			head = headNode.next;
			((DoubleLinkedListNode<T>) head).previous = headNode.previous;
		}
	}

	@Override
	public void removeLast() {
		if (!isEmpty()) {
			DoubleLinkedListNode<T> aux = (DoubleLinkedListNode<T>) last.next;
			last.data = null;
			last.next = aux;
			aux.previous = last;
			aux.next = null;
			last = last.previous;
		}
	}
}