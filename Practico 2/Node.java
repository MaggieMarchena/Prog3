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

	//Sets a given Node as the childLeft
	protected void setChildLeft(Node n) {
		childLeft = n;
	}
	
	//Sets a given Node as the childRight
	protected void setChildRight(Node n) {
		childRight = n;
	}

	//GETTERS
	
	//Returns the Integer value of the Node
	protected Integer getInfo() {
		return info;
	}

	//Returns the Node on childLeft
	protected Node getChildLeft() {		
		return childLeft;
	}
	
	//Returns the Node on childRight
	protected Node getChildRight() {		
		return childRight;
	}

}
