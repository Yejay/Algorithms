package graphTest;

import graph.Edge;
import graph.Graph;
import graph.GraphRead;
import graph.Vertex;

public class GraphDemo {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph<Vertex, Edge<Vertex>> G = new Graph<Vertex, Edge<Vertex>>(false);
		
		// 3 Knoten generieren
		Vertex v1 = new Vertex(5);
		Vertex v2 = new Vertex(10);
		Vertex v3 = new Vertex(15);
		
		// Knoten zum Graphen hinzufuegen
		G.addVertex(v1);
		G.addVertex(v2);
		G.addVertex(v3);
		
		// 3 Kanten erzeugen
		Edge<Vertex> e1 = new Edge<Vertex> (v1, v2);
		Edge<Vertex> e2 = new Edge<Vertex> (v2, v3);
		Edge<Vertex> e3 = new Edge<Vertex> (v1, v3);
		
		// Kanten zum Graphen hinzufuegen
		G.addEdge(e1);
		G.addEdge(e2);
		G.addEdge(e3);
		
		System.out.println("G: " + G);
		
		// Iterieren durch alle Nachbarn von v1
		System.out.println("\nDurch alle Nachbarn iterieren:");
		for (Vertex v: G.getNeighbours(v1)) {
			System.out.println(v + " ist Nachbar von " + v1);
		}
		
		// Iterieren durch alle inzidenten Kanten von v1
		System.out.println("\nDurch alle inzidenten Kanten iterieren:");
		for (Edge<Vertex> e : G.getIncidentEdges(v1)) {
			System.out.println(e + " ist inzident zu " + v1);
		}
		
		// Einlesen eines Graph
		
		Graph<Vertex,Edge<Vertex>> mst_graph = GraphRead.FileToGraph("bsp_mst_1.txt",false, false,true);
		System.out.println("\nMst_graph: " + mst_graph);
	}
}
