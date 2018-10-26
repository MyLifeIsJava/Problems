package codility.sorting;

import java.util.Arrays;

/**
 * https://app.codility.com/programmers/lessons/6-sorting/distinct/
 * 
 * @author kiransringeri
 *
 */
public class Distinct {

  public static void main(String[] args) {
    System.out.println(solution(new int[] {2,1,1,2,3,1}));
  }

  public static int solution(int[] A) {
    Arrays.sort(A);
    int distinctCount = 0;
    Integer prevVal = null; 
    for(int val : A) {
      if(prevVal == null || prevVal.intValue() != val) {
        distinctCount ++;
      }
      prevVal = val;
    }
    return distinctCount;
  }
}
