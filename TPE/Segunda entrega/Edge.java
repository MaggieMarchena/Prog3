package graph;

public class Edge {
	
	protected static final int DEFAULT_WEIGHT = 1;
	protected Integer weight;
	private Vertex source;
	private Vertex destination;

	protected Edge(Vertex source, Vertex destination) {
		this.weight = DEFAULT_WEIGHT;
		this.source = source;
		this.destination = destination;
	}
	
	protected Vertex getSource(){
		return this.source;
	}
	
	protected Vertex getDestination(){
		return this.destination;
	}
	
	public Integer getWeight(){
		return this.weight;
	}
	
	public void addWeight(){
		this.weight++;
	}

}
