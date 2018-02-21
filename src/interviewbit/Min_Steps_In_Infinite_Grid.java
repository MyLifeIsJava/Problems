package interviewbit;

import java.util.Arrays;
import java.util.List;

/**
 * Problem definition : https://www.interviewbit.com/problems/min-steps-in-infinite-grid/
 * Status : Completed
 * 
 * @author kiran
 *
 */
public class Min_Steps_In_Infinite_Grid {

    public static void main(String[] args) {
        Min_Steps_In_Infinite_Grid obj = new Min_Steps_In_Infinite_Grid();
        System.out.println(obj.coverPoints(Arrays.asList(4,6, 20), Arrays.asList(5,1, 100)));
    }

    public int coverPoints(List<Integer> A, List<Integer> B) {
        int steps = 0;
        if(A.size() != B.size())
            throw new IllegalArgumentException();
        
        if(A.size() == 1)
            return steps;
        
        for(int i = 1; i < A.size(); i++) {
            int x1 = A.get(i-1);
            int x2 = A.get(i);
            int y1 = B.get(i-1);
            int y2 = B.get(i);
//            We have to go from (x1,y1) to (x2,y2)
            int currSteps = 0;
            if(x1 != x2 || y1 != y2) {
                if(x1 == x2) {
                    currSteps = Math.abs(y2 - y1);  
                }
                else if(y1 == y2) {
                    currSteps = Math.abs(x2 - x1);
                }
                else {
                    int x = Math.abs(x2 - x1);
                    int y = Math.abs(y2 - y1);
                    int a = x < y ? x : y;
                    int b = x < y ? y : x;
                    currSteps = a;
                    currSteps += b - a;
                }
            }
            steps += currSteps;
        }
        return steps;
    }
}
