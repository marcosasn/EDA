package sorting.linearSorting;

import java.util.Arrays;

import sorting.SortingImpl;

public class Countingsort extends SortingImpl<Integer> {

	@Override
	protected void sort(Integer[] array, int leftIndex, int rightIndex) {
		Integer[] arrayB = new Integer[array.length];
		Integer[] arrayC = new Integer[100];

		for (int i = 0; i < arrayC.length; i++) {
			arrayC[i] = 0;
		}

		for (int j = 0; j < array.length; j++) {
			arrayC[array[j]]++;
		}

		for (int k = 1; k < arrayC.length; k++) {
			arrayC[k] = arrayC[k-1] + arrayC[k];
		}

		for (int i = rightIndex; i >= leftIndex; i--) {
			arrayB[arrayC[array[i]]-1] = array[i];
			arrayC[array[i]] = arrayC[array[i]]-1;
		}

		for (int i = leftIndex; i <= rightIndex; i++) {
			array[i] = arrayB[i];
		}
		System.out.println(Arrays.asList(array));
	}
}