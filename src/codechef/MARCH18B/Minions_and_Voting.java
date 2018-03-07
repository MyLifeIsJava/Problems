package codechef.MARCH18B;

import java.util.Scanner;

/**
 * Problem statement : https://www.codechef.com/MARCH18B/problems/MINVOTE
 * Status : Success
 * 
 * @author kiran
 *
 */
public class Minions_and_Voting {
    /*
    1 ≤ T ≤ 10^5
    1 ≤ N ≤ 10^5
    1 ≤ Si ≤ 10^9 for each valid i
    sum of N over all test cases won't exceed 10^6
    */
    public static void main(String[] args) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(System.in);
            int q = scanner.nextInt();
            for(int query=0; query < q; query++) {
                int n = scanner.nextInt();
                int []data = new int[n];
                for(int i=0; i < n ; i++) {
                    data[i] = scanner.nextInt();
                }
                solve(data);
            }
            
        }catch(Throwable th) {
            th.printStackTrace();
        }finally {
            if(scanner != null)
                scanner.close();
        }
    }

    private static void solve(int []data) {
//        System.out.println("Inside solve, data="+Arrays.toString(data));
        long []cumulativeSumsRight = new long[data.length];
        long []cumulativeSumsLeft = new long[data.length];
        
        int []result = new int[data.length];
        for(int i=0; i < data.length; i++) {
            if(i == 0)
                cumulativeSumsRight[i] = data[i];
            else
                cumulativeSumsRight[i] = cumulativeSumsRight[i-1] + data[i];
            
            int j = data.length - i - 1;
            if(j == (data.length - 1))
                cumulativeSumsLeft[j] = data[j];
            else
                cumulativeSumsLeft[j] = cumulativeSumsLeft[j+1] + data[j]; 
        }
//        System.out.println("cumulativeSumsRight="+Arrays.toString(cumulativeSumsRight));
//        System.out.println("cumulativeSumsLeft="+Arrays.toString(cumulativeSumsLeft));
//        System.out.println("data="+Arrays.toString(data));
        for(int i=0; i < data.length; i++) {
//            System.out.println("i="+i+", data="+data[i]);
            if(i > 0)
                result[i-1] = result[i-1] + 1; //Always vote for the one standing in front
            if(i < (data.length - 1))
                result[i+1] =result[i+1] + 1; //Always vote for the one standing immediately behind
            int left = i-2; //We can skip the one standing immediately in front
            int right = i+2; //We can skip the one standing immediately behind
            boolean leftDone = false;
            boolean rightDone = false;
            while (left >= 0 || right < data.length) {
//                System.out.println("\t\tleft="+left +", right="+right +",result="+Arrays.toString(result));
                if (leftDone && rightDone)
                    break;
                
                if(right < data.length) {
                    // Can this minion vote for minion[right]?
                    long rightSum = cumulativeSumsRight[right];
                    // Exclude the ith and jth minion's influence
                    rightSum = rightSum - data[right] - cumulativeSumsRight[i];
//                    System.out.println("\t\t\tsum="+cumulativeSumsRight[right]+"-"+data[right]+"-"+cumulativeSumsRight[i]+"="+rightSum);
                    if (data[i] >= rightSum)
                        result[right] = result[right] + 1;
                    else
                        // If a minion can't vote for jth minion standing behind
                        // behind, then it can't vote for (j+1), (j+2)... minions
                        rightDone = true;
                    right++;
                }
                
                if(left >= 0) {
                    // Can this minion vote for minion[left]?
                    long leftSum = cumulativeSumsLeft[left];
                    // Exclude the ith and jth minion's influence
                    leftSum = leftSum - data[left] - cumulativeSumsLeft[i];
                    if (data[i] >= leftSum)
                        result[left] = result[left] + 1;
                    else
                        // If a minion can't vote for jth minion in front, then it
                        // can't vote for (j-1), (j-2)... minions
                        leftDone = true;
                    left--;
                }
            }
//            System.out.println("\tresult="+Arrays.toString(result));
        }
        for(int res : result)
            System.out.print(res+" ");
        System.out.println();
    }
}
