package others;

public class NumberConverter {

    public static void main(String[] args) {
        System.out.println(convertToDecimal("111", 2));
        System.out.println(convertToDecimal("G", 16));

    }

    public static int convertToDecimal(String number, int base) {
        int retVal = 0;
        if(base < 2 || base > 16) return -1;
        
        for(int i=0; i < number.length(); i++) {
            int v = digitToValue(number.charAt(i), base);
            retVal = retVal * base + v;
        }
        
        return retVal;
    }
    
    private static int digitToValue(char c, int base) {
        int intVal = (int)c;
        if(intVal >= '0' && intVal <= '9')
            intVal = intVal - '0';
        else if('a' <= intVal && intVal <= 'z')
            intVal = 9 + (1 + intVal - (int)'a');
        else if('A' <= intVal && intVal <= 'Z')
            intVal = 9 + (1 + intVal - (int)'A');
        if(intVal >= base)
            return -1;
        return intVal;
    }
}
