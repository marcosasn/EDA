package sorting.variationsOfSelectionsort;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class IntercaledBidirectionalSelectionsortTeste {
	Integer[] array;
	IntercaledBidirectionalSelectionsort<Integer> intercaledBidirectionalSelectionsort;
	
	@Before
	public void setUp() throws Exception {
		array = new Integer[]{10, 30, 5, 1, 2, 4};
		intercaledBidirectionalSelectionsort =  new IntercaledBidirectionalSelectionsort<>();
	}

	@Test
	public void test() {
		intercaledBidirectionalSelectionsort.sort(array, 0, array.length-1);
	}

}
