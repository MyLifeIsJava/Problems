package codility.sorting;

import java.util.Arrays;

/**
 * https://app.codility.com/programmers/lessons/6-sorting/triangle/
 * 
 * @author kiransringeri
 *
 */
public class Triangle {

  public static void main(String[] args) {
    System.out.println(solution(new int[] {10,2,5,1,8,20}));
    System.out.println(solution(new int[] {10,50,5,1}));
  }

  public static int solution(int[] A) {
//    First sort.
//    a+b>c, a+c>b, b+c >a => a+b+c > 2a|2b|2c
//    And after sorting these a,b,c must be sonsecutive
    Arrays.sort(A);
    int n = A.length;
    int []doubled = new int[n];
    for(int i=0 ; i < n; i++) {
      doubled[i] = 2 * A[i];
    }
    boolean exists = false;
    for(int i=0 ; i < n-2; i++) {
      int sumofthree = A[i] + A[i+1] + A[i+2];
//      System.out.println("i="+i+", sum="+sumofthree+":"+doubled[i]+","+doubled[i+1]+","+doubled[i+2]);
      if(sumofthree > doubled[i] && sumofthree > doubled[i+1] && sumofthree > doubled[i+2]) {
        exists = true;
        break;
      }
    }
    return exists ? 1 : 0;
  }
}
