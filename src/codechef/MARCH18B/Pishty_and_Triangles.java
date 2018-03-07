package codechef.MARCH18B;

import java.util.Scanner;

/**
 * Problem statement :  https://www.codechef.com/MARCH18B/problems/PSHTRG
 * 
 * Status : My implementation is wrong. I am assuming 3 consecutive numbers for a triangle.
 *          But we should consider any 3 numbers in the given range, not just the consecutive ones.
 *          This makes life hard :-(
 *          
 * @author kiran
 *
 */
public class Pishty_and_Triangles {

    public static void main(String[] args) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            int q = scanner.nextInt();
            data= new int[n];
            for(int i=0; i < n; i++) {
                data[i] = scanner.nextInt();
            }
            initialize();
            
            for(int i=0; i< q; i++) {
                int type = scanner.nextInt();
                if(type == 1) {
                    int pos = scanner.nextInt();
                    int val = scanner.nextInt();
                    changeValue(pos-1, val);
                }else {
                    int left = scanner.nextInt();
                    int right = scanner.nextInt();
//                  Convert to ZERO-based indexes
                    left = left - 1;
                    right = right - 1;
                    long l = getHighestPerimiter(left, right);
                    System.out.println(l);
                }
            }
        }catch(Throwable th) {
            th.printStackTrace();
        }finally {
            if(scanner != null)
                scanner.close();
        }
    }

    private static long getHighestPerimiter(int l, int r) {
        long retVal = 0;
        r -= 2; //We will have to consider from l to r-2, thats how we have created the 'perimeters' and 'triangles' arrays
        if(r >= l) {
            for(int i=l; i <= r; i++) {
                if(triangles[i] && perimeters[i] > retVal) {
                    retVal = perimeters[i];
                }
            }
        }
        return retVal;
    }
    private static void changeValue(int index, int val) {
        int oldVal = data[index];
        if(oldVal == val) //Nothing to do
            return;
        data[index] = val;
        int start = Math.max(0, index - 2);
        int end = Math.min(data.length - 1, index + 2);
        for(int i=start; i <= end; i++) {
            setValuesForData(i);
        }
    }
    private static void setValuesForData(int i) {
        if(i > data.length-3)
            return;
        
        int a = data[i];
        int b = data[i+1];
        int c = data[i+2];
        perimeters[i] = (long)a+b+c;
//      Check whether this is a valid triangle or not
        if(a+b > c && a+c > b && b+c > a) {
//            Valid triangle : Sum of any two sides is greater than the third side
            triangles[i] = true;
        }else {
            triangles[i] = false;
        }
    }
    private static void initialize() {
        int n = data.length;
        if(n < 3)
            return;
        perimeters = new long[n];
        triangles = new boolean[n];
        for(int i=0; i <= n-3; i++) {
            setValuesForData(i);
        }
    }
    
    private static long []perimeters = null;
    private static boolean []triangles = null;
    private static int []data = null;
}
