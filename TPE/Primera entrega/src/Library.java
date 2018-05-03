package library;
import java.util.ArrayList;
import java.util.List;

import comparators.ComparatorGenderName;
import components.Book;
import components.Index;

public class Library {
	
	//ATTRIBUTES
	private Index index;
	private List<Book> books;
	private ComparatorGenderName comparator;

	public Library() {
		this.index = new Index();
		this.books = new ArrayList<Book>();
		this.comparator = new ComparatorGenderName();
	}
	
	public void addBook(Book b){
		this.index.add(b);
		this.books.add(b);
	}
	
	public void sort(){
		this.index.sort(this.comparator);
	}
	
	public List<Book> getBooksByGender(String genderName){
		return this.index.getBooksByGender(genderName);
	}

}
