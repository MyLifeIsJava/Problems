package google.codejam;

import java.util.Scanner;

/**
 * Problem description : https://code.google.com/codejam/contest/3264486/dashboard#s=p1&a=0
 * @author kiran
 * Status : Fails for 735, 424, 825 etc
 */
public class TidyNumbers {
    public static void main(String []args) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(System.in);
            int count = scanner.nextInt();
            scanner.nextLine();
            String []data = new String[count];
            for(int i=0; i < count; i++) {
                data[i] = scanner.nextLine();
            }
            for(int i=0; i < count; i++) {
                String val  = data[i];
                String res = getGreatestTidy(val);
                System.out.println("Case #"+ (i+1) +": "+ res);
                for(int k=0; k < res.length(); k++) {
                    int currVal = Integer.parseInt(""+res.charAt(k));
                    if(k +1 < res.length()) {
                        int nextVal = Integer.parseInt(""+res.charAt(k+1));
                        if(nextVal < currVal) {
                            System.err.println("WRONG: input="+data[i]+", output="+res);
                        }
                    }
                }
            }
        }catch(Throwable th) {
            
        }
    }
    
    private static String getGreatestTidy(String number) {
        String valStr = "";
        int size = number.length();
        boolean decrement = false;
        for(int i= size - 1; i >= 0; i--) {
            int currVal = Integer.parseInt(""+number.charAt(i));
            if(decrement) {
                currVal -= 1;
            }
            decrement = false;
            if(i - 1 >= 0) {
                if(currVal == 0)
                    decrement = true;
                if(!decrement) {
                    int prevVal = Integer.parseInt(""+number.charAt(i - 1));
                    if(prevVal == 0 || currVal < prevVal) {
                        decrement = true;
                    }
                }
                if(decrement) {
//                    Make current value as 9
                    currVal = 9; 
//                    And we need to decrement the previous value
                }
            }
            if(i != 0 || currVal != 0)
                valStr = currVal + valStr;
        }
        return valStr;
    }
}
