package app;

import java.util.List;

import components.Book;
import counter.IterationCounter;
import fileReader.CSVReader;
import fileWritter.CSVWritter;
import util.Timer;

public class App {

	public static void main(String[] args) {
		
		//Strings con los nombres de archivo que se van a utilizar
		String file1 = "dataset1.csv";
		String file2 = "dataset2.csv";
		String file3 = "dataset3.csv";
		String file4 = "dataset4.csv";
		
		//Creación del timer
		Timer timer = new Timer();
		
		////////////////////////////////////////////PRUEBAS DE CARGA DE ESTRUCTURA//////////////////////////////////////////////////
		
		//Comienzo prueba 1, 20 libros
		timer.start();
		IterationCounter.start();
		
		//Creación del reader que contiene la colección
		CSVReader reader1 = new CSVReader();	
		
		//Agregar el archivo al reader, esto genera la creación de los libros, su agregado a la colección e indexado
		reader1.addFile(file1);
		
		//Fin prueba 1
		double t1 = timer.stop();
		System.out.println(t1);	
		int c1 = IterationCounter.get();
		System.out.println(c1);
/*		
		//Comienzo prueba 2, 1.000 libros
		timer.start();
		IterationCounter.start();
				
		//Creación reader y agregado de archivo
		CSVReader reader2 = new CSVReader();
		reader2.addFile(file2);

		//Fin prueba 2				
		double t2 = timer.stop();
		System.out.println(t2);
		int c2 = IterationCounter.get();
		System.out.println(c2);
		
		//Comienzo prueba 3, 100.000 libros
		timer.start();
		IterationCounter.start();
		
		//Creación reader y agregado de archivo
		CSVReader reader3 = new CSVReader();
		reader3.addFile(file3);
		
		//Fin prueba 3
		double t3 = timer.stop();
		System.out.println(t3);
		int c3 = IterationCounter.get();
		System.out.println(c3);
		
		//Comienzo prueba 4, 1.000.000 libros
		timer.start();
		IterationCounter.start();
		
		//Creación reader y agregado de archivo
		CSVReader reader4 = new CSVReader();
		reader4.addFile(file4);
		
		//Fin prueba 4
		double t4 = timer.stop();
		System.out.println(t4);
		int c4 = IterationCounter.get();
		System.out.println(c4);
*/		
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		////////////////////////////////////////////PRUEBAS DE BÚSQUEDA DE LIBROS//////////////////////////////////////////////////
		
		//Creación del writter
		CSVWritter writter = new CSVWritter();
		
		//Nombres de los géneros que se buscarán
		String genderName1 = "cine";
		String genderName2 = "humor";
		String genderName3 = "moda";
		String genderName4 = "periodismo";		
		
		//Nombres de los archivos de salida
		String fileName1 = "movie.csv";
		String fileName2 = "humor.csv";
		String fileName3 = "fashion.csv";
		String fileName4 = "journalism.csv";
		
		//Comienzo prueba 1, búsqueda en colección de 20
		timer.start();
		IterationCounter.start();
		
		//Búsqueda
		List<Book> movieBooks = reader1.getBooksByGender(genderName1);		
		
		//Creación del archivo por medio del writter
		writter.createFile(fileName1, movieBooks);
		
		//Fin prueba 1
		double t5 = timer.stop();
		System.out.println(t5);
		int c5 = IterationCounter.get();
		System.out.println(c5);
/*		
		//Comienzo prueba 2, 1.000 libros
		timer.start();
		IterationCounter.start();
		
		//Búsqueda
		List<Book> humorBooks = reader2.getBooksByGender(genderName2);		
				
		//Creación del archivo por medio del writter
		writter.createFile(fileName2, humorBooks);
				
		//Fin prueba 2
		double t6 = timer.stop();
		System.out.println(t6);
		int c6 = IterationCounter.get();
		System.out.println(c6);
		
		//Comienzo prueba 3, 100.000 libros
		timer.start();
		IterationCounter.start();
				
		//Búsqueda
		List<Book> fashionBooks = reader3.getBooksByGender(genderName3);		
						
		//Creación del archivo por medio del writter
		writter.createFile(fileName3, fashionBooks);
						
		//Fin prueba 3
		double t7 = timer.stop();
		System.out.println(t7);
		int c7 = IterationCounter.get();
		System.out.println(c7);
				
		//Comienzo prueba 4, 1.000.000 libros
		timer.start();
		IterationCounter.start();
				
		//Búsqueda
		List<Book> journalismBooks = reader4.getBooksByGender(genderName4);		
						
		//Creación del archivo por medio del writter
		writter.createFile(fileName4, journalismBooks);
						
		//Fin prueba 4
		double t8 = timer.stop();
		System.out.println(t8);
		int c8 = IterationCounter.get();
		System.out.println(c8);
*/		
	}
}
