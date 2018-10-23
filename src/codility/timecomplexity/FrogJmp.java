package codility.timecomplexity;

public class FrogJmp {

  public static void main(String[] args) {
//    System.out.println(solution(10, 85, 30));
//    System.out.println(solution(10, 26, 5));
//    Expected=142730189
    System.out.println(142730189*7+3);
    System.out.println(solution(3, 999111321, 7));
  }

  public static int solution(int X, int Y, int D) {
    int distance = Y - X;
    double jumpsNeeded = (double)distance / (double)D;
    int minJumps = (int)Math.ceil(jumpsNeeded);
    return minJumps;
  }
}
