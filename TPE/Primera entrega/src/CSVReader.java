package fileReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import components.Book;
import library.Library;

public class CSVReader {
	
	private List<String> fileNames;
	private int counter;
	private Library library;
	boolean firstLine;

    public CSVReader() {
		this.fileNames = new ArrayList<String>();
		this.counter = 0;
		this.library = new Library();
		this.firstLine = true;
	}

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
	
	public List<Book> getBooksByGender(String genderName){
		return this.library.getBooksByGender(genderName);
	}
    
}
