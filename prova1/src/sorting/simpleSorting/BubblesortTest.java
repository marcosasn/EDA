package sorting.simpleSorting;

import static org.junit.Assert.*;

import org.junit.Test;

public class BubblesortTest {

	@Test
	public void testBubbleSort() {
		Bubblesort<Integer> bubbleSort = new Bubblesort<>();

		Integer[] arr = new Integer[] { 5, 4, 3, 2, 1 };
		bubbleSort.sort(arr, 0, arr.length);
		assertArrayEquals(new Integer[] { 1, 2, 3, 4, 5 }, arr);

		arr = new Integer[] { 1, 2, 3, 4, 5 };
		bubbleSort.sort(arr, 0, arr.length);
		assertArrayEquals(new Integer[] { 1, 2, 3, 4, 5 }, arr);

		arr = new Integer[] { 1, 2, 3, 4, -5 };
		bubbleSort.sort(arr, 0, arr.length);
		assertArrayEquals(new Integer[] { -5, 1, 2, 3, 4 }, arr);

		arr = new Integer[] { -5, -4, -3, -2, -1, -6, -7 };
		bubbleSort.sort(arr, 0, arr.length);
		assertArrayEquals(new Integer[] { -7, -6, -5, -4, -3, -2, -1 }, arr);

		arr = new Integer[] {};
		bubbleSort.sort(arr, 0, arr.length);
		assertArrayEquals(new Integer[] {}, arr);

		arr = new Integer[] { 3, 3, 3, 3 };
		bubbleSort.sort(arr, 4, arr.length);
		assertArrayEquals(new Integer[] { 3, 3, 3, 3 }, arr);

		arr = new Integer[] { 8, 7, 6, 5, 4, 3, 2, 1 };
		bubbleSort.sort(arr, 4, 4);
		assertArrayEquals(new Integer[] { 8, 7, 6, 5, 4, 3, 2, 1 }, arr);

		arr = new Integer[] { 8, 7, 6, 5, 4, 3, 2, 1 };
		bubbleSort.sort(arr, 4, 0);
		assertArrayEquals(new Integer[] { 8, 7, 6, 5, 4, 3, 2, 1 }, arr);

	}

}
