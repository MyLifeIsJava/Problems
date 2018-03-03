package techgig.techcon_two;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;


/**
 * Prize Challenge by Techgig - TECHCON 2
 * Test 4 - CODING CHALLENGE - EXPERT
 * Your Highest Score 90
 * Status : Tried to solve all test cases, but current code get sonly 10 score
 * 
 * @author kiran
 *
 */
public class The_Journey_of_Geek_Goddess {
    private static int counter = 0;
    
    private static class Mountain{
        Point base;
        Point top;
        double m = 0;
        double c = 0;
        boolean mcComputed = false;
        int count = counter++;
        public String toString() {
            return "["+base.toString()+","+top.toString()+"]";
        }
        private void computeMandC(){
            m = (double) (top.y - base.y) / ((double) (top.x - base.x));
            c = (double) base.y - m * base.x;
            mcComputed = true;
        }
        public double getY(Point p) {
            if(!mcComputed)
                computeMandC();
            double y = m * p.x + c;
            return y;
        }
    }
    private static class Point{
        int x;
        int y;
        public String toString() {
            return "("+x+","+y+")";
        }
    }
    public static void main(String[] args) {
        List<Mountain> mountains = new ArrayList<>();
        
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
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
        solve(mountains, false);        
        
        
        /*
        Mountain m = new Mountain();mountains.add(m);
        m.base = new Point(); m.base.x = 0; m.base.y = 0;
        m.top = new Point(); m.top.x = 10000000; m.top.y = 9934500;
        
        m = new Mountain();mountains.add(m);
        m.base = new Point(); m.base.x = 1; m.base.y = 100;
        m.top = new Point(); m.top.x = 10; m.top.y = 500;
        
        m = new Mountain();mountains.add(m);
        m.base = new Point(); m.base.x = 10000000; m.base.y = 9907200;
        m.top = new Point(); m.top.x = 10092900; m.top.y = 10000100;
        m.count = 929;
        
        m = new Mountain();mountains.add(m);
        m.base = new Point(); m.base.x = 10000000; m.base.y = 9907300;
        m.top = new Point(); m.top.x = 10092800; m.top.y = 10000100;
        m.count = 928;
        
        m = new Mountain();mountains.add(m);
        m.base = new Point(); m.base.x = 10000000; m.base.y = 9934500;
        m.top = new Point(); m.top.x = 10065600; m.top.y = 10000100;
        m.count = 656;
        
        for(Mountain m1 : mountains) {
            System.out.println(m1.count+"->"+m1);
        }
        */
        
        /*
        int n = 100000;
        int x1 = 10000000;
        int y1 = 10000000;
        int x2 = 10000100;
        int y2 = 10000100;
        
        Mountain m = new Mountain();mountains.add(m);
        m.base = new Point(); m.base.x = 0; m.base.y = 0;
        m.top = new Point(); m.top.x = x1; m.top.y = y1;
        int change = 100;
//        System.out.println(m.count+"->"+m);
        for(int i=0; i < n; i++) {
            m = new Mountain();mountains.add(m);
            m.base = new Point(); m.base.x = x1; m.base.y = y1;
            m.top = new Point(); m.top.x = x2; m.top.y = y2;
            y1 -= change;
            x2 += change;
//            System.out.println(m.count+"->"+m);
        }
        */
        /*
        Collections.shuffle(mountains);
        long st = System.currentTimeMillis();
        solve(mountains, false);
        long et = System.currentTimeMillis();
        System.out.println("Time="+((et-st)/1000) +" seconds");
        */
    }
    
    private static Mountain getNextMountain(Mountain currMount, List<Mountain> mountains) {
        
        Mountain nextMount = null;
//        double nextMountYIntersection = 0;
        ListIterator<Mountain> iter = mountains.listIterator();
//        int count = 0;
        boolean currMountGot = false;
        while (iter.hasNext()) {
//            count ++;
            Mountain mount = iter.next();
            if(!currMountGot) {
                if(mount == currMount)
                    currMountGot = true;
                continue;
            }
            
            if (mount.base.x <= currMount.top.x) {
                if (mount.top.x <= currMount.top.x) {
                    iter.remove();
                } else {
                    boolean bottomY = mount.base.y <= currMount.top.y;
                    if (bottomY) {
                        double y2 = mount.getY(currMount.top);
                        if (y2 < currMount.top.y) {
                            if (nextMount == null) {
                                nextMount = mount;
//                                nextMountYIntersection = y2;
                                break;
                            }/* else if (y2 > nextMountYIntersection) {
                                nextMount = mount;
                                nextMountYIntersection = y2;
                            }*/
                        }else {
                            iter.remove(); //This causes most of the test cases to fail!
                        }
                    }else {
                        iter.remove(); //This causes most of the test cases to fail!
                    }
                }
            }else {
//                Since we have sorted the list on base.x, we can stop at this stage as all next points will have base.x more than this
                break; //This causes most of the test cases to fail!
            }
        }
//        System.out.println("\tTested "+ count+" mountains");
        if(nextMount != null)
            mountains.remove(currMount);
        return nextMount;
    }
    
    private static void solve(List<Mountain> mountains, boolean print) {
        
        if(mountains.isEmpty()) {
            System.out.println("0");
            return;
        }
        
        long l1 = System.currentTimeMillis();
        if(print) {
            System.out.println("Sorting");
        }
//        List<Mountain> mountainsTwo = new ArrayList<>(mountains);
        Collections.sort(mountains, (a,b)->{
            int retVal = 0;
            if(a.top.x == b.base.x && a.top.y == b.base.y) {
                retVal = -1;
            }if(a.base.x == b.top.x && a.base.y == b.top.y) {
                retVal = 1;
            }
            else if(a.top.x < b.base.x)
                retVal =  -1;
            else if(a.base.x > b.top.x)
                retVal = 1;
//            (Ax-Cx)*(Bx-Cy) - (Ay-Cy)*(Bx-Cx)
            else {
                Point x = a.top.x > b.top.x ? b.top : a.top;
                double y1 = a.getY(x);
                double y2 = b.getY(x);
                if(y1 > y2)
                    retVal = -1;
                else if(y1 < y2)
                    retVal = 1;
                else
                    retVal = 0;
            }
            return retVal;
            });
        long l2 = System.currentTimeMillis();
        if(print) {
            System.out.println("Time to sort="+(l2-l1)+" ms");
        }
        
        if(mountains.size() < 50 && print)
            System.out.println("Sorted="+mountains);
        
        int count = 0;
        Mountain prevMountain = null;
        while(true) {
            if(prevMountain != null)
                mountains.remove(prevMountain);
            if(mountains.size() == 0) {
                System.out.println("0");
                return;
            }
            prevMountain = mountains.get(0);
            if(prevMountain.base.x == 0 && prevMountain.base.y == 0)
                break;
        }
        
        while(true) {
            count ++;
            if(print) {
                System.out.println(""+ count +". "+prevMountain);
                System.out.println("\tInvoking getNextMountain with "+mountains.size()+" mountains");
            }

            Mountain mount = getNextMountain(prevMountain, mountains);

            prevMountain = mount;
            if(mount == null) {
                break;
            }
        }
        if(print) {
            System.out.println("----------------------");
        }
        System.out.println(count);
    }
}
