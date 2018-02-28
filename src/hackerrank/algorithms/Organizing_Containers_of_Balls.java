package hackerrank.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Problem statement : https://www.hackerrank.com/challenges/organizing-containers-of-balls/problem
 * 
 * @author kiran
 *
 */
public class Organizing_Containers_of_Balls {
    static String organizingContainers(int[][] container) {
        // Complete this function
        String possiBleResult = "Possible";
        String impossiBleResult = "Impossible";
        boolean possible = true;
        if(container == null || container.length == 0) {
            return impossiBleResult;
        }
        
        int size = container.length;
        Long []containersCount = new Long[size];
        long []typesCount = new long[size];
        for(int i=0; i < size; i++) {
//            i is the container
            for(int j=0; j < size; j++) {
//                j is the type
                if(containersCount[i] == null)
                    containersCount[i] = 0L;
                typesCount[j] += container[i][j];
                containersCount[i] += container[i][j];
            }
        }
        List<Long> containersCountList = new ArrayList<>(Arrays.asList(containersCount));
        for(Long l : typesCount) {
            if(!containersCountList.remove(l)) {
                possible = false;
                break;
            }
        }

        return possible ? possiBleResult : impossiBleResult;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int n = in.nextInt();
            int[][] container = new int[n][n];
            for(int container_i = 0; container_i < n; container_i++){
                for(int container_j = 0; container_j < n; container_j++){
                    container[container_i][container_j] = in.nextInt();
                }
            }
            String result = organizingContainers(container);
            System.out.println(result);
        }
        in.close();
    }
}
