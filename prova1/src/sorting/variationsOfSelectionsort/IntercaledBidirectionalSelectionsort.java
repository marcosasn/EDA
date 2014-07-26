package sorting.variationsOfSelectionsort;

import java.util.Arrays;

import sorting.SortingImpl;
import sorting.Util;

/**
 * This selectionsort variation puts the greatest element into the right
 * position (walking from left to right) and, after that, it puts the smallest
 * element into the left position (walking from right to left). This happens in
 * a same iteration. The following iterations do the same until the array is
 * completely ordered.The algorithm must sort the elements from leftIndex to
 * rightIndex (inclusive).
 */
public class IntercaledBidirectionalSelectionsort<T extends Comparable<T>> extends
		SortingImpl<T> {

	@Override
	protected void sort(T[] array, int leftIndex, int rightIndex) {
		int contPares = 0;
		int contImpares = 0;
		
		System.out.println(Arrays.asList(array));
		for (int i = leftIndex; i <= rightIndex; i++) {
			if (i % 2 == 0) contPares++;
			else contImpares++;
		}
		
		T[] arrayPares = (T[]) new Comparable[contPares];
		T[] arrayImpares = (T[]) new Comparable[contImpares];
		
		int j = 0;
		int k = 0;
		for (int i = leftIndex; i <= rightIndex; i++) {
			if (i % 2 == 0) arrayPares[j++] = array[i];
			else arrayImpares[k++] = array[i];
		}
		
		System.out.println(Arrays.asList(arrayPares));
		System.out.println(Arrays.asList(arrayImpares));
		
		selectionSort(arrayImpares, 0, arrayImpares.length-1);
		selectionSort(arrayPares, 0, arrayPares.length-1);
		
		System.out.println(Arrays.asList(arrayPares));
		System.out.println(Arrays.asList(arrayImpares));
		
		merge(array, arrayPares, arrayImpares, leftIndex, rightIndex);

	}
	
	private void selectionSort(T[] array, int leftIndex, int rigthIndex) {
		int low;
		for (int i = leftIndex; i <= rigthIndex; i++) {
			low = i;
			for (int j = i+1; j <= rigthIndex; j++) {
				if (array[j].compareTo(array[low]) < 0) {
					low = j;
				}
				
			}Util.swap(array, i, low);
		}
	}
	
	private void merge(T[] array, T[] arrayPares, T[] arrayImpares, int leftIndex, int rightIndex) {
		int contLeft = leftIndex;
		int contRight = rightIndex;
		T[] result = (T[]) new Comparable[array.length];
		
		int j = 0;
		int k = 0;
		for (int i = leftIndex; i <= rightIndex; i++) {
			if (i % 2 == 0) result[i] = arrayPares[j++];
			else result[i] = arrayImpares[k++];
		}
		System.out.println(Arrays.asList(result));
		
		for (int i = leftIndex; i <= rightIndex; i++) {
		}
		
		System.out.println(Arrays.asList(array));
	}

}
