package codility.countingelements;

public class FrogRiverOne {

  public static void main(String[] args) {
     System.out.println(solution(5, new int[] {1,3,1,4,2,3,5,4}));
  }

  public static int solution(int X, int[] A) {
    byte []leafPositionArray = new byte[X];
    int result = -1;
    int uniqueLeafPositions = 0;
    for(int index=0; index < A.length; index++) {
      int leafPosition  = A[index] - 1;
      int leaves = leafPositionArray[leafPosition];
      if(leaves == 0) {
//        The first leaf at this position
        uniqueLeafPositions ++;
      }
      leafPositionArray[leafPosition] = 1;
      if(uniqueLeafPositions == X) {
//        We got all leaves
        result = index;
        break;
      }
    }
    return result; 
  }
}
