package a02;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;

import graph.Edge;
import graph.Graph;
import graph.GraphRead;
import graph.Vertex;

/**
 * 
 * @author Yejay Demirkan
 * @author Vasiliki Ioannidou
 *
 */
public class PrimsAlgorithm {

	/** Graph from file */
	private Graph<Vertex, Edge<Vertex>> graph;
	/** HashMap saving a key value pair of vertices with their weight */
	private HashMap<Vertex, Integer> minW;
	/** HashMap saving a key value pair of vertices with their predecessors */
	private HashMap<Vertex, Vertex> pred;
	/** Vertex with the smallest ID in the graph */
	private Vertex startVertex;

	/**
	 * Constructor
	 * 
	 * @param filepath
	 */
	public PrimsAlgorithm(String filepath) {
		this.graph = GraphRead.FileToGraph(filepath, false, false, true);
		this.minW = new HashMap<Vertex, Integer>();
		this.pred = new HashMap<Vertex, Vertex>();
		this.startVertex = startVertex();
	}

	/**
	 * Determines the vertex with the smallest ID
	 * 
	 * @return the smallest vertex determined by ID
	 */
	public Vertex startVertex() {
		Collection<Vertex> vertices = graph.getVertices();

		Iterator<Vertex> iterator = vertices.iterator();

		Vertex min = iterator.next();
		Vertex value;
		while (iterator.hasNext()) {
			value = iterator.next();
			if (value.getId() < min.getId()) {
				min = value;
			}
		}
		return min;
	}

	/**
	 * Compares edges of graph to make sure given vertices belong to an edge of the
	 * graph and return their weight.
	 * 
	 * @param a the vertex whose weight is to be determined
	 * @param b the vertex whose weight is to be determined
	 * @return the weight of the edge
	 */
	public int weightfunction(Vertex a, Vertex b) {
		for (Edge<Vertex> e : graph.getEdges()) {
			if (a.equals(e.getVertexA()) && b.equals(e.getVertexB())
					|| b.equals(e.getVertexA()) && a.equals(e.getVertexB())) {
				return e.getWeight();
			}
		}
		return Integer.MAX_VALUE;
	}

	/**
	 * Calculates the weight of all vertices in minW
	 * 
	 * @return the sum of weights in minW
	 */
	public int weightOfMinW() {
		int sum = 0;
		for (Integer weight : minW.values()) {
			sum += weight;
		}
		return sum;
	}

	/**
	 * Calculates the weight of all vertices in the graph
	 * 
	 * @return the sum of weight in the graph
	 */
	public int weightOfGraph() {
		int sum = 0;
		for (Edge<Vertex> e : graph.getEdges()) {
			sum += e.getWeight();
		}
		return sum;
	}

	/**
	 * Runs Prims algorithm on a graph to determine the minimal spanning tree of the
	 * graph
	 */
	public void primMST() {
		// set initial weight of all vertices to Integer Max Value
		for (Vertex vertex : graph.getVertices()) {
			minW.put(vertex, Integer.MAX_VALUE);
		}
		// set weight of start vertex in minW to 0
		minW.put(startVertex, 0);
		// set weight of start vertex in pred to null
		pred.put(startVertex, null);

		// get the number of vertices from the graph to be used as inital capacity for
		// the priority queue
		int initialCapacity = graph.getNumberVertices();
		// create a priority queue with initial capacity as number of vertices of graph
		// and sort them using lambda from smallest to biggest by ID
		PriorityQueue<Vertex> queue = new PriorityQueue<>(initialCapacity, (a, b) -> a.getId() - b.getId());
		// add all vertices of graph to priority queue
		queue.addAll(graph.getVertices());
		// while queue is not empty
		while (queue.size() != 0) {
			// get but dont remove first element from queue
			Vertex firstElement = queue.peek();
			// while queue has a next element get a vertex from queue
			for (Vertex vertex : queue) {
				// get weight of vertex and first element from minW and compare to see which has
				// a bigger weight
				if (minW.get(vertex) < minW.get(firstElement)) {
					// if weight of vertex is smaller than weight of first element, then set vertex
					// as first element (= therefore as smallest vertex)
					firstElement = vertex;
				}
			}
			// remove first element from priority queue
			queue.remove(firstElement);
			// get neighbours of first element
			for (Vertex vertex : graph.getNeighbours(firstElement)) {
				// if queue contains vertex and weight of edge between first element and vertex
				// is smaller than weight of vertex in minW
				if (queue.contains(vertex) && weightfunction(firstElement, vertex) < minW.get(vertex)) {
					// set first element as predecessor of vertex in pred (value = predecessor to
					// key)
					pred.put(vertex, firstElement);
					// get weight of edge between first element and vertex
					int weight = weightfunction(firstElement, vertex);
					// put vertex into minW
					minW.put(vertex, weight);
				}
			}
		}
	}

	/**
	 * @return the graph
	 */
	public Graph<Vertex, Edge<Vertex>> getGraph() {
		return graph;
	}

	/**
	 * @return the minW
	 */
	public HashMap<Vertex, Integer> getMinW() {
		return minW;
	}

	/**
	 * @return the pred
	 */
	public HashMap<Vertex, Vertex> getPred() {
		return pred;
	}

	/**
	 * @return the startVertex
	 */
	public Vertex getStartVertex() {
		return startVertex;
	}
}