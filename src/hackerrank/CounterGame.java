package hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CounterGame {

//Complete the counterGame function below.
  static String counterGame(long n) {
    double d = Math.pow(2, 64) - 1;
    System.out.println(d);
    long l = (long)d;
    System.out.println(l);
    for(int i=0; i < 64; i++) {
      System.out.print("0");
    }
    System.out.println();
    System.out.println(Long.toBinaryString(l));
    
    return "";
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    counterGame(6);
    /*
      BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

      int t = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      for (int tItr = 0; tItr < t; tItr++) {
          long n = scanner.nextLong();
          scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

          String result = counterGame(n);

          bufferedWriter.write(result);
          bufferedWriter.newLine();
      }

      bufferedWriter.close();

      scanner.close();
      */
  }

}
