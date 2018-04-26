package practico2;

public class BinaryTree {
	
	//ATTRIBUTES
	Node root;
	int height;
	
	
	//CONSTRUCTOR
	public BinaryTree(Integer value) {
		this.root = new Node(value);
		this.height = -1;
	}
		
	//METHODS
	
	
	public Integer getRoot() {
		return this.root.getInfo();
	}
	
	public boolean hasElement(Integer value) {
		if(!this.isEmpty()) return hasElement(this.root, value);
		else return false;
	}
	
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

	public boolean isEmpty() {
		return (this.root.getInfo() == null);
	}

	public void insert(Integer value) {
		 this.root = insert(root, value);
	}
	
	private Node insert(Node n, Integer value) {
		if (this.isEmpty()){
			n = new Node(value);
        	this.height++;
		}
		else if (n == null) {
        	n = new Node(value);
        	this.height++;
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
	
	public int getHeight() {
		return this.height;
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
