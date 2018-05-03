package components;
import java.util.ArrayList;
import java.util.List;

public class Gender {
	
	//ATTRIBUTES
	private String name;
	private List<Book> books;

	public Gender(String name) {
		this.name = name;
		books = new ArrayList<Book>();
	}
	
	public String getName() {
		return name;
	}
	
	protected List<Book> getBooks(){
		return this.books;
	}
	
	protected void addBook(Book b){
		this.books.add(b);
	}
	
	protected void sortByTitle(){
		
	}
	
	protected void sortByAuthor(){
		
	}
	
	protected void sortByPages(){
		
	}

}
