package practico2;

public class BinaryTree {
	
	//ATTRIBUTES
	Node root;
	int height;
	
	
	//CONSTRUCTOR
	public BinaryTree(Integer value) {
		this.root = new Node(value);
		this.height = 0;
	}
		
	//METHODS
	
	//GETTERS
	
	//Returns the Integer value of the Node in the root
	public Integer getRoot() {
		return this.root.getInfo();
	}
	
	//Returns the int height of the Tree
	public int getHeight() {
		return this.height;
	}
	
	//INSERT
	
	//Creates a new Node with the given Integer value and inserts it in the Tree on the correct order
	public void insert(Integer value) {
		 this.root = insert(root, value);
	}
	
	//Complejidad O(n)
	private Node insert(Node n, Integer value) {
		if (this.isEmpty()){
			n = new Node(value);
		}
		else if (n == null) {
       	n = new Node(value);
       }   
       else if (value < n.getInfo()) {
           n.setChildLeft(insert(n.getChildLeft(), value));
       } 
       else if (value > n.getInfo()) {
           n.setChildRight(insert(n.getChildRight(), value));
       } 
       else {
           return n;
       }    
       return n;
   }   
	
	//INFO
	
	//Returns a boolean for the existence of a given Integer value in the Nodes of the Tree
	public boolean hasElement(Integer value) {
		if(!this.isEmpty()) return hasElement(this.root, value);
		else return false;
	}
	
	//Complejidad O(n)
	private boolean hasElement(Node n, Integer value){
		boolean result = false;
		if (n.getInfo() == value) {
			result = true;
		}
		else if (n.getInfo() > value) {
			if(n.getChildLeft() != null) {
				result = (hasElement(n.getChildLeft(), value));				
			}
		}
		else {
			result = (hasElement(n.getChildRight(), value));
		}
		return result;
	}

	//Returns existences of Nodes in the Tree
	public boolean isEmpty() {
		return (this.root.getInfo() == null);
	}	
	
//	public boolean delete(Integer value) {
//
//	}
//	
//	private Node delete (Node n, Integer value){
//		
//	}
	
//	void printPosOrder() {
//		
//	}
//	
//	void printPreOrder() {
//		
//	}
//	
//	void printInOrder() {
//		
//	}
//	
//	List getLongestBranch() {
//		
//	}
//	
//	List getFrontera() {
//		
//	}
//	
//	Object getMaxElem() {
//		
//	}
//	
//	List getElemAtLevel(i) {
//		
//	}

}
