package leetcode;

/**
 * Problem definition : https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 * 
 * Status : Completed
 * 
 * @author kiran
 *
 */
public class Median_Of_Two_Sorted_Arrays {

    public static void main(String[] args) {
        try {
            Median_Of_Two_Sorted_Arrays obj = new Median_Of_Two_Sorted_Arrays();
            double val = 0;
//            val = obj.findMedianSortedArrays(new int[]{1,3}, new int[]{2});
//            System.out.println(val);
            val = obj.findMedianSortedArrays(new int[]{1,2}, null);
            System.out.println(val);
//            val = obj.findMedianSortedArrays(new int[]{1,3}, new int[]{2,5,6,7});
//          System.out.println(val);
        }catch(Throwable th) {
            th.printStackTrace();
        }
    }

    private double getMedian(int []nums) {
        double median = 0;
        int mid = nums.length / 2;
        if(nums.length % 2 == 0) {
            median = (nums[mid] + nums[mid-1])/2.0;
        }else {
            median = nums[mid];
        }
        return median;
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        Logic is keep splitting both the arrays so that the total count of left side arrays is same as total count of right side arrays
//        If we divide nums1 at i and nums2 at j, then len(nums1[0...i-1]+len(nums2[0...j-1]) = len(nums1[i...n]) + len(nums2[j...m])
//        We keep splitting while we get left arrays always smaller than right array
//        i.e, nums1[i-1] <= nums2[j] and nums2[j-1]<=nums1[i]
//        Whenever this criteria is not satisfied, we move either left or right to try to satisfy this criteria
          
        int array1Size = nums1 == null ? 0 : nums1.length;
        int array2Size = nums2 == null ? 0 : nums2.length;
        
//      Let us solve some trivial cases initially
        if(array1Size == 0 && array2Size == 0) {
            return 0;
        }
        else if(array1Size == 0) {
            return getMedian(nums2);
        }else if(array2Size == 0) {
            return getMedian(nums1);
        }
        
//      Let us always have nums1 as smaller length array
        if(array1Size > array2Size) {
            return findMedianSortedArrays(nums2, nums1);
        }
        
//        Let us start splitting arrays and find the median
        int start = 0;
        int end = array1Size;
        while(start <= end) {
//            First array from 0 to (i-1)
            int i = (start + end) / 2;
//            We have to have left and right array sizes same
//            So we have to split Y such a way that this criteria is satisfied
            int arraySize = (array1Size + array2Size + 1) / 2;
            int j = arraySize - i;
//            Now check these 2 arrays (the split arrays)
            int array1LeftMax = i == 0 ? Integer.MIN_VALUE : nums1[i-1]; //We might have a situation where we have nothing in left array
            int array1RightMin = i == array1Size ? Integer.MAX_VALUE : nums1[i]; //Right array is empty
            int array2LeftMax = j == 0 ? Integer.MIN_VALUE : nums2[j-1];
            int array2RightMin = j == array2Size ? Integer.MAX_VALUE : nums2[j];
            
            boolean medianFound = array1LeftMax <= array2RightMin && array2LeftMax <= array1RightMin;
            if(medianFound) {
//                We have found the median : Take max from left array and min from right array
                if((array1Size+array2Size) % 2 == 0) {
//                    Even size array
                    return (Math.max(array1LeftMax, array2LeftMax) + Math.min(array1RightMin, array2RightMin)) / 2.0;
                }else {
                    return Math.max(array1LeftMax, array2LeftMax);
                }
            }
            else if(array1LeftMax > array2RightMin) {
//                We have to move left
                end = i - 1;
            }
            else {
//                We have to move right
                start = i +1;
            }
        }
        throw new IllegalArgumentException("Arrays are not sorted");
    }
}
