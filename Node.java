package ejercicio5;

public class Node {

	private Object info;
	private Node next;

	public Node() {
		info = null;
		next = null;
	}

	public Node(Object o, Node n) {
		setInfo(o);
		setNext(n);
	}

	public void setInfo(Object o) {
		info = o;
	}

	public void setNext(Node n) {
		next = n;
	}

	public Object getInfo() {
		return info;
	}

	public Node getNext() {
		return next;
	}
	
	public void printObject (Node n){
		System.out.println(n.getInfo().toString());
	}
	
	@Override
	public String toString(){
		String result = ""+info+"";
		return result;
	}

}
