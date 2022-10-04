import java.util.*;
public class Tester {
	public static void main(String [] args) {

		LinkedList q = new LinkedList();
		for(int x = 0; x<8; x++) {
			q.add(x);
		}
		Set s = new HashSet<>();

		int [] dist = {0, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};

		WeightedGraph g = new WeightedGraph(8);
		g.addEdge(1,2,9);
		g.addEdge(1,6,14);
		g.addEdge(1,7,15);
		g.addEdge(2,3,24);
		g.addEdge(3,8,19);
		g.addEdge(3,5,2);
		g.addEdge(4,3,6);
		g.addEdge(4,8,6);
		g.addEdge(5,4,11);
		g.addEdge(5,8,16);
		g.addEdge(6,5,30);
		g.addEdge(6,7,5);
		g.addEdge(6,3,18);
		g.addEdge(7,5,20);
		g.addEdge(7,8,44);

		String [] path = {" ", " ", " ", " ", " ", " ", " ", " "};

		while(q.peekFirst() != null) {
			int u = min_distance(q, dist);
			s.add(u);
			LinkedList edges = g.edges(u);
			for(int x = 0; x < edges.size(); x++) {
				Edge e = (Edge)edges.get(x);
				if(dist[x] > dist[u] + e.weight()) {
					dist[x] = dist[u] + e.weight();
					path[x] = path[u] + " " + e.toString();
				}
			}

		}

		for(int x = 0; x < path.length; x++) {
			System.out.print("path from 0 to " + x + " is " + path[x] + "\n");
		}
	}

	public static int min_distance(LinkedList q, int [] dist) {
			int u = Integer.MAX_VALUE;
			int y = 0;
			for(int x = 0; x < dist.length; x++) {				
				if(dist[x] >= 0 && dist[x] < u) {
					u = dist[x];
					dist[x] = -1;
					y = x;			
				}
			}
			return (int)q.remove(y);				
		}
}
