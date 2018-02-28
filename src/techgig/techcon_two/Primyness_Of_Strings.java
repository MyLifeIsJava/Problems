package techgig.techcon_two;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Prize Challenge by Techgig - TECHCON 2
 * Test 1 - CODING CHALLENGE - EASY
 * Your Highest Score 100
 * 
 * @author kiran
 * 
 */
public class Primyness_Of_Strings {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long st = System.currentTimeMillis();
        String str = scanner.nextLine();
        solve(str, false);
        
        /*
        long st = System.currentTimeMillis();
        String str = "59775989755668587";// "59775989755668587";// "59775989755668587";
        st = System.currentTimeMillis();
        solve(str, false);
        long et = System.currentTimeMillis();
        System.out.println("Size="+str.length()+", time="+(et-st)+" ms");
        System.out.println("time_isPrime="+time_isPrime+", primeChecks="+primeChecks);
        */
    }
    
    public static List<Long> sieveOfEratosthenes(long n) {
        Map<Long, Boolean> map = new HashMap<>();
        for (long p = 2; p * p <= n; p++) {
            Boolean b = map.get(p);
            if (b == null || b.booleanValue()) {
                for (long i = p * 2; i <= n; i += p) {
                    map.put(i, false);
                }
            }
        }
        List<Long> primeNumbers = new LinkedList<>();
        for (long i = 2; i <= n; i++) {
            Boolean b = map.get(i);
            if (b == null || b.booleanValue()) {
                primeNumbers.add(i);
            }
        }
        return primeNumbers;
    }
        
    private static void solve(String str, boolean print) {
        int length = str.length();
        int []intArray = new int[length];
        int []tempArray = new int[length];
//        System.out.println("Initializing");
        for(int i=0; i < length; i++) {
            tempArray[i] = (int)Math.pow(2, i);
            intArray[i] = Integer.parseInt(String.valueOf(str.charAt(i)));
        }
        
        int maxCombinations = (int)Math.pow(2, length) - 1;
        int start = 0;
        int count = 0;
        
//        System.out.println("Processing");
        
        BigInteger bi = new BigInteger(str);
        double d1= bi.doubleValue();
        if(d1 == 2.0 || d1 == 3.0 || (d1 > 2 && isPrime(bi))) {
            println(bi , print);
            count ++;
        }
        Map<String, Boolean> handledNumbers = new HashMap<>();  
        while(start < maxCombinations - 1) {
            start ++;
            int leastSignificantDigit = -1;
            StringBuilder buff = new StringBuilder();
//            When start = maxCombinations, we might get long overflow (For the actual given number)
            for(int i=0; i < length; i++) {
                int pos = tempArray[i];
                if((pos & start) > 0) {
//                    val = val * 10 + intArray[i];
                    buff.append(intArray[i]);
                    leastSignificantDigit = intArray[i];
                }
            }
            str = buff.toString();
            if(str.length() > 6)
                continue;
            if(handledNumbers.containsKey(str)) {
                boolean prime = handledNumbers.get(str);
                if(prime) {
                    count ++;
                    println(str , print);
                }
                continue;
            }
            long val = Long.parseLong(buff.toString());
            if(val == 2 || val == 3) {
                println(val , print);
                handledNumbers.put(str, true);
                count ++;
            }
            else if(val > 1 && leastSignificantDigit % 2 != 0) {
//                Number is even, so not a prime
                if(isPrime(val)){
                    println(val , print);
                    count ++;
                    handledNumbers.put(str, true);
                }else {
                    handledNumbers.put(str, false);
                }
            }else {
                handledNumbers.put(str, false);
            }
        }
        long et = System.currentTimeMillis();
        System.out.println(count);
    }
    private static void println(Object n, boolean print) {
       if(print)
           System.out.println(n);
    }
    private static long time_isPrime = 0;
    private static int primeChecks = 0;
    
    private static boolean isPrime(long d) {
        primeChecks ++;
        long st_isPrime = System.currentTimeMillis();
        if(d % 2 == 0)
            return false;
        long mid = (long)Math.sqrt(d);

        for(long l = 3 ; l <= mid ; l+=2) {
            if(d % l == 0) {
                return false;
            }
        }
        long et_isPrime = System.currentTimeMillis();
        time_isPrime += (et_isPrime-st_isPrime);
        
        return true;
    }
    private static boolean isPrime(BigInteger bi) {
        primeChecks ++;
        long st_isPrime = System.currentTimeMillis();
        double d = bi.doubleValue();
        if(d % 2 == 0)
            return false;
        long mid = (long)Math.sqrt(d);

        for(long l = 3 ; l <= mid ; l+=2) {
            if(d % l == 0) {
                return false;
            }
        }
        long et_isPrime = System.currentTimeMillis();
        time_isPrime += (et_isPrime-st_isPrime);
        
        return true;
    }
}
