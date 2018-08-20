package hackerrank.august_circuits_18;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * https://www.hackerearth.com/challenge/competitive/august-circuits-18/algorithm/string-4-d1093b86/
 * 
 * <pre>
 * String
Max. Marks: 100
You are given a String  of size , consisting of lowercase English characters. Now, you need to select a single English lowercase alphabet, and delete all occurences of it from the given string 
Considering you do the mentioned exactly once over the given string, what is the minimum possible length of the resultant string ?

Input Format :

The first line contains a single integer N. The next line contains a String  of length  consisting of lowercase Englsh characters.

Output Format :

Print the required answer on a single line

Constraints :

Note that the Expected Output feature of Custom Invocation is not supported for this contest. 

SAMPLE INPUT 
5
aaaaa
SAMPLE OUTPUT 
0
Explanation
We can delete all occurences of the letter  to get a resultant string of length .
 * </pre>
 * 
 * Status : Success, 100 Marks
 * 
 * @author kiransringeri
 *
 */
public class StringTest {

  public static void main(java.lang.String[] args) {
    Scanner scanner = null;
    try {
      scanner = new Scanner(System.in);
      int strLength = scanner.nextInt();
//      Just read the new line
      scanner.nextLine();
//      Now read the string
      String str = scanner.nextLine();
      int answer = compute(strLength, str);
      System.out.println(answer);
    }finally {
      scanner.close();
    }
  }

  private static int compute(int strLength, String str) {
    Map<Character, Integer> charFreqMap = new HashMap();
    int maxFreq = 0;
    for(int i=0; i < str.length(); i++) {
      char c = str.charAt(i);
      Integer freq = charFreqMap.get(c);
      if(freq == null) {
        freq = 1;
      }else {
        freq = freq.intValue() + 1;
      }
      if(freq > maxFreq) {
        maxFreq = freq;
      }
      charFreqMap.put(c, freq);
    }
    return strLength - maxFreq;
  }
}
