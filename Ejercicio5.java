package ejercicio5;

public class Ejercicio5 {

	public static void main(String[] args) {
	
		MySimpleLinkedList list1 = new MySimpleLinkedList();
		MySimpleLinkedList list2 = new MySimpleLinkedList();
		
		MySimpleLinkedList list3 = new MySimpleLinkedList();
		MySimpleLinkedList list4 = new MySimpleLinkedList();
		
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
		
		System.out.println("Lista 1: ");
		list1.printList();
		System.out.println("Lista 2: ");
		list2.printList();	
		System.out.println("Lista combinada: ");
		MySimpleLinkedList resultList = mergeListsSorted(list1, list2);		
		resultList.printList();	
		
		System.out.println("Lista 3: ");
		list3.printList();
		System.out.println("Lista 4: ");
		list4.printList();	
		System.out.println("Lista combinada: ");
		MySimpleLinkedList resultList2 = mergeSortedLists(list3, list4);		
		resultList2.printList();	
	}
	
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
