package sorting.divideAndConquer;

import sorting.SortingImpl;

public class Mergesort<T extends Comparable<T>> extends SortingImpl<T> {

	@Override
	protected void sort(T[] array,int leftIndex, int rightIndex) {
		int mid = (leftIndex + rightIndex) / 2;
		if (leftIndex < rightIndex) {
			
			sort(array, leftIndex, mid);
			sort(array, mid + 1, rightIndex);
			
			merge(array, leftIndex, rightIndex, mid);
		}
	}


	private T[] merge(T[] array, int leftIndex, int rightIndex, int mid) {
		int contLeft = leftIndex;
		int contRight = rightIndex;
		
		T[] result = (T[]) new Comparable[array.length];
		
		for (int i = leftIndex; i <= mid; i++) {
			result[i] = array[i];
		}
		for (int j = mid+1; j <= rightIndex; j++) {
			result[rightIndex + mid + 1 - j] = array[j];
		}
		
		for (int k = leftIndex; k <= rightIndex; k++) {
			if (result[contLeft].compareTo(result[contRight]) <= 0) {
				array[k] = result[contLeft];
				contLeft++;
			}
			else {
				array[k] = result[contRight];
				contRight--;
			}
		}
		return array;
	}
}
