package adt.linkedList;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class SingleLinkedListNodeTest {
	SingleLinkedListImpl<Integer> slli;

	@Before
	public void setUp() throws Exception {
		slli = new SingleLinkedListImpl<Integer>();
	}

	@Test
	public void test() {
		System.out.println(slli.isEmpty());
		System.out.println(slli.size());
		slli.insert(10);
		System.out.println(Arrays.toString(slli.toArray()));
		
		System.out.println(slli.isEmpty());
		System.out.println(slli.size());
		slli.remove(10);
		System.out.println(slli.size());
		System.out.println(Arrays.toString(slli.toArray()));
	}

}
