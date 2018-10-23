package codility.timecomplexity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermMissingElem {

  public static void main(String[] args) {
    int n = 100000;
    Integer missing = 4;
    List<Integer> list = new ArrayList<>();
    for(int i=1; i <= n; i++) {
      list.add(i);
    }
    list.remove(missing);
    Integer []data = list.toArray(new Integer[] {});
    
    System.out.println(Arrays.toString(data));
    missing = solution(data);
    System.out.println(missing);
  }

  public static int solution(Integer[] A) {
    long n = A.length;
//    First find the sum of all numbers from 1 till n+1
    long expectedSum = (n+1) * (n+2) / 2;
//    Now find the sum from the given array
    long actualSum = 0;
    for(int data : A) {
      actualSum += (long)data;
    }
    int missingNum = (int)(expectedSum - actualSum);
    return missingNum;
  }
}
