package hackerrank.algorithms;

import java.util.Scanner;

/**
 * Problem statement : https://www.hackerrank.com/challenges/jumping-on-the-clouds/problem
 * Status : Success 
 * 
 * @author kiran
 *
 */
public class Jumping_on_the_Clouds {

    static int jumpingOnClouds(int[] c) {
        if(c == null || c.length == 0)
            return 0;
        int jumps = 0;
        for(int i=0; i < c.length - 1; ) {
            if(i < c.length - 2 && c[i+2] == 0) {
                i += 2; //Jump 2 steps as this cloud is not a thunder
                jumps ++;
            }
            else {
                i += 1;
                jumps ++;
            }
        }
        return jumps;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] c = new int[n];
        for(int c_i = 0; c_i < n; c_i++){
            c[c_i] = in.nextInt();
        }
        int result = jumpingOnClouds(c);
        System.out.println(result);
        in.close();
    }

}
