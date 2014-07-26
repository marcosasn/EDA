package adt.avltree;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;

public class AVLTreeImpl<T extends Comparable<T>> extends BSTImpl<T> implements AVLTree<T> {

	//AUXILIARY
	protected int calculateBalance(BSTNode<T> node){
		if(!node.isEmpty()){
			return height((BSTNode<T>)node.getLeft()) - height((BSTNode<T>)node.getRight());
		}
		return 0;
	}
	
	//AUXILIARY
	protected void rebalance(BSTNode<T> node) {
		int balance = calculateBalance(node);
		if (balance > 1) {
			if (calculateBalance((BSTNode<T>)node.getLeft()) < 0) {
				leftRotation((BSTNode<T>) node.getLeft());
				rightRotation(node);
			}
			else {
				rightRotation(node);
			}
		}
		else if (balance < -1) {
			if (calculateBalance((BSTNode<T>)node.getRight()) > 0) {
				rightRotation((BSTNode<T>)node.getRight());
				leftRotation(node);
			}
			else {
				leftRotation(node);
			}
		}
	}
	
	@Override
	protected void insert(BSTNode<T> node, T element){
		if(node.isEmpty()){
			node.setData(element);
			node.setLeft(new BSTNode<T>());
			node.setRight(new BSTNode<T>());
			node.getLeft().setParent(node);
			node.getRight().setParent(node);
		}
		
		else{
			if (element.compareTo(node.getData()) < 0) {
				insert((BSTNode<T>)node.getLeft(), element);
			}
			else {
				insert((BSTNode<T>)node.getRight(), element);
			}
		}
		rebalance(node);
	}
	
	@Override
	protected void remove(BSTNode<T> node) {
		BSTNode<T> tmp = node;

		if (tmp != null) {
			if (!tmp.isEmpty()) {
				if (tmp.getLeft().isEmpty() && tmp.getRight().isEmpty()) {				
					tmp = new BSTNode<T>();
					rebalanceUp(tmp);
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
					rebalanceUp(tmp);
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
	
	//AUXILIARY
	protected void rebalanceUp(BSTNode<T> node){
			BSTNode<T> parent = (BSTNode<T>)node.getParent();
			while(parent!= null){
				rebalance(parent);
				parent = (BSTNode<T>)parent.getParent();
			}
	}
	
	//AUXILIARY
	protected void leftRotation(BSTNode<T> node) {
		BSTNode<T> pivot = (BSTNode<T>) node.getRight();
		node.setRight(pivot.getLeft());
		
		
		if (node.getRight() != null) {
			node.getRight().setParent(node);
			
			pivot.setLeft(node);
			pivot.setParent(node.getParent());
	
			if (pivot.getParent() != null) {
				if (node.getParent().getLeft().equals(node)) {
					pivot.getParent().setLeft(pivot);
				}
	
				else {
					pivot.getParent().setRight(pivot);
				}
			}
			else {
				root = pivot;
			}
			node.setParent(pivot);
		}
	}
	
	//AUXILIARY
	protected void rightRotation(BSTNode<T> node) {
		BSTNode<T> pivot = (BSTNode<T>)node.getLeft();
		node.setLeft(pivot.getRight());
		
		if (node.getLeft() != null) {
			node.getLeft().setParent(node);
			pivot.setRight(node);
			pivot.setParent(node.getParent());
			
			if (pivot.getParent() != null){
				if(!node.getParent().getRight().isEmpty() && node.getParent().getRight().equals(node)) {
					node.getParent().setRight(pivot);
				}
				else {
					node.getParent().setLeft(pivot);
				}
			}
			else {
				root = pivot;
			}
			node.setParent(pivot);
		}
	}
}