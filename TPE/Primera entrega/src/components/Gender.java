package components;
import java.util.ArrayList;
import java.util.List;

public class Gender {
	
	//ATTRIBUTES
	private String name;
	private List<Book> books;

	//CONSTRUCTORS
	public Gender(String name) {
		this.name = name;
		books = new ArrayList<Book>();
	}
	
	//METHODS
	
	/**
	 * Devuelve nombre del género
	 * @return String
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Devuelve la lista de libros del género
	 * @return
	 */
	protected List<Book> getBooks(){
		return this.books;
	}
	
	/**
	 * Agrega un libro a la lista del género
	 * @param b el libro que se agrega
	 */
	protected void addBook(Book b){
		this.books.add(b);
	}
	
	//SORTING
	protected void sortByTitle(){
		
	}
	
	protected void sortByAuthor(){
		
	}
	
	protected void sortByPages(){
		
	}

}
