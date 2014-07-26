package sorting.simpleSorting;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class SelectionsortTeste<T> {
	private Integer[] vazio;
	private Integer[] unitario;
	private Integer[] positivos;
	private Integer[] negativos;
	private Integer[] positivosNegativos;
	private Integer[] iguais;
	private Selectionsort selectionSort;

	@Before
	public void setUp() {
		selectionSort = new Selectionsort<>();
		vazio = new Integer[]{};
		unitario = new Integer[]{1};
		positivos = new Integer[]{5, 4, 3, 2, 1, 0};
		negativos = new Integer[]{-1, -2, -3, -4, -5, 0};
		positivosNegativos = new Integer[]{-5, 4, -3, 2, -1, 0};
		iguais = new Integer[]{5, 5, 5, 5, 5, 0};
	}

	@Test
	public void testaSortNormal() {
		selectionSort.sort(vazio, 0, vazio.length - 1);
		Assert.assertArrayEquals(new Integer[]{}, vazio);
		
		selectionSort.sort(unitario, 0, unitario.length - 1);
		Assert.assertArrayEquals(new Integer[]{1}, unitario);
		
		selectionSort.sort(positivos, 0, positivos.length - 1);
		Assert.assertArrayEquals(new Integer[]{0, 1, 2, 3, 4, 5}, positivos);
		
		selectionSort.sort(negativos, 0, negativos.length - 1);
		Assert.assertArrayEquals(new Integer[]{-5, -4, -3, -2, -1, 0}, negativos);
		
		selectionSort.sort(positivosNegativos, 0, positivosNegativos.length - 1);
		Assert.assertArrayEquals(new Integer[]{-5, -3, -1, 0, 2, 4}, positivosNegativos);
		
		selectionSort.sort(iguais, 0, iguais.length - 1);
		Assert.assertArrayEquals(new Integer[]{0, 5, 5, 5, 5, 5}, iguais);
	}
	
	@Test
	public void testaSortPersonalizado() {
		selectionSort.sort(vazio, 2, vazio.length - 1);
		Assert.assertArrayEquals(new Integer[]{}, vazio);
		
		selectionSort.sort(unitario, 4, unitario.length - 1);
		Assert.assertArrayEquals(new Integer[]{1}, unitario);

		selectionSort.sort(positivos, 3, positivos.length - 1);
		Assert.assertArrayEquals(new Integer[]{5, 4, 3, 0, 1, 2}, positivos);

		selectionSort.sort(negativos, 2, negativos.length - 1);
		Assert.assertArrayEquals(new Integer[]{-1, -2, -5, -4, -3, 0}, negativos);
		
		selectionSort.sort(positivosNegativos, 1, positivosNegativos.length - 1);
		Assert.assertArrayEquals(new Integer[]{-5, -3, -1, 0, 2, 4}, positivosNegativos);
		
		selectionSort.sort(iguais, 3, iguais.length - 1);
		Assert.assertArrayEquals(new Integer[]{5, 5, 5, 0, 5, 5}, iguais);
	}
}