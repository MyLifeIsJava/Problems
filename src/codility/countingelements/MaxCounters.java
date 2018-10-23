package codility.countingelements;

import java.util.Arrays;

public class MaxCounters {

  public static void main(String[] args) {
    int []data = {3,4,4,6,1,4,4};
    int []result = solution(5, data);
    System.out.println(Arrays.toString(result));
  }

  public static int[] solution(int N, int[] A) {
//    Initialize the counter with ZEROes
    int []counter = new int[N];
    int maxValOperation = N+1;
    int currMax = 0;
    int prevMax = 0;
    for(int index=0; index < A.length; index++) {
      int operation = A[index];
      if(operation == maxValOperation) {
//        Set the max value of the any counter
        prevMax = currMax;
      }
      else {
        int counterVal = counter[operation-1];
        if(counterVal < prevMax) {
//          The case when we have not set the max val for this counter
          counterVal = prevMax + 1;
        }else {
          counterVal += 1;
        }
        counter[operation-1] = counterVal;
        if(currMax < counterVal) {
          currMax = counterVal;
        }
      }
    }
    for(int i=0; i < N; i++) {
      if(counter[i] < prevMax) {
        counter[i] = prevMax;
      }
    }
    return counter;
  }
}
