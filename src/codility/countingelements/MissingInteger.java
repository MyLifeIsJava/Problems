package codility.countingelements;

public class MissingInteger {

  public static void main(String[] args) {
    System.out.println(solution(new int[]{1, 3, 6, 4, 1, 2}));
    System.out.println(solution(new int[]{1,2,3}));
    System.out.println(solution(new int[]{-1,-3}));
  }

  public static int solution(int[] A) {
    int n = A.length;
    byte []counter = new byte[n];
    for(int a: A) {
      if(a > 0 && a <= n) {
        counter[a-1] = 1;
      }
    }
    int result = n+1;
    for(int i=0; i < counter.length; i++) {
      if(counter[i] == 0) {
        result = i + 1;
        break;
      }
    }
    return result;
  }
}
