public class Edge {
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
}