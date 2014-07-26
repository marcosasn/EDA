package sorting.divideAndConquer;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MergesortTeste {
	private Integer[] vazio;
	private Integer[] unitario;
	private Integer[] positivos;
	private Integer[] negativos;
	private Integer[] positivosNegativos;
	private Integer[] iguais;
	private Mergesort mergeSort;

	@Before
	public void setUp() throws Exception {
		mergeSort = new Mergesort<>();
		vazio = new Integer[]{};
		unitario = new Integer[]{1};
		positivos = new Integer[]{5, 4, 3, 2, 1, 0};
		negativos = new Integer[]{0, -1, -2, -3, -4, -5};
		positivosNegativos = new Integer[]{-5, 4, -3, 2, -1, 0};
		iguais = new Integer[]{5, 5, 5, 5, 5, 0};
	}

	@Test
	public void testaMergesort() {
		mergeSort.sort(vazio, 0, vazio.length-1);
		Assert.assertArrayEquals(new Integer[]{}, vazio);
		
		mergeSort.sort(unitario, 0, unitario.length-1);
		Assert.assertArrayEquals(new Integer[]{1}, unitario);
		
		mergeSort.sort(positivos, 0, positivos.length-1);
		Assert.assertArrayEquals(new Integer[]{0, 1, 2, 3, 4, 5}, positivos);
		
		mergeSort.sort(negativos, 0, negativos.length-1);
		Assert.assertArrayEquals(new Integer[]{-5, -4, -3, -2, -1, 0}, negativos);
		
		mergeSort.sort(positivosNegativos, 0, positivosNegativos.length-1);
		Assert.assertArrayEquals(new Integer[]{-5, -3, -1, 0, 2, 4}, positivosNegativos);
		
		mergeSort.sort(iguais, 0, iguais.length-1);
		Assert.assertArrayEquals(new Integer[]{0, 5, 5, 5, 5, 5}, iguais);
	}
	
	@Test
	public void testaSortMergesort() {
		mergeSort.sort(vazio);
		Assert.assertArrayEquals(new Integer[]{}, vazio);
		
		mergeSort.sort(unitario);
		Assert.assertArrayEquals(new Integer[]{1}, unitario);
		
		mergeSort.sort(positivos);
		Assert.assertArrayEquals(new Integer[]{0, 1, 2, 3, 4, 5}, positivos);
		
		mergeSort.sort(negativos);
		Assert.assertArrayEquals(new Integer[]{-5, -4, -3, -2, -1, 0}, negativos);
		
		mergeSort.sort(positivosNegativos);
		Assert.assertArrayEquals(new Integer[]{-5, -3, -1, 0, 2, 4}, positivosNegativos);
		
		mergeSort.sort(iguais);
		Assert.assertArrayEquals(new Integer[]{0, 5, 5, 5, 5, 5}, iguais);
	}
	
	@Test
	public void testaMergesortPersonalizado() {
		mergeSort.sort(vazio, 2, vazio.length - 1);
		Assert.assertArrayEquals(new Integer[]{}, vazio);
		
		mergeSort.sort(unitario, 4, unitario.length - 1);
		Assert.assertArrayEquals(new Integer[]{1}, unitario);

		mergeSort.sort(positivos, 3, positivos.length - 1);
		Assert.assertArrayEquals(new Integer[]{5, 4, 3, 0, 1, 2}, positivos);

		mergeSort.sort(negativos, 2, negativos.length - 1);
		Assert.assertArrayEquals(new Integer[]{0, -1, -5, -4, -3, -2}, negativos);
		
		mergeSort.sort(positivosNegativos, 1, positivosNegativos.length - 1);
		Assert.assertArrayEquals(new Integer[]{-5, -3, -1, 0, 2, 4}, positivosNegativos);
		
		mergeSort.sort(iguais, 3, iguais.length - 1);
		Assert.assertArrayEquals(new Integer[]{5, 5, 5, 0, 5, 5}, iguais);
	}
}
