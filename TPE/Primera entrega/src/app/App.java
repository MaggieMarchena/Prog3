package app;

import java.util.List;

import components.Book;
import fileReader.CSVReader;
import fileWritter.CSVWritter;
import util.Timer;

public class App {

	public static void main(String[] args) {
		
		Timer timer = new Timer();
		
		CSVReader reader = new CSVReader();
		
		String file1 = "dataset1.csv";
//		String file2 = "dataset2.csv";
//		String file3 = "dataset3.csv";
//		String file4 = "dataset4.csv";
		
		reader.addFile(file1);
		
		String genderName = "cine";
		List<Book> movieBooks = reader.getBooksByGender(genderName);
		
		CSVWritter writter = new CSVWritter();
		
		writter.createFile("movie.csv", movieBooks);
		
//		reader.addFile("dataset2.csv");
//		reader.addFile("dataset3.csv");
//		reader.addFile("dataset4.csv");
		
	}

}
