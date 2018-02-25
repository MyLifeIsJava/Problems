package leetcode.weeklycontest._73;

public class Rotated_Digits {
    public static void main(String []args) {
        Rotated_Digits obj = new Rotated_Digits();
        obj.rotatedDigits(100);
    }
    
    public int rotatedDigits(int N) {
        int ret = 0;
        outer:
        for(int i = 1;i <= N;i++){
            char[] s = Integer.toString(i).toCharArray();
            boolean ok = false;
            for(char c : s){
                if(c == '0' || c == '1' || c == '8'){
                    continue;
                }
                if(c == '2' || c == '5' || c == '6' || c == '9'){
                    ok = true;
                    continue;
                }
                continue outer;
            }
            if(ok)ret++;
        }
        return ret;
    }
}
