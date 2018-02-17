package others;

import java.util.LinkedHashSet;
import java.util.Set;

public class PrintPrimeFactors {

    public static void main(String[] args) {
        System.out.printf("Prime factors of number '%d' are : %s %n", 24, getPrimeFactors(24)); 
    }

    private static Set<Integer> getPrimeFactors(int number){
        Set<Integer> retSet = new LinkedHashSet<Integer>();
        int num2 = number;
        for(int i=2 ; i <= num2; i++) {
            if(num2 % i == 0) {
                retSet.add(i);
                num2 /= i;
                i--; // Keep dividing with the same number till we can
            }
        }
        return retSet;
    }
}
