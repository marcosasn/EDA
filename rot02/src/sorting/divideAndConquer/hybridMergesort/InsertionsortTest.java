package sorting.divideAndConquer.hybridMergesort;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InsertionsortTest {
	private Integer[] vazio;
	private Integer[] unitario;
	private Integer[] positivos;
	private Integer[] negativos;
	private Integer[] positivosNegativos;
	private Integer[] iguais;
	private Insertionsort insertionSort;

	@Before
	public void setUp() throws Exception {
		insertionSort = new Insertionsort<>();
		vazio = new Integer[]{};
		unitario = new Integer[]{1};
		positivos = new Integer[]{5, 4, 3, 2, 1, 0};
		negativos = new Integer[]{0, -1, -2, -3, -4, -5};
		positivosNegativos = new Integer[]{-5, 4, -3, 2, -1, 0};
		iguais = new Integer[]{5, 5, 5, 5, 5, 0};
	}

	@Test
	public void testaInsertionsort() {
		insertionSort.sort(vazio, 0, vazio.length - 1);
		Assert.assertArrayEquals(new Integer[]{}, vazio);
		
		insertionSort.sort(unitario, 0, unitario.length - 1);
		Assert.assertArrayEquals(new Integer[]{1}, unitario);
		
		insertionSort.sort(positivos, 0, positivos.length - 1);
		Assert.assertArrayEquals(new Integer[]{0, 1, 2, 3, 4, 5}, positivos);
		
		insertionSort.sort(negativos, 0, negativos.length - 1);
		Assert.assertArrayEquals(new Integer[]{-5, -4, -3, -2, -1, 0}, negativos);
		
		insertionSort.sort(positivosNegativos, 0, positivosNegativos.length - 1);
		Assert.assertArrayEquals(new Integer[]{-5, -3, -1, 0, 2, 4}, positivosNegativos);

		insertionSort.sort(iguais, 0, iguais.length - 1);
		Assert.assertArrayEquals(new Integer[]{0, 5, 5, 5, 5, 5}, iguais);
	}
	
	@Test
	public void testaInsertionsortPersonalizado() {
		insertionSort.sort(vazio, 2, vazio.length - 1);
		Assert.assertArrayEquals(new Integer[]{}, vazio);
		
		insertionSort.sort(unitario, 4, unitario.length - 1);
		Assert.assertArrayEquals(new Integer[]{1}, unitario);

		insertionSort.sort(positivos, 3, positivos.length - 1);
		Assert.assertArrayEquals(new Integer[]{0, 1, 2, 5, 4, 3}, positivos);

		insertionSort.sort(negativos, 2, negativos.length - 1);
		Assert.assertArrayEquals(new Integer[]{-5, -4, -3, -2, 0, -1}, negativos);
		
		insertionSort.sort(positivosNegativos, 1, positivosNegativos.length - 1);
		Assert.assertArrayEquals(new Integer[]{-5, -3, -1, 0, 2, 4}, positivosNegativos);
		
		insertionSort.sort(iguais, 3, iguais.length - 1);
		Assert.assertArrayEquals(new Integer[]{0, 5, 5, 5, 5, 5}, iguais);
	}
	
	@Test
	public void testaSortInsertionsort() {
		insertionSort.sort(vazio);
		Assert.assertArrayEquals(new Integer[]{}, vazio);
		
		insertionSort.sort(unitario);
		Assert.assertArrayEquals(new Integer[]{1}, unitario);

		insertionSort.sort(positivos);
		Assert.assertArrayEquals(new Integer[]{0, 1, 2, 3, 4, 5}, positivos);

		insertionSort.sort(negativos);
		Assert.assertArrayEquals(new Integer[]{-5, -4, -3, -2, -1, 0}, negativos);
		
		insertionSort.sort(positivosNegativos);
		Assert.assertArrayEquals(new Integer[]{-5, -3, -1, 0, 2, 4}, positivosNegativos);
		
		insertionSort.sort(iguais);
		Assert.assertArrayEquals(new Integer[]{0, 5, 5, 5, 5, 5}, iguais);
	}
}
