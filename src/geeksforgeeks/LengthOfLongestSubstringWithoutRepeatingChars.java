package geeksforgeeks;

import java.util.HashMap;
import java.util.Map;

/**
 * https://www.geeksforgeeks.org/length-of-the-longest-substring-without-repeating-characters/
 * 
 * @author kiransringeri
 *
 */
public class LengthOfLongestSubstringWithoutRepeatingChars {
  public static void main(String args[]) throws Exception {
    System.out.println(maxNonrepeatedSubstringLength("pwwwwwkkeww"));
  }

  private static int maxNonrepeatedSubstringLength(String str) {
    Map<Character, Integer> lastIndexMap = new HashMap<Character, Integer>();
    int maxLen = 0;
    int currLen = 0;
    for(int i=0; i < str.length(); i++) {
      char c = str.charAt(i);
      Integer lastIndex = lastIndexMap.get(c);
      if(lastIndex != null && (i - currLen) < lastIndex) {
        currLen = i - lastIndex;
      }else {
//        Current character is not repeated, so our current unique char string can grow by 1 character
        currLen ++;
      }
      lastIndexMap.put(c, i);
      if(currLen > maxLen) {
        maxLen = currLen;
      }
    }
    return maxLen;
  }
}
