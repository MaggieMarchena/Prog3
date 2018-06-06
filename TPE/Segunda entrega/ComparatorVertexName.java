package util;

import java.util.Comparator;

import graph.Vertex;

public class ComparatorVertexName implements Comparator<Vertex> {

	//CONSTRUCTORS
	public ComparatorVertexName() {
	}

	/**
	 * Compara los nombres de los g�neros para ordenarlos de forma alfab�tica
	 */
	@Override
	public int compare(Vertex v1, Vertex v2) {
		return (v1.getLabel().compareTo(v2.getLabel()));
	}
}
