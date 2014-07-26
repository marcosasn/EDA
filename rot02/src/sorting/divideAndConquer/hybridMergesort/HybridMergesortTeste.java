package sorting.divideAndConquer.hybridMergesort;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import sorting.divideAndConquer.Mergesort;

public class HybridMergesortTeste {
	private Integer[] vazio;
	private Integer[] unitario;
	private Integer[] positivos;
	private Integer[] negativos;
	private Integer[] positivosNegativos;
	private Integer[] iguais;
	private HybridMergesort hybridMergeSort;

	@Before
	public void setUp() throws Exception {
		hybridMergeSort = new HybridMergesort<>();
		vazio = new Integer[]{};
		unitario = new Integer[]{1};
		positivos = new Integer[]{5, 4, 3, 2, 1, 0};
		negativos = new Integer[]{0, -1, -2, -3, -4, -5};
		positivosNegativos = new Integer[]{-5, 4, -3, 2, -1, 0};
		iguais = new Integer[]{5, 5, 5, 5, 5, 0};
	}

	@Test
	public void testaHybridMergesort() {
		hybridMergeSort.sort(vazio, 0, vazio.length - 1);
		Assert.assertArrayEquals(new Integer[] {}, vazio);
		Assert.assertTrue(HybridMergesort.INSERTIONSORT_APPLICATIONS == 1);
		Assert.assertTrue(HybridMergesort.MERGESORT_APPLICATIONS == 0);

		hybridMergeSort.sort(unitario, 0, unitario.length - 1);
		Assert.assertArrayEquals(new Integer[] { 1 }, unitario);
		Assert.assertTrue(HybridMergesort.INSERTIONSORT_APPLICATIONS == 2);
		Assert.assertTrue(HybridMergesort.MERGESORT_APPLICATIONS == 0);

		hybridMergeSort.sort(positivos, 0, positivos.length - 1);
		Assert.assertArrayEquals(new Integer[] { 0, 1, 2, 3, 4, 5 }, positivos);
		Assert.assertTrue(HybridMergesort.INSERTIONSORT_APPLICATIONS == 2);
		Assert.assertTrue(HybridMergesort.MERGESORT_APPLICATIONS == 1);
		
		hybridMergeSort.sort(negativos, 0, negativos.length - 1);
		Assert.assertArrayEquals(new Integer[] { -5, -4, -3, -2, -1, 0 }, negativos);
		Assert.assertTrue(HybridMergesort.INSERTIONSORT_APPLICATIONS == 2);
		Assert.assertTrue(HybridMergesort.MERGESORT_APPLICATIONS == 2);

		hybridMergeSort.sort(positivosNegativos, 0, positivosNegativos.length - 1);
		Assert.assertArrayEquals(new Integer[] { -5, -3, -1, 0, 2, 4 }, positivosNegativos);
		Assert.assertTrue(HybridMergesort.INSERTIONSORT_APPLICATIONS == 2);
		Assert.assertTrue(HybridMergesort.MERGESORT_APPLICATIONS == 3);

		hybridMergeSort.sort(iguais, 0, iguais.length - 1);
		Assert.assertArrayEquals(new Integer[] { 0, 5, 5, 5, 5, 5 }, iguais);
		Assert.assertTrue(HybridMergesort.INSERTIONSORT_APPLICATIONS == 2);
		Assert.assertTrue(HybridMergesort.MERGESORT_APPLICATIONS == 4);
	}
	
	@Test
	public void testaHybridMergesortPersonalizado() {
		hybridMergeSort.sort(vazio, 2, vazio.length - 1);
		Assert.assertArrayEquals(new Integer[]{}, vazio);
		Assert.assertTrue(HybridMergesort.INSERTIONSORT_APPLICATIONS == 3);
		Assert.assertTrue(HybridMergesort.MERGESORT_APPLICATIONS == 4);
		
		hybridMergeSort.sort(unitario, 4, unitario.length - 1);
		Assert.assertArrayEquals(new Integer[]{1}, unitario);
		Assert.assertTrue(HybridMergesort.INSERTIONSORT_APPLICATIONS == 4);
		Assert.assertTrue(HybridMergesort.MERGESORT_APPLICATIONS == 4);

		hybridMergeSort.sort(positivos, 3, positivos.length - 1);
		Assert.assertArrayEquals(new Integer[]{0, 1, 2, 5, 4, 3}, positivos);
		Assert.assertTrue(HybridMergesort.INSERTIONSORT_APPLICATIONS == 5);
		Assert.assertTrue(HybridMergesort.MERGESORT_APPLICATIONS == 4);

		hybridMergeSort.sort(negativos, 2, negativos.length - 1);
		Assert.assertArrayEquals(new Integer[]{-5, -4, -3, -2, 0, -1}, negativos);
		Assert.assertTrue(HybridMergesort.INSERTIONSORT_APPLICATIONS == 6);
		Assert.assertTrue(HybridMergesort.MERGESORT_APPLICATIONS == 4);
		
		hybridMergeSort.sort(positivosNegativos, 1, positivosNegativos.length - 1);
		Assert.assertArrayEquals(new Integer[]{-5, -3, -1, 0, 2, 4}, positivosNegativos);
		Assert.assertTrue(HybridMergesort.INSERTIONSORT_APPLICATIONS == 7);
		Assert.assertTrue(HybridMergesort.MERGESORT_APPLICATIONS == 4);
		
		hybridMergeSort.sort(iguais, 3, iguais.length - 1);
		Assert.assertArrayEquals(new Integer[]{0, 5, 5, 5, 5, 5}, iguais);
		Assert.assertTrue(HybridMergesort.INSERTIONSORT_APPLICATIONS == 8);
		Assert.assertTrue(HybridMergesort.MERGESORT_APPLICATIONS == 4);
	}
	
	@Test
	public void testaSortHybridMergesort() {
		hybridMergeSort.sort(vazio);
		Assert.assertArrayEquals(new Integer[] {}, vazio);
		Assert.assertTrue(HybridMergesort.INSERTIONSORT_APPLICATIONS == 0);
		Assert.assertTrue(HybridMergesort.MERGESORT_APPLICATIONS == 0);
		
		hybridMergeSort.sort(unitario);
		Assert.assertArrayEquals(new Integer[] { 1 }, unitario);
		Assert.assertTrue(HybridMergesort.INSERTIONSORT_APPLICATIONS == 0);
		Assert.assertTrue(HybridMergesort.MERGESORT_APPLICATIONS == 0);
		
		hybridMergeSort.sort(positivos);
		Assert.assertArrayEquals(new Integer[]{0, 1, 2, 3, 4, 5}, positivos);
		Assert.assertTrue(HybridMergesort.INSERTIONSORT_APPLICATIONS == 0);
		Assert.assertTrue(HybridMergesort.MERGESORT_APPLICATIONS == 0);
		
		hybridMergeSort.sort(negativos);
		Assert.assertArrayEquals(new Integer[]{ -5, -4, -3, -2, -1, 0 }, negativos);
		Assert.assertTrue(HybridMergesort.INSERTIONSORT_APPLICATIONS == 0);
		Assert.assertTrue(HybridMergesort.MERGESORT_APPLICATIONS == 0);
		
		hybridMergeSort.sort(positivosNegativos);
		Assert.assertArrayEquals(new Integer[]{-5, -3, -1, 0, 2, 4}, positivosNegativos);
		Assert.assertTrue(HybridMergesort.INSERTIONSORT_APPLICATIONS == 0);
		Assert.assertTrue(HybridMergesort.MERGESORT_APPLICATIONS == 0);
		
		hybridMergeSort.sort(iguais);
		Assert.assertArrayEquals(new Integer[]{0, 5, 5, 5, 5, 5}, iguais);
		Assert.assertTrue(HybridMergesort.INSERTIONSORT_APPLICATIONS == 0);
		Assert.assertTrue(HybridMergesort.MERGESORT_APPLICATIONS == 0);
	}
}
