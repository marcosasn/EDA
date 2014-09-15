package adt.skipList;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class SkipListImplTest {
	SkipListImpl<Integer> skipList1;

	@Before
	public void setUp() throws Exception {
		skipList1 = new SkipListImpl<Integer>(5);
	}
	
	@Test
	public void testListVazia() {
		assertEquals(0, skipList1.size());
		assertEquals(5, skipList1.height());
		assertEquals(new String("[]"), Arrays.asList(skipList1.toArray()).toString());
	}
	

	@Test
	public void testInsert() {
		for (int i = 1; i <= 8; i++) {
			skipList1.insert(i, i);
		}
		
		System.out.println("search(4): " + skipList1.search(4));
		System.out.println("search(20): " + skipList1.search(20));
		System.out.println("size: " + skipList1.size());
		System.out.println("height: " + skipList1.height());
		System.out.println("toArray: " + Arrays.asList(skipList1.toArray()));
		System.out.println("toArray2: " + Arrays.asList(skipList1.toArray2()));
		//System.out.println("toArray3: " + Arrays.asList(skipList1.toArray3()));
	}
	
	@Test
	public void testInsert2() {
		int numbers[] = {4,8,12,14,17,18,21,25};
		for (int number: numbers) {
			skipList1.insert(number, number);
		}
		
		System.out.println("\nsearch(4): " + skipList1.search(4));
		System.out.println("search(20): " + skipList1.search(20));
		System.out.println("size: " + skipList1.size());
		System.out.println("height: " + skipList1.height());
		System.out.println("toArray: " + Arrays.asList(skipList1.toArray()));
		System.out.println("toArray2: " + Arrays.asList(skipList1.toArray2()));
		System.out.println("toArray3: " + Arrays.asList(skipList1.toArray3()));
	}
}
