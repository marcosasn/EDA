package sorting.variationsOfSelectionsort;

import java.util.Arrays;

import sorting.SortingImpl;
import sorting.Util;

/**
 * This selectionsort variation puts the greatest element into the right position (walking from 
 * left to right) and, after that, it puts the smallest element into the left position (walking from 
 * right to left). This happens in a same iteration. The following iterations do the same until 
 * the array is completely ordered.The algorithm must sort the elements from leftIndex to 
 * rightIndex (inclusive). 
 */
public class BidirectionalSelectionsort<T extends Comparable<T>> extends SortingImpl<T>{

	@Override
	protected void sort(T[] array,int leftIndex, int rightIndex) {
		System.out.println(Arrays.asList(array));
		
		while(leftIndex < rightIndex){
			int min = leftIndex;
			int max = rightIndex;
			
			for (int i = leftIndex+1; i <= rightIndex; i++) {
				if (array[i].compareTo(array[min]) < 0) {
					min = i;					
				}
			}
			Util.swap(array, leftIndex++, min);
			
			for (int j = rightIndex - 1; j >= leftIndex; j--) {
				if (array[j].compareTo(array[max]) > 0) {
					max = j;					
				}
			}
			Util.swap(array, rightIndex--, max);
		}
		System.out.println(Arrays.asList(array));
	}
}