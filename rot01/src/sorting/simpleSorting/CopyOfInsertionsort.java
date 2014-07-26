package sorting.simpleSorting;

import sorting.SortingImpl;
import sorting.Util;

/**
 * The insertion sort algorithm consumes the array (element by element) and inserts the elements 
 * into an ordered list. The algorithm must sort the elements from 
 * leftIndex to rightIndex (inclusive). 
 */
public class CopyOfInsertionsort<T extends Comparable<T>> extends SortingImpl<T> {

	@Override
	protected void sort(T[] array, int leftIndex, int rightIndex) {
		for (int i = leftIndex; i <= rightIndex; i++) {
			T key = array[i];
			int j = i - 1;
			while (j >= 0 && array[j].compareTo(key) > 0){
				array[j + 1] = array[j];
				Util.swap(array, j+1, j);
				j = j - 1;
			}
			array[j + 1] = key;
		}
	}
}
