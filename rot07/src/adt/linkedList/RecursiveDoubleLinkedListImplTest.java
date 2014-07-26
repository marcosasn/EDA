package adt.linkedList;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class RecursiveDoubleLinkedListImplTest {
	RecursiveDoubleLinkedListImpl<Integer> rdlli;
	
	@Before
	public void setUp() throws Exception {
		rdlli = new RecursiveDoubleLinkedListImpl<Integer>();
	}

	@Test
	public void test() {
		System.out.println(rdlli.isEmpty());
		System.out.println(rdlli.size());
		System.out.println(Arrays.toString(rdlli.toArray()));
		System.out.println();
		
		rdlli.insertFirst(110);
		System.out.println(rdlli.isEmpty());
		System.out.println(rdlli.size());
		System.out.println(Arrays.toString(rdlli.toArray()));
		System.out.println();
		
		rdlli.insertFirst(50);
		System.out.println(rdlli.isEmpty());
		System.out.println(rdlli.size());
		System.out.println(Arrays.toString(rdlli.toArray()));
		System.out.println();
		
		rdlli.insertFirst(200);
		System.out.println(rdlli.isEmpty());
		System.out.println(rdlli.size());
		System.out.println(Arrays.toString(rdlli.toArray()));
		System.out.println();
		
		System.out.println(rdlli.isEmpty());
		System.out.println(rdlli.size());
		System.out.println(Arrays.toString(rdlli.toArray()));
		System.out.println(rdlli.search(10));
		System.out.println();
		
		rdlli.insertFirst(20);
		System.out.println(rdlli.isEmpty());
		System.out.println(rdlli.size());
		System.out.println(Arrays.toString(rdlli.toArray()));
		System.out.println();
		
		rdlli.removeFirst();
		System.out.println(rdlli.isEmpty());
		System.out.println(rdlli.size());
		System.out.println(Arrays.toString(rdlli.toArray()));
		System.out.println();
		
		rdlli.removeLast();
		System.out.println(rdlli.isEmpty());
		System.out.println(rdlli.size());
		System.out.println(Arrays.toString(rdlli.toArray()));
	}
}
