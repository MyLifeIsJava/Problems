package codility.maximumslice;

/**
 * https://app.codility.com/programmers/lessons/9-maximum_slice_problem/max_slice_sum/
 * 
 * @author kiransringeri
 *
 */
public class MaxSliceSum {

  public static void main(String[] args) {
    long result = solution(new int[] {3,2,-6,4,0});
    System.out.println(result);
  }

  public static int solution(int[] A) {
    int maxSliceSum = A[0];
    int maxSumEndingHere = A[0];
    int n = A.length;
    for(int i=1; i < n; i++) {
      int a = A[i];
//      Max sum ending here is either this value itself or adding this value to prev sum
      maxSumEndingHere = Math.max(a, maxSumEndingHere + a);
      maxSliceSum = Math.max(maxSliceSum, maxSumEndingHere);
    }
    return maxSliceSum;
  }
}
