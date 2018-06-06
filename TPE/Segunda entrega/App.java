package app;

import java.util.Collections;
import java.util.List;

import graph.Edge;
import graph.Graph;
import graph.Vertex;
import util.CSVReader;
import util.ComparatorVertexName;

public class App {
	
	private CSVReader reader;
	private Graph genreGraph;

	public App() {
		this.reader = new CSVReader();
		this.genreGraph = new Graph();
	}
	
	public void createGenreGraph(String fileName){
		List<String[]> data = this.reader.readFile(fileName);
		for (int i = 0; i < data.size(); i++){
			String[] entry = data.get(i);
			for (int j = 1; j < entry.length; j++){
				String genre = entry[j-1];
				String genreDest = entry[j];
				Vertex source = this.genreGraph.getVertex(genre);
				Vertex destination = this.genreGraph.getVertex(genreDest);			
				if (source == null){
					source = new Vertex(genre);					
				}
				if (destination == null){
					destination = new Vertex(genreDest);			
				}
				Edge e = this.genreGraph.edgeExists(source, destination);
				if (e == null){
					this.genreGraph.addEdge(source, destination);
				}
				else {
					e.addWeight();
				}
				this.genreGraph.addVertex(source);
			}
		}
		this.genreGraph.sortVertices(new ComparatorVertexName());
	}
	
	public List<String> getMostSearchedAfter(int q, String genre){
		List<String> result = this.genreGraph.getMostSearchedAfter(q, genre);
		if (result == null){
			return null;
		}
		return result;
	}
	
	public List<String> getAllAfter(String genre){
		this.genreGraph.resetVerticesStates();
		List<String> result = this.genreGraph.getAllAfter(genre);
		if (result == null){
			return null;
		}
		Collections.reverse(result);
		return result;
	}
	
	public Graph getCycleGraph(String genre){
		this.genreGraph.resetVerticesStates();
		Graph result = this.genreGraph.cycle_getAllConected(genre);
		if (result == null){
			return null;
		}
		return result;
	}

}
