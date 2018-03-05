package leetcode.weeklycontest._74;

public class NumberOfSubarraysWithBoundedMaximum {

    public static void main(String[] args) {
        NumberOfSubarraysWithBoundedMaximum obj = new NumberOfSubarraysWithBoundedMaximum();
        System.out.println(obj.numSubarrayBoundedMax(new int[] {2, 1, 4, 3}, 2, 3));
    }

    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        long count = 0;
        long subArraySize = 0;
        int i=0;
        int maxTillNow = Integer.MIN_VALUE;
        for(; i <A.length; i++) {
            if(A[i] > maxTillNow)
                maxTillNow = A[i];
            if(maxTillNow < L || maxTillNow > R) {
                if(subArraySize > 0) {
                    count += (subArraySize * (subArraySize +1))/2;
                    System.out.println("subArraySize="+subArraySize+","+count);
                }
                subArraySize = 0; 
                maxTillNow = Integer.MIN_VALUE;
            }else {
                subArraySize ++;
            }
        }
        if(i == A.length && subArraySize > 0) {
            count += (subArraySize * (subArraySize +1))/2;
            System.out.println("subArraySize="+subArraySize+","+count);
        }
        return (int)count;
    }
}
