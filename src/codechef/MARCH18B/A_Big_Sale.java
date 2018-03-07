package codechef.MARCH18B;

import java.text.DecimalFormat;
import java.util.Scanner;
/**
 * Problem statement : https://www.codechef.com/MARCH18B/problems/BIGSALE
 * 
 * Status : Completed [1st attempt :-) ]
 *  
 * @author kiran
 *
 */
public class A_Big_Sale {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        DecimalFormat df = new DecimalFormat("##.0000000");
        for(int a=0; a <t; a++) {
            int n = scanner.nextInt();
            double totalLoss = 0;
            for(int i=0; i<n; i++) {
                int price = scanner.nextInt();
                int quantity = scanner.nextInt();
                int discount = scanner.nextInt();
                if(quantity > 0 && discount > 0) {
//                    Loss is only when there are some items and there is some discount
                    totalLoss += getLoss(quantity, price, discount);
                }
            }
            System.out.println(df.format(totalLoss));
        }
    }
    private static double getLoss(double quantity, double price, double discount) {
        double loss = quantity * price * discount * discount / 10000.0;
        return loss;
    }
}
