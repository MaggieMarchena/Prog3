package fileReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import components.Book;
import counter.IterationCounter;
import library.Library;

public class CSVReader {
	
	//ATTRIBUTES
	private List<String> fileNames;
	private int counter;
	private Library library;
	private boolean firstLine;
	private IterationCounter itCounter;

	//CONSTRUCTORS
    public CSVReader() {
		this.fileNames = new ArrayList<String>();
		this.counter = 0;
		this.library = new Library();
		this.firstLine = true;
		this.itCounter = new IterationCounter();
	}

    //METHODS
    
    /**
     * Agrega el archivo a la lista de archivos del reader, al leer el archivo se generan los libros 
     * y se agregan conjuntamente a la colección y al índice de la misma
     * @param fileName nombre del archivo que se agrega
     */
	public void addFile(String fileName) {
		this.fileNames.add(fileName);
		this.counter++;
        String csvFile = this.fileNames.get(counter-1);
        String line = "";
        String cvsSplitBy = ",";
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
            	if (!this.firstLine){
            		String[] items = line.split(cvsSplitBy);
                    String[] genders = items[3].split(" ");
                    Book book = new Book(items[0], items[1], items[2], genders);
                    this.library.addBook(book);
            	}
                this.firstLine = false;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.library.sort();
    }
	
	/**
	 * Inicia la búsqueda de los libros de un género desde la colección
	 * @param genderName nombre del género 
	 * @return List<Book>
	 */
	public List<Book> getBooksByGender(String genderName){
		return this.library.getBooksByGender(genderName);
	}
	
	/**
	 * Devuelve el valor de iteraciones
	 * @return int
	 */
	public IterationCounter getItCounter(){
		return this.itCounter;
	}
    
}
