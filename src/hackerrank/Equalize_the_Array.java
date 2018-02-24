package hackerrank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Problem statement : https://www.hackerrank.com/challenges/equality-in-a-array/problem
 * Status : Completed
 * 
 * @author kiran
 *
 */
public class Equalize_the_Array {

    static int equalizeArray(int[] arr) {
        if(arr == null || arr.length <= 1)
            return 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        int maxCount = 0;
        for(int data : arr) {
            Integer repetitions = map.get(data);
            if(repetitions == null)
                repetitions = 1;
            else
                repetitions = repetitions + 1;
            map.put(data, repetitions);
            if(repetitions > maxCount)
                maxCount = repetitions;
        }
        return arr.length - maxCount;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        int result = equalizeArray(arr);
        System.out.println(result);
        in.close();
    }

}
