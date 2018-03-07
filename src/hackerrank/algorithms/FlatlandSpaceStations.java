package hackerrank.algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class FlatlandSpaceStations {

    static int flatlandSpaceStations(int n, int[] c) {
        Arrays.sort(c);
        int maxDist = 0;
        int currDist = 0;
        int prevStation = c[0];
        int nextStation = c[0];
        int stationIndex = 0;
        for(int i=0; i < n; i++) {
            while(stationIndex < c.length && i >= nextStation) {
                prevStation = nextStation;
                stationIndex ++;
                if(stationIndex < c.length)
                    nextStation = c[stationIndex];
            }
            int dist1 = Integer.MAX_VALUE;
            if(i >= prevStation)
                dist1 = i - prevStation;
            int dist2= Integer.MAX_VALUE;
            if(i <= nextStation)
                dist2 = nextStation - i;
            currDist = Math.min(dist1, dist2);
            if(currDist >= maxDist)
                maxDist = currDist;
        }
        return maxDist;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] c = new int[m];
        for(int c_i = 0; c_i < m; c_i++){
            c[c_i] = in.nextInt();
        }
        int result = flatlandSpaceStations(n, c);
        System.out.println(result);
        in.close();
    }

}
