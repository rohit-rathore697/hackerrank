import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static int unitHourGlass(int[][] a, int i, int j, int n, int m) {
        int res = 0;
        if ((i >= 1) && (j >= 1) && (i < n) && (j < m)) {
            res += a[i][j];
            res += a[i+1][j-1] + a[i+1][j] + a[i+1][j+1];
            res += a[i-1][j-1] +a[i-1][j] +a[i-1][j+1];
        }
        System.out.print(res+" ");
        return res;
    }
    static int max(int a , int b){
        if(a >b){
            return a;
        }
        return b;
    }

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        int l = arr.length;
        int w = arr[0].length;
        int res = Integer.MIN_VALUE;
        int i , j;
        for(i = 1 ; i < l - 1 ; i++){
            for(j = 1 ; j < w -1 ; j++){
                res = max(res , unitHourGlass(arr , i , j , l , w));
            }            
        }
        return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
