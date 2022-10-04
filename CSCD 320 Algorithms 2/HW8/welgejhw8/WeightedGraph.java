import java.util.*;

public class WeightedGraph {
	private int v; //number of vertices
	private LinkedList [] vertices;

	public WeightedGraph(int i) {
		this.v = i;
		vertices = new LinkedList [v];
		for(int x = 0; x<i; x++) {
			vertices[x] = new LinkedList();
		}
	}

	public void addEdge(int v, int x, int weight) {vertices[v].add(new Edge(v, x, weight));}

	public LinkedList edges(int v) {return vertices[v];}

	public int getVertices() {return this.v;}
}