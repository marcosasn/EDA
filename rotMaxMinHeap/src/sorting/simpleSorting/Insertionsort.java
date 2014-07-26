package sorting.simpleSorting;

import sorting.SortingImpl;
import sorting.Util;

/**
 * The insertion sort algorithm consumes the array (element by element) and
 * inserts the elements into an ordered list. The algorithm must sort the
 * elements from leftIndex to rightIndex (inclusive).
 */
public class Insertionsort<T extends Comparable<T>> extends SortingImpl<T> {

	@Override
	protected void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex < 0 || rightIndex > array.length) {
			return;
		}
		T num;
		for (int i = leftIndex + 1; i < rightIndex; i++) {
			num = array[i];
			for (int j = i - 1; (j >= leftIndex && array[j].compareTo(num) > 0); j--)
				Util.swap(array, j + 1, j);
		}

	}

}
