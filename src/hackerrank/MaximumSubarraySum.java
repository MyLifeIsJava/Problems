package hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/maximum-subarray-sum/problem?h_r=internal-search
 * 
 * @author kiransringeri
 *
 */
public class MaximumSubarraySum {

//Complete the maximumSum function below.
  static long maximumSum(long[] a, long m) {
    return 0;
    /*
    if(a == null || a.length == 0) {
      return 0;
    }
    long []sumArray = new long[a.length];
    sumArray[0] = a[0] % m;
    long maxModulo = sumArray[0];
    for(int i=1; i < a.length; i++) {
      long val = 
    }*/
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    long l = (long)Math.pow(10, 18);
    long k = (long)Math.pow(10, 0);
    l = l * k;
    System.out.println(l);
//    readInputAndWriteToOutput();
  }
  
  private static void readInputAndWriteToOutput() throws IOException {
      BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

      int q = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      for (int qItr = 0; qItr < q; qItr++) {
          String[] nm = scanner.nextLine().split(" ");

          int n = Integer.parseInt(nm[0]);

          long m = Long.parseLong(nm[1]);

          long[] a = new long[n];

          String[] aItems = scanner.nextLine().split(" ");
          scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

          for (int i = 0; i < n; i++) {
              long aItem = Long.parseLong(aItems[i]);
              a[i] = aItem;
          }

          long result = maximumSum(a, m);

          bufferedWriter.write(String.valueOf(result));
          bufferedWriter.newLine();
      }

      bufferedWriter.close();

      scanner.close();
  }

}
