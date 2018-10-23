package codility.timecomplexity;

public class TapeEquilibrium {

  public static void main(String[] args) {
    System.out.println(solution(new int[] {3,1,2,4,3}));
  }

  public static int solution(int[] A) {
    Integer minDiff = null;
//    First get the total sum of all digits
    int totalSum = 0;
    for(int a : A) {
      totalSum += a;
    }
    int n = A.length;
    int currSum = 0;
//    Now start traversing element by element and find the difference if we cut at that element position
    for(int i=0; i < n-1; i++) {
      currSum += A[i];
      int currDiff = Math.abs(totalSum - (2 * currSum));
      if(minDiff == null || minDiff > currDiff) {
        minDiff = currDiff;
      }
    }
    
    return minDiff == null ? 0 : minDiff.intValue();
  }
}
