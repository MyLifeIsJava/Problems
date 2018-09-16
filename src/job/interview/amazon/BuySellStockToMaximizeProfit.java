package job.interview.amazon;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of stock prices of previous day, find the maximum profit one can make by buying and selling it.
 * You can't sell before buying.
 * The index in array is the time in minutes from the market open.
 * You can't buy and sell in the same time.
 * 
 * Asked at Amazon on 01-Sep-2018
 * 
 * @author kiransringeri
 *
 */
public class BuySellStockToMaximizeProfit {

  public static void main(String[] args) {
    System.out.println(maximizeProfitBySingleBuySell(new int[] {10, 14, 12, 14, 5, 6, 9, 25, 1, 100}));
  }

  private static int maximizeProfitBySingleBuySell(int []data) {
    Integer bestProfit = null;
    if(data.length >= 2) {
//      We need atleast 2 data points
      int bestBuySoFar = data[0];
      for(int i=1; i < data.length; i++) {
        int currProfit = data[i] - bestBuySoFar;
        if(bestProfit == null || currProfit > bestProfit) {
          bestProfit = currProfit;
        }
        if(data[i] < bestBuySoFar) {
          bestBuySoFar = data[i];
        }
      }
    }
    return bestProfit;
  }
  
  private static List<Integer> maximizeProfitByMultipleBuySells(){
    List<Integer> profitsList = new ArrayList<>();
    
    return profitsList;
  }
}
