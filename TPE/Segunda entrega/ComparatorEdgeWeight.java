package util;

import java.util.Comparator;

import graph.Edge;

public class ComparatorEdgeWeight implements Comparator<Edge> {

	public ComparatorEdgeWeight() {
	}

	@Override
	public int compare(Edge e1, Edge e2) {
		return (e1.getWeight().compareTo(e2.getWeight()));
	}

}
