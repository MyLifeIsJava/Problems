package leetcode.weeklycontest._73;

public class Domino_and_Tromino_Tiling {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public int numTilings(int n) {
        int mod = 1000000007;
        long[] dp = new long[4];
        dp[0] = 1;
        for(int i = 0;i < n;i++){
            long[] ndp = new long[4];
            // ||
            ndp[3] += dp[0];
            // |
            ndp[1] += dp[2];
            ndp[2] += dp[1];
            // none
            ndp[0] += dp[3];
            // -
            ndp[0] += dp[0];
            
            ndp[1] += dp[0];
            ndp[2] += dp[0];
            ndp[3] += dp[1];
            ndp[3] += dp[2];
            
            for(int j = 0;j < 4;j++){
                dp[j] = ndp[j] % mod;
            }
        }
        return (int)dp[0];
    }
}
