package codechef.MARCH18B;

import java.util.Scanner;

/**
 * Problem statement : https://www.codechef.com/MARCH18B/problems/CHEGLOVE
 * 
 * Status : Completed [1st attempt :-) ]
 * 
 * @author kiran
 *
 */
public class Chef_and_Glove {

    public static void main(String[] args) {
        /*
        Constraints
        1 ≤ T ≤ 10
        1 ≤ N ≤ 10^5
        1 ≤ Li ≤ 10^9
        1 ≤ Gi ≤ 10^9

        Subtask #1 (30 points) : 1 ≤ N ≤ 10^2
        Subtask #2 (70 points) : No additional constraints
        */
        
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for(int i=0; i < t; i++) {
            int n = scanner.nextInt();
            int []L = new int[n];
            for(int j=0; j < n; j++) {
                L[j] = scanner.nextInt();
            }

            int []G = new int[n];
            for(int j=0; j < n; j++) {
                G[j] = scanner.nextInt();
            }
            
            String ans = solve(n, L, G);
            System.out.println(ans);
        }
    }

    private static String solve(int n, int []fingers, int []sheath) {
//        "front", "back", "both", or "none"
        boolean front = true;
        boolean back = true;
        for(int i=0; i < n; i++) {
            if(!front && !back)
                break;
            if(front && fingers[i] > sheath[i]) {
                front = false;
            }
            if(back && fingers[i] > sheath[n-1-i]) {
                back = false;
            }
        }
        String result = null;
        if(front && back)
            result = "both";
        else if(front)
            result = "front";
        else if(back)
            result = "back";
        else
            result = "none";
        return result;
    }
}
