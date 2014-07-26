package adt.hashtable;

public class HashtableOpenAddressQuadraticProbingImpl<T> extends
		AbstractHashtable<T, Object> {

	public HashtableOpenAddressQuadraticProbingImpl(int size,
			HashFunctionClosedAddressMethod method, int c1, int c2) {
		super(size);
		super.table = new Object[size];
		super.hashFunction = new HashFunctionQuadraticProbingImpl<T>(this,
				method, c1, c2);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void insert(T element) {
		int index;
		if (!this.isFull()) {
			for (int i = 0; i < this.capacity(); i++) {
				index = ((HashFunctionQuadraticProbingImpl<T>) hashFunction)
						.hash(element, i);
				if (table[index] == null
						|| table[index].getClass() == DELETED.class) {
					table[index] = element;
					super.elements++;
				} else {
					super.COLLISIONS++;
				}
			}
		}
	}

	@Override
	public void remove(T element) {
		int index;
		if (search(element) != null) {
			index = this.indexOf(element);
			super.table[index] = new DELETED();
			super.elements--;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T search(T element) {
		T result = null;
		int index = this.indexOf(element);
		if (index != -1) {
			result = (T) super.table[index];
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int indexOf(T element) {
		int result = -1;
		int index;
		for (int i = 0; i < this.capacity(); i++) {
			index = ((HashFunctionQuadraticProbingImpl<T>)hashFunction).hash(element, i);
			if (super.table[index].equals(element)) {
				result = index;
			}
		}
		return result;
	}
}
