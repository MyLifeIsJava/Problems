package codility.countingelements;

public class PermCheck {

  public static void main(String[] args) {
    System.out.println(solution(new int[] {4,2,3,1}));
    System.out.println(solution(new int[] {4,3,1}));
  }

  public static int solution(int[] A) {
    byte []countArray = new byte[A.length];
    for(int i=0; i < A.length; i++) {
      int data = A[i];
//      This number is out of range
      if(data > A.length) {
        return 0;
      }
//      Mark this number as present in the array
      countArray[data-1] = 1;
    }
    
    for(byte b : countArray) {
//      If this digit is not present in given array
      if(b != 1) {
        return 0;
      }
    }
    return 1;
  }
}
