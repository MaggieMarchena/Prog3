package ejercicio5;

public class Ejercicio5 {

	public static void main(String[] args) {
	
		MySimpleLinkedList list1 = new MySimpleLinkedList();
		MySimpleLinkedList list2 = new MySimpleLinkedList();
		
		Node n1 = new Node(4,null);
		Node n2 = new Node(3,null);
		Node n3 = new Node(15,null);
		Node n4 = new Node(28,null);
		Node n5 = new Node(80,null);
		Node n6 = new Node(49,null);
		
		list1.insert(n1);
		list1.insert(n2);
		list1.insert(n3);
		list1.insert(n4);
		list1.insert(n5);
		list1.insert(n6);

		Node n7 = new Node(28,null);
		Node n8 = new Node(4,null);
		Node n9 = new Node(47,null);
		Node n10 = new Node(1,null);
		Node n11 = new Node(80,null);
		Node n12 = new Node(20,null);
		
		list2.insert(n7);
		list2.insert(n8);
		list2.insert(n9);
		list2.insert(n10);
		list2.insert(n11);
		list2.insert(n12);
		
		System.out.println("Lista 1: ");
		list1.printList();
		System.out.println("Lista 2: ");
		list2.printList();	
		System.out.println("Lista combinada: ");
		MySimpleLinkedList resultList = mergeListsSorted(list1, list2);		
		resultList.printList();	
	}
	
	private static MySimpleLinkedList mergeListsSorted(MySimpleLinkedList l1, MySimpleLinkedList l2) {
		MySimpleLinkedList resultList = new MySimpleLinkedList();
		int size = l1.size();
		Node tmp = l1.firstNode();	
		l1.resetCursor();
		for (int i=0; i<size; i++) {
			l2.resetCursor();
			if (l2.has(tmp.getInfo())) {
				resultList.insertSorted(tmp.getInfo());
			}
			tmp = tmp.getNext();
		}
		return resultList;		
	}

}
