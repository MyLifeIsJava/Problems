package hackerrank.algorithms;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Problem statement : https://www.hackerrank.com/challenges/queens-attack-2/problem
 * Status: 
 * 
 * @author kiran
 *
 */
public class Queen_s_Attack_II {
    static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
//        Find the nearest obstacle in each direction
//        There are 8 directions in total
        int distanceToTop= r_q - 1;
        int distanceToBottom = n - r_q;
        int distanceToLeft = c_q - 1;
        int distanceToRight = n - c_q;
        
        int distanceToLeftTop = Math.min(r_q, c_q) - 1;
        int distanceToRightBottom = Math.min(n - r_q, n - c_q);
        int distanceToLeftBottom = Math.min(n-r_q, c_q - 1);
        int distanceToRightTop = Math.min(r_q - 1, n - c_q);
//        Instead store the distance from the queen to top, bottom, left and right
//        And distance to top left, bottom right, bottom left and top right
//        Then when we get an obstacle, update this distance (Distance of the obstacle from the queen)
//        Finally add all the distances
//        int [][]matrix = new int[n][n];
//        matrix[r_q-1][c_q-1] = 1;
//        System.out.println(distanceToTop+","+distanceToBottom+","+distanceToLeft+","+distanceToRight+","+distanceToLeftTop+","+distanceToRightBottom+","+distanceToLeftBottom+","+distanceToRightTop);
        for(int []obstacke : obstacles) {
//            matrix[obstacke[0]-1][obstacke[1]-1] = -1;
            int xDist = obstacke[0] - r_q;
            int yDist = obstacke[1] - c_q;
//            System.out.println("\t"+obstacke[0]+","+obstacke[1]+":"+xDist+","+yDist);
            if(xDist == 0) {
//                Obstacle is on the same row
                int newDist = Math.abs(yDist) - 1;
                if(yDist < 0) {
//                    Obstacle is on the left
                    if(newDist < distanceToLeft)
                        distanceToLeft = newDist;
                }else {
//                    Obstacle is on the right
                    if(newDist < distanceToRight)
                        distanceToRight = newDist;
                }
            }
            else if(yDist == 0) {
//              Obstacle is on the same column
                int newDist = Math.abs(xDist) - 1;
              if(xDist < 0) {
//                  Obstacle is on the top
                  if(newDist < distanceToTop)
                      distanceToTop = newDist;
              }else {
//                  Obstacle is on the bottom
                  if(newDist < distanceToBottom)
                      distanceToBottom = newDist;
              }
            }
            else {
//                Obstacle might be on the diagonals
                if(Math.abs(xDist) == Math.abs(yDist)) {
                    int newDist = Math.abs(xDist) - 1;
                    if(xDist < 0 && yDist < 0) {
//                        On the path to top left
                        if(newDist < distanceToLeftTop)
                            distanceToLeftTop = newDist;
                    }else if(xDist > 0 && yDist > 0) {
//                        On the path to bottom right
                        if(newDist < distanceToRightBottom)
                            distanceToRightBottom = newDist;
                    }else if(xDist < 0 && yDist > 0) {
//                        On the path to top right
                        if(newDist < distanceToRightTop)
                            distanceToRightTop = newDist;
                    }else if(xDist >0 && yDist < 0) {
//                        On the path to left bottom
                        if(newDist < distanceToLeftBottom)
                            distanceToLeftBottom = newDist;
                    }
                }
            }
        }
//        System.out.println(distanceToTop+","+distanceToBottom+","+distanceToLeft+","+distanceToRight+","+distanceToLeftTop+","+distanceToRightBottom+","+distanceToLeftBottom+","+distanceToRightTop);
        int result = distanceToTop+distanceToBottom+distanceToLeft+distanceToRight+distanceToLeftTop+distanceToRightBottom+distanceToLeftBottom+distanceToRightTop;
        /*
        System.out.println("<table border='1' cellspacing='0' cellpadding='1'><tr>");
        for(int i=0; i < n; i++) {
            System.out.println("<tr>");
            for(int j=0; j< n; j++) {
                String style = "";
                if(r_q-1 == i || c_q-1 == j) {
                    style = " style='background-color: yellow;'";
                }
                int distX = Math.abs(i - (r_q-1));
                int distY = Math.abs(j - (c_q-1));
                if(distX == distY){
                    style = " style='background-color: orange;'";
                }
                style +=" title='[" + (i+1)+","+(j+1) + "]'";
                System.out.print("<td "+ style+">" + matrix[i][j]+ "</td>");
            }
            System.out.println("</tr>");
        }
        System.out.println("</table>");
        */
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int r_q = in.nextInt();
        int c_q = in.nextInt();
        int[][] obstacles = new int[k][2];
        for(int obstacles_i = 0; obstacles_i < k; obstacles_i++){
            for(int obstacles_j = 0; obstacles_j < 2; obstacles_j++){
                obstacles[obstacles_i][obstacles_j] = in.nextInt();
            }
        }
        int result = queensAttack(n, k, r_q, c_q, obstacles);
        System.out.println(result);
        in.close();
    }
}
