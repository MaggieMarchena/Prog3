package ejercicio5;

public class Ejercicio5 {

	public static void main(String[] args) {
	
		//Creation of lists
		
		//1 and 2 will be unsorted
		MySimpleLinkedList list1 = new MySimpleLinkedList();
		MySimpleLinkedList list2 = new MySimpleLinkedList();
		
		//3 and 4 will be sorted < to >
		MySimpleLinkedList list3 = new MySimpleLinkedList();
		MySimpleLinkedList list4 = new MySimpleLinkedList();
		
		//Insert values into the lists
		list1.insertFirst(4);
		list1.insertFirst(3);
		list1.insertFirst(15);
		list1.insertFirst(28);
		list1.insertFirst(80);
		list1.insertFirst(49);
		
		list2.insertFirst(28);
		list2.insertFirst(4);
		list2.insertFirst(47);
		list2.insertFirst(3);
		list2.insertFirst(80);
		list2.insertFirst(20);
		
		list3.insertFirst(80);
		list3.insertFirst(49);
		list3.insertFirst(28);
		list3.insertFirst(15);
		list3.insertFirst(4);
		list3.insertFirst(3);
		
		list4.insertFirst(80);
		list4.insertFirst(47);
		list4.insertFirst(28);
		list4.insertFirst(20);
		list4.insertFirst(4);
		list4.insertFirst(3);
		
		//Print the unsorted lists
		System.out.println("Lista 1: ");
		list1.printList();
		System.out.println("Lista 2: ");
		list2.printList();
		
		//Create new sorted list with common elements from lists 1 and 2 and print	
		System.out.println("Lista combinada: ");
		MySimpleLinkedList resultList = mergeListsSorted(list1, list2);		
		resultList.printList();			
		
		//Print the sorted lists
		System.out.println("Lista 3: ");
		list3.printList();
		System.out.println("Lista 4: ");
		list4.printList();	
		
		//Create new sorted list with common elements from lists 1 and 2 and print	
		System.out.println("Lista combinada: ");
		MySimpleLinkedList resultList2 = mergeSortedLists(list3, list4);		
		resultList2.printList();	
	}
	
	
	//Returns a new list, sorted < to >, with the common elements of 2 given unsorted lists
	private static MySimpleLinkedList mergeListsSorted(MySimpleLinkedList l1, MySimpleLinkedList l2) {
		MySimpleLinkedList resultList = new MySimpleLinkedList();
		int size = l1.size();
		l1.resetCursor();			
		for (int i=0; i<size; i++) {
			Integer tmp = l1.get();
			l2.resetCursor();
			if (l2.has(tmp)) {
				resultList.insertSorted(tmp);
			}
		}
		resultList.resetCursor();
		return resultList;		
	}
	
	//Returns a new list with the common elements of 2 given lists sorted < to >, keeping the order
	private static MySimpleLinkedList mergeSortedLists(MySimpleLinkedList l1, MySimpleLinkedList l2) {
		MySimpleLinkedList resultList = new MySimpleLinkedList();
		int size = l1.size();
		l1.resetCursor();	
		l2.resetCursor();
		for (int i=0; i<size; i++) {
			Integer tmp = l1.get();
			if (l2.hasForSorted(tmp)) {
				resultList.insertFromSortedLists(tmp);
			}
		}
		resultList.resetCursor();
		return resultList;		
	}

}
