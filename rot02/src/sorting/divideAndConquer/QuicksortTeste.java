package sorting.divideAndConquer;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class QuicksortTeste {
	private Integer[] vazio;
	private Integer[] unitario;
	private Integer[] positivos;
	private Integer[] negativos;
	private Integer[] positivosNegativos;
	private Integer[] iguais;
	private Quicksort quickSort;

	@Before
	public void setUp() throws Exception {
		quickSort = new Quicksort<>();
		vazio = new Integer[]{};
		unitario = new Integer[]{1};
		positivos = new Integer[]{5, 4, 3, 2, 1};
		negativos = new Integer[]{-1, -2, -3, -4, -5};
		positivosNegativos = new Integer[]{-5, 4, -3, 2, -1};
		iguais = new Integer[]{5, 5, 5, 5, 5};
	}

	@Test
	public void testaSort() {
		quickSort.sort(vazio, 0, vazio.length-1);
		Assert.assertArrayEquals(new Integer[]{}, vazio);
		
		quickSort.sort(unitario, 0, unitario.length-1);
		Assert.assertArrayEquals(new Integer[]{1}, unitario);
		
		quickSort.sort(positivos, 0, positivos.length-1);
		Assert.assertArrayEquals(new Integer[]{1, 2, 3, 4, 5}, positivos);
		
		quickSort.sort(negativos, 0, negativos.length-1);
		Assert.assertArrayEquals(new Integer[]{-5, -4, -3, -2, -1}, negativos);
		
		quickSort.sort(positivosNegativos, 0, positivosNegativos.length-1);
		Assert.assertArrayEquals(new Integer[]{-5, -3, -1, 2, 4}, positivosNegativos);
		
		quickSort.sort(iguais, 0, iguais.length-1);
		Assert.assertArrayEquals(new Integer[]{5, 5, 5, 5, 5}, iguais);
	}
}
