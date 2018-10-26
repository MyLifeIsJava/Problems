package codility.stacksqueues;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * https://app.codility.com/programmers/lessons/7-stacks_and_queues/brackets/
 * 
 * @author kiransringeri
 *
 */
public class Brackets {

  public static void main(String[] args) {
    System.out.println(solution("{[()()]}"));
    System.out.println(solution("{[()()])"));
  }

  public static int solution(String S) {
    if(S == null || S.isEmpty()) {
      return 1;
    }
    Map<Character, Character> bracePairMap = new HashMap<>();
    bracePairMap.put(']', '[');
    bracePairMap.put('}', '{');
    bracePairMap.put(')', '(');
    
    Stack<Character> openBracesStack = new Stack<>();
    int n = S.length();
    boolean properlyNested = true;
    for(int i=0; i < n; i++) {
      char c = S.charAt(i);
      if(bracePairMap.containsKey(c)) {
//        This is the closing brace
        char mathingOpenBrace = bracePairMap.get(c);
        if(openBracesStack.isEmpty() || !openBracesStack.pop().equals(mathingOpenBrace)) {
          properlyNested = false;
          break;
        }
      }
      else {
//        Since String contains only these braces, we can directly assume this as opening brace
        openBracesStack.push(c);
      }
    }
    if(properlyNested) {
//      There should not be any opening braces left in the stack
      properlyNested = openBracesStack.isEmpty();
    }
    return properlyNested ? 1 : 0;
  }
}
