package adt.stack;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StackImplTest {
	
	private StackImpl<Integer> stack;

	@Before
	public void setUp() throws Exception {
		stack = new StackImpl<Integer>(5);
	}

	@Test
	public void test() throws StackOverflowException, StackUnderflowException {
		Assert.assertTrue(stack.isEmpty());
		Assert.assertFalse(stack.isFull());
		
		try {
			stack.pop();
			Assert.fail();
			
		} catch (StackUnderflowException e) {
			Assert.assertEquals("Stack is empty", e.getMessage());
		}
	
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);
		
		try {
			stack.push(60);
			Assert.fail();
		} catch(StackOverflowException e) {
			Assert.assertEquals("Stack is full", e.getMessage());
		}
		
		Assert.assertTrue(stack.top() == 50);
		stack.pop();
		Assert.assertTrue(stack.top() == 40);
	}

}
