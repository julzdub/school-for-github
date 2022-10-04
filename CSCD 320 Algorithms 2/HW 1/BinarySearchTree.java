import java.util.*;
public class BinarySearchTree {

	private class Node {
		
		Node left;
		Node right;
		int data;

		Node(int newData) {
			left = null;
			right = null;
			data = newData;
		}

	}

	private Node root;


	private Node insert(Node node, int data) {
		if(node == null) {
			node = new Node(data);
		}
		else {
			if(data < node.data) {
				node.left = insert(node.left, data);
			}
			else {
				node.right = insert(node.right, data);
			}
		}

		return node;
	}

	public int quickSearch(int[] array, int value) {
		Node root = makeTree(array);
		int index = 0;
		index = quickSearchHelper(root, index, value);
		
		if(index <= 0) {
			return 0;
		}

		if(index >= array.length) {
			return -1;
		}

		return index;
		
	}

	private int quickSearchHelper(Node root, int index, int value) {
		if(root == null || root.data == value) {
			return index;
		}

		else if(root.data < value) {
			//System.out.print("plus 1 to index \n");
			return quickSearchHelper(root.right, index + 1, value);
		}

		return index;
	}

	private Node makeTree(int[] array) {
		Node root = null;
		for(int x=0; x<array.length; x++) {
			root = insert(root, array[x]);
		}
		return root;
	}

	
}

	