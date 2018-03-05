package hackerrank.algorithms;

import java.util.Scanner;

public class AppendAndDelete {

    static String appendAndDelete(String s, String t, int k) {
        int s_length = s.length();
        int t_length = t.length();
        int mismatchIndex = 0;
        for(; mismatchIndex < s_length && mismatchIndex < t_length; mismatchIndex++) {
            if(s.charAt(mismatchIndex) != t.charAt(mismatchIndex))
                break;
        }
        int charsToDelete = s_length - mismatchIndex;
        int charsToInsert = t_length - mismatchIndex;
        int minOperations = charsToDelete + charsToInsert;
        if(minOperations == k){
            return "Yes";
        }
        else if(k < minOperations) {
            return "No";
        }
        else {
            int extraOps = k - minOperations;
            if(extraOps % 2 == 0)
                return "Yes";
            if(extraOps >= (2 * (s_length - charsToDelete)))
                return "Yes";
            return "No";
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String t = in.next();
//        while(true) {
            int k = in.nextInt();
            String result = appendAndDelete(s, t, k);
            System.out.println(result);
//        }
        in.close();
    }

}
