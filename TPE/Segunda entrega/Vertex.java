package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Vertex {
	
	private String label;
	private List<Edge> edges;
	private String state;
	private Vertex parent;

	public Vertex(String label) {
		this.label = label;
		this.edges = new ArrayList<Edge>();
		this.state = "white";
	}
	
	protected void setParent(Vertex p){
		this.parent = p;
	}
	
	protected void setState(String s){
		this.state = s;
	}
	
	public String getLabel(){
		return this.label;
	}
	
	protected String getState(){
		return this.state;
	}
	
	protected Vertex getParent(){
		return this.parent;
	}
	
	public void addEdge(Edge e){
		this.edges.add(e);
	}
	
	public List<Edge> getEdges(){
		return this.edges;
	}
	
	protected List<Vertex> getNeighbours(){
		List<Vertex> result = new ArrayList<Vertex>();
		Iterator<Edge> it = this.edges.iterator();
		while (it.hasNext()){
			result.add(it.next().getDestination());
		}
		return result;
	}

}
