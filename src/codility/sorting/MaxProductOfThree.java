package codility.sorting;

/**
 * https://app.codility.com/programmers/lessons/6-sorting/max_product_of_three/
 * 
 * @author kiransringeri
 *
 */
public class MaxProductOfThree {

  public static void main(String[] args) {
    System.out.println(solution(new int[] {-3, 1, 2, -2, 5, 6}));
    System.out.println(solution(new int[] {-5, 5, -5, 4}));
    System.out.println(solution(new int[] {4, 7, 3, 2, 1, -3, -5}));
  }

  public static int solution(int[] A) {
//    Find the 3 maximum numbers
    int max1 = Integer.MIN_VALUE;
    int max2 = Integer.MIN_VALUE;
    int max3 = Integer.MIN_VALUE;
    
    int min1 = Integer.MAX_VALUE;
    int min2 = Integer.MAX_VALUE;
    int min3 = Integer.MAX_VALUE;
    
    for(int val :  A) {
      if(val >= max1) {
        max3 = max2;
        max2 = max1;
        max1 = val;
      }else if(val >= max2) {
        max3 = max2;
        max2 = val;
      }else if(val >= max3) {
        max3 = val;
      }
      
      if(val <= min1) {
        min3 = min2;
        min2 = min1;
        min1 = val;
      }else if(val <= min2) {
        min3 = min2;
        min2 = val;
      }else if(val <= min3) {
        min3 = val;
      }
    }
//    System.out.println("Max:"+max1+","+max2+","+max3);
//    System.out.println("Min:"+min1+","+min2+","+min3);
//    It might happen that we have the below
//    -100, -99, ... , 10, 12, 14
//    In this case -100 * -99 * 14 is the highest product
    int productOfMin = min1 * min2;
    int productOfMax = max2 * max3;
    int product = 0;
//    System.out.println("productOfMin="+productOfMin+",productOfMax="+productOfMax);
    if(productOfMin > productOfMax && max1 >= 0) {
      product = productOfMin * max1;
    }
    else {
      product = productOfMax * max1;
    }
    return product;
  }
}
