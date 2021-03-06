package app;

import java.util.List;

import util.IterationCounter;
import graph.Graph;
import util.Timer;

public class Test {

	public static void main(String[] args) {
		
		//Nombres de los archivos a utilizar
		String file1 = "dataset1.csv";
		String file2 = "dataset2.csv";
		String file3 = "dataset3.csv";
		String file4 = "dataset4.csv";
		
		//Creaci�n de herramientas
		App app1 = new App();
		App app2 = new App();
		App app3 = new App();
		App app4 = new App();
		
		//Creaci�n del timer
		Timer timer = new Timer();
				
		//TEST
		
		////////////////////////////////////////////PRUEBAS DE CARGA DE ESTRUCTURA//////////////////////////////////////////////////
		
		//Prueba 1, archivo 1
		timer.start();
		IterationCounter.start();
		
		app1.createGenreGraph(file1);
		double t1 = timer.stop();
		System.out.println("timer" + t1);	
		int c1 = IterationCounter.get();
		System.out.println("counter" + c1);
/*		
		//Prueba 2, archivo 2
		timer.start();
		IterationCounter.start();
		
		app2.createGenreGraph(file2);
		double t1 = timer.stop();
		System.out.println("timer" + t1);
		int c1 = IterationCounter.get();
		System.out.println("counter" + c1);	
		
		//Prueba 3, archivo 3
		timer.start();
		IterationCounter.start();
		
		app3.createGenreGraph(file3);
		double t1 = timer.stop();
		System.out.println("timer" + t1);	
		int c1 = IterationCounter.get();
		System.out.println("counter" + c1);
		
		//Prueba 4, archivo 4
		timer.start();
		IterationCounter.start();
		
		app4.createGenreGraph(file4);
		double t1 = timer.stop();
		System.out.println(t1);	
		int c1 = IterationCounter.get();
		System.out.println("counter" + c1);
*/		
		
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		//////////////////////////////////////////////////PRUEBAS DE SERVICIOS/////////////////////////////////////////////////////
		
		//Prueba 1, archivo 1
		
		//Servicio 1
		timer.start();
		IterationCounter.start();
		
		System.out.println("Servicio 1: \n");
		service1(app1, 3, "viajes"); 
		System.out.println("\n");
		double t2 = timer.stop();
		System.out.println("timer" + t2);
		int c2 = IterationCounter.get();
		System.out.println(c2);
		
		//Servicio 2
		timer.start();
		IterationCounter.start();
		
		System.out.println("Servicio 2: \n");
		service2(app1, "viajes");
		System.out.println("\n");
		double t3 = timer.stop();
		System.out.println("timer" + t3);
		int c3 = IterationCounter.get();
		System.out.println(c3);
		
		
		//Servicio 3
		timer.start();
		IterationCounter.start();
		
		System.out.println("Servicio 3: \n");
		service3(app1, "negocios");
		System.out.println("\n");
		double t4 = timer.stop();
		System.out.println("timer" + t4);
		int c4 = IterationCounter.get();
		System.out.println(c4);
/*		
		//Prueba 2, archivo 2
		
		//Servicio 1
		timer.start();
		IterationCounter.start();
		
		System.out.println("Servicio 1: \n");
		service1(app2, 3, "viajes"); 
		System.out.println("\n");
		double t2 = timer.stop();
		System.out.println("timer" + t2);
		int c2 = IterationCounter.get();
		System.out.println(c2);
		
		//Servicio 2
		timer.start();
		IterationCounter.start();
		
		System.out.println("Servicio 2: \n");
		service2(app2, "viajes");
		System.out.println("\n");
		double t3 = timer.stop();
		System.out.println("timer" + t3);
		int c3 = IterationCounter.get();
		System.out.println(c3);
		
		//Servicio 3
		timer.start();
		IterationCounter.start();
		
		System.out.println("Servicio 3: \n");
		service3(app2, "viajes");
		System.out.println("\n");
		double t4 = timer.stop();
		System.out.println("timer" + t4);
		int c4 = IterationCounter.get();
		System.out.println(c4);
		
		//Prueba 3, archivo 3
		
		//Servicio 1
		timer.start();
		IterationCounter.start();
		
		System.out.println("Servicio 1: \n");
		service1(app3, 3, "viajes"); 
		System.out.println("\n");
		double t2 = timer.stop();
		System.out.println("timer" + t2);
		int c2 = IterationCounter.get();
		System.out.println(c2);
		
		//Servicio 2
		timer.start();
		IterationCounter.start();
		
		System.out.println("Servicio 2: \n");
		service2(app3, "viajes");
		System.out.println("\n");
		double t3 = timer.stop();
		System.out.println("timer" + t3);
		int c3 = IterationCounter.get();
		System.out.println(c3);
		
		//Servicio 3
		timer.start();
		IterationCounter.start();
		
		System.out.println("Servicio 3: \n");
		service3(app3, "viajes");
		System.out.println("\n");
		double t4 = timer.stop();
		System.out.println("timer" + t4);
		int c4 = IterationCounter.get();
		System.out.println(c4);
		
		//Prueba 4, archivo 4
		
		//Servicio 1
		timer.start();
		IterationCounter.start();
		
		System.out.println("Servicio 1: \n");
		service1(app4, 5, "viajes"); 
		System.out.println("\n");
		double t2 = timer.stop();
		System.out.println("timer" + t2);
		int c2 = IterationCounter.get();
		System.out.println("counter" + c2);
		
		//Servicio 2
		timer.start();
		IterationCounter.start();
		
		System.out.println("Servicio 2: \n");
		service2(app4, "humor");
		System.out.println("\n");
		double t3 = timer.stop();
		System.out.println("timer" + t3);
		int c3 = IterationCounter.get();
		System.out.println(c3);
		
		//Servicio 3
		timer.start();
		IterationCounter.start();
		
		System.out.println("Servicio 3: \n");
		service3(app4, "negocios");
		System.out.println("\n");
		double t4 = timer.stop();
		System.out.println("timer" + t4);
		int c4 = IterationCounter.get();
		System.out.println(c4);
*/
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	}
	
	public static void service1(App app, int q, String genre){
		List<String> result = app.getMostSearchedAfter(q, genre);
		if (result != null){
			printList(result);
		}
		else {
			System.out.println("El g�nero ingresado no posee tantas b�squedas posteriores � no existe");
		}
	}
	
	public static void service2(App app, String genre){
		List<String> result = app.getAllAfter(genre);
		if (result != null){
			printList(result);
		}
		else {
			System.out.println("El g�nero ingresado no existe");
		}
	}
	
	public static void service3(App app, String genre){
		Graph result = app.getCycleGraph(genre);
		if (result != null){
			result.printCycleList(result);;
		}
		else {
			System.out.println("El g�nero ingresado no existe � no tiene un ciclo");
		}
	}
	
	public static void printList(List<String> list){
		for (int i = 0; i < list.size(); i++){
			String genre = list.get(i);
			System.out.println(genre);
		}
	}

}
