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

	//CONSTRUCTORS
	public Library() {
		this.index = new Index();
		this.books = new ArrayList<Book>();
		this.comparator = new ComparatorGenderName();
	}
	
	//METHODS
	
	/**
	 * Agrega el libro a la colección y al índice de la misma
	 * @param b el libro que se va a agregar
	 */
	public void addBook(Book b){
		this.index.add(b);
		this.books.add(b);
	}
	
	/**
	 * Ordena la lista de géneros de forma alfabética
	 */
	public void sort(){
		this.index.sort(this.comparator);
	}
	
	/**
	 * Inicia la búsqueda de los libros de un género en el índice
	 * @param genderName nombre del género
	 * @return List<Book>
	 */
	public List<Book> getBooksByGender(String genderName){
		return this.index.getBooksByGender(genderName);
	}

}
