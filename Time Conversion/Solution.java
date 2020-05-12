import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
        /*
         * Write your code here.
         */
         String res = "";
        String hrs = s.substring(0, 2);
        String min = s.substring(3, 5);
        String sec = s.substring(6, 8);
        String ampm = s.substring(8);
        int hr = Integer.parseInt(hrs);
        if((ampm.equalsIgnoreCase("PM")) && (hr != 12)) {
            hr += 12;
            if(hr >= 24) {
                hr = 24 - hr;
            }
        }
        else if(ampm.equalsIgnoreCase("AM")) {
            if(hr == 12) {
                hr = 0;
            }
        }
        if(hr < 10) {
            res = res + "0" + Integer.toString(hr);
        }
        else {
            res += Integer.toString(hr);
        }
        res = res +":" +min +":" + sec;
        return res;
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scan.nextLine();

        String result = timeConversion(s);

        bw.write(result);
        bw.newLine();

        bw.close();
    }
}
