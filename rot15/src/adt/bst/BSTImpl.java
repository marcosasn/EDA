package adt.bst;

import java.util.ArrayList;
import java.util.List;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

	protected  BSTNode<T> root;

	public BSTImpl() {
		root = new BSTNode<T>();
	}

	public BSTNode<T> getRoot(){
		return this.root;
	}
	
	@Override
	public boolean isEmpty() {
		return root.isEmpty();
	}

	@Override
	public int height() {
		return height(this.getRoot());
	}

	protected int height(BSTNode<T> node) {
		int result = -1;
		if (node != null && !node.isEmpty()) {
			result = 1 + greater(height((BSTNode<T>)node.getLeft()), height((BSTNode<T>)node.getRight()));
		}
		return result;
	}

	private int greater(int value1, int value2) {
		if (value1 > value2) {
			return value1;
		}
		return value2;
	}
	
	@Override
	public BSTNode<T> search(T element) {
		return search(this.getRoot(), element);
	}
	
	private BSTNode<T> search(BSTNode<T> node, T element) {
		if (node == null) {
			return null;
		}
		
		if (!node.isEmpty() && element.equals(node.getData())) {
			return node;
		}
		else {
			if (!node.isEmpty() && element.compareTo(node.getData()) < 0) {
				return search((BSTNode<T>)node.getLeft(), element);
			}
			else if (!node.isEmpty() && element.compareTo(node.getData()) > 0){
				return search((BSTNode<T>)node.getRight(), element);
			}
			return node;
		}
	}
	
	@Override
	public void insert(T element) {
		insert(this.getRoot(), element);
	}
	
	protected void insert(BSTNode<T> node, T element) {
		if (node.isEmpty()) {
			node.setData(element);
			node.setLeft(new BSTNode<T>());
			node.setRight(new BSTNode<T>());
			node.getLeft().setParent(node);
			node.getRight().setParent(node);
		}
		else {
			if (element.compareTo(node.getData()) < 0) {
				insert((BSTNode<T>)node.getLeft(), element);
			}
			else {
				insert((BSTNode<T>)node.getRight(), element);
			}
		}
	}
	
	@Override
	public BSTNode<T> maximum() {
		if (this.isEmpty()) {
			return null;
		}
		return maximum(this.getRoot()); 
	}
	
	private BSTNode<T> maximum(BSTNode<T> node) {
		if (node.getRight().isEmpty()) {
			return node;
		}
		return maximum((BSTNode<T>)node.getRight());
	}
	
	@Override
	public BSTNode<T> minimum() {
		if (this.isEmpty()) {
			return null;
		}
		return minimum(this.getRoot());
	}
	
	private BSTNode<T> minimum(BSTNode<T> node) {
		if (node.getLeft().isEmpty()) {
			return node;
		}
		return minimum((BSTNode<T>)node.getLeft());
	}
	
	@Override
	public BSTNode<T> sucessor(T element) {
		BSTNode<T> x = search(element);
		if (x.isEmpty()) {
			return null;
		}
		if (!x.getRight().isEmpty()) {
			return minimum((BSTNode<T>)x.getRight());
		}
		
		BSTNode<T> y = (BSTNode<T>)x.getParent();
		while (y != null && x.equals(y.getRight())) {
			x = y;
			y = (BSTNode<T>)y.getParent();
		}
		return y;
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		BSTNode<T> x = search(element);
		if (x.isEmpty()) {
			return null;
		}
	
		if (!x.getLeft().isEmpty()) {
			return maximum((BSTNode<T>)x.getLeft());
		}
		
		BSTNode<T> y = (BSTNode<T>)x.getParent();
		while (y != null && x.equals(y.getLeft())) {
			x = y;
			y = (BSTNode<T>)y.getParent();
		}
		return y;
	}
	
	@Override
	public void remove(T element) {
		BSTNode<T> node = search(element);
		remove(node);
	}
	
	protected void remove(BSTNode<T> node) {
		BSTNode<T> tmp = node;

		if (tmp != null) {
			if (!tmp.isEmpty()) {
				if (tmp.getLeft().isEmpty() && tmp.getRight().isEmpty()) {				
					tmp = new BSTNode<T>();
				} 
				
				else if (tmp.getLeft().isEmpty() || tmp.getRight().isEmpty()) {
					if (tmp.getParent() != null) {
						if (tmp.getParent().getLeft().equals(tmp)) {	
							if (!tmp.getLeft().isEmpty()) {
								tmp.getParent().setLeft(tmp.getLeft());
							} 
							
							else {
								tmp.getParent().setLeft(tmp.getRight());
							}
						} 
						
						else {
							if (!tmp.getLeft().isEmpty()) {
								tmp.getParent().setRight(tmp.getLeft());
							} 
							
							else {
								tmp.getParent().setRight(tmp.getRight());							
							}
						}
					} 
					
					else {				
						if (!tmp.getLeft().isEmpty() && tmp.getRight().isEmpty()) {
							tmp = (BSTNode<T>) tmp.getLeft();
						} 
						
						else if (tmp.getLeft().isEmpty() && !tmp.getRight().isEmpty()) {
							tmp = (BSTNode<T>)tmp.getRight();
						}
						
						tmp.setParent(null);
					}
				} 
				
				else {
					BSTNode<T> sucessor = sucessor(tmp.getData());
					tmp.setData(sucessor.getData());
					remove(sucessor);
				}
			}
		}
		
		node.setLeft(tmp.getLeft());
		node.setParent(tmp.getParent());
		node.setRight(tmp.getRight());
		node.setData(tmp.getData());
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public T[] preOrder() {
		List<T> array = new ArrayList<T>();
		preOrder(this.getRoot(), array);
		return (T[]) array.toArray(new Comparable[size()]);
	}

	private void preOrder(BSTNode<T> node, List<T> array) {
		if (node == null) return;
		
		if (!node.isEmpty()) {
			array.add(node.getData());
			preOrder((BSTNode<T>) node.getLeft(), array);
			preOrder((BSTNode<T>) node.getRight(), array);
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public T[] order() {
		List<T> array = new ArrayList<T>();
		order(root, array);
		return (T[]) array.toArray(new Comparable[size()]);
	}
	
	private void order(BSTNode<T> node, List<T> array) {
		if (!node.isEmpty()) {
			order((BSTNode<T>)node.getLeft(), array);
			array.add(node.getData());
			order((BSTNode<T>) node.getRight(), array);
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public T[] postOrder() {
		List<T> array = new ArrayList<T>();
		postOrder(root, array);
		return (T[]) array.toArray(new Comparable[size()]);
	}
	
	private void postOrder(BSTNode<T> node, List<T> array) {
		if (node != null  && !node.isEmpty()) {
			postOrder((BSTNode<T>)node.getLeft(), array);
			postOrder((BSTNode<T>)node.getRight(), array);
			array.add(node.getData());
		}
	}

	@Override
	public int size() {
		return size(this.getRoot());
	}
	
	private int size(BSTNode<T> node){
		int result = 0;
		if(node != null && !node.isEmpty()){
			result = 1 + size((BSTNode<T>)node.getLeft()) + size((BSTNode<T>)node.getRight());
		}
		return result;
	}
}