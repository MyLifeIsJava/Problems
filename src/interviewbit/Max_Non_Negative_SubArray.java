package interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem definition : https://www.interviewbit.com/problems/max-non-negative-subarray/
 * Status : Completed
 * 
 * @author kiran
 *
 */
public class Max_Non_Negative_SubArray {

    public static void main(String[] args) {
        Max_Non_Negative_SubArray obj = new Max_Non_Negative_SubArray();
        System.out.println(obj.maxset(Arrays.asList(1967513926, 1540383426, -1303455736, -521595368)));
    }
    
    public ArrayList<Integer> maxset(List<Integer> A) {
        int maxSubsetBeginIndex = -1;
        int maxSubsetEndIndex = -1;
        long maxSubsetSum = Long.MIN_VALUE;
        ArrayList<Integer> retList = null;
        if(A == null || A.isEmpty())
            return retList;
        
        int currSubsetBeginIndex = -1;
        int currentSubsetEndIndex = -1;
        long currentSubsetSum = 0;
        for(int i=0; i < A.size(); i++){
            if(A.get(i) < 0){
                if(currentSubsetSum > maxSubsetSum){
                    maxSubsetBeginIndex = currSubsetBeginIndex;
                    maxSubsetEndIndex = currentSubsetEndIndex;
                    maxSubsetSum = currentSubsetSum;
                }
                currSubsetBeginIndex = -1;
                currentSubsetEndIndex = -1;
                currentSubsetSum = 0;
            }else{
                if(currSubsetBeginIndex == -1)
                    currSubsetBeginIndex = i;
                currentSubsetSum += A.get(i);
                currentSubsetEndIndex = i;
                
                if(i == A.size() - 1){
                    if(currentSubsetSum > maxSubsetSum){
                        maxSubsetBeginIndex = currSubsetBeginIndex;
                        maxSubsetEndIndex = currentSubsetEndIndex;
                        maxSubsetSum = currentSubsetSum;
                    }
                }
            }
        }
        retList = new ArrayList<>();
        if(maxSubsetBeginIndex >= 0){
            for(int i= maxSubsetBeginIndex; i <= maxSubsetEndIndex; i++){
                retList.add(A.get(i));
            }
        }
        return retList;
    }

}
    