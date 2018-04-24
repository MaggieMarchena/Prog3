package ejercicio5;

public class MySimpleLinkedList {

	//ATTRIBUTES
	protected Node first;
	protected int nodeCount;
	protected Node cursor;
	
	//CONSTRUCTORS
	public MySimpleLinkedList() {
		nodeCount = 0;
		cursor = first;
	}
	
	//GETTERS
	public Integer getFirst() {
		return first.getInfo();
	}
	
	public Integer getNext(){
		return cursor.getNext().getInfo();
	}
	
	public Integer get() {
		Integer o = cursor.getInfo();
		this.cursor = cursor.getNext();
		return o;
	}
	
	
	//METHODS
	
	
	//INSERTING NODES
	
	//Insert in the first place
	public void insertFirst(Integer o) {
		Node tmp = new Node(o, null);
		tmp.setNext(first);
		first = tmp;
		nodeCount++;
	}
	
	//Insert in the last place, uses cursor
	public void insertLast(Integer o) {
		Node tmp = new Node(o, null);
		cursor.setNext(tmp);
		nodeCount++;
	}
	
	//Insert from an unsorted source, in < to > order
	public void insertSorted(Integer o) {
		Node tmp = this.first;
		if (!this.isEmpty()) {	
			if ((this.size() == 1)){
				if (tmp.getInfo() > o) {
					this.insertFirst(o);
				}
				else {
					this.insertLast(o);
				}
			}
			else {
				if (tmp.getInfo() > o){
					this.insertFirst(o);
				}
				else {
					while (tmp.getInfo() <= o) { 
						if ((tmp.getInfo() <= o) && (tmp.getNext().getInfo() > o)){
							Node n = new Node (o, tmp.getNext());
							tmp.setNext(n);
							this.nodeCount++;
							tmp = n.getNext();
						}
						else {
							tmp = tmp.getNext();
						}				
					}
				}			
			}		
		}
		else {
			this.insertFirst(o);
		}			
	}

	//Insert from a sorted source, keeping < to > order, uses cursor
	public void insertFromSortedLists(Integer o) {
		if (this.isEmpty()){
			this.insertFirst(o);
			this.resetCursor();
		}
		else {
			this.insertLast(o);
			this.cursor = cursor.getNext();
		}
	}
	
	//INFO
	
	//Shows integer from a node and takes it out of the list 
	public Integer extract() { 
		Integer o = first.getInfo();
		first = first.getNext();
		nodeCount--;
		return o;
	}
	
	//Shows existence of nodes in the list
	public boolean isEmpty() { 
		return (nodeCount == 0);
	}
	
	//Looks for specific value in an unsorted list, uses cursor
	//@return boolean
	public boolean has(Integer o) {
		boolean has = false;
		int aux = 0;
		while ((aux < this.nodeCount) && (!has)){
			if (this.get().equals(o)) {				
				has = true;
			}
			else {
				has = false;
			}
			aux++;
		}
		return has;
	}
	
	//Looks for specific value in a sorted list, uses cursor
	//@return boolean
	public boolean hasForSorted(Integer o) {
		boolean has = false;
		int aux = 0;
		while ((aux < this.nodeCount) && (!has) && (cursor.getInfo() <= o)){
			if (this.get().equals(o)) {				
				has = true;
			}
			else {
				has = false;
			}
			aux++;
		}
		return has;
	}
	
	//Shows amount of nodes in a list
	public int size() {
		return nodeCount;
	}
	
	//Shows position of a node with a specific value
	public int indexOf(Integer o) {
		int index = -1;
		Node tmp = first;
		int current = 0;
		while ((tmp != null) && (index == -1)) {
			if (tmp.getInfo().equals(o))
				index = current;
			current++;
		}
		return index;
	}
	
	//OTHER
	
	//Sets cursor in the first node of a list
	public void resetCursor() {
		cursor = first;
	}
	
	//Deletes the node in a specific position
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
	
	//PRINTING
	
	//Prints the node in a specific position, uses cursor
	public void print(int n) {
		resetCursor();
		Node tmp = cursor;
		for(int i=1; i<n; i++){
			tmp = tmp.getNext();
		}	
		System.out.println(tmp.getInfo().toString());
	}
	
	//Prints a whole list, uses cursor
	public void printList(){
		resetCursor();
		for (int i = 0; i < nodeCount; i++){
			System.out.println(cursor.getInfo().toString());
			if (cursor.getNext() != null){
				cursor = cursor.getNext();
			}
		}
	}

}
