package codility.stacksqueues;

import java.util.Stack;

/**
 * https://app.codility.com/programmers/lessons/7-stacks_and_queues/stone_wall/
 * 
 * @author kiransringeri
 *
 */
public class StoneWall {

  public static void main(String[] args) {
    System.out.println(solution(new int[] {8,8,5,7,9,8,7,4,8}));
  }

  public static int solution(int[] H) {
    Stack<Integer> stack = new Stack<>();
    int n = H.length;
    int cuboidsNeeded = 0;
    for(int i=0; i < n; i++) {
      int currHeight = H[i];
      int prevHeight = stack.isEmpty() ? 0 : stack.peek();
      if(prevHeight != currHeight) { //If heights are same, we an use same cuboid for this portion of the wall
        while(prevHeight > currHeight) { //We have to use a new cuboid in this case for the previous portion of the wall
          cuboidsNeeded ++;
          stack.pop();//Remove the previous height
          prevHeight = stack.isEmpty() ? 0 : stack.peek(); //Check the next wall portion which is already there on the stack
        }
        if(prevHeight != currHeight) {
          stack.push(currHeight);
        }
      }
    }
//    If we still have some heights left in the stack, then we need so many cuboids
    cuboidsNeeded += stack.size();
    return cuboidsNeeded;
  }
}
