import javax.naming.CompositeName;

public class BinaryTree {

    private class Node {
        Node left;
        Node right;
        Comparable data;

        Node(Comparable newData) {
            left = null;
            right = null;
            data = newData;
        }
    }

    private Node root; //root of tree

    public void BinaryTree() {
        root = null;
    }

    public void insert(Comparable data) {
        root = insert(root, data);
    }

    private Node insert(Node node, Comparable data) {
        if(node == null){
            return new Node(data);
        }
        else {
            if(0 > data.compareTo(node.data)) {
                node.left = insert(node.left, data);
            }
            else {
                node.right = insert(node.right, data);
            }
        }

        return node;
    }

    public void printTreeInOrder() { //in order traversal
        printTreeInOder(root);
        System.out.println();
    }

    private void printTreeInOder(Node node) {
        if(node == null) return; // base case

        printTreeInOder(node.left);
        System.out.print(node.data + " ");
        printTreeInOder(node.right);
    }

    public void printTreePostOrder() { //post order traversal
        printTreePostOder(root);
        System.out.println();
    }

    private void printTreePostOder(Node node) {
        if(node == null) return;

        printTreePostOder(node.left);
        printTreePostOder(node.right);
        System.out.print(node.data + " ");
    }

    public boolean delete(Comparable toRemove) {
        if(root.data.compareTo(toRemove) == 0) {
            removeRoot();
            return true;
        }

        if(root.data.compareTo(toRemove) > 0) {
            root.left = delete(root.left, toRemove);
            return true;
        }

        if(root.data.compareTo(toRemove) < 0) {
            root.right = delete(root.right, toRemove);
            return true;
        }

        return false;
    }

    private Node delete(Node node, Comparable toRemove) {
        if(node == null) return null;

        if(node.data.compareTo(toRemove) == 0) {
            Node rootTemp = this.root;
            root = node;
            removeRoot();
            Node secondTemp = root;
            root = rootTemp;
            return secondTemp;
        }

        if(node.data.compareTo(toRemove) > 0) {
            node.right = delete(node.right, toRemove);
            return node;
        }

        if(node.data.compareTo(toRemove) < 0) {
            node.left = delete(node.left, toRemove);
            return node;
        }



        return null;
    }

    public boolean removeRoot() {
        if(root == null) return false;

        if(root.left != null && root.right != null) {
            root.left = removeRoot(root.left);
            return true;
        }

        if(root.right != null) {
            root = root.right;
            return true;
        }

        root = root.left;
        return true;
    }

    private Node removeRoot(Node node) {
        if(node == null) throw new IllegalArgumentException("node passsed in is null");

        if(node.right == null && node.left == null) {
            root.data = node.data;
            return null;
        }

        if(node.right != null) {
            node.right = removeRoot(node.right);
            return node;
        }

        root.data = node.data;
        return node.left;
    }

    public BinaryTree buildTree(Object inOrder[], Object postOrder[]) {
        if(inOrder == null || postOrder == null) {
            throw new IllegalArgumentException("params are null");
        }

        if(inOrder.length <= 1 || postOrder.length <= 1) {
            BinaryTree newTree = new BinaryTree();
            newTree.insert((Comparable) postOrder[0]);
            return newTree;
        }

        Object [] leftInOrder;
        Object [] leftPostOrder;
        Object [] rightInOrder;
        Object [] rightPostOrder;

        BinaryTree newTree = new BinaryTree();
        //System.out.println("initial insert: " + postOrder[postOrder.length-1]);
        newTree.insert((Comparable) postOrder[postOrder.length -1]);

        int x;
        for(x = 0; ! inOrder[x].equals(postOrder[postOrder.length-1]); x++) {} //figuring out how long to make new sublists

        //System.out.println(x);

        leftInOrder = new Object [x];
        leftPostOrder = new Object [x];

       // System.out.println("left in order length " + leftInOrder.length);
       // System.out.println("left post order length " + leftPostOrder.length);

        for(x = 0; x < leftInOrder.length; x++) {
            leftInOrder[x] = inOrder[x];
            leftPostOrder[x] = postOrder[x];

         //   System.out.println("element added to leftInOrder: " + leftInOrder[x]);
         //   System.out.println("element added to leftPostOrder: " + leftPostOrder[x]);
        }

        rightInOrder = new Object[(inOrder.length - leftInOrder.length) - 1]; //minus 1 is the root I dont want to copy
        rightPostOrder = new Object[rightInOrder.length];

        //System.out.println("right in order length " + rightInOrder.length);
        //System.out.println("right post order length " + rightPostOrder.length);

        for(x = 0; x < rightInOrder.length; x++) {
            rightInOrder[x] = inOrder[leftInOrder.length + x + 1];
            rightPostOrder[x] = postOrder[leftPostOrder.length + x];
            
          //  System.out.println("element added to rightInOrder: " + rightInOrder[x]);
          //  System.out.println("element added to rightPostOrder: " + rightPostOrder[x]);
        }



        newTree.root.left = buildTreeHelper(leftInOrder, leftPostOrder);
        newTree.root.right = buildTreeHelper(rightInOrder, rightPostOrder);

        return newTree;
    }

    private Node buildTreeHelper(Object inOrder[], Object postOrder[]) {
        if(inOrder == null || postOrder == null) {
            throw new IllegalArgumentException("params are null");
        }

        if(postOrder.length == 0) {
            return null;
        }

        if(postOrder.length == 1) {
            //System.out.println("returning node " + inOrder[0]);
            return new Node((Comparable) inOrder[0]);
        }

        Object [] leftInOrder;
        Object [] leftPostOrder;
        Object [] rightInOrder;
        Object [] rightPostOrder;
        
        Node nn = new Node((Comparable) postOrder[postOrder.length-1]); //make root from list into a node
        
        int x;
        for(x = 0; ! inOrder[x].equals(postOrder[postOrder.length-1]); x++) {} //figuring out how long to make new sublists
                                                                                //finds the next root in the list
        //System.out.println(x);


        leftInOrder = new Object [x];
        leftPostOrder = new Object [x];

        //System.out.println("left in order length " + leftInOrder.length);
        //System.out.println("left post order length " + leftPostOrder.length);
        
        for(x = 0; x < leftInOrder.length; x++) {
            leftInOrder[x] = inOrder[x];
            leftPostOrder[x] = postOrder[x];

            //System.out.println("element added to leftInOrder: " + leftInOrder[x]);
            //System.out.println("element added to leftPostOrder: " + leftPostOrder[x]);
        }

        rightInOrder = new Object[(inOrder.length - leftInOrder.length) - 1]; //minus 1 is the root I dont want to copy
        rightPostOrder = new Object[rightInOrder.length];


        //System.out.println("right in order length " + rightInOrder.length);
        //System.out.println("right post order length " + rightPostOrder.length);

        for(x = 0; x < rightInOrder.length; x++) {
            rightInOrder[x] = inOrder[leftInOrder.length + x + 1];
            rightPostOrder[x] = postOrder[leftPostOrder.length + x];
            
            //System.out.println("element added to rightInOrder: " + rightInOrder[x]);
            //System.out.println("element added to rightPostOrder: " + rightPostOrder[x]);
        }

        

        nn.left = buildTreeHelper(leftInOrder, leftPostOrder);
        nn.right = buildTreeHelper(rightInOrder, rightPostOrder);

        return nn;

    }
}
