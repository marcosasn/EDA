package adt.linkedList;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class DoubleLinkedListImplTest {
	DoubleLinkedListImpl<Integer> dlli;

	@Before
	public void setUp() throws Exception {
		dlli = new DoubleLinkedListImpl<Integer>();
	}

	@Test
	public void test() {
		System.out.println(dlli.isEmpty());
		System.out.println(dlli.size());
		dlli.insertFirst(10);
		System.out.println(Arrays.toString(dlli.toArray()));
		
		System.out.println(dlli.isEmpty());
		System.out.println(dlli.size());
		
		
		dlli.insertFirst(10);
		dlli.insertFirst(20);
		dlli.insertFirst(30);
		System.out.println(dlli.size());
		System.out.println(Arrays.toString(dlli.toArray()));
		
		dlli.removeLast();
		System.out.println(Arrays.toString(dlli.toArray()));
		
		dlli.removeLast();
		System.out.println(Arrays.toString(dlli.toArray()));
		
		dlli.removeLast();
		System.out.println(Arrays.toString(dlli.toArray()));
		
		dlli.removeLast();
		System.out.println(Arrays.toString(dlli.toArray()));
	}
}
