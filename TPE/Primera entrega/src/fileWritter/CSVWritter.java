package fileWritter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import components.Book;

public class CSVWritter {	
	
	/**
	 * Crea el archivo de salida a partir de una List<Book>, tomando como dato sólo el título de cada libro
	 * @param fileName nombre que tendrá el archivo de salida
	 * @param books List<Book> la lista desde la que se leerán los datos para crear el archivo
	 */
	public void createFile(String fileName, List<Book> books) {
		BufferedWriter bw = null;
		try {
			File file = new File(fileName);
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			int booksQ = books.size();
			for(int i = 0; i < booksQ; i++) {
	    			bw.write(books.get(i).getTitle());
	    			bw.newLine();
    			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
			} catch (Exception ex) {
				System.out.println("Error cerrando el BufferedWriter" + ex);
			}
		}
	}

}
