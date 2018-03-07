package codechef.MARCH18B;

/**
 * Problem statement : https://www.codechef.com/MARCH18B/problems/XXOR
 * Status : Success after improving the performance for large input.
 * Now I am using a incrementing count array to find out the number of ones and zeroes.
 * 1 ≤ N ≤ 10^5
 * 1 ≤ Q ≤ 10^5
 * 0 ≤ Ai < 2^31
 * 
 */
import java.util.BitSet;
import java.util.Scanner;

public class Chef_and_Easy_Problem {

    public static void main(String[] args) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            int q = scanner.nextInt();
            int []data= new int[n];
            for(int i=0; i < n; i++) {
                data[i] = scanner.nextInt();
                
            }
            
            for(int query=0; query < q; query++) {
                int l = scanner.nextInt();
                int r = scanner.nextInt();
                long answer = solve(data, (query==0), l, r);
                System.out.println(answer);
            }
            /*
            int n = (int)Math.pow(10, 5);
            int []data = new int[n];
            for(int i=0; i < n; i++) {
                Random rand = new Random();
                data[i] = rand.nextInt(maxVal);
            }
            long totalTime = 0;
            long maxTime = 0;
            Random rand = new Random();
            int randTill = n + 1;
            for(int i=0; i<n; i++) {
                int l = rand.nextInt(randTill);
                if(l == 0) l = 1;
                int r = rand.nextInt(randTill);
                if(r == 0) r = 1;
                if(l > r) {
                    int t = l;
                    l = r;
                    r = t;
                }
                long st = System.currentTimeMillis();
                solve(data, (i==0), l, r);
                long et = System.currentTimeMillis();
                long time = (et-st);
                totalTime += time;
            }
            System.out.println("Total time="+totalTime+" ms");
            */
        }catch(Throwable th) {
            th.printStackTrace();
        }finally {
            if(scanner != null)
                scanner.close();
        }
    }

    private static final int maxVal = (int)Math.pow(2, 31);
    private static int[][] zeroesArray = null;
    private static int[][] onesArray = null;
    private static BitSet[] bitSetArray = null;
    
    private static long solve(int []data, boolean initial, int l, int r) {
        int n = data.length;
        if(initial) {
            bitSetArray = new BitSet[data.length];
            zeroesArray = new int[data.length][32];
            onesArray = new int[data.length][32];
            for(int i=0;i <n; i++) {
                bitSetArray[i] = BitSet.valueOf(new long[] {data[i]});
                
                for(int j=0; j < 32; j++) {
                    if(i > 0) {
                        zeroesArray[i][j] = zeroesArray[i-1][j];
                        onesArray[i][j] = onesArray[i-1][j];
                    }
                    
                    if(bitSetArray[i].get(j)) {
                        onesArray[i][j] = onesArray[i][j] + 1;
                    }else {
                        zeroesArray[i][j] = zeroesArray[i][j] + 1;
                    }
                }
            }
//            System.out.println("onesArray="+Arrays.deepToString(onesArray));
//            System.out.println("zeroesArray="+Arrays.deepToString(zeroesArray));
        }
        BitSet ans = BitSet.valueOf(new long[] {maxVal});
        for(int k=0; k < 32; k++) {
            boolean isOneAtL = bitSetArray[l-1].get(k);
            int ones = onesArray[r-1][k] - onesArray[l-1][k];
            if(isOneAtL)
                ones += 1;
            int zeroes = zeroesArray[r-1][k] - zeroesArray[l-1][k];
            if(!isOneAtL)
                zeroes += 1;
            if(ones >= zeroes) {
                ans.clear(k); 
            }
        }
        return ans.toLongArray()[0];
    }
}
