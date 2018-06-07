package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import util.IterationCounter;
import util.ComparatorEdgeWeight;

public class Graph {
	
	private List<Vertex> vertices;
	private List<Edge> edges;
	
	private final String NOT_VISITED = "white";
	private final String VISITED = "grey";
	private final String DONE = "black";

	public Graph() {
		this.vertices = new ArrayList<Vertex>();
		this.edges = new ArrayList<Edge>();
	}
	
	public void addVertex(Vertex v){
		if (!this.vertices.contains(v)){
			this.vertices.add(v);
		}
	}
	
	private void addVertexList(List<Vertex> vertices){
		this.vertices.addAll(vertices);
	}
	
	public void addEdge(Vertex s, Vertex d){
		Edge e = new Edge(s, d);
		this.edges.add(e);
		s.addEdge(e);
	}
	
	private void getEdgesFromVertices(List<Vertex> vertices){
		for (int i = 0; i < vertices.size(); i++){
			IterationCounter.add();
			this.edges.addAll(vertices.get(i).getEdges());
		}
	}
	
	public List<Edge> getEdges(){
		return this.edges;
	}
	
	public Vertex getVertex(String label){
		Iterator<Vertex> itr = this.vertices.iterator();
		while (itr.hasNext()){
			IterationCounter.add();
			Vertex aux = itr.next();
			if (aux.getLabel().equals(label)){
				return aux;
			}
		}
		return null;
	}
	
	public Edge edgeExists(Vertex s, Vertex d){
		Iterator<Edge> itr = this.edges.iterator();
		while (itr.hasNext()){
			IterationCounter.add();
			Edge aux = itr.next();
			if ((aux.getSource().equals(s)) && (aux.getDestination().equals(d))){
				return aux;
			}
		}
		return null;
	}
	
	private void sortEdgesByWeight(Vertex v){
		List<Edge> edges = v.getEdges();
		Collections.sort(edges, new ComparatorEdgeWeight());
	}
	
	public List<String> getMostSearchedAfter(int q, String label){
		Vertex v = this.getVertex(label);
		if ((q > this.edges.size()) || v == null){
			return null;
		}
		List<String> result = new ArrayList<String>();
		this.sortEdgesByWeight(v);
		for (int i = 0; i < q; i++){
			IterationCounter.add();
			result.add(this.edges.get(i).getDestination().getLabel());
		}
		return result;
	}
	
	public List<String> getAllAfter(String label){
		List<String> result = new ArrayList<String>();
		Vertex root = this.getVertex(label);
		if (root == null){
			return null;
		}
		return (this.dfs_getAllAfter(root, result));
	}
	
	private List<String> dfs_getAllAfter(Vertex root, List<String> result){
		root.setState(this.VISITED);
		List<Vertex> neighbours = root.getNeighbours();
		for (int i = 0; i < neighbours.size(); i++){
			IterationCounter.add();
			Vertex aux = neighbours.get(i);
			if (aux.getState().equals(this.NOT_VISITED)){
				aux.setParent(root);
				this.dfs_getAllAfter(aux, result);
			}
		}
		root.setState(this.DONE);
		if (!result.contains(root.getLabel())){
			result.add(root.getLabel());
		}
		return result;
	}
	
	private Graph buildCycleGraph(List<Vertex> vertices){
		Graph result = new Graph();
		result.addVertexList(vertices);
		for (int i = 0; i < vertices.size(); i++){
			IterationCounter.add();
			Vertex aux = vertices.get(i);
			Edge e = this.edgeExists(aux.getParent(), aux);
			aux.addEdge(e);
		}
		this.getEdgesFromVertices(vertices);
		return result;
	}
	
	public Graph cycle_getAllConected(String label){
		List<Vertex> vertices = new ArrayList<Vertex>();
		Vertex root = this.getVertex(label);
		Graph result = this.cycle_getAllConected(root, vertices);
		if ((root == null) || (result == null)){
			return null;
		}
		return result;
	}
	
	private Graph cycle_getAllConected(Vertex root, List<Vertex> vertices){		
		boolean cycle = false;
		List<Vertex> neighbours = root.getNeighbours(); 
		while (!cycle){
			IterationCounter.add();
			int i = 0;
			Vertex aux = neighbours.get(i);
			if (root.getState().equals(this.NOT_VISITED)){
				cycle = this.hasCycle(root, vertices);
			}
			aux.setParent(root);
			i++;
		}
		if (cycle){
			return this.buildCycleGraph(vertices);
		}
		return null;
	}
	
	private boolean hasCycle(Vertex root, List<Vertex> vertices){
		boolean result = false;
		root.setState(this.VISITED);
		List<Vertex> neighbours = root.getNeighbours();
		int i = 0;
		while (!result && (i < neighbours.size())){
			IterationCounter.add();
			Vertex aux = neighbours.get(i);
			if (aux.getState().equals(this.NOT_VISITED)){
				result = this.hasCycle(aux, vertices);
				if (result){
					vertices.add(root);
				}
			}
			else if (aux.getState().equals(this.VISITED)){
				return true;
			}
			aux.setParent(root);
			i++;
		}
		root.setState(this.DONE);
		return result;
	}
	
	public void resetVerticesStates(){
		for (int i = 0; i < this.vertices.size(); i++){
			this.vertices.get(i).setState("white");
			this.vertices.get(i).setParent(null);
		}
	}
	
	public void printCycleList(Graph cycle){
		List<Vertex> vertices = cycle.vertices;
		Collections.reverse(vertices);
		for (int i = 0; i < vertices.size(); i++){
			Vertex aux = vertices.get(i);
			System.out.println("Género: " + aux.getLabel());
			System.out.println("-------> (" + aux.getEdges().get(0).getWeight() + ")");
		}
		Vertex first = vertices.get(0);
		System.out.println("Género: " + first.getLabel());
		System.out.println("-------> (" +first.getEdges().get(0).getWeight() + ")");
	}
	
	public void sortVertices(Comparator<Vertex> c){
		Collections.sort(this.vertices, c);
	}
	
}
