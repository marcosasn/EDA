package adt.linkedList;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class RecursiveSingleLinkedListImplTest {
	RecursiveSingleLinkedListImpl<Integer> rslli;
	
	@Before
	public void setUp() throws Exception {
		rslli = new RecursiveSingleLinkedListImpl<Integer>();
	}

	@Test
	public void test() {
		System.out.println(rslli.isEmpty());
		System.out.println(rslli.size());
		System.out.println(Arrays.toString(rslli.toArray()));
		System.out.println();
		
		rslli.insert(10);
		rslli.insert(20);
		rslli.insert(30);
		
		System.out.println(rslli.isEmpty());
		System.out.println(rslli.size());
		System.out.println(Arrays.toString(rslli.toArray()));
		System.out.println();
		
		rslli.remove(30);
		System.out.println(rslli.isEmpty());
		System.out.println(rslli.size());
		System.out.println(Arrays.toString(rslli.toArray()));
		System.out.println(rslli.search(10));
		
	}

}
