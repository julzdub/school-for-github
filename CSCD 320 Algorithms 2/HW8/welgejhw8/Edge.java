import java.util.*;

public class Edge implements Comparable<Edge> {
	private int vert1;
	private int vert2;
	private int weight;

	public Edge(int v1, int v2, int wt) {
		this.vert1 = v1;
		this.vert2 = v2;
		this.weight = wt;
	}

	public Edge(int v1, int v2) {
		this.vert1 = v1;
		this.vert2 = v2;
	}

	public int v1() {return this.vert1;}
	public int v2() {return this.vert2;}
	public int weight() {return this.weight;}


	public int compare(Edge e, Edge f) {
		if (e.weight < f.weight) return -1;		
		if (e.weight > f.weight) return +1;		
		return 0;
	}
	
	public int compareTo(Edge that)	
	{		
		if(this.weight < that.weight) return -1;		
		else if (this.weight > that.weight) return +1;		
		else return  0;
	}

	public String toString() {
		String s = this.vert1 + " -> " + this.vert2 + " ";
		return s;
	}

}