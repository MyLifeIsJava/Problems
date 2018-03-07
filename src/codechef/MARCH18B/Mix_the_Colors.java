package codechef.MARCH18B;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Problem statement : https://www.codechef.com/MARCH18B/problems/MIXCOLOR
 * 
 * Status : Completed [1st attempt :-) ]
 * 
 * @author kiran
 *
 */
public class Mix_the_Colors {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for(int a=0; a < t; a++) {
            int n = scanner.nextInt();
            int duplicates = 0;
            Map<Integer, Boolean> map = new HashMap<>();
            for(int i=0; i<n; i++) {
                int color = scanner.nextInt();
                if(map.containsKey(color))
                    duplicates ++;
                else
                    map.put(color, true);
            }
            System.out.println(duplicates);
        }
        scanner.close();
    }

}
