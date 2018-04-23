package ejercicio5;

public class Node {

	private Integer info;
	private Node next;

	protected Node() {
		info = null;
		next = null;
	}

	protected Node(Integer o, Node n) {
		setInfo(o);
		setNext(n);
	}

	public void setInfo(Integer o) {
		info = o;
	}

	public void setNext(Node n) {
		next = n;
	}

	public Integer getInfo() {
		return info;
	}

	protected Node getNext() {		
		return next;
	}
	
	protected boolean hasNext(){
		return (this.getNext() != null);
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
