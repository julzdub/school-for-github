import java.util.ArrayList;

public class Tester  {
    public static void main(String [] args) {
        ArrayList<Comparable> comparableArrayList = new ArrayList<Comparable>();
        comparableArrayList.add(8);
        comparableArrayList.add(3);
        comparableArrayList.add(10);
        comparableArrayList.add(1);
        comparableArrayList.add(6);
        comparableArrayList.add(14);
        comparableArrayList.add(4);
        comparableArrayList.add(7);
        comparableArrayList.add(13);
        BinarySearchTree myBTS = new BinarySearchTree();

        for(int x = 0; x < 9; x++) {
            myBTS.insert(comparableArrayList.get(x));
        }

        myBTS.printTreeInOrder();
        System.out.print("\n");
        
        myBTS.printTreePostOrder();
        System.out.print("\n");

        myBTS.delete(new Integer(8));

        myBTS.printTreeInOrder();
        System.out.print("\n");
        
        myBTS.printTreePostOrder();
        System.out.print("\n");

        myBTS.delete(new Integer(10));

        myBTS.printTreeInOrder();
        System.out.print("\n");
        
        myBTS.printTreePostOrder();
        System.out.print("\n");
    }
}
//With PostOrder you know that the last number is the root so you should be able to see that after both left and right subtree has been printed.
//With inOrder the root should be in the middle of the left and right subtrees