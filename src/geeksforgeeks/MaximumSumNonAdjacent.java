package geeksforgeeks;

public class MaximumSumNonAdjacent {

  public static void main(String[] args) {
//    int []data = new int[] {5, 5, 10, 100, 10, 5}; // 110
//    int []data = {1, 2, 3}; //4
//    int []data = {1, 20 , 3};//20
    int []data = {3, 2, 5, 10, 7};//15
    System.out.println(getMaximumNonAdjacentSum(data));
  }

  private static long getMaximumNonAdjacentSum(int []data) {
    if(data == null || data.length == 0) {
      return 0;
    }
    if(data.length == 1) {
      return data[0];
    }
    if(data.length == 2) {
      return Math.max(data[0], data[1]);
    }
    int []maxSums = new int[data.length];
    maxSums[0] = data[0];
    maxSums[1] = data[1];
    for(int i=2; i < data.length; i++) {
      int sumIncludingIth = Math.max(data[i], maxSums[i-2] + data[i]);
      int sumExcludingIth = maxSums[i-1];
      maxSums[i] = Math.max(sumIncludingIth, sumExcludingIth);
    }
    return maxSums[data.length - 1];
  }
  
  
}
