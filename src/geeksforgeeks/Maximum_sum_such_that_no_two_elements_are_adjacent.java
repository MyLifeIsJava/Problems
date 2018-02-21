package geeksforgeeks;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Maximum_sum_such_that_no_two_elements_are_adjacent {

    public static void main(String[] args) {
        int []array = new int[] {5, 5, 10, 100, 10, 5};
        int sum = findMaximumSumOfNonAdjacent(array);
        System.out.print("[");
        Arrays.stream(array).forEach(a -> System.out.print(a+","));
        System.out.print("]\n");
        System.out.println(sum);
        System.out.println("-------------");
        
        array = new int[] {1, 2, 3};
        sum = findMaximumSumOfNonAdjacent(array);
        String str = Arrays.stream(array).mapToObj(String::valueOf).collect(Collectors.joining(",","[","]"));
        System.out.println(str);
        System.out.println(sum);
        System.out.println("-------------");

        array = new int[] {1, 20, 3};
        sum = findMaximumSumOfNonAdjacent(array);
        System.out.println(sum);
    }

    public static int findMaximumSumOfNonAdjacent(int []array) {
        int result = 0;
        if(array == null || array.length == 0)
            return result;
//        Let us maintain two arrays : 
//        one for the maximum sum if an element is considered
//        Another for the maximum sum if an element is not considered
        int []maxSumIncluded = new int[array.length];
        int []maxSumExcluded = new int[array.length];
        maxSumIncluded[0] = array[0];
        maxSumExcluded[0] = 0;
        for(int i=1; i <  array.length; i++) {
            maxSumIncluded[i] = maxSumExcluded[i-1] + array[i];
            maxSumExcluded[i] = Math.max(maxSumIncluded[i-1], maxSumExcluded[i-1]);
        }
        result = Math.max(maxSumIncluded[array.length-1], maxSumExcluded[array.length-1]);
        return result;
    }
}
