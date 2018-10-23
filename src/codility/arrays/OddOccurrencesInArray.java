package codility.arrays;

public class OddOccurrencesInArray {

  public static void main(String[] args) {
    int []data = {9,3,9,3,9,7,9};
    int oddOccurence = solution(data);
    System.out.println(oddOccurence);
  }

  public static int solution(int[] A) {
//    We can use XOR as XOR of a number with the same number gives ZERO
    int zorSum = 0;
    for(int a :  A) {
      zorSum = zorSum ^ a;
    }
    return zorSum;
  }
}
