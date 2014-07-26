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
		for (int i = 1; i <= 7; i++) {
			skipList1.insert(i, i);
		}
		
		System.out.println("search(4): " + skipList1.search(4));
		System.out.println("search(20): " + skipList1.search(20));
		System.out.println("size: " + skipList1.size());
		System.out.println("height: " + skipList1.height());
		System.out.println("toArray: " + Arrays.asList(skipList1.toArray()));
	}
}
