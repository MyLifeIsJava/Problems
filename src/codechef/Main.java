package codechef;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Problem statement : https://www.codechef.com/MARCH18B/problems/GCDCNT
 * 
 * @author kiran
 *
 */
public class Main {

    public static void main(String[] args)  throws java.lang.Exception{
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int []data = new int[n];
        for(int i=0; i < n; i++) {
            data[i] = scanner.nextInt();
        }
        int q = scanner.nextInt();
        Map<Integer, Integer> gcdMap = new HashMap<>();
        for(int i=0; i < q; i++) {
            int type = scanner.nextInt();
            if(type == 1) {
                int x = scanner.nextInt() - 1;
                int y = scanner.nextInt();
                data[x] = y;
            }else {
                int count = 0;
                int l = scanner.nextInt() - 1;
                int r = scanner.nextInt() - 1;
                int g = scanner.nextInt();
                for(int k=l; k <= r; k++) {
//                    if GCD(g, data[k]) is 1, then increment the count
                    Integer gcd = gcdMap.get(data[k]);
                    if(gcd == null) {
                        gcd = getGCD(g, data[k]);
                        gcdMap.put(data[k], gcd);
                    }
                    if(gcd.intValue() == 1)
                        count ++;
                }
                System.out.println(count);
            }
        }
    }

    public static int getGCD(int min, int max) {
        if(min > max) {
            return getGCD(max, min);
        }
        int gcd = 0;
        int remainder = max % min;
        while(remainder != 0) {
            max = min;
            min = remainder;
            remainder = max % min;
        }
        gcd = min;
        return gcd;
    }
}
