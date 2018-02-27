package leetcode.weeklycontest._73;

public class Domino_and_Tromino_Tiling {

    public static void main(String[] args) {
        Domino_and_Tromino_Tiling obj = new Domino_and_Tromino_Tiling();
        for(int i=0; i < 5; i++) {
            System.out.println("N="+i+", ans="+ obj.numTilings(i));
        }
    }
/*
    def numTilings(self, N):
        def numTilingsD(N):
            if N in cacheD: return cacheD[N]
            if N <= 2: return N if N > 0 else 1 if N == 0 else 0
            cacheD[N] = (numTilingsD(N - 2) + numTilingsD(N - 1) + (2 * numTilingsT(N - 1))) % ((10**9) + 7)
            return cacheD[N]

        def numTilingsT(N):
            if N in cacheT: return cacheT[N]
            if N <= 2: return 1 if N == 2 else 1 if N == 0 else 0
            cacheT[N] = (numTilingsD(N - 2) + numTilingsT(N - 1)) % ((10**9) + 7)
            return cacheT[N]
        cacheD, cacheT = {}, {}
        return numTilingsD(N)
*/                
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
