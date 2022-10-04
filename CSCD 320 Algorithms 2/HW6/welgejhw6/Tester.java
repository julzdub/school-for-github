import java.util.*;

public class Tester {
	public static void main(String [] args) {
		Graph wg = new Graph(8);
		wg.setEdge(0, 1, 4);
		wg.setEdge(0, 2, 6);
		wg.setEdge(0, 3, 16);
		wg.setEdge(1, 7, 24);
		wg.setEdge(2, 3, 8);
		wg.setEdge(2, 5, 5);
		wg.setEdge(2, 7, 23);
		wg.setEdge(3, 4, 21);
		wg.setEdge(3, 5, 10);
		wg.setEdge(4, 5, 14);
		wg.setEdge(4, 6, 7);
		wg.setEdge(5, 6, 11);
		wg.setEdge(5, 7, 23);
		wg.setEdge(6, 7, 9);


		System.out.print("The result of the BFS traversal starting from 0 is: \n");
		wg.breadthFirstSearch(wg, 0);
	}
}