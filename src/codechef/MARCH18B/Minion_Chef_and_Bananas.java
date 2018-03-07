package codechef.MARCH18B;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Problem definition :
 * Status : Fine according to me, but codechef gives ERROR
 * 
 * @author kiran
 *
 */
public class Minion_Chef_and_Bananas {

    public static void main(String[] args) {
        
        /*
        Constraints
        1 ≤ T ≤ 10
        1 ≤ N ≤ 10^5
        N ≤ H ≤ 10^9
        1 ≤ Ai ≤ 10^9 for each valid i
        */
        
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for(int a=0; a < t; a++) {
            int n = scanner.nextInt();
            int h = scanner.nextInt();
            int []pile = new int[n];
            int maxPileSize = 0;
            for(int i=0; i<n; i++) {
                pile[i] = scanner.nextInt();
                if(pile[i] > maxPileSize)
                    maxPileSize = pile[i];
            }
            int val = solve(n, h, pile, maxPileSize);
            System.out.println(val);
        }
        scanner.close();
        
        /*
        int t = 10;
        long totalTime = 0;
        for(int i=0; i < t; i++) {
            int n = 100000;
            int limit = 1000000000;
            Random rand = new Random();
            int h = n - 1;
            while(h < n) {
                h = rand.nextInt(limit);
            }
            
            int []pile = new int[n];
            int maxPileSize = 0;
            for(int j=0; j < n ; j++) {
                rand = new Random();
                while(pile[j] == 0) {
                    pile[j] = rand.nextInt(limit);
                    if(maxPileSize < pile[j])
                        maxPileSize = pile[j];
                }
            }
            System.out.println("n="+n+", h="+h);
            long st = System.currentTimeMillis();
            solve(n, h, pile, maxPileSize);
            long et = System.currentTimeMillis();
            long time = et-st;
            totalTime += time;
            System.out.println("Test Casse: "+i+", time="+time+" ms");
        }
        System.out.println("Total time="+totalTime+" ms");
        */
    }
    
    private static int solve(int n, int h, int []pile, int maxPileSize) {
        if(h == n || n == 1) {
//          If number of hours is same as number of piles, then value = items in maximum pile
          return maxPileSize;
      }else {
          Arrays.sort(pile);
          int []picks = new int[n];
          picks[n-1] = n;
          int counter = 0;
          for(int i=n-2; i >=0; i--) {
              picks[i] = n;
              for(int j=i+1; j<n; j++) {
                  picks[i] += Math.ceil((double)pile[j]/pile[i]) - 1;
              }
              if(picks[i] > h) {
//                  The previous one
                  return pile[i+1];
              }else if(picks[i] == h) {
//                  Current one
                  return pile[i];
              }
              counter ++;
//              if(counter % 5000 == 0)
//                  System.out.println("Completed: " + (100*counter/n)+" %");
          }
          return pile[0];
      }
    }
}
