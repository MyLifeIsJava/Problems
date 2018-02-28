package techgig.techcon_two;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Prize Challenge by Techgig - TECHCON 2
 * Test 2 - CODING CHALLENGE - MEDIUM
 * Your Highest Score 70
 * 
 * @author kiran
 *
 */
public class Bitmap_Images {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        
        int [][]matrix1 = new int[n][m];        
        for(int i=0; i < n; i++) {
            for(int j=0; j < m; j++) {
                matrix1[i][j] = scanner.nextInt();
            }
        }
        
        int [][]matrix2 = new int[n][m];
        for(int i=0; i < n; i++) {
            for(int j=0; j < m; j++) {
                matrix2[i][j] = scanner.nextInt();
            }
        }
        
        doIt(n, m, matrix1, matrix2);
        
        /*
        int n = 4;
        int m = 4;
        int [][]matrix1 = new int[n][m];  
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                Random rand = new Random(System.nanoTime());
                int x = rand.nextInt(7);
                matrix1[i][j] = (x % 2 == 0 ? 0 : 1);
            }
        }
        int [][]matrix2 = transformMatrix(matrix1, 5);
//        matrix2[2][3] = (matrix2[2][3]+1)%2; 

        System.out.println(Arrays.deepToString(matrix1));
        System.out.println(Arrays.deepToString(matrix2));
        doIt(n, m, matrix1, matrix2);
        */
        
    }
    private static int[][] transformMatrix(int [][]input, int times){
        System.out.println("Flipping "+ times+" times");
        int [][]output = new int[input.length][input[0].length];
        for(int i=0; i < input.length; i++) {
            int []row = input[i];
            for(int j=0; j < row.length; j++) {
                output[i][j] = input[i][j];
            }
        }
        
        while(times > 0) {
            for(int i=0; i <= output.length - 3; i++) {
                if(times <= 0)
                    break;
                int []row = output[i];
                Random rand = new Random();
                if(rand.nextInt(15) % 2 != 0)
                    continue;
                for(int j=0; j <= row.length - 3; j++) {
                    rand = new Random();
                    if(rand.nextInt(7) % 2 != 0)
                        continue;
                    doFlip(output, i, j);
                    times --;
                    if(times <= 0)
                        break;
                }
            }
        }
        
        return output;
    }
    private static void doFlip(int [][]matrix1, int i, int j) {
//        System.out.println("Flipped: ("+i+","+j+")");
        matrix1[i][j] = (matrix1[i][j] + 1) % 2;
        matrix1[i][j+1] = (matrix1[i][j+1] + 1) % 2;
        matrix1[i][j+2] = (matrix1[i][j+2] + 1) % 2;
        
        matrix1[i+1][j] = (matrix1[i+1][j] + 1) % 2;
        matrix1[i+1][j+1] = (matrix1[i+1][j+1] + 1) % 2;
        matrix1[i+1][j+2] = (matrix1[i+1][j+2] + 1) % 2;
        
        matrix1[i+2][j] = (matrix1[i+2][j] + 1) % 2;
        matrix1[i+2][j+1] = (matrix1[i+2][j+1] + 1) % 2;
        matrix1[i+2][j+2] = (matrix1[i+2][j+2] + 1) % 2;
    }
    private static void doIt(int n, int m, int [][]matrix1, int [][]matrix2) {
        if(matrix1 == null || matrix1.length == 0){
            System.out.println("-1");
        }
        if(matrix2 == null || matrix2.length == 0){
            System.out.println("-1");
        }
        
        int flips = -1;
        if(n >= 3 && m >= 3) {
            flips = 0;
            
            for(int i=0; i <= n - 3; i++) {
                for(int j=0; j <= m - 3; j++) {
//                    System.out.println("i="+i+",j="+j);
                    if(matrix1[i][j] != matrix2[i][j]) {
//                        Flip the 3 X 3 sub matrix
                        doFlip(matrix1, i, j);
                        
                        flips++;
//                        System.out.println("\t"+Arrays.deepToString(matrix1));
                    }else {
//                        System.out.println("\tBits are same");
                    }
                }                
            }
            for(int i=0; i < n; i++) {
                if(flips == -1)
                    break;
                for(int j=0; j < n; j++) {
                    if(matrix1[i][j] != matrix2[i][j]) {
                        flips = -1;
                        break;
                    }
                }
            }
        }
        
        System.out.println(flips);
    }
}
