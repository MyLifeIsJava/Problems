package others;

import java.util.ArrayList;
import java.util.List;

/**
 * Dynamic Programming
 * 
 * A subsequence is a sequence that can be derived from another sequence by deleting some elements without changing the order of the remaining elements
 * 
 * Find the longest common subsequence between two strings
 * 
 * @author kiran
 *
 */
public class Longest_Common_Subsequence {

    public static void main(String[] args) {
        String str = longestCommonSubsequence("abcdaf", "acbcf");
        System.out.println(str);
    }

    private static String longestCommonSubsequence(String str1, String str2) {
        if(str1 == null || str1.length() == 0 || str2 == null || str2.length() == 0)
            return null;
        int [][]matrix = new int[1+str1.length()][1+str2.length()];
        for(int i=1; i <= str1.length(); i++) {
            char c1 = str1.charAt(i-1);
            for(int j=1; j <= str2.length(); j++) {
                char c2 = str2.charAt(j-1);
                if(c1 == c2) {
//                    1 + matrix[i-1, j-1]
                    matrix[i][j] = matrix[i-1][j-1] + 1; //Diagonal cell value + 1
                }else {
//                    Max(matrix[i, j-1], matrix[i-1, j])
                    matrix[i][j] = Math.max(matrix[i][j-1], matrix[i-1][j]);
                }
            }
        }
//        Now find out the characters forming this subsequence
        int i = str1.length();
        int j = str2.length();
        List<Character> res = new ArrayList<>();
        int val = matrix[i][j];
        while(val > 0) {
            if(i == 0)
                break;
            if(matrix[i-1][j] == val) {
//                Value = Max(left,top)
                i = i-1;
            }else if(matrix[i][j-1] == val) {
//                Value = Max(left,top)
                j = j-1;
            }else{//Diagonal element
//              This character is part of longest subsequence
              res.add(str1.charAt(i - 1));
              i = i - 1;
              j = j - 1;
          }
            val = matrix[i][j];
        }
        if(res.size() > 0) {
            StringBuilder strBuff = new StringBuilder();
            for(int k = res.size() - 1; k >= 0; k--) {
                strBuff.append(res.get(k));
            }
            return strBuff.toString();
        }
        return null;
    }
}
