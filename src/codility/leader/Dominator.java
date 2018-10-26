package codility.leader;

/**
 * https://app.codility.com/programmers/lessons/8-leader/dominator/
 * 
 * @author kiransringeri
 *
 */
public class Dominator {

  public static void main(String[] args) {
    int val = solution(new int[] {2, 1, 1, 3, 4});
    System.out.println(val);
  }

  public static int solution(int[] A) {
    int dominatorIndex = -1;
    int dominatorVal = 0;
    int dominatorCount = 0;
    int n = A.length;
    int half = n /2 + 1;
    for(int i=0; i < n; i++) {
      if(dominatorCount == 0) {
        dominatorIndex = i;
        dominatorVal = A[i];
        dominatorCount++;
      }
      else {
        if(A[i] == dominatorVal) {
          dominatorCount ++;
          if(dominatorCount >= half) {
//            No need to check next elements
            break;
          }
        }
        else {
          dominatorCount --;
        }
      }
    }
    if(dominatorCount > 0) {
      if(dominatorCount < half) {
        dominatorCount = 0;
        for(int i=0; i < n; i++) {
          if(A[i] == dominatorVal) {
            dominatorCount ++;
          }
        }
        if(dominatorCount < half) {
          dominatorIndex = -1;
        }
      }
    }else {
      dominatorIndex = -1;
    }
    return dominatorIndex;
  }
}
