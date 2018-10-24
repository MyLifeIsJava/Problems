package codility.prefixsums;

public class CountDiv {

  public static void main(String[] args) {
    System.out.println(solution(0, 2000000000, 2000000000));
    System.out.println(solution(0, 1, 1));
    System.out.println(solution(11, 345, 17));
  }

  /**
   * A and B are integers within the range [0..2,000,000,000];
   * K is an integer within the range [1..2,000,000,000];
   * A ≤ B.
   * @param A
   * @param B
   * @param K
   * @return
   */
  public static int solution(int A, int B, int K) {
//    TODO: How can we use prefix sums to solve this?
    int result = 0;
    if(A == B) {
      if(A % K == 0) {
        result = 1;
      }
    }else {
//      A is always less than B
//      So B can't be ZERO. But A can be zero
      result = B / K;
      if(A == 0) {
        result += 1;
      }else {
        result -= (A-1)/K;
      }
    }
    return result;
  }
}
