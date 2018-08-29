package hackerrank.algorithms;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/sum-vs-xor/problem
 * 
 * 
 * @author kiransringeri
 *
 */
public class SumVsXOR {
  public static void main(String []args){
    try(Scanner scanner = new Scanner(System.in)){
      long number = scanner.nextLong();
      long val = process(number);
      System.out.println(val);
    }catch(Throwable th){
      th.printStackTrace();
    }
  }

  private static long process(long val){
    // Get how many zeroes are there in the 'val'
    // If we have 1, then we can have only 0 at this position to have sum and XOR same
    // If we hace '0', then we can have either '0' or '1' Because 0 + 1 = 0 ^ 1 = 1 and 0 + 0 = 0 ^ 0 = 0
    int setBits = getUnSetBits(val);
    long result = (long)1 << setBits;
    return result;
  }

  private static int getUnSetBits(long val){
    // First flip the bits
    val = flipBits(val);
    System.out.println(Long.toBinaryString(val));
    return getSetBits(val);
  }

  private static int getSetBits(long val){
    int bitSets = 0;
    while(val > 0){
      // Clear the rightmost set bit
      val = val & (val - 1);
      bitSets ++;
    }
    return bitSets;
  }
  /**
  * flips all bits from right till most significant bit inclusive
  */
  private static long flipBits(long val){
    long mask = 1;
    while(mask <= val){
      val = val ^ mask;
      mask = mask << 1;
    }
    return val;
  }
}
