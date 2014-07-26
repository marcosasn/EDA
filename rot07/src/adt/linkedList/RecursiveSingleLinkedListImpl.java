package adt.linkedList;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;
	
	public RecursiveSingleLinkedListImpl() {
	}
	
	@Override
	public boolean isEmpty() {
		if (getData() == null) {
			return true;
		}
		return false;
	}

	@Override
	public int size() {
		if (isEmpty()) {
			return 0;
		}
		else {
			return 1 + getNext().size();
		}
	}

	@Override
	public T search(T element) {
		if (isEmpty()) {
			return null;
		}
		else {
			if (getData().equals(element)) {
				return getData();
			}
			else {
				return getNext().search(element);
			}
		}
	}

	@Override
	public void insert(T element) {
		if (isEmpty()) {
			setData(element);
			setNext(new RecursiveSingleLinkedListImpl<T>());
		}
		else {
			getNext().insert(element);
		}
	}

	@Override
	public void remove(T element) {
		if (isEmpty()) {
			
		}
		else {
			if (getData().equals(element)) {
				setData(next.getData());
				setNext(next.getNext());
			}
			else {
				getNext().remove(element);
			}
		}

	}
	@Override
	public T[] toArray(){
		T[] result = (T[]) new Object[size()];
		int indice = 0;
		
		toArrayList(result, this, indice);
		return result;
	}

	private void toArrayList(T[] array,
			RecursiveSingleLinkedListImpl<T> recursiveSingleLinkedListImpl, int indice) {
		if(!recursiveSingleLinkedListImpl.isEmpty()) {
			array[indice] = recursiveSingleLinkedListImpl.getData();
			indice ++;
			toArrayList(array, recursiveSingleLinkedListImpl.getNext(), indice);
		}
		
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RecursiveSingleLinkedListImpl<T> getNext() {
		return next;
	}

	public void setNext(RecursiveSingleLinkedListImpl<T> next) {
		this.next = next;
	}

}
