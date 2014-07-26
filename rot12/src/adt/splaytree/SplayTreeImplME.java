package adt.splaytree;

import adt.avltree.AVLTreeImplMARCOS;
import adt.bst.BSTNode;

public class SplayTreeImplME<T extends Comparable<T>> extends AVLTreeImplMARCOS<T>
		implements SplayTree<T> {

	private void splay(BSTNode<T> node) {
		if (node == null || node.isEmpty() || node.equals(this.getRoot())) {
			return;
		}

		else if (node.getParent().equals(this.getRoot())) {
			if (node.getParent().getRight().equals(node)) {
				super.leftRotation(node);
			} else if (node.getParent().getLeft().equals(node)) {
				super.rightRotation(node);
			}
		}

		else {
			if (node.getParent().equals(node.getParent().getParent().getLeft())) {
				if (node.equals(node.getParent().getLeft())) {
					super.rightRotation((BSTNode<T>) node.getParent()
							.getParent());
					super.rightRotation((BSTNode<T>) node.getParent());
				}

				else if (node.equals(node.getParent().getRight())) {
					super.leftRotation((BSTNode<T>) node.getParent());
					super.rightRotation((BSTNode<T>) node.getParent());
				}
			}

			else if (node.getParent().equals(
					node.getParent().getParent().getRight())) {
				if (node.equals(node.getParent().getRight())) {
					leftRotation((BSTNode<T>) node.getParent().getParent());
					leftRotation((BSTNode<T>) node.getParent());
				}

				else if (node.equals(node.getParent().getLeft())) {
					rightRotation((BSTNode<T>) node.getParent());
					leftRotation((BSTNode<T>) node.getParent());
				}
			}

			splay(node);
		}
	}

	/*@Override
	public void insert(T element) {
		insert(this.getRoot(), element);
	}*/
	
	@Override
	public void insert(BSTNode<T> node, T element) {
		if (node == null) return;
		
		if (node.isEmpty()) {
			node.setData(element);
			node.setLeft(new BSTNode<T>());
			node.setRight(new BSTNode<T>());
			node.getLeft().setParent(node);
			node.getRight().setParent(node);
			splay(node);
		}

		else {
			if (node.getData().compareTo(element) < 0) {
				insert((BSTNode<T>) node.getRight(), element);
			}

			else if (node.getData().compareTo(element) > 0) {
				insert((BSTNode<T>) node.getLeft(), element);
			}
		}

	}

	@Override
	protected void remove(BSTNode<T> node) {
		if (!node.isEmpty()) {

			if (node.getLeft().isEmpty() && node.getRight().isEmpty()) {
				node.setData(null);

			} else if (node.getRight().isEmpty() || node.getLeft().isEmpty()) {
				if (node.equals(root)) {
					if (!node.getLeft().isEmpty()) {
						root = (BSTNode<T>) node.getLeft();
						root.setParent(null);
					} else {
						root = (BSTNode<T>) node.getRight();
						root.setParent(null);
					}
				} else {
					if (!node.getParent().getRight().isEmpty()
							&& node.getParent().getRight().equals(node)) {
						if (!node.getLeft().isEmpty()) {
							node.getLeft().setParent(node.getParent());
							node.getParent().setRight(node.getLeft());
						} else {
							node.getRight().setParent(node.getParent());
							node.getParent().setRight(node.getRight());
						}
					} else {
						if (!node.getLeft().isEmpty()) {
							node.getLeft().setParent(node.getParent());
							node.getParent().setLeft(node.getLeft());
						} else {
							node.getRight().setParent(node.getParent());
							node.getParent().setLeft(node.getRight());
						}
					}
				}

			} else {
				BSTNode<T> sucessor = sucessor((T) node);
				T element = sucessor.getData();
				remove(sucessor);
				node.setData(element);

			}
		}
	}

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