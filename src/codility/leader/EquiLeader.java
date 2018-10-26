package codility.leader;

/**
 * https://app.codility.com/programmers/lessons/8-leader/equi_leader/
 * 
 * @author kiransringeri
 *
 */
public class EquiLeader {

  public static void main(String[] args) {
    int val = solution(new int[] {4,3,4,4,4,2});
    System.out.println(val);
  }

  public static int solution(int[] A) {
//    The equileader and the leader of entire array must be the same
    int equiLeaders = 0;
    int n = A.length;
    int leaderVal = 0;
    int leaderCount = 0;
    for(int i=0; i <n; i++) {
      if(leaderCount == 0) {
        leaderVal = A[i];
        leaderCount ++;
      }
      else {
        if(A[i] == leaderVal) {
          leaderCount ++;
        }else {
          leaderCount --;
        }
      }
    }
    if(leaderCount > 0) {
      leaderCount = 0;
      for(int i=0; i <n; i++) {
        if(A[i] == leaderVal) {
          leaderCount ++;
        }
      }
      boolean leaderExists = leaderCount > n/2;
      if(leaderExists) {
//        System.out.println("Leader="+leaderVal+", COunt="+leaderCount);
        int leaderCountTillNow = 0;
        for(int i=0; i < n; i++) {
          if(A[i] == leaderVal) {
            leaderCountTillNow ++;
          }
          int remainingLeaders = leaderCount - leaderCountTillNow;
//          System.out.println("i="+i+", data="+A[i]+", leaderCountTillNow="+leaderCountTillNow+", remainingLeaders="+remainingLeaders+","+(i+1)/2+","+(n-i-1)/2);
          if(leaderCountTillNow > (i+1)/2 && remainingLeaders > (n-i-1)/2) {
            equiLeaders ++;
          }
        }
      }
    }
    return equiLeaders;
  }
}
