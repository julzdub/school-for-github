import java.util.*;

public class Graph {
	private int [][] matrix;
	private int numEdge;
	public int [] mark;

	final int VISITED = 1;
	final int UNVISITED = 0;

	public Graph(int n) {
		mark = new int[n];
		matrix = new int[n][n];
		numEdge = 0;
	}

	public int n() {return mark.length;}
	public int e() {return numEdge;}

	public Edge first(int v) {
		for(int i = 0; i<mark.length; i++) {
			if(matrix[v][i] != 0) {
				return new Edge(v, i);
			}
		}
		return null;
	}

	public Edge next(Edge w) {
		if(w == null) {
			return null;
		}
		for(int i = w.v2()+1; i<mark.length; i++) {
			if(matrix[w.v1()][i] != 0) {
				return new Edge(w.v1(), i);
			}
		}
		return null;
	}

	public boolean isEdge(Edge w) {
		if(w == null) return false;
		else return matrix[w.v1()][w.v2()] != 0;
	}

	public boolean isEdge(int i, int j) {
		return matrix[i][j] != 0;
	}

	public int v1(Edge w) {
		return w.v1();
	}

	public int v2(Edge w) {
		return w.v2();
	}

	public void setEdge(int i, int j, int wt) {
		assert (wt!=0) : "can't have weight to 0";
		if(matrix[i][j] == 0) numEdge++;
		matrix[i][j] = wt;
	}

	public void setEdge(Edge w, int weight) {
		if(w != null) setEdge(w.v1(), w.v2(), weight);
	}

	public void delEdge(Edge w) {
		if(w != null) {
			if(matrix[w.v1()][w.v2()] != 0) {
				matrix[w.v1()][w.v2()] = 0;
				numEdge--;
			}
		}
	}

	public int weight(int i, int j) {
		if(matrix[i][j] == 0) {
			return Integer.MAX_VALUE;
		}
		else return matrix[i][j];
	}

	public int weight(Edge w) {
		assert w!=null : "edge is null";
		if(matrix[w.v1()][w.v2()] == 0) {
			return Integer.MAX_VALUE;
		}
		else return matrix[w.v1()][w.v2()];
	}

	public void setMark(int v, int val) {
		mark[v] = val;
	}

	public int getMark(int v) {
		return mark[v];
	}

	public void breadthFirstSearch(Graph g, int start) {
		Queue q = new LinkedList<Integer>();
		q.add(start);
		g.setMark(start, VISITED);

		while(!q.isEmpty()) {
			int v = (int)q.remove();
			System.out.print(v + "\n");
			for(Edge w = g.first(v); g.isEdge(w); w = g.next(w)) {
				if(g.getMark(g.v2(w)) == UNVISITED) {
					g.setMark(g.v2(w), VISITED);
					q.add(g.v2(w));
				}
			}
		}
	}

}