package techgig.techcon_two;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

/**
 * Prize Challenge by Techgig - TECHCON 2
 * Test 3 - CODING CHALLENGE - SEMI-PRO
 * Your Highest Score 100
 * 
 * @author kiran
 *
 */
public class Happy_New_Year {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int persons = scanner.nextInt();
        int []array = new int[n];
        for(int i=0; i < n; i++)
            array[i] = scanner.nextInt();
        solve(n, persons, array, false);
        
    }
    
    private static void solve_remaining(int persons, int []array, int []queue, boolean print) {
        TreeMap<Long, Set<Integer>> multipliersMap = new TreeMap<>();
        for(int i=0; i < array.length; i++) {
            int x = array[i];
            long lx = (long)x * (queue[i] + 1); //Since current queue is handled, try for one more person in this queue
            Set<Integer> set = multipliersMap.get(lx);
            if(set == null) {
                set = new HashSet<>();
                multipliersMap.put(lx, set);
            }
            set.add(i);
        }
        long minTime = 0;
        while(persons > 0) {
            Entry<Long, Set<Integer>> entry = multipliersMap.firstEntry();
            long currMinTime = entry.getKey();
            minTime = currMinTime;
            Set<Integer> indices = entry.getValue();
            for(Integer index : indices) {
                persons --;
                if(persons == 0)
                    break;
                
                long newVal = currMinTime + array[index];
                Set<Integer> indices2 = multipliersMap.get(newVal);
                if(indices2 == null) {
                    indices2 = new HashSet<>();
                    multipliersMap.put(newVal, indices2);
                }
                indices2.add(index);
            }
            
            multipliersMap.remove(currMinTime);
        }
        System.out.println(minTime);
    }
    
    private static void solve(int n, int persons, int []array, boolean print) {
        Arrays.sort(array);
        int max = array[0];
        double sum = 0;
//        Find the max first
        for(int i=0; i < array.length; i++) {
            if(max < array[i])
                max = array[i];
        } 
        double []ratioArray = new double[n];
        for(int i=0; i < array.length; i++) {
            ratioArray[i] = (double)max / array[i];
            sum += ratioArray[i];
        }
        if(print)
            System.out.println("Max="+max+", Sum="+sum);
        int []queue =  new int[array.length];
        int personsConsidered = 0;
        for(int i=0; i < array.length; i++) {
            double d = ratioArray[i];
            d = (d * persons) / sum;
            int l = (int)d;
            queue[i] = l;
            personsConsidered += l;
        }
        ratioArray = null;
        int remainingPersons = persons - personsConsidered;
        if(print)
            System.out.println("personsConsidered="+personsConsidered+", Handling remaining persons="+remainingPersons);
        if(remainingPersons > 0) {
//            Let us solve the remaining with a different approach
            solve_remaining(remainingPersons, array, queue, print);
        }else {
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

}
