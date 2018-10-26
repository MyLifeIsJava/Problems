package codility.maximumslice;

/**
 * https://app.codility.com/programmers/lessons/9-maximum_slice_problem/max_double_slice_sum/
 * 
 * @author kiransringeri
 *
 */
public class MaxDoubleSliceSum {

  public static void main(String[] args) {
    int answer = 0;
    answer = solution(new int[] {-4, -5, -1, -5, -7, -19, -11});
    System.out.println(answer);
    answer = solution(new int[] {0, 10, -5, -2, -2, 0});
    System.out.println(answer);
  }

  public static int solution(int[] A) {
    int maximalSum = 0;
    int n = A.length;
    int []maxSumsEndingHere = new int[n];
    int []maxSumsEndingHereReversed = new int[n];
    
    for(int i=1; i< n-1; i++) {
        maxSumsEndingHere[i] = Math.max(A[i], maxSumsEndingHere[i-1] + A[i]);
    }
    for(int i=n-2; i>0; i--) {
      maxSumsEndingHereReversed[i] = Math.max(A[i], maxSumsEndingHereReversed[i+1] + A[i]);
    }
    
//    System.out.println("maxSumsEndingHere        ="+Arrays.toString(maxSumsEndingHere));
//    System.out.println("maxSumsEndingHereReversed="+Arrays.toString(maxSumsEndingHereReversed));
    
    for(int i=1; i < n-1; i++) {
//      Assume we have i as the middle point
//      If the max sum to left or right is less than ZERO, then we can assume it as ZERO as we can include the immediate left/right index
      maximalSum = Math.max(maximalSum, Math.max(0, maxSumsEndingHere[i-1]) + Math.max(0,maxSumsEndingHereReversed[i+1]));
//      System.out.println("i="+i+", maximalSum="+maximalSum);
    }
    return maximalSum;
  }
}
