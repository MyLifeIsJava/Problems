package leetcode;

/**
 * Problem statement : https://leetcode.com/problems/longest-palindromic-substring/description/
 * Method : Dynamic Programming
 * Time Complexity : O(n^2)
 * Alternates : Yes, Manacher's algorithm in O(n) Ref: https://www.youtube.com/watch?v=nbTSfrEfo6M
 * 
 * @author kiran
 *
 */
public class Long_Palindromic_Substring {

    public static void main(String[] args) {
        String str = "babad";// "BANANA";// "0ABAB313BABA0";
        Long_Palindromic_Substring obj = new Long_Palindromic_Substring();
        System.out.println(obj.longestPalindrome(str));
    }

    public String longestPalindrome(String s) {
        if(s == null || s.length() <= 1)
            return s;
        
        char []chars = s.toCharArray();
        boolean [][]truthValues = new boolean[chars.length][chars.length];
        
        int longestPalindromeLength = 1;
        int longestPalindromeBeginIndex = 0;
//        Palindromes of length=1
        for(int i=0; i < chars.length; i++) {
            truthValues[i][i] = true;
        }
//        Palindromes of length 2
        for(int i=0; i < chars.length - 1; i++) {
            if(chars[i] == chars[i+1]) {
                truthValues[i][i+1] = true;
                if(longestPalindromeLength != 2) {
                    longestPalindromeLength = 2;
                    longestPalindromeBeginIndex = i;
                }
            }
        }
//        Palindromes of length > 2
        for(int palSize=3; palSize <= chars.length; palSize++) {
            for(int j=0; j < chars.length - palSize + 1; j++) {
                if(chars[j] == chars[j + palSize - 1] && //Last two charatcres of this is same
                        truthValues[j+1][j + palSize - 2]) { //If the inner string is a palindrome
                    truthValues[j][j + palSize - 1] = true;
                    if(longestPalindromeLength != palSize) {
                        longestPalindromeLength = palSize;
                        longestPalindromeBeginIndex = j;
                    }
                }
            }
        }
        if(longestPalindromeLength >= 0) {
            StringBuilder str = new StringBuilder();
            for(int i=0; i < longestPalindromeLength; i++)
                str.append(chars[longestPalindromeBeginIndex + i]);
            return str.toString();
        }
        return null;
    }
}
