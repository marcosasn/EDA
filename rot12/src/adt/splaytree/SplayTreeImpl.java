package adt.splaytree;

import adt.avltree.AVLTreeImpl;
import adt.bst.BSTNode;

public class SplayTreeImpl<T extends Comparable<T>> extends AVLTreeImpl<T> implements
		SplayTree<T> {

	//rightRotation de Avltree estava errado
	//splay dessa classe estava errado
	
	
	private void splay(BSTNode<T> node){
		if (node == null || node.isEmpty() || node.equals(this.getRoot())) {
			return;
		}
			
		else if (node.getParent().equals(this.getRoot())) {
			if (node.equals(node.getParent().getRight())) {
				super.leftRotation(this.getRoot());
			}
			else if (node.equals(node.getParent().getLeft())) {
				super.rightRotation(this.getRoot());
			}
		
		}else{
			
			if (node.getParent().equals(node.getParent().getParent().getRight())) {
				if (node.equals(node.getParent().getRight())) {
					super.leftRotation((BSTNode<T>)node.getParent().getParent());
					super.leftRotation((BSTNode<T>)node.getParent());
					
				}else if (node.equals(node.getParent().getLeft())) {
					super.rightRotation((BSTNode<T>) node.getParent());
					super.leftRotation((BSTNode<T>) node.getParent());
				}
			
			} else if (node.getParent().equals(node.getParent().getParent().getLeft())) {
				if (node.equals(node.getParent().getRight())) {
					super.leftRotation((BSTNode<T>)node.getParent());
					super.rightRotation((BSTNode<T>) node.getParent());
					
				} else if(node.equals(node.getParent().getLeft())) {
					super.rightRotation((BSTNode<T>) node.getParent().getParent());
					super.rightRotation((BSTNode<T>) node.getParent());
				}
			}
			this.splay(node);
		}
	}
		
	//ok
	@Override
	protected void insert(BSTNode<T> node, T element){//ok
		if(node.isEmpty()){
			node.setData(element);
			node.setLeft(new BSTNode<T>());
			node.setRight(new BSTNode<T>());
			node.getLeft().setParent(node);
			node.getRight().setParent(node);
			this.splay(node);
			
		}else{
			if (element.compareTo(node.getData()) < 0) {
				insert((BSTNode<T>)node.getLeft(), element);
				
			}else if (element.compareTo(node.getData()) > 0) {
				insert((BSTNode<T>)node.getRight(), element);
			}
		}
	}
	
	//ok
	@Override
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

	//ok
	@Override
	public void remove(T element) {
		BSTNode<T> aux = super.search(element);
		if (aux.isEmpty()) {
			this.splay((BSTNode<T>) aux.getParent());
		}

		else {
			remove(aux);
			this.splay((BSTNode<T>) aux.getParent());
		}
	}
	
	//ok
	@Override
	public BSTNode<T> search(T element) {
		BSTNode<T> x = super.search(element);
		if (!x.isEmpty()) {
			this.splay(x);
		}

		else {
			this.splay((BSTNode<T>) x.getParent());
		}
		return x;
	}
}