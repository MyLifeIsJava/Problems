package hackerrank.algorithms.bitmanipulation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/lonely-integer/problem?
 * 
 * @author kiransringeri
 *
 */
public class LonelyInteger {

//Complete the lonelyinteger function below.
  static int lonelyinteger(int[] a) {
    if(a == null || a.length == 0) {
      throw new IllegalArgumentException();
    }
    int answer = a[0];
//    A number XORed to itself even times gives ZERO
//    A number XORed to itself odd times gives the same number
    for(int i=1; i < a.length; i++) {
      answer = answer ^ a[i];
    }
    return answer;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    int answer = lonelyinteger(new int[]{0,0,1,2,1});
    System.out.println(answer);
//    readFromConsoleAndPerform();
  }
  
  private static void readFromConsoleAndPerform() throws IOException{
      BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

      int n = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      int[] a = new int[n];

      String[] aItems = scanner.nextLine().split(" ");
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      for (int i = 0; i < n; i++) {
          int aItem = Integer.parseInt(aItems[i]);
          a[i] = aItem;
      }

      int result = lonelyinteger(a);

      bufferedWriter.write(String.valueOf(result));
      bufferedWriter.newLine();

      bufferedWriter.close();

      scanner.close();
  }

}
