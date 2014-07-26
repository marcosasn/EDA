package adt.btree;

import java.util.LinkedList;

public class BTreeImpl<T extends Comparable<T>> implements
		BTree<T> {

	protected BNode<T> root;
	protected int order;
	
	public BTreeImpl(int order) {
		this.order = order;
		this.root = new BNode<T>(order);
	}
	
	@Override
	public BNode<T> getRoot() {
		return this.root;
	}

	@Override
	public boolean isEmpty() {
		return this.root.isEmpty();
	}

	@Override
	public int height() {
		return height(this.root);
	}
	
	private int height(BNode<T> node){
		int height = -1;
		if (!node.isEmpty()) {
			if (node.isLeaf()) {
				height = 0;
			}
			else {
				height = 1 + height(node.getChildren().get(0));
			}
		}
		return height;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public BNode<T>[] depthLeftOrder() {
		LinkedList<BNode<T>> list = new LinkedList<BNode<T>>();
		list = depthLeftOrder(this.getRoot(), list);
		BNode<T>[] temp = new BNode[list.size()];

		return (BNode<T>[]) list.toArray(temp);
	}
	
	private LinkedList<BNode<T>> depthLeftOrder(BNode<T> node, LinkedList<BNode<T>> list){
		if (!node.isEmpty()) {
			list.add(node);
			for (int i = 0; i < node.getChildren().size(); i++){
				depthLeftOrder(node.getChildren().get(i), list);				
			}			
		}
		return list;
	}
	
	@Override
	public int size() {
		return size(this.getRoot());
	}
	
	private int size(BNode<T> node) {
		int size = 0;
		if (!node.isEmpty() && node.isLeaf()) {
			size = node.size();
		}
		else {
			size = node.size();
			for (int i = 0; i < node.getChildren().size(); i++) {
				size += size(node.getChildren().get(i));
			}
		}
		return size;
	}

	@Override
	public BNodePosition<T> search(T element) {
		return search(this.getRoot(), element);
	}
	
	private BNodePosition<T> search(BNode<T> node, T element) {
		int i = 0;
		while (i < node.getElements().size() && element.compareTo(node.getElementAt(i)) > 0) {
			i++;
		}
		
		if (i < node.getElements().size() && !node.getElements().isEmpty() && element.equals(node.getElementAt(i))) {
			return new BNodePosition<T>(node, i);
		}
		if (node.isLeaf()) {
			return new BNodePosition<T>();
		}
		return search(node.getChildren().get(i), element);
	}
	
	@Override
	public void insert(T element) {
		insert(this.getRoot(), element);
	}
	
	private void insert(BNode<T> node, T element) {
		if (node.isLeaf()) {
			node.addElement(element);
			if (node.getElements().size() > node.maxKeys) {
				node.split();
			}
		}
		else {
			int position = searchPosition(node.getElements(), element);
			insert(node.getChildren().get(position), element);
		}
	}
	
	private int searchPosition(LinkedList<T> list, T element){
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).compareTo(element) > 0) {
				return i;
			}
		}
		return list.size();
	}

	//NAO PRECISA IMPLEMENTAR OS METODOS ABAIXO
	@Override
	public BNode<T> maximum(BNode<T> node) {
		//NAO PRECISA IMPLEMENTAR
		if (node.isLeaf()) {
			return node;
		}
		return maximum(node.getChildren().getLast());
	}
	@Override
	public BNode<T> minimum(BNode<T> node) {
		//NAO PRECISA IMPLEMENTAR
		if (node.isLeaf()) {
			return node;
		}
		return minimum(node.getChildren().getFirst());
	}
	@Override
	public void remove(T element) {
		//NAO PRECISA IMPLEMENTAR
	}
}