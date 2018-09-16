package hackerrank.algorithms.bitmanipulation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class XOR_Sequence {

//Complete the xorSequence function below.
  static long xorSequence(long l, long r) {
    return l;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
//    useStandardInput();
    int []data = new int[100];
    data[0] = 0;
    for(int i=1; i < data.length; i++) {
      data[i] = i ^ data[i-1];
      int val = (i+1) % 4;
      if(val == 1) {
        val = i;
      }else if(val == 2) {
        val = 1;
      }else if(val == 3) {
        val = i + 1;
      }
      if(data[i] != val) {
        throw new RuntimeException("Wrong logic!");
      }
      System.out.println(i+"="+data[i]+","+val);
    }
//    System.out.println("-------");
//    for(int i=4; i<data.length; i+=4) {
//      int x = data[i] ^ data[i+1] ^ data[i+2] ^ data[i+3];
//      System.out.println(x);
//    }
//    3,4,5,6
//    7,8,9,10
//    11,12,13,14
  }
  
  public static void useStandardInput() throws IOException {
      BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

      int q = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      for (int qItr = 0; qItr < q; qItr++) {
          String[] lr = scanner.nextLine().split(" ");

          long l = Long.parseLong(lr[0]);

          long r = Long.parseLong(lr[1]);

          long result = xorSequence(l, r);

          bufferedWriter.write(String.valueOf(result));
          bufferedWriter.newLine();
      }

      bufferedWriter.close();

      scanner.close();
  }

}
