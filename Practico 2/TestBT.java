package practico2;

public class TestBT {

	public static void main(String[] args) {
		
		//Create binary tree
		BinaryTree bt = new BinaryTree(null);
		
		//Insert values
		bt.insert(6);
		bt.insert(4);
		bt.insert(8);
		bt.insert(3);
		bt.insert(5);
		bt.insert(7);
		bt.insert(9);
		
		//Search for value
		boolean hasElement = bt.hasElement(8);
		System.out.println("Árbol contiene el valor : " + hasElement);

	}

}
