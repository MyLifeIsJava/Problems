package job.interview.amazon;

/**
 * The order information keeps coming in from E-commerce website as a stream of {prodId, quantity, timestamp}
 * We need to give the top "K" most popular (maximum quantity bought) products in 1 hour at any given point in time.
 * Multiple data points for same product id can come, in that case we should consider the aggregate quantity.
 * Also the data point which was there 1 hour ago should not be considered.
 * The value of "K" will be small < 10.
 *  
 * Asked at Amazon on 01-Sep-2018
 *  
 * @author kiransringeri
 *
 */
public class FindTopKProducts {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
