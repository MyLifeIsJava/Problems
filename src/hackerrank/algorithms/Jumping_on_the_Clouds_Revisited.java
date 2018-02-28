package hackerrank.algorithms;

import java.util.Scanner;

/**
 * Problem statement : https://www.hackerrank.com/challenges/jumping-on-the-clouds-revisited/problem
 * Status : Completed
 * 
 * @author kiran
 *
 */
public class Jumping_on_the_Clouds_Revisited {

    static int jumpingOnClouds(int[] c, int k) {
        int energy = 100;
        int n = c.length; //n >= 2
        int steps = n / k;
        energy -= steps;
//      Find out thunder clouds which Aerith visits in this journey
//        She can jump from initial position to itself and it can be a thunder cloud
        for(int i=0; i < n; i += k) {
            if(c[i] == 1) {
                energy -= 2;
            }
        }
        return energy;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] c = new int[n];
        for(int c_i = 0; c_i < n; c_i++){
            c[c_i] = in.nextInt();
        }
        int result = jumpingOnClouds(c, k);
        System.out.println(result);
        in.close();
    }

}
