package adt.stack;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StackRecursiveDoubleLinkedListImplTeste {
	StackRecursiveDoubleLinkedListImpl<Integer> sdlli;

	@Before
	public void setUp() throws Exception {
		sdlli = new StackRecursiveDoubleLinkedListImpl<>(3);
	}

	@Test
	public void test() throws StackOverflowException, StackUnderflowException {
		sdlli.push(10);
		sdlli.push(20);
		sdlli.push(30);
		
		System.out.println(sdlli.isEmpty());
		System.out.println(sdlli.isFull());
		
		try {
			sdlli.push(40);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println(sdlli.top());
		sdlli.pop();
		
		System.out.println(sdlli.top());
		sdlli.pop();
		
		System.out.println(sdlli.top());
		sdlli.pop();
		
		try {
			sdlli.pop();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println(sdlli.isEmpty());
		System.out.println(sdlli.isFull());
	}
}
