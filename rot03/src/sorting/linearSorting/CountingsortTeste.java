package sorting.linearSorting;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CountingsortTeste {
	private Integer[] vazio;
	private Integer[] unitario;
	private Integer[] positivos;
	private Integer[] iguais;
	private Countingsort countingSort;

	@Before
	public void setUp() throws Exception {
		countingSort = new Countingsort();
		vazio = new Integer[]{};
		unitario = new Integer[]{1};
		positivos = new Integer[]{5, 4, 3, 2, 1, 0};
		iguais = new Integer[]{5, 5, 5, 5, 5, 0};
	}

	@Test
	public void testaSortNormal() {
		countingSort.sort(vazio, 0, vazio.length-1);
		Assert.assertArrayEquals(new Integer[]{}, vazio);
		
		countingSort.sort(unitario, 0, unitario.length-1);
		Assert.assertArrayEquals(new Integer[]{1}, unitario);

		countingSort.sort(positivos, 0, positivos.length-1);
		Assert.assertArrayEquals(new Integer[]{0, 1, 2, 3, 4, 5}, positivos);

		countingSort.sort(iguais, 0, iguais.length-1);
		Assert.assertArrayEquals(new Integer[]{0, 5, 5, 5, 5, 5}, iguais);
	}
	
	@Test
	public void testaSortPersonalizado() {
		countingSort.sort(vazio, 2, vazio.length);
		Assert.assertArrayEquals(new Integer[]{}, vazio);
		
		countingSort.sort(unitario, 4, unitario.length-1);
		Assert.assertArrayEquals(new Integer[]{1}, unitario);

		/*countingSort.sort(positivos, 1, positivos.length-1);
		Assert.assertArrayEquals(new Integer[]{5, 0, 1, 2, 3, 4}, positivos);
	
		countingSort.sort(iguais, 3, iguais.length-1);
		Assert.assertArrayEquals(new Integer[]{0, 5, 5, 5, 5, 5}, iguais);
	*/}
}
