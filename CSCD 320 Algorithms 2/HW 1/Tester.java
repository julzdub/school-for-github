
public class Tester {
	public static void main(String args[]) {
		int index = -1;
		int[] aRay = new int [] {1, 3, 5, 7, 9, 14, 16, 19};
		
		BinarySearchTree tree = new BinarySearchTree();
		
		index = tree.quickSearch(aRay, 8);
		System.out.print("index value is: " + index + "\n");

		
		index = tree.quickSearch(aRay, 19);
		System.out.print("index value is: " + index + "\n");

		
		index = tree.quickSearch(aRay, 20);
		System.out.print("index value is: " + index + "\n");

		
		index = tree.quickSearch(aRay, 6);
		System.out.print("index value is: " + index + "\n");

		index = tree.quickSearch(aRay, -1);
		System.out.print("index value is: " + index + "\n");

	}
}