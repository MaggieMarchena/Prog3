package counter;

public class IterationCounter {
	
	private int counter;

	public IterationCounter() {
	}
	
	public void start(){
		this.counter = 0;
	}
	
	public void add(){
		this.counter++;
	}
	
	public int get(){
		return this.counter;
	}

}
