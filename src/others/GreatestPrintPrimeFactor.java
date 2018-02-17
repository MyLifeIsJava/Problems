package others;

public class GreatestPrintPrimeFactor {

    public static void main(String[] args) {
        double d = 13195D;
        long l = getGreatestPrimeFactor(d);
        System.out.printf("Greatest prime factor of number "+d+" is : "+l); 
    }

    private static long getGreatestPrimeFactor(double number){
        long i = 1;
        double num2 = number;
        for(i=2 ; i <= num2; i++) {
            if(num2 % i == 0) {
                num2 /= i;
                i--;
            }
        }
        return i;
    }
}
