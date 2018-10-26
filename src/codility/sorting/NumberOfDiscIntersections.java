package codility.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * https://app.codility.com/programmers/lessons/6-sorting/number_of_disc_intersections/
 * 
 * @author kiransringeri
 *
 */
public class NumberOfDiscIntersections {

  public static void main(String[] args) {
//    System.out.println(solution(new int[] {1,5,2,1,4,0}));
    System.out.println(solution(new int[] {1, 2147483647, 0}));
  }

  
  public static int solution(int[] A) {
    class Point{
      long x;
      boolean left = true;
      Point(long x, boolean left){
        this.x = x;
        this.left = left;
      }
      public String toString() {
        return x+(left?"( ":") ");
      }
    }
    
    List<Point> points = new ArrayList<>();
    int n = A.length;
    for(int i=0; i < n; i++) {
      Point leftPoint = new Point((long)i-(long)A[i], true);
      Point rightPoint = new Point((long)i+(long)A[i], false);
      points.add(leftPoint);
      points.add(rightPoint);
    }
//    Sort on X, If two have same X, then the 'left' will come before 'right'
    Collections.sort(points, new Comparator<Point>() {
      @Override
      public int compare(Point o1, Point o2) {
        if(o1.x < o2.x) {
          return -1;
        }else if(o1.x > o2.x) {
          return 1;
        }else if(o1.left) {
          return -1;
        }else if(o2.left) {
          return 1;
        }else {
          return 0;
        }
      }
    });
    int totalIntersections = 0;
    int currentOpenBraces = 0;
    for(Point point : points) {
      if(point.left) {
//        This is a left brace, so will intersect will all open braces
        totalIntersections += currentOpenBraces;
//        Increment the open brabces
        currentOpenBraces ++;
        if(totalIntersections > 10000000) {
          totalIntersections = -1;
          break;
        }
      }else {
//        Close brace. SO decrease the open braces count
        currentOpenBraces --;
      }
    }
    return totalIntersections;
  }
}
