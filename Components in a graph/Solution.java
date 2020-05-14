import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    // Each item is itself a set.
    // A set may have a superset.
    // Each set is initially a set of one.  A size of zero indicates 1 item.
    public static int[] set_size;
    public static int[] set_super;

    public static int getParentSet(int a) {
        // Also optimize the tree, rehoming everything to the untimate parent.
        //  Eventually this would flatten the tree, reducing queries from O(log(n)) to O(1).
        int parent = a;
        while (set_super[parent] != 0) {
            parent = set_super[parent];
        }
        
        // rehome everything up the tree
        while (set_super[a] != 0 && set_super[a] != parent) {
            int next = set_super[a];
            set_super[a] = parent;
            a = next;
        }

        return parent;
    }
    
    public static void performMerge(int a, int b) {
        int a_parent = getParentSet(a);
        int b_parent = getParentSet(b);

        // Make B the smaller set
        if (set_size[b_parent] > set_size[a_parent]) {
            int temp = b_parent;
            b_parent = a_parent;
            a_parent = temp;
        }
        
        // Merge set B into set A
        if (a_parent != b_parent) {
            set_size[a_parent] += set_size[b_parent] + 1;
            set_super[b_parent] = a_parent;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        set_size = new int[2*n+1];
        set_super = new int[2*n+1];
        
        for (int i=0;  i < n;  i++) {
            int node1 = in.nextInt();
            int node2 = in.nextInt();
            performMerge(node1, node2);
        }
        
        int smallest = Integer.MAX_VALUE;
        int largest = Integer.MIN_VALUE;

        for (int i=1;  i <= 2*n;  i++) {
            if (set_super[i] == 0 && set_size[i] > 0) {
                //System.out.printf("set[%d] is size {%d}\n", i, set_size[i]+1);
                if (set_size[i] < smallest) smallest = set_size[i];
                if (set_size[i] > largest) largest = set_size[i];
            }
        }
        smallest++;
        largest++;
        
        System.out.println(smallest + " " + largest);
    }
}
