package techgig.compete.job.lti;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/**
 * Doesn't work for some cases
 * 
 * @author kiran
 *
 */
public class Ritik_the_day_dreamer {

    public static void main(String[] args) {
        Scanner scanner = null;
        try {
            /*
            scanner = new Scanner(System.in);
            int m = scanner.nextInt();// Rows. 1 <= M <= 1000
            int n = scanner.nextInt();// Columns. 1 <= N <= 1000
            int [][]data = new int[m][n];
            for(int i=0; i < m; i++) {
                for(int j=0; j< n; j++) {
                    data[i][j] = scanner.nextInt();
                }
            }
            scanner.close();
            
            long ans = solve(m, n, data, false);
            System.out.println(ans);
            */
            /*
            int m = 1000;
            int n = 1000;
            int [][]data = new int[m][n];
            for(int i=0; i < m; i++) {
                for(int j=0; j < n; j++) {
                    Random rand = new Random();
                    int val = -1 * m * n;// rand.nextInt((2*m*n)+1) - (m*n);
//                    We dont need ZERO
                    while(val == 0)
                        val = rand.nextInt((2*m*n)+1) - (m*n);
                    data[i][j] = val;
                }
            }
            data[0][0] = 0;
            data[m-1][n-1] = 0;
            if(m*n < 100)
                System.out.println(Arrays.deepToString(data));
            System.out.println("Matrix cells="+(m*n));
            long st = System.currentTimeMillis();
            long ans = solve(m, n, data, false);
            long et = System.currentTimeMillis();
            long time = et - st;
            System.out.println("Ans="+ans+", Time="+time);
            */
            
            int [][]data = {
                    {0, 1 , 2},
                    {-500, -500 , 3},
                    {6, 5 , 4},
                    {7, -500, -500},
                    {8, 9, 0},
                    };
            System.out.println(Arrays.deepToString(data));
            long ans = solve(data.length, data[0].length, data, true);
            System.out.println("Answer="+ans);
            
        }catch(Throwable th) {
            th.printStackTrace();
        }finally {
            if(scanner != null)
                scanner.close();
        }
    }

    private static long solve(int m, int n, int [][]data, boolean debug) {
        if(m <= 1 && n <= 1)
            return 0;
        
//        Matrix stores the minimum moves needed to reach the end point
        long [][]minMoves = new long[m][n];
//        Initialize to -1
        for(int row=m-1; row >= 0; row--) {
            for(int col=n-1; col >= 0; col--) {
                minMoves[row][col] = -1;
            }
        }
//      If we are the last cell, then we dont need any moves
        minMoves[m-1][n-1] = 0;
      
//      Do a breadth first traversal and reach 0,0, at each step set/update minMoves[row][col] with the minimum value possible
        class MatrixCell{
            int row;
            int col;
            public MatrixCell(int row, int col) {
                this.row = row; this.col = col;
            }
            @Override
            public int hashCode() {
                return (row+"."+col).hashCode();
            }
            @Override
            public boolean equals(Object obj) {
                if(obj instanceof MatrixCell) {
                    MatrixCell cell2 = (MatrixCell)obj;
                    return cell2.row == row && cell2.col == col;
                }
                return false;
            }
        }
//        LinkedList<MatrixCell> queue = new LinkedList<>();
        LinkedHashMap<MatrixCell, Boolean> queue = new LinkedHashMap<>();
//      First add the adjacent cells of the last cell to the queue
//        Map<MatrixCell, Boolean> addedCells = new HashMap<>();
        if(n > 1) {
            MatrixCell cell = new MatrixCell(m-1, n-2);
//            queue.add(cell);
//            addedCells.put(cell, true);
            queue.put(cell, true);
        }
        if(m > 1) {
            MatrixCell cell = new MatrixCell(m-2, n-1);
//            queue.add(cell);
//            addedCells.put(cell, true);
            queue.put(cell, true);
        }
        Map<Integer, Long> minValMap = new HashMap<>();
        
        while(!queue.isEmpty()) {
            MatrixCell cell = queue.keySet().iterator().next();// queue.poll();
            queue.remove(cell);
            int row = cell.row;
            int col = cell.col;
//            if(row == 0 && col == 0)
//                System.out.println("Handling cell ["+row+","+col+"]");
            int sleepTime = data[row][col] < 0 ? Math.abs(data[row][col]) : 0;
            long currCellMoves = sleepTime + 1;
            long nextCellMoves = Integer.MAX_VALUE;
            if(row + 1 < m) {
//                Cell in next row exists
                nextCellMoves = minMoves[row+1][col];
//                System.out.println("\tValue at ["+(row+1)+","+col+"] is "+ minMoves[row+1][col]);
            }
            if(col + 1 < n) {
//                Cell in next column exists
//                System.out.println("\tValue at ["+(row)+","+(col+1)+"] is "+ minMoves[row][col+1]);
                if(minMoves[row][col+1] < nextCellMoves)
                    nextCellMoves = minMoves[row][col+1];
            }
//          check if we can jump to another cell with same value and less value of moves compared to 'nextCellMoves'
            Long jumpCellMoves = null;//minValMap.get(data[row][col]);
            if(data[row][col] > 0)
                jumpCellMoves = minValMap.get(data[row][col]);
            if(jumpCellMoves != null && jumpCellMoves.longValue() < nextCellMoves) {
                nextCellMoves = jumpCellMoves;
            }
            
            currCellMoves += nextCellMoves;
            minMoves[row][col] = currCellMoves;
            
            if(jumpCellMoves == null || jumpCellMoves.longValue() > currCellMoves){
                minValMap.put(data[row][col], currCellMoves);
            }
                
//            System.out.println("\tValue set to "+minMoves[row][col]);
            int prevRow = row - 1;
            int prevCol = col - 1;
            if(prevRow >= 0) {
                MatrixCell prevCell = new MatrixCell(prevRow, col);
                if(!queue.containsKey(prevCell))
                    queue.put(prevCell, true);
//                if(!addedCells.containsKey(prevCell)) {
//                    queue.add(prevCell);
//                    addedCells.put(prevCell, true);
//                }
            }
            if(prevCol >= 0) {
                MatrixCell prevCell = new MatrixCell(row, prevCol);
                if(!queue.containsKey(prevCell))
                    queue.put(prevCell, true);
//                if(!addedCells.containsKey(prevCell)) {
//                    queue.add(prevCell);
//                    addedCells.put(prevCell, true);
//                }
            }
            int nextRow = row + 1;
            int nextCol = col + 1;
            if(nextRow < m) {
                if(minMoves[nextRow][col] > currCellMoves) {
                    
                }
            }
            if(nextCol < n) {
                if(minMoves[nextRow][col] > currCellMoves) {
                    
                }
            }
        }
        
        if(debug && m*n < 100)
            System.out.println(Arrays.deepToString(minMoves));
        return minMoves[0][0];
    }
    
}
