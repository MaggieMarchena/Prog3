package counter;

public class IterationCounter {
	
	//ATTRIBUTES
	private int counter;

	//CONSTRUCTORS
	public IterationCounter() {
	}
	
	//METHODS
	
	/**
	 * Asigna valor 0 al counter
	 */
	public void start(){
		this.counter = 0;
	}
	
	/**
	 * Agrega una unidad al counter
	 */
	public void add(){
		this.counter++;
	}
	
	/**
	 * Devuelve el counter
	 * @return int
	 */
	public int get(){
		return this.counter;
	}

}
