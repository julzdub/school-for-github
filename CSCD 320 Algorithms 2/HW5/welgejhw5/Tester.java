import java.util.*;

public class Tester {

    public static void main(String [] args) {
        String [] words = {"zoo", "big", "bike", "good", "apple", "moon", "mud"};
        
        
        MinHeap myheap = new MinHeap(words, 7, 7);
        myheap.buildheap();

        ArrayList sorted = new ArrayList();

        while(myheap.heapsize() > 0) {
            String cur = (String)myheap.removemin(); //remove and return the next smallest object on each call
            sorted.add(cur);
        }

        for(int i = 0; i<sorted.size(); i++) {
            System.out.print((String)sorted.get(i) + "\n");
        }

        System.out.print("Time Complexity is O(n log n)\n");
    }
}