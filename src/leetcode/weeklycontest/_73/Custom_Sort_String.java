package leetcode.weeklycontest._73;

public class Custom_Sort_String {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public String customSortString(String S, String T) {
        char[] t = T.toCharArray();
        int[] f = new int[26];
        for(char c : t){
            f[c-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < S.length();i++){
            for(int j = 0;j < f[S.charAt(i)-'a'];j++){
                sb.append(S.charAt(i));
            }
            f[S.charAt(i)-'a'] = 0;
        }
        for(int i = 0;i < 26;i++){
            for(int j = 0;j < f[i];j++){
                sb.append((char)('a'+i));
            }
        }
        return sb.toString();
    }
}
