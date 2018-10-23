package codility.arrays;

import java.util.Arrays;

public class CyclicRotation {

  public static void main(String[] args) {
    int[] data = {1, 2, 3, 4};
    System.out.println(Arrays.toString(data));
    int k = 5;
    data = rotateArrayRight(data, k);
    System.out.println(Arrays.toString(data));
  }

  public static int[] rotateArrayRight(int[] data, int k) {
    if (data == null) {
      return null;
    }
    int n = data.length;
    int[] result = new int[n];
    for (int i = 0; i < n; i++) {
      int newIndex = (i + k) % n;
      result[newIndex] = data[i];
    }
    return result;
  }
}
