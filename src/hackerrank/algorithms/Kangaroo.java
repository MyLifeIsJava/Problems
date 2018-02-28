package hackerrank.algorithms;

import java.util.Scanner;

public class Kangaroo {

    static String kangaroo(int x1, int v1, int x2, int v2) {
        if(x1 != x2 && v1 == v2)
            return "NO";
        if(x1 == x2 && v1 == v2)
            return "YES";
        int num = x2 - x1;
        int den = v1 - v2;
        if((num > 0 && den < 0) || (num < 0 && den > 0) )
            return "NO";
        int rem = num % den;
//        System.out.println("num="+num+",den="+den+", rem="+rem+", quot="+(num/den));
        if(rem == 0)
            return "YES";
        else
            return "NO";
    }

    public static void main(String[] args) {
        
       Scanner in = new Scanner(System.in);
        int x1 = in.nextInt();
        int v1 = in.nextInt();
        int x2 = in.nextInt();
        int v2 = in.nextInt();
        String result = kangaroo(x1, v1, x2, v2);
        System.out.println(result);
        /*
        int x1 = 28;
        int x2 = 96;
        for(int i=1; i < 1000000000; i++) {
            x1 = x1 + 8;
            x2 = x2 + 2;
            if(x1 == x2)
                System.out.println(i);
        }*/
    }

}
