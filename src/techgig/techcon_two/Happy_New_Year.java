package techgig.techcon_two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Prize Challenge by Techgig - TECHCON 2
 * Test 3 - CODING CHALLENGE - SEMI-PRO
 * Your Highest Score 40
 * 
 * @author kiran
 *
 */
public class Happy_New_Year {

    public static void main(String[] args) {
        /*
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int persons = scanner.nextInt();
        int []array = new int[n];
        for(int i=0; i < n; i++)
            array[i] = scanner.nextInt();
        solve(n, persons, array, false);
        */
        
        
        long st = System.currentTimeMillis();
        int []array = {9, 1, 2, 5, 20};//"{1,1,1,1,1,5,6,7},100"
        int n = array.length;
        int persons = (int)Math.pow(10, 5);
        System.out.println("S="+n+", P="+persons);
        System.out.println(Arrays.toString(array));
        solve(n, persons, array, true);
        long et = System.currentTimeMillis();
        System.out.println("Time="+(et-st)+" ms");
        
    }
    
    private static void solve(int n, int persons, int []array, boolean print) {
        int max = array[0];
        double sum = 0;
//        Find the max first
        for(int i=0; i < array.length; i++) {
            if(max < array[i])
                max = array[i];
        } 
        for(int i=0; i < array.length; i++) {
            double d = (double)max / array[i];
            sum += d;
        }
        
        int []queue =  new int[array.length];
        int personsConsidered = 0;
        for(int i=0; i < array.length; i++) {
            double d = (double)max / array[i];
            d = (d * persons) / sum;
            int l = (int)d;
            queue[i] = l;
            personsConsidered += l;
        }
        int remainingPersons = persons - personsConsidered;
        while(remainingPersons > 0) {
            long nextMaxTime = -1;
            int nextQueue = -1;
            for(int i=0; i < array.length; i++) {
                long time = array[i] * (queue[i] + 1);
                if(nextMaxTime == -1 || time < nextMaxTime) {
                    nextMaxTime = time;
                    nextQueue = i;
                }
            }
            remainingPersons --;
            queue[nextQueue] = queue[nextQueue] + 1;
        }
        if(print) {
            System.out.println("Time :"+Arrays.toString(array));
            System.out.println("Queue:"+Arrays.toString(queue));
        }
        long time = 0;
        if(print) System.out.print("Times:[");
        for(int i=0; i < array.length; i++) {
            long t = queue[i] * array[i];
            if(print && i > 0) 
                System.out.print(", ");
            if(print) System.out.print(t);
            if(i == 0 || time < t)
                time = t;
        }
        if(print) {
            System.out.print("]");
            System.out.println();
        }
        System.out.println(time);
    }

}
