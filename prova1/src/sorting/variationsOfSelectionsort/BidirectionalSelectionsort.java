package sorting.variationsOfSelectionsort;

import sorting.SortingImpl;

/**
 * This selectionsort variation puts the greatest element into the right
 * position (walking from left to right) and, after that, it puts the smallest
 * element into the left position (walking from right to left). This happens in
 * a same iteration. The following iterations do the same until the array is
 * completely ordered.The algorithm must sort the elements from leftIndex to
 * rightIndex (inclusive).
 */
public class BidirectionalSelectionsort<T extends Comparable<T>> extends
		SortingImpl<T> {

	@Override
	protected void sort(T[] array, int leftIndex, int rightIndex) {
		int i = leftIndex;
		int k = rightIndex - 1;
		while (i < k) {
			int min = i;
			int max = i;
			int j;
			for (j = i + 1; j <= k; j++) {
				if (array[j].compareTo(array[min]) < 0) 
					min = j;
				if (array[j].compareTo(array[min]) > 0) 
					max = j;
			}
			T tmp = array[min];
			array[min] = array[i];
			array[i] = tmp;

			if (max == i) {
				tmp = array[min];
				array[min] = array[k];
				array[k] = tmp;
			} else {
				tmp = array[max];
				array[max] = array[k];
				array[k] = tmp;
			}
			i++;
			k--;
		}
	}

}
