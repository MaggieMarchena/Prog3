package app;

import java.util.List;

import graph.Graph;
import util.Timer;

public class Test {

	public static void main(String[] args) {
		
		//Nombres de los archivos a utilizar
		String file1 = "dataset1.csv";
		String file2 = "dataset2.csv";
		String file3 = "dataset3.csv";
		String file4 = "dataset4.csv";
		
		//Creación de herramientas
		App app1 = new App();
		App app2 = new App();
		App app3 = new App();
		App app4 = new App();
		
		//Creación del timer
		Timer timer = new Timer();
				
		//TEST
		
		////////////////////////////////////////////PRUEBAS DE CARGA DE ESTRUCTURA//////////////////////////////////////////////////
		
		//Prueba 1, archivo 1
		timer.start();
		app1.createGenreGraph(file1);
		double t1 = timer.stop();
		System.out.println(t1);			
/*		
		//Prueba 2, archivo 2
		timer.start();
		app2.createGenreGraph(file2);
		double t1 = timer.stop();
		System.out.println(t1);	
		
		//Prueba 3, archivo 3
		timer.start();
		app3.createGenreGraph(file3);
		double t1 = timer.stop();
		System.out.println(t1);	
		
		//Prueba 4, archivo 4
		timer.start();
		app4.createGenreGraph(file4);
		double t1 = timer.stop();
		System.out.println(t1);	
*/		
		
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		//////////////////////////////////////////////////PRUEBAS DE SERVICIOS/////////////////////////////////////////////////////
		
		//Prueba 1, archivo 1
		
		//Servicio 1
		timer.start();
		System.out.println("Servicio 1: \n");
		service1(app1, 3, "viajes"); 
		System.out.println("\n");
		double t2 = timer.stop();
		
		//Servicio 2
		timer.start();
		System.out.println("Servicio 2: \n");
		service2(app1, "viajes");
		System.out.println("\n");
		double t3 = timer.stop();
		
		//Servicio 3
		timer.start();
		System.out.println("Servicio 3: \n");
		service3(app1, "viajes");
		System.out.println("\n");
		double t4 = timer.stop();
/*		
		//Prueba 2, archivo 2
		
		//Servicio 1
		timer.start();
		System.out.println("Servicio 1: \n");
		service1(app2, 3, "viajes"); 
		System.out.println("\n");
		double t2 = timer.stop();
		
		//Servicio 2
		timer.start();
		System.out.println("Servicio 2: \n");
		service2(app2, "viajes");
		System.out.println("\n");
		double t3 = timer.stop();
		
		//Servicio 3
		timer.start();
		System.out.println("Servicio 3: \n");
		service3(app2, "viajes");
		System.out.println("\n");
		double t4 = timer.stop();
		
		//Prueba 3, archivo 3
		
		//Servicio 1
		timer.start();
		System.out.println("Servicio 1: \n");
		service1(app3, 3, "viajes"); 
		System.out.println("\n");
		double t2 = timer.stop();
		
		//Servicio 2
		timer.start();
		System.out.println("Servicio 2: \n");
		service2(app3, "viajes");
		System.out.println("\n");
		double t3 = timer.stop();
		
		//Servicio 3
		timer.start();
		System.out.println("Servicio 3: \n");
		service3(app3, "viajes");
		System.out.println("\n");
		double t4 = timer.stop();
		
		//Prueba 4, archivo 4
		
		//Servicio 1
		timer.start();
		System.out.println("Servicio 1: \n");
		service1(app4, 3, "viajes"); 
		System.out.println("\n");
		double t2 = timer.stop();
		
		//Servicio 2
		timer.start();
		System.out.println("Servicio 2: \n");
		service2(app4, "viajes");
		System.out.println("\n");
		double t3 = timer.stop();
		
		//Servicio 3
		timer.start();
		System.out.println("Servicio 3: \n");
		service3(app4, "viajes");
		System.out.println("\n");
		double t4 = timer.stop();
*/
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	}
	
	public static void service1(App app, int q, String genre){
		List<String> result = app.getMostSearchedAfter(q, genre);
		if (result != null){
			printList(result);
		}
		else {
			System.out.println("El género ingresado no posee tantas búsquedas posteriores ó no existe");
		}
	}
	
	public static void service2(App app, String genre){
		List<String> result = app.getAllAfter(genre);
		if (result != null){
			printList(result);
		}
		else {
			System.out.println("El género ingresado no existe");
		}
	}
	
	public static void service3(App app, String genre){
		Graph result = app.getCycleGraph(genre);
		if (result != null){
			result.printCycleList(result);;
		}
		else {
			System.out.println("El género ingresado no existe ó no tiene un ciclo");
		}
	}
	
	public static void printList(List<String> list){
		for (int i = 0; i < list.size(); i++){
			String genre = list.get(i);
			System.out.println(genre);
		}
	}

}
