package codility.prefixsums;

public class MinAvgTwoSlice {

  public static void main(String[] args) {
    System.out.println(solution(new int[] {4,2,2,5,1,5,8}));
    System.out.println(solution(new int[] {7,9,3,4,3,9}));
    System.out.println(solution(new int[] {9,9,1,2,2,2,1}));
    System.out.println(solution(new int[] {9,2,4,1,7}));
    System.out.println(solution(new int[] {7,2,3,6}));
//    int n = 100000;
//    int []data = new int[n];
//    for(int i=0; i < n; i++) {
//      Random r = new Random();
//      data[i] = r.nextInt(n);
//    }
//    System.out.println(solution(data));
  }

  /**
   * N is an integer within the range [2..100,000];
   * each element of array A is an integer within the range [−10,000..10,000
   * 
   * 
   * Solution: To solve this we need to go with the below proof which says 
   * 
   * Every slice must be of size two or three. Slices of bigger sizes are created from such smaller slices. 
   * Therefore should any bigger slice have an optimal value, all sub-slices must be the same, for this case to hold true. 
   * Should this not be true, one of the sub-slices must be the optimal slice. The others being bigger. 
   * Therefore we check all possible slices of size 2/3 and return the smallest one. The first such slice is the correct one
   * 
   * https://github.com/daotranminh/playground/blob/master/src/codibility/MinAvgTwoSlice/proof.pdf
   * 
   * @param A
   * @return
   */
  public static int solution(int[] A) {
    int n = A.length;
    int minAvgIndex = -1;
    Float minAvg = null;
//    Just find the minimum of all slices of size 2 and 3
    for(int i=0; i < n-1; i++) {
      float avgSlice2 = (float)(A[i] + A[i+1])/2.0f;
      if(minAvg == null || minAvg > avgSlice2) {
        minAvg = avgSlice2;
        minAvgIndex = i;
      }
      if(i+2 < n) {
        float avgSlice3 = (float)(A[i]+A[i+1]+A[i+2])/3.0f;
        if(minAvg > avgSlice3) {
          minAvg = avgSlice3;
          minAvgIndex = i;
        }
      }
    }
    return minAvgIndex;
  }
 
}
