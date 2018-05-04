package components;

public class Book {
	
	//ATTRIBUTES
	private String title;
	private String author;
	private String pages;
	private String[] genders;

	//CONSTRUCTORS
	public Book(String title, String author, String pages, String[] genders) {
		this.title = title;
		this.author = author;
		this.pages = pages;
		this.genders = genders;
	}

	//METHODS
	
	//GETTERS
	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getPages() {
		return pages;
	}

	public String[] getGenders() {
		return genders;
	}

	//SETTERS	
	protected void setTitle(String title) {
		this.title = title;
	}

	protected void setAuthor(String author) {
		this.author = author;
	}

	protected void setPages(String pages) {
		this.pages = pages;
	}

	protected void setGenders(String[] genders) {
		this.genders = genders;
	}

}
