package sorting.variationsOfSelectionsort;

import static org.junit.Assert.*;

import org.junit.Test;

public class BidirectionalSelectionsortTest {

	@Test
	public void testBidirectionSelectionSort() {
		BidirectionalSelectionsort<Integer> bidirectionSelectionSort = new BidirectionalSelectionsort<>();

		Integer[] arr = new Integer[] { 5, 4, 3, 2, 1 };
		bidirectionSelectionSort.sort(arr, 0, arr.length);
		assertArrayEquals(new Integer[] { 1, 2, 3, 4, 5 }, arr);

		arr = new Integer[] { 1, 2, 3, 4, 5 };
		bidirectionSelectionSort.sort(arr, 0, arr.length);
		assertArrayEquals(new Integer[] { 1, 2, 3, 4, 5 }, arr);

		arr = new Integer[] { 1, 2, 3, 4, -5 };
		bidirectionSelectionSort.sort(arr, 0, arr.length);
		assertArrayEquals(new Integer[] { -5, 1, 2, 3, 4 }, arr);

		arr = new Integer[] { -5, -4, -3, -2, -1, -6, -7 };
		bidirectionSelectionSort.sort(arr, 0, arr.length);
		assertArrayEquals(new Integer[] { -7, -6, -5, -4, -3, -2, -1 }, arr);

		arr = new Integer[] {};
		bidirectionSelectionSort.sort(arr, 0, arr.length);
		assertArrayEquals(new Integer[] {}, arr);

		arr = new Integer[] { 3, 3, 3, 3 };
		bidirectionSelectionSort.sort(arr, 4, arr.length);
		assertArrayEquals(new Integer[] { 3, 3, 3, 3 }, arr);

		arr = new Integer[] { 8, 7, 6, 5, 4, 3, 2, 1 };
		bidirectionSelectionSort.sort(arr, 4, 4);
		assertArrayEquals(new Integer[] { 8, 7, 6, 5, 4, 3, 2, 1 }, arr);

		arr = new Integer[] { 8, 7, 6, 5, 4, 3, 2, 1 };
		bidirectionSelectionSort.sort(arr, 4, 0);
		assertArrayEquals(new Integer[] { 8, 7, 6, 5, 4, 3, 2, 1 }, arr);

	}
}
