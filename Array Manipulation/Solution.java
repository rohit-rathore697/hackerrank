import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static void print(long[] arr){
        for(long i : arr){
            System.out.println(i+" ");
        }
        System.out.println();
    }


    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {
        long res = 0;
        long[] arr = new long[n];
        int i , a , b , k;
        for(i = 0 ; i < queries.length ; i++){
            a = queries[i][0] - 1;
            b = queries[i][1] - 1;
            k = queries[i][2];
            arr[a] += (long)k;
            if(b < n-1){
                arr[b+1] -= (long)k;
            }
            //print(arr);
        }
        for(i = 1 ; i < n ; i++){
            arr[i] += arr[i-1];
            //print(arr);
            if(arr[i] >= res){
                res = arr[i];
            }
        }
        return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
