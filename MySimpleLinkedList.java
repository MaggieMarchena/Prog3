package ejercicio5;

import java.util.Iterator;

public class MySimpleLinkedList implements Iterable<Object> {

	protected Node first;
	protected int nodeCount;
	protected Node cursor;
	
	public class MyIterator implements Iterator<Object> {

		private Node cursor;

		@Override
		public boolean hasNext() {
			return cursor != null;
		}

		@Override
		public Object next() {
			Node tmp = cursor;
			cursor = cursor.getNext();
			return tmp.getInfo();
		}

		@Override
		public void remove() {
		}

		private MyIterator(Node first) {
			cursor = first;
		}
	}
	
	public MySimpleLinkedList() {
		nodeCount = 0;
		cursor = first;
	}
	
	public void insert(Object o) {
		Node tmp = new Node(o, null);
		tmp.setNext(first);
		first = tmp;
		nodeCount++;
	}
	
	public void insertSorted(Object o) {
		Node tmp = first;
		Node n = new Node(o,null);	
		if (tmp != null) {
			while (((int)tmp.getInfo() < (int)n.getInfo()) && (tmp.getNext() != null)) {
				tmp = tmp.getNext();
			}		
			if (tmp.getNext() == null) {
				n.setNext(tmp.getNext());
				tmp.setNext(n);	
			}else {
				tmp.setNext(n);
			}
		}else {
			this.first = n;
		}		
		this.nodeCount++;
	}
	
	public Object extract() { 
		Object o = first.getInfo();
		first = first.getNext();
		nodeCount--;
		return o;
	}
	
	public Object first() {
		return first.getInfo();
	}
	
	public Node firstNode(){
		return first;
	}
	
	public Object get() {
		Object o = cursor.getInfo();
		this.cursor = cursor.getNext();
		return o;
	}
	
	public boolean isEmpty() { 
		return (nodeCount == 0);
	}
	
	public boolean has(Object o) {
		boolean has = false;
		for (int i=0; i<this.nodeCount; i++) {
			if (this.get().equals(o)) {			//no funciona -_-
				has = true;
			}
			else {
				has = false;
			}
		}
		return has;
	}
	
	public int size() {
		return nodeCount;
	}
	
	public void print(int n) {
		Node tmp = cursor;
		for(int i=1; i<n; i++){
			tmp = tmp.getNext();
		}	
		System.out.println(tmp.getInfo().toString());
	}
	
	public void printList(){
		resetCursor();
		for (int i = 0; i < nodeCount; i++){
			System.out.println(cursor.getInfo().toString());
			if (cursor.getNext() != null){
				cursor = cursor.getNext();
			}
		}
	}
	
	public int indexOf(Object o) {
		int index = -1;
		Node tmp = cursor;
		int current = 0;
		while ((tmp != null) && (index == -1)) {
			if (tmp.getInfo().equals(o))
				index = current;
			current++;
		}
		return index;
	}
	
	public boolean RemoveAt(int index) {
		boolean canRemove = false;
		if ((index >= 0) && (index <= this.size() - 1)) {
			canRemove = true;
			if (index == 0) {
				Node tmp = first;
				first = first.getNext();
				tmp.setNext(null);
			} else { 
				Node tmp = first;
				int current = 0;
				while (current < index - 1) { 
					tmp = tmp.getNext();
					current++;
				}
				
				Node remove = tmp.getNext();
				tmp.setNext(remove.getNext());
				remove.setNext(null);
			}
			nodeCount--;
		}
		return canRemove;
	}
	
	public void resetCursor() {
		cursor = first;
	}

	public boolean cursorHasNext() {
		return cursor != null;
	}
	
	@Override
	public MyIterator iterator() {
		return new MyIterator(first);
	}

}
