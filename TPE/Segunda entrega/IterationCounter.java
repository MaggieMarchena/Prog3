package util;

public class IterationCounter {
	
	//ATTRIBUTES
	private static int counter;

	//CONSTRUCTORS
	public IterationCounter() {
	}
	
	//METHODS
	
	/**
	 * Asigna valor 0 al counter
	 */
	public static void start(){
		counter = 0;
	}
	
	/**
	 * Agrega una unidad al counter
	 */
	public static void add(){
		counter++;
	}
	
	/**
	 * Devuelve el counter
	 * @return int
	 */
	public static int get(){
		return counter;
	}

}
