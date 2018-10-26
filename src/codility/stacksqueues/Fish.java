package codility.stacksqueues;

import java.util.Stack;

/**
 * https://app.codility.com/programmers/lessons/7-stacks_and_queues/fish/
 * 
 * @author kiransringeri
 *
 */
public class Fish {

  public static void main(String[] args) {
    System.out.println(solution(new int[] {4,3,2,1,5}, new int[] {0,1,0,0,0}));
  }

  public static int solution(int[] A, int[] B) {
    int aliveFishCount = 0;
    Stack<Integer> downStreamFishSizes = new Stack<>();
    int n = A.length;
    for(int i=0; i < n; i++) {
      int currFishSize = A[i];
      boolean upstream = B[i] == 0;
      if(upstream) {
//        If this fish is going upstream
        if(downStreamFishSizes.isEmpty()) {
//          If there are no fish coming downstream, then this fish will survive
          aliveFishCount ++;
        }
        else {
//          This fish might eat or get eater by the down stream fish
          while(!downStreamFishSizes.isEmpty()) {
            int downStreamFishSize = downStreamFishSizes.peek();
            if(downStreamFishSize > currFishSize) {
  //            This fish will get eaten and downstream fish survives now
              break;
            }
            else {
  //            This fish will eat the downstream fish, and survives for now
  //            So remove the downstream fish from stack
              downStreamFishSizes.pop();
            }
          }
          if(downStreamFishSizes.isEmpty()) {
//            This fish has eater all downstream fishes, then this will survive
            aliveFishCount ++;
          }
        }
      }else {
//        Add it to the stack
        downStreamFishSizes.add(currFishSize);
      }
    }
//    If there are still some downstream fishes, all of them will survive
    aliveFishCount += downStreamFishSizes.size();
    return aliveFishCount;
  }
}
