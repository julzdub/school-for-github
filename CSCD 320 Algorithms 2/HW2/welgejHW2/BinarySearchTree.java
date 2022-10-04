public class BinarySearchTree extends Tester {

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

    public void BinarySearchTree() {
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


}
