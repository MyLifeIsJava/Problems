package hackerrank.datastructures.trees;

import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://www.hackerrank.com/challenges/kittys-calculations-on-a-tree/problem
 * 
 * Works for small input. Otherwise takes hell lot of time
 * 
 * 
 * @author kiran
 *
 */
public class Kitty_sCalculationsOnATree {
    public static void main(String[] args) throws Exception {
        long initialHeap = 0;
        /* Below three variables are sufficient to maintain the Tree data */
        int []parents = null;
        int []levels = null;
        Map<Integer, List<Integer>> children = new HashMap<>();
        try {
            initialHeap = ManagementFactory.getMemoryMXBean().getHeapMemoryUsage().getUsed();
            System.out.println("Initial heap="+initialHeap);
            int n = 50000;
            parents = new int[n+1];
            
            boolean debug = n <= 20;
            
            long st = System.currentTimeMillis();
            
            for(int i=0; i <= n; i++)
                parents[i] = -1; //Assume all are roots :-)
            
            int counter = 0;
            int group = 10;
            for(int i=2; i <= n; i++) {
                int x = Math.max(1, i - counter - 2);
                int y = i;
//                Assumption is the edge is a directed one from x -> y . Does this assumption cause any issues?
                if(parents[y] != -1) {
                    int temp = x;
                    x = y;
                    y = temp;
                }
                parents[y] = x;
                List<Integer> childList = children.get(x);
                if(childList == null) {
                    childList = new ArrayList<>();
                    children.put(x, childList);
                }
                childList.add(y);
                
                if(debug)
                    System.out.println("node: "+x+","+y);
                
                counter ++;
                if(counter == group)
                    counter = 0;
            }
            
            int root = -1;
            for(int i=1; i <= n; i++) {
                if(parents[i] == -1) {
                    root = i;
                    break;
                }
            }
            int currLevel = 0;
            levels = new int[n+1];
            levels[root] = currLevel;
            currLevel ++;
            
            List<Integer> childList = children.get(root);
            while(childList != null && !childList.isEmpty()) {
                List<Integer> childList2 = new ArrayList<>();
                for(int k : childList) {
                    levels[k] = currLevel;
                    if(children.get(k) != null)
                        childList2.addAll(children.get(k));
                }
                childList = childList2;
                currLevel ++;
            }
            
            if(debug) {
                System.out.println(Arrays.toString(parents));
                System.out.println(children);
                System.out.println(Arrays.toString(levels));
            }
            
//          To test have all vertices in the set
//            int []vertices = {5};
            
            int []vertices = new int[n/2];
            for(int i=0; i < n/2; i++)
                vertices[i] = i+1;

            int start = 0;
            int end = 1;
            long sum = 0;
            int k = vertices.length;
            
//          Generate all possible pairs of given vertices
//            TODO: There should be some way to avoid this generation of all combinations
            long maxTime = 0;
            while(start < k - 1) {
                long time1 = System.currentTimeMillis();
                int v1 = vertices[start];
                int v2 = vertices[end];
                if(debug)
                    System.out.println("Handling nodes "+v1+","+v2);
//              Find the distance between v1 and v2
//                Assumption v1 != v2
//                Start traversing upward till we reach same level
                int node1 = v1;
                int node2 = v2;

                int level1 = levels[node1];
                int level2 = levels[node2];
                while(level1 < level2) {
                    node2 = parents[node2];
                    level2 = levels[node2];
                }
                while(level1 > level2) {
                    node1 = parents[node1];
                    level1 = levels[node1];
                }
//                Since we are at same level, keep going one step upward in each path at a time
                while(node1 != node2) {
                    node2 = parents[node2];
                    node1 = parents[node1];
                }
                int d = levels[v1] + levels[v2] - 2 * levels[node1];
                if(debug)
                    System.out.println("\tDistance="+d);
                sum = getSum(sum, v1, v2, d);
                
                if(end == k-1) {
                    start ++;
                    end = start + 1;
                }else {
                    end ++;
                }
                long time2 = System.currentTimeMillis();
                long time = time2 - time1;
                if(time > maxTime) {
                    maxTime = time;
                    System.out.println("TIme to get teh distance="+time);
                }
            }
            System.out.println(sum);
            
            long et = System.currentTimeMillis();
            System.out.println("Time="+(et-st)+" ms");
        }catch(Throwable th){
            th.printStackTrace();
            if(th instanceof OutOfMemoryError) {
                long finalHeap = ManagementFactory.getMemoryMXBean().getHeapMemoryUsage().getUsed();
                System.out.println("Final heap="+finalHeap);
                long heapSize = finalHeap - initialHeap;
                double mb = (long)heapSize / 1000000.00;
                System.out.println("Heap used="+mb+" MB");
            }
        }finally {
            
        }
    }   
    private static long mod_factor = 1000000007;
    
    private static long getSum(long sum, int v1, int v2, int dist) {
        sum = (sum + ((v1% mod_factor) * (v2% mod_factor) * (dist% mod_factor))% mod_factor) % mod_factor;
        return sum;
    }
}
