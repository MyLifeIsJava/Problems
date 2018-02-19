package hackerrank;

import java.util.Scanner;

/**
 * Problem definition : https://www.hackerrank.com/challenges/camelcase/problem
 * Status : Completed
 * 
 * @author kiran
 *
 */
public class Camel_Case {

    static int camelcase(String s) {
        int words = 1;
        int capitalA = 'A';
        int capitalB = 'Z';
//        System.out.println(capitalA+","+capitalB);
        for(int i=0; i < s.length(); i++) {
            int c = s.charAt(i);
//            System.out.println(c);
            if(capitalA <= c  && c <= capitalB) {
                words ++;
            }
        }
        return words;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int result = camelcase(s);
        System.out.println(result);
        in.close();
    }

}
