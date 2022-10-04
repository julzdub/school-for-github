import java.util.*;

public class Tester {

    public static void main(String [] args) {
        Object [] inOrderSequence = {9, 5, 1, 7, 2, 12, 8, 4, 3, 11};
        Object [] postOrderSequence = {9, 1, 2, 12, 7, 5, 3, 11, 4, 8};
        BinaryTree myTree = new BinaryTree();
        myTree = myTree.buildTree(inOrderSequence, postOrderSequence);

        System.out.println("in Order: ");
        myTree.printTreeInOrder();
        System.out.println("in Post Order: ");
        myTree.printTreePostOrder();
    }
}
