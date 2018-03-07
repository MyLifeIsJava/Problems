package codechef.MARCH18B;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/**
 * Problem statement : https://www.codechef.com/MARCH18B/problems/GCDCNT
 * NOTE: Use the class name "Main" when submitting at codechef.com
 * 
 * @author kiran
 *
 */
public class Chef_and_Gcd_Queries {

    public static void main(String[] args)  throws java.lang.Exception{
        /*
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int []data = new int[n];
        for(int i=0; i < n; i++) {
            data[i] = scanner.nextInt();
        }
        int q = scanner.nextInt();
        for(int i=0; i < q; i++) {
            int type = scanner.nextInt();
            if(type == 1) {
                int x = scanner.nextInt() - 1;
                int y = scanner.nextInt();
                data[x] = y;
            }else {
                int l = scanner.nextInt() - 1;
                int r = scanner.nextInt() - 1;
                int g = scanner.nextInt();
                int result = heckGCD(data, l, r, g);
                System.out.println(result);
            }
        }*/
        
        int limit_small = 1000;
        int limit_large = 50000;
        int limit = limit_large;
        
        int n = limit;
        int q = limit;
        Random rand = new Random();
        int []data = new int[n];
        for(int i=0; i < n; i++) {
            rand = new Random();
            data[i] = rand.nextInt(100000);
            if(data[i] == 0)
                data[i] = 100000;
        }

        long totalTime = 0;
        
        for(int i=0; i < q; i++) {
            rand = new Random();
            int g = rand.nextInt(100000);
            if(g == 0)
                g = 100000;
            rand = new Random();
            int l = rand.nextInt(n);
            int r = rand.nextInt(n);
            if(l > r) {
                int t = l;
                l = r;
                r = t;
            }
            long st1 = System.currentTimeMillis();
            int ans = checkGCD(data, l, r, g);
            long et1 = System.currentTimeMillis();

            long time = et1 - st1;
            totalTime += time;
            System.out.println("i="+i+", g="+g+", ans="+ans+", time="+time+" ms");
        }
        System.out.println(totalTime+" ms");
    }

    private static int checkGCD(int []data, int l, int r, int g) {
        int count = 0;
        Map<Integer, Boolean> gcdMap = new HashMap<>();
        for(int k=l; k <= r; k++) {
//            if GCD(g, data[k]) is 1, then increment the count
            Boolean gcd_one = gcdMap.get(data[k]);
            if(gcd_one == null) {
                gcd_one = isGCDOne(g, data[k]);
                gcdMap.put(data[k], gcd_one);
            }
            if(gcd_one.booleanValue())
                count ++;
        }
        return count;
    }
    
    public static boolean isGCDOne(int min, int max) {
//      GCD of 2 even number is atleast 2
        if(min % 2 == 0 && max % 2 == 0)
            return false;
        
        if(min > max) {
            return isGCDOne(max, min);
        }
        int gcd = 0;
        int remainder = max % min;
        while(remainder != 0) {
            max = min;
            min = remainder;
            remainder = max % min;
        }
        gcd = min;
        return gcd == 1;
    }
}
