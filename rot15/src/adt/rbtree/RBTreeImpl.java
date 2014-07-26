package adt.rbtree;

import java.util.LinkedList;

import adt.avltree.AVLTreeImpl;
import adt.bst.BSTNode;
import adt.rbtree.RBNode.Colour;

public class RBTreeImpl<T extends Comparable<T>> extends AVLTreeImpl<T> 
	implements RBTree<T> {

	public RBTreeImpl() {
		this.root = new RBNode<T>();
	}
	
	protected int blackHeight(){
		return blackHeight((RBNode<T>) this.getRoot());
	}

	private int blackHeight(RBNode<T> node) {
		int height = 0;
		if (!node.isEmpty()) {
			if (node.getColour() == Colour.BLACK) {
				height = 1 + max(blackHeight((RBNode<T>) node.getLeft()),
						blackHeight((RBNode<T>) node.getRight()));
			} else {
				height = max(blackHeight((RBNode<T>) node.getLeft()),
						blackHeight((RBNode<T>) node.getRight()));
			}
		}
		return height;
	}
	
	private int max(int heightLeft, int heightRight) {
		return heightLeft >= heightRight ? heightLeft : heightRight;
	}

	protected boolean verifyProperties(){
		boolean resp = verifyNodesColour()
						&& verifyNILNodeColour()
						&& verifyRootColour()
						&& verifyChildrenOfRedNodes()
						&& verifyBlackHeight();
		return resp;
	}

	/**
	 * The colour of each node of a RB tree is black or red. This is guaranteed by the type Colour.
	 */
	private boolean verifyNodesColour(){
		return true;
	}
	
	/**
	 * The colour of the root must be black.
	 */
	private boolean verifyRootColour(){
		return ((RBNode<T>)root).getColour() == Colour.BLACK;
	}
	
	/**
	 * This is guaranteed by the constructor.
	 */
	private boolean verifyNILNodeColour(){
		return true;
	}

	/**
	 * Verifies the property for all RED nodes: the children of a red node must be BLACK.
	 */
	private boolean verifyChildrenOfRedNodes(){
		boolean resp = true;
		if(!this.isEmpty()){
			resp = verifyChildrenOfRedNodes((RBNode<T>) this.getRoot());
		}
		return resp;
	}

	private boolean verifyChildrenOfRedNodes(RBNode<T> node) {
		boolean resp = true;
		if (!node.isEmpty()) {
			if (node.getColour() == Colour.RED) {
				if (((RBNode<T>) node.getRight()).getColour() == Colour.BLACK) {
					resp = ((RBNode<T>) node.getLeft()).getColour() == Colour.BLACK
							&& verifyChildrenOfRedNodes((RBNode<T>) node.getLeft())
							&& verifyChildrenOfRedNodes((RBNode<T>) node.getRight());
				}
			} else {
				resp = verifyChildrenOfRedNodes((RBNode<T>) node.getLeft())
						&& verifyChildrenOfRedNodes((RBNode<T>) node.getRight());
			}
		}		
		return resp;
	}

	/**
	 * Verifies the black-height property from the root. The method blackHeight returns an exception if the black heights are different.  
	 */
	private boolean verifyBlackHeight(){
		return blackHeight((RBNode<T>) this.getRoot().getLeft()) == blackHeight((RBNode<T>) this.getRoot().getRight());
	}
	
	@Override
	public void insert(T value) {
		RBNode<T> node = insert((RBNode<T>)this.getRoot(), value);
		node.setColour(Colour.RED);
		fixUpCase1(node);
	}
	
	private void fixUpCase1(RBNode<T> node) {
		if (node.equals(this.getRoot())) {
			node.setColour(Colour.BLACK);
		}
		else {
			fixUpCase2(node);
		}
	}

	private void fixUpCase2(RBNode<T> node) {
		if (((RBNode<T>)node.getParent()).getColour() != Colour.BLACK) {
			fixUpCase3(node);
		}
	}

	private void fixUpCase3(RBNode<T> node) {
		if (this.returnsUncle(node).getColour() == Colour.RED) {
			((RBNode<T>)node.getParent()).setColour(Colour.BLACK);
			this.returnsUncle(node).setColour(Colour.BLACK);
			((RBNode<T>)node.getParent().getParent()).setColour(Colour.RED);
			fixUpCase1((RBNode<T>) node.getParent().getParent());
		}
		else {
			fixUpCase4(node);
		}
	}
	
	private RBNode<T> returnsUncle(RBNode<T> node) {
		if (node.getParent().getParent().getLeft().equals(node.getParent())) {
			return (RBNode<T>) node.getParent().getParent().getRight();
		}
		return (RBNode<T>) node.getParent().getParent().getLeft();
	}

	private void fixUpCase4(RBNode<T> node) {
		RBNode<T> next = node;
		if (!node.getParent().getRight().isEmpty() && !node.getParent().getLeft().isEmpty()) {
			if (node.getParent().getRight().equals(node) && node.getParent().getParent().getLeft().equals(node.getParent())) {
				super.leftRotation((BSTNode<T>) node.getParent());
				next = (RBNode<T>) node.getLeft();
			}
			else if (node.getParent().getLeft().equals(node) && node.getParent().getParent().getRight().equals(node.getParent())) {
				super.rightRotation((BSTNode<T>) node.getParent());
				next = (RBNode<T>) node.getRight();
			}
			else {
				fixUpCase5(next);
			}
		}
		else {
			fixUpCase5(next);
		}
	}

	private void fixUpCase5(RBNode<T> node) {
		((RBNode<T>)node.getParent()).setColour(Colour.BLACK);
		((RBNode<T>)node.getParent().getParent()).setColour(Colour.RED);
		if (node.getParent().getLeft().equals(node)) {
			super.rightRotation((BSTNode<T>) node.getParent().getParent());
		}
		else {
			super.leftRotation((BSTNode<T>) node.getParent().getParent());
		}
	}

	private RBNode<T> insert(RBNode<T> node, T element) {
		if (node.isEmpty()) {
			node.setData(element);
			node.setLeft(new RBNode<T>());
			node.setRight(new RBNode<T>());
			node.getLeft().setParent(node);
			node.getRight().setParent(node);
			return node;
		}
		else {
			if (element.compareTo(node.getData()) < 0) {
				return insert((RBNode<T>)node.getLeft(), element);
			}
			else {
				return insert((RBNode<T>)node.getRight(), element);
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public RBNode<T>[] extendedPreOrder(){
		LinkedList<RBNode<T>> list = new LinkedList<RBNode<T>>();
		list = extendedPreOrder((RBNode<T>) this.getRoot(), list);
		RBNode<T>[] temp = new RBNode[list.size()];
		
		return (RBNode<T>[]) list.toArray(temp);
	}
	
	private LinkedList<RBNode<T>> extendedPreOrder(RBNode<T> node, LinkedList<RBNode<T>> list){
		if (!node.isEmpty()) {
			list.add(node);
			extendedPreOrder((RBNode<T>) node.getLeft(), list);
			extendedPreOrder((RBNode<T>) node.getRight(), list);
		}
		return list;
	}
}