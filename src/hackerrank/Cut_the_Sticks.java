package hackerrank;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Problem definition :  https://www.hackerrank.com/challenges/cut-the-sticks/problem
 * Status : Completed
 * 
 * @author kiran
 *
 */
public class Cut_the_Sticks {

    static int[] cutTheSticks(int[] arr) {
//        Let us find out the unique numbers and their count and sort then ascending
        int []retData = null;
        Map<Integer, Integer> map = new TreeMap<>();
        if(arr == null || arr.length == 0)
            return retData;
        for(int i=0; i < arr.length ; i++) {
            int data = arr[i];
            Integer val = map.get(data);
            if(val == null)
                val = 1;
            else
                val = val.intValue() + 1;
            map.put(data, val);
        }
        retData = new int[map.size()];
        int counter = 0;
        int items = arr.length;
        for(int val : map.values()) {
            retData[counter] = items;
            items -= val;
            counter++;
        }
        return retData;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        int[] result = cutTheSticks(arr);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
        }
        System.out.println("");


        in.close();
    }

}
