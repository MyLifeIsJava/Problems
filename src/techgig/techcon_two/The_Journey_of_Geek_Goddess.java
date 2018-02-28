package techgig.techcon_two;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Prize Challenge by Techgig - TECHCON 2
 * Test 4 - CODING CHALLENGE - EXPERT
 * Your Highest Score 30
 * 
 * @author kiran
 *
 */
public class The_Journey_of_Geek_Goddess {

    private static class Mountain implements Comparable<Mountain>{
        Point base;
        Point top;
        @Override
        public int compareTo(Mountain m2) {
            if(base.x < m2.base.x)
                return -1;
            if(base.x > m2.base.x)
                return 1;
            double angle1 = Math.atan2(top.y - base.y, top.x - base.x);
            double angle2 = Math.atan2(m2.top.y - m2.base.y, m2.top.x - m2.base.x);
            if(angle1 > angle2)
                return -1;
            else if(angle1 == angle2)
                return 1;
            return 0;
        }
    }
    private static class Point implements Comparable<Point>{
        int x;
        int y;
        
        @Override
        public int compareTo(Point o2) {
            Point o1 = this;
            if(o1.x < o2.x)
                return -1;
            if(o1.x > o2.x)
                return 1;
            if(o1.y < o2.y)
                return -1;
            if(o1.y > o2.y)
                return 1;
            return 0;
        }
        
    }
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Mountain> mountains = new ArrayList<>();
        for(int i=0; i < n; i++) {
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();
            int x2 = scanner.nextInt();
            int y2 = scanner.nextInt();
            Mountain mountain = new Mountain();
            mountains.add(mountain);
            Point p1 = new Point();
            p1.x = x1; p1.y = y1;
            mountain.base = p1;
            Point p2 = new Point();
            p2.x = x2; p2.y = y2;
            mountain.top = p2;
        }
        
        Collections.sort(mountains);
        
        int count = 0;
        Point prevMountainTop = null;
        for(Mountain mount : mountains) {
            if(prevMountainTop == null) {
                count ++;
                prevMountainTop = mount.top;
            }
            else {
                boolean bottomX = mount.base.x <=  prevMountainTop.x;
                boolean bottomY = mount.base.y <= prevMountainTop.y;
                boolean topX = mount.top.x > prevMountainTop.x;
                if(bottomX && bottomY && topX) {
                    count ++;
                    prevMountainTop = mount.top;
                }
            }
        }
        System.out.println(count);
    }

}
