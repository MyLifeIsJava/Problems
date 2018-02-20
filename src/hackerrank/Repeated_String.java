package hackerrank;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Problem definition :  https://www.hackerrank.com/challenges/repeated-string/problem
 * 
 * @author kiran
 *
 */
public class Repeated_String {

    static long repeatedString(String s, long n) {
        long retVal = 0;
        if(s != null && s.length() > 0) {
            Map<Integer, Integer> map = new LinkedHashMap<>();
            int count = 0;
            for(int i=0; i < s.length(); i++) {
                char c = s.charAt(i);
                if(c == 'a') {
                    count++;
                }
//              a's till ith position
                map.put(i, count);
            }
            long quotient = n / s.length();
            long reminder = n % s.length();
            retVal = count * quotient;
            if(reminder > 0) {
                long val = 0;
                for(int position : map.keySet()) {
                    if(position >= reminder)
                        break;
                    val = map.get(position); 
                }
                retVal += val;
            }
        }
        return retVal;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        long n = in.nextLong();
        long result = repeatedString(s, n);
        System.out.println(result);
        in.close();
    }

}
