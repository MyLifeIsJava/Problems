package hackerrank.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Problem statement : https://www.hackerrank.com/challenges/divisible-sum-pairs/problem
 * Status : Completed
 * 
 * @author kiran
 *
 */
public class Divisible_Sum_Pairs {
    public static void main(String []args) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int []data = new int[n];
            for(int i=0; i <n; i++) {
                data[i] = scanner.nextInt();
            }
//            Print the number of  pairs where  and  +  is evenly divisible by .
            
            int result = divisibleSumPairs(n, k, data);
            
            System.out.println(result);
        }finally {
            scanner.close();
        }
    }
    
    /*            
    My Logic: a[i]+a[j] is divisible by k when (a[i]+a[j])%k=0
    This should imply a[i]%k+a[j]k=k
    So the problem gets reduced to sum of two array items (actually the modulo k) equal to k
    */ 
    static int divisibleSumPairs(int n, int k, int[] data) {
        int result = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i < n; i++) {
            int value = data[i];
            int remainder = value % k;
            int difference = remainder == 0 ? 0 : (k - remainder);
                            
            List<Integer> pairCandidates = map.get(difference);
            if(pairCandidates != null && !pairCandidates.isEmpty()) {
//                Current element can be combined will all these elements
                result += pairCandidates.size();
            }
            pairCandidates = map.get(remainder);
            if(pairCandidates == null) {
                pairCandidates = new ArrayList<>();
                map.put(remainder, pairCandidates);
            }
            pairCandidates.add(i);
        }
        return result;
    }
}
