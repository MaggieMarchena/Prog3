package ejercicio5;

public class Node {

	//ATTRIBUTES
	private Integer info;
	private Node next;

	//CONSTRUCTORS
	protected Node() {
		info = null;
		next = null;
	}

	protected Node(Integer o, Node n) {
		setInfo(o);
		setNext(n);
	}

	//SETTERS
	public void setInfo(Integer o) {
		info = o;
	}

	public void setNext(Node n) {
		next = n;
	}

	//GETTERS
	public Integer getInfo() {
		return info;
	}

	protected Node getNext() {		
		return next;
	}
	
	
	//METHODS
	
	//EXISTENCE OF NEXT NODE
	protected boolean hasNext(){
		return (this.getNext() != null);
	}

}
