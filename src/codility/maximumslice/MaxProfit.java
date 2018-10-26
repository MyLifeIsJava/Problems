package codility.maximumslice;

/**
 * https://app.codility.com/programmers/lessons/9-maximum_slice_problem/max_profit/
 * 
 * @author kiransringeri
 *
 */
public class MaxProfit {

  public static void main(String[] args) {
    int val = solution(new int[] {6,5,4,3});//23171, 21011,21123,21366,21013,21367});
    System.out.println(val);
  }

  public static int solution(int[] A) {
    int maxProfit = 0;
    if(A.length >= 2) {
      int n = A.length;
      int buyPrice = A[0];
      for(int i=0; i < n; i++) {
  //      I can buy or sell on this day
        int price = A[i];
        if(price <= buyPrice) {
          buyPrice = price;
        }else {
          int profit = price - buyPrice;
          if(profit > maxProfit) {
            maxProfit = profit;
          }
        }
      }
    }
    return maxProfit;
  }
}
