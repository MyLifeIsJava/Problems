package leetcode.weeklycontest._73;

public class Custom_Sort_String {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public String customSortString(String S, String T) {
        char[] t = T.toCharArray();
        int[] f = new int[26];
//        The array 't' will have counts of each alphabet in teh tartget string
        for(char c : t){
            f[c-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < S.length();i++){
//            For each string in the source string, put all occurrences of it in the target string in the buffer
            for(int j = 0;j < f[S.charAt(i)-'a'];j++){
                sb.append(S.charAt(i));
            }
//            Reset the occurent of this character as ZERO as we have handled this character
            f[S.charAt(i)-'a'] = 0;
        }
//        Now handle the other characters
        for(int i = 0;i < 26;i++){
            for(int j = 0;j < f[i];j++){
                sb.append((char)('a'+i));
            }
        }
        return sb.toString();
    }
}
