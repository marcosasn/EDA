package adt.queue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class QueueImplTest {
	QueueImpl<Integer> queue;
	
	@Before
	public void setUp() throws Exception {
		queue = new QueueImpl<Integer>(5);
	}

	@Test
	public void test() throws QueueOverflowException, QueueUnderflowException {
		Assert.assertTrue(queue.isEmpty());
		Assert.assertFalse(queue.isFull());
		
		try {
			queue.dequeue();
			Assert.fail();
			
		} catch (QueueUnderflowException e) {
			Assert.assertEquals("Fila vazia", e.getMessage());
		}
	
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
		queue.enqueue(50);
		
		try {
			queue.enqueue(60);
			Assert.fail();
		} catch(QueueOverflowException e) {
			Assert.assertEquals("Fila cheia", e.getMessage());
		}
		
		Assert.assertTrue(queue.head() == 10);
		queue.dequeue();
		Assert.assertTrue(queue.head() == 20);

	}

}
