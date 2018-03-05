package common;

/**
 * Euclidean algorithm to find the GCD/HCF
 * 
 * @author kiran
 *
 */
public class GCD_or_HCF {

    public static void main(String []args) {
        System.out.println(getGCD(1071, 462));
    }
    
    public static long getGCD(long min, long max) {
        if(min > max) {
            return getGCD(max, min);
        }
        long gcd = 0;
        long remainder = max % min;
        while(remainder != 0) {
            max = min;
            min = remainder;
            remainder = max % min;
        }
        gcd = min;
        return gcd;
    }
}
