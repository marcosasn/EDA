package adt.rbtree;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class RBTreeImplTest {
	
	RBTreeImpl<Integer> tree;
	
	@Before
	public void start() {
		tree = new RBTreeImpl<>();
	}

	@Test
	public void test() {
		//            (4,B)
		//            /   \
		//         (2,R)  (8,R)
		//
		tree.insert(8);
		tree.insert(4);
		tree.insert(2);
		
		//System.out.println(tree.blackHeight());
		//System.out.println(tree.verifyChildrenOfRedNodes());
		System.out.println(Arrays.asList(tree.extendedPreOrder()));
		System.out.println();
	}
	
	@Test
	public void test2() {
		//                (7,B)
		//                /   \
		//           (3,B)    (18,R)
		//                     /    \
		//                (10,B)    (22,B)
		//                /    \         \
		//            (8,R)    (11,R)     (26,R)
		//
		tree.insert(7);
		tree.insert(3);
		tree.insert(18);
		tree.insert(10);
		tree.insert(22);
		tree.insert(8);
		tree.insert(11);
		tree.insert(26);
		
		//System.out.println(tree.blackHeight());
		//System.out.println(tree.verifyChildrenOfRedNodes());
		System.out.println(Arrays.asList(tree.extendedPreOrder()));
		System.out.println();
	}
	
	@Test
	public void test3() {
		//                (13,B)
		//                /    \
		//           (8,R)     (17,R)
		//           /   \      /    \
		//        (1,B)(11,B)(15,B) (25,B)
		//            \              /   \
		//           (6,R)       (22,R) (27,R)
		//
		tree.insert(13);
		tree.insert(8);
		tree.insert(17);
		tree.insert(1);
		tree.insert(11);
		tree.insert(15);
		tree.insert(25);
		tree.insert(6);
		tree.insert(22);
		tree.insert(27);
		
		//System.out.println(tree.blackHeight());
		//System.out.println(tree.verifyChildrenOfRedNodes());
		System.out.println(Arrays.asList(tree.extendedPreOrder()));
		System.out.println();
	}
}