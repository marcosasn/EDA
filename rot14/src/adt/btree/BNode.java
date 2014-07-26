package adt.btree;

import java.util.Collections;
import java.util.LinkedList;

public class BNode<T extends Comparable<T>> {
	protected LinkedList<T> elements; //PODE TRABALHAR COM ARRAY TAMBEM
	protected LinkedList<BNode<T>> children; //PODE TRABALHAR COM ARRAY TAMBEM
	protected BNode<T> parent;
	protected int maxKeys;
	protected int maxChildren;
	
	public BNode(int order){
		this.maxChildren = order;
		this.maxKeys = order - 1;
		this.elements = new LinkedList<T>();	
		this.children = new LinkedList<BNode<T>>();
	}
	@Override
	public String toString() {
		return this.elements.toString();
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		boolean resp = false;
		if(obj != null){
			if(obj instanceof BNode){
				if(this.size() == ((BNode<T>) obj).size()){
					resp = true;
					int i = 0;
					while(i<this.size() && resp){
						resp = resp && this.getElementAt(i).equals(((BNode<T>) obj).getElementAt(i));
						i++;
					}
				}
			}
		}
		return resp;
	}
	public boolean isEmpty(){
		return this.size() == 0;
	}
	public int size(){
		return this.elements.size();
	}
	public boolean isLeaf(){
		return this.children.size() == 0;
	}
	public boolean isFull(){
		return this.size()== maxKeys;
	}
	public void addElement(T element){
		this.elements.add(element);
		Collections.sort(elements);
	}
	public void removeElement(T element){
		this.elements.remove(element);
	}
	public void removeElement(int position){
		this.elements.remove(position);
	}
	public void addChild(int position, BNode<T> child){
		this.children.add(position, child);
		child.parent = this;
	}
	public void removeChild(BNode<T> child){
		this.children.remove(child);
	}
	public int indexOfChild(BNode<T> child){
		return this.children.indexOf(child);
	}
	public T getElementAt(int index){
		return this.elements.get(index);
	}
	
	protected T calculateMedian(LinkedList<T> list){
		return list.get(list.size()/2);
	}
	
	protected void split(){
		T median = calculateMedian(this.getElements());
		int index, indexLeft, indexRight;
		BNode<T> higher = new BNode<T>(maxChildren);
		BNode<T> smaller = new BNode<T>(maxChildren);
		LinkedList<BNode<T>> children = new LinkedList<BNode<T>>();
		
		for (int i = 0; i < this.getElements().size(); i++) {
			if (median.compareTo(this.getElementAt(i)) < 0) {
				higher.addElement(this.getElementAt(i));
			}
			else if (median.compareTo(this.getElementAt(i)) > 0) {
				smaller.addElement(this.getElementAt(i));
			}
		}
		
		//a raíz tem filhos
		if (this.parent == null && !this.isLeaf()) {
			children = this.getChildren();
			this.setElements(new LinkedList<T>());
			this.addElement(median);
			this.setChildren(new LinkedList<BNode<T>>());
			smaller.parent = this;
			higher.parent = this;
			this.addChild(0, smaller);
			this.addChild(1, higher);
			
			if (!this.isLeaf()) {
				reorganizesChildren(children, smaller, 0, smaller.size()+1);
				reorganizesChildren(children, higher, higher.size()+1, children.size());
			}
		} 
		
		//só tem um nó
		else if (this.parent == null && this.isLeaf()) {
			this.setElements(new LinkedList<T>());
			this.addElement(median);
			smaller.parent = this;
			higher.parent = this;
			this.addChild(0, smaller);
			this.addChild(1, higher);
						
		}
		
		else if (this.isLeaf()) {
			BNode<T> toPromote = new BNode<T>(maxChildren);
			toPromote.elements.add(median);
			toPromote.parent = this.parent;
				
			smaller.parent = this.parent;
			higher.parent = this.parent;
			
			index = searchPosition(toPromote.parent.getElements(), median);
			indexLeft = index;
			indexRight = index + 1;
			
			parent.children.set(indexLeft, smaller);
			parent.children.add(indexRight, higher);
			toPromote.promote();
		}
		
		else {
			children = this.children;
			
			BNode<T> toPromote = new BNode<T>(maxChildren);
			toPromote.elements.add(median);
			toPromote.parent = this.parent;
				
			smaller.parent = this.parent;
			higher.parent = this.parent;
			
			index = searchPosition(toPromote.parent.getElements(), median);
			indexLeft = index;
			indexRight = index + 1;
			
			parent.children.add(indexLeft, smaller);
			parent.children.add(indexRight, higher);
			
			int contOne = 0, contTwo = 0;
			for (int i = 0; i < children.size(); i++) {
				if (children.get(i).getElements().get(0).compareTo(median) < 0) {
					smaller.addChild(contOne++, children.get(i));
				} 
				else {
					higher.addChild(contTwo++, children.get(i));
				}
			}
			
			parent.removeChild(this);
			toPromote.promote();
		}
	}
	
	private void reorganizesChildren(LinkedList<BNode<T>> children, BNode<T> parent, int first, int last){
		int index;
		for (int i = first; i < last; i++) {
			index = searchPosition(parent.getElements(), children.get(i).getElements().get(0));
			parent.addChild(index, children.get(i));
		}
	}
	
	private int searchPosition(LinkedList<T> list, T median){
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).compareTo(median) > 0) {
				return i;
			}
		}
		return list.size();
	}
	
	protected void promote(){
		int index = searchPosition(this.parent.getElements(), this.getElementAt(0));
		this.parent.getElements().add(index, this.getElementAt(0));
	
		if (this.parent.size() > maxKeys) {
			parent.split();
		}
	}
	
	public LinkedList<T> getElements() {
		return elements;
	}
	public void setElements(LinkedList<T> elements) {
		this.elements = elements;
	}
	public LinkedList<BNode<T>> getChildren() {
		return children;
	}
	public void setChildren(LinkedList<BNode<T>> children) {
		this.children = children;
	}
}