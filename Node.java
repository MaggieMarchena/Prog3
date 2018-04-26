package practico2;

public class Node {

	//ATTRIBUTES
	private Integer info;
	private Node childLeft;
	private Node childRight;

	//CONSTRUCTORS
	protected Node(Integer value) {
		info = value;
		childLeft = null;
		childRight = null;
	}

	//SETTERS

	protected void setChildLeft(Node n) {
		childLeft = n;
	}
	
	protected void setChildRight(Node n) {
		childRight = n;
	}

	//GETTERS
	protected Integer getInfo() {
		return info;
	}

	protected Node getChildLeft() {		
		return childLeft;
	}
	
	protected Node getChildRight() {		
		return childRight;
	}
	
	
	//METHODS

}
