package adt.linkedList;

public class RecursiveDoubleLinkedListImpl<T> extends
		RecursiveSingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected RecursiveDoubleLinkedListImpl<T> previous;

	public RecursiveDoubleLinkedListImpl() {
	}

	@Override
	public void insertFirst(T element) {
		if (isEmpty()) {
			setData(element);
			setNext(new RecursiveDoubleLinkedListImpl<T>());
			((RecursiveDoubleLinkedListImpl<T>) getNext()).previous = this;
			previous = new RecursiveDoubleLinkedListImpl<T>();
			previous.next = this;

		} else {
			RecursiveDoubleLinkedListImpl<T> newNode = new RecursiveDoubleLinkedListImpl<T>();
			newNode.setNext(next);
			newNode.previous = this;
			newNode.setData(data);
			((RecursiveDoubleLinkedListImpl<T>) getNext()).previous = newNode;
			setData(element);
			setNext(newNode);
		}

	}

	@Override
	public void removeFirst() {
		if (isEmpty()) {

		} else {
			if (!isEmpty()) {
				setData(next.getData());
				setNext(next.getNext());
				previous = new RecursiveDoubleLinkedListImpl<>();
			} else {
				((RecursiveDoubleLinkedListImpl<T>)getNext()).removeFirst();
			}
		}
	}

	@Override
	public void removeLast() {
		if(!isEmpty()){		
			if(getNext().isEmpty()){
				if(previous.isEmpty())
					setData(null);
				previous.next = next;
				((RecursiveDoubleLinkedListImpl<T>)getNext()).previous = previous;
			}else
				((RecursiveDoubleLinkedListImpl<T>)getNext()).removeLast();
			}
		}
}

