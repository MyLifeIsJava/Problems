package others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Dynamic Programming
 * 
 * We are given the items.
 * Each item has a weight and a value.
 * And a weight is given as input.
 * 
 * We have to find all those items whose total weight is less than or equal to the given weight, but with maximum value possible.
 * 
 * In other words we can say that 'Pick items which can fit into a bag of weight X to maximize the value'
 * 
 * Status : Completed
 * 
 * @author kiran
 *
 */
public class ZeroSlashOne_Knapsack_Problem {

    public static void main(String[] args) {
        int [][]items = {
                {1, 1},
                {3, 4},
                {4, 5},
                {5, 7},
        };
        int[] result = getItemsWithMaximumValue(items, 7);
        if(result != null) {
            for(int i : result) {
                System.out.println(Arrays.toString(items[i]));
            }
        }else {
            System.out.println("NONE");
        }
    }

    /**
     * 
     * @param items - a two dimensional array. Each item in the array is {x,y} where x is the weight and y is the value
     * @param weight
     * @return indices of items
     */
    private static int[] getItemsWithMaximumValue(int [][]items, int weight) {
//        Let us create a matrix of N X M where N = number of items and M = weight +1
//        This matrix stores the maximum value possible for a given weight and items
        int [][]matrix = new int[items.length][weight+1];
//        Initialize the matrix for weight=0
//        No need to initialize in Java as the default values will be ZERO
//        Let us handle the items one by one
        for(int i=0; i < items.length; i++) {
            int currentWeight = items[i][0];
            int currentValue = items[i][1];
            for(int j=0; j <= weight; j++) {
//                The value at matrix[i][j] will be 
//                if the current weight is greater than the item weight, then same as row above, same column as we can't include this item
//                Else the maximum of below two
//                      1) By considering the current item, i.e, items[i]
//                      2) By not considering the current item
//                Not considering the current item -> copy from the value above row, same column
//                Considering the current item: item's value + value from above row, column = (weight-item's weight)
//                          i.e, Consider current item, for the remaining item look up the matrix
                if(currentWeight > j) {
//                    If it is the first item, then we can leave the values as ZERO
                    if(i > 0) {
                        matrix[i][j] = matrix[i-1][j]; //Above row, same column
                    }
                }
                else {
                    if(i == 0) {
//                        For first item/row, just copy the item's value
                        matrix[i][j] = currentValue;
                    }
                    else {
                        int valueIfNotConsidered = matrix[i-1][j]; //Above row, same column
                        int remainingWeight = j - currentWeight;
                        int valueIfConsidered = currentValue + matrix[i-1][remainingWeight];
                        matrix[i][j] = Math.max(valueIfNotConsidered, valueIfConsidered);
                    }
                }
            }
        }
//        Now find out the items
        List<Integer> consideredWeights = new ArrayList<>();
        int i = items.length - 1; //Last row
        int j = weight; //Last column
        while(i >= 0) {
            int val = matrix[i][j];
            if(i == 0) {
                if(matrix[i][j] != 0)
                    consideredWeights.add(i);
                i --;
            }
            else if(matrix[i-1][j] != val) {
//                The max value has changed because of this item, so include this item
                consideredWeights.add(i);
//                Deduct the weight of this item from j
                j = j - items[i][0];
                i = i -1; //Check previous item for the weight difference
            }
            else {
                i = i - 1;
//                Check previous item for the same weight
            }
        }
        int []retArray = null;
        if(!consideredWeights.isEmpty()) {
            retArray = new int[consideredWeights.size()];
            for(int x = 0; x < consideredWeights.size(); x++)
                retArray[consideredWeights.size() - (1+x)] = consideredWeights.get(x);
                
        }
        return retArray;
    }
}
