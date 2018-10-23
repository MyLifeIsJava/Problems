package codility.iterations;

public class BinaryGap {

  public static void main(String[] args) {
    int val = 2147483637;
    System.out.println(Integer.toBinaryString(val));
    int result = solve(val);
    System.out.println("Binary gap in " + val +" is "+result);
  }

  private static int solve(int N) {
    int maxGapSize = 0;
    int currGapSize = 0;
    boolean rightBoundaryFound = false;
    while(N > 0) {
//      Check the right-most bit
      if((N & 1) == 1) {
        rightBoundaryFound = true;
        currGapSize = 0;
      }else {
        if(rightBoundaryFound) {
          currGapSize ++;
          if(maxGapSize < currGapSize) {
            maxGapSize = currGapSize;
          }
        }
      }
//      Right shift the number to check the next bit
      N = N >> 1;
    }
    return maxGapSize;
  }
}
