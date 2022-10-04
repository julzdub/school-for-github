public class Tester {
    public static void main(String[] args) {

        Trie2 tr = new Trie2();

        tr.insertString("hello");
        tr.insertString("hell");
        tr.insertString("he");
        tr.insertString("ant");
        tr.insertString("child");
        tr.insertString("apple");
        tr.insertString("ape");
        tr.insertString("bike");
        tr.insertString("bake");
        tr.insertString("cat");
        tr.insertString("file");
        tr.insertString("pen");
        tr.insertString("did");

        System.out.println(tr.wordsPrefixedBy("ap"));
        System.out.println(tr.wordsPrefixedBy("he"));

    }
}
