package adt.hashtable;

import java.util.LinkedList;

public class HashtableClosedAddressImpl<T> extends
		AbstractHashtable<T, LinkedList<T>> {

	@SuppressWarnings("unchecked")
	public HashtableClosedAddressImpl(int size,
			HashFunctionClosedAddressMethod method) {
		super(size);
		super.table = (LinkedList<T>[]) new LinkedList[getPrimeAbove(size)];
		super.hashFunction = new HashFunctionDivisionMethodImpl<T>(this);
	}

	/**
	 * It returns the prime number that is closest (and greater) to the given
	 * number.
	 */
	int getPrimeAbove(int number) {
		int result = number;
		while (!Util.isPrime(result)) {
			result = result + 1;
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void insert(T element) {
		if (this.search(element) == null) {
			int index = ((HashFunctionDivisionMethodImpl<T>) hashFunction).hash(element);
			
			if (super.table[index] == null) {
				super.table[index] = new LinkedList<T>();
			} else {
				super.COLLISIONS++;
			}
			super.table[index].add(element);
			super.elements++;
		}
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void remove(T element) {
		if (this.search(element) != null) {
			int index = ((HashFunctionDivisionMethodImpl)hashFunction).hash(element);
			super.table[index].remove(element);
			super.elements--;
		}
	}

	@SuppressWarnings({"unchecked" })
	@Override
	public T search(T element) {
		T result = null;
		int index = ((HashFunctionDivisionMethodImpl<T>)hashFunction).hash(element);
		if (super.table[index] != null && super.table[index].indexOf(element) != -1) {
			result = super.table[index].get(super.table[index].indexOf(element));
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int indexOf(T element) {
		int index = -1;
		if (this.search(element) != null) {
			index = ((HashFunctionDivisionMethodImpl<T>)hashFunction).hash(element);
		}
		return index;
	}
}