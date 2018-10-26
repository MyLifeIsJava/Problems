package codility.stacksqueues;

/**
 * https://app.codility.com/programmers/lessons/7-stacks_and_queues/nesting/
 * 
 * @author kiransringeri
 *
 */
public class Nesting {

  public static void main(String[] args) {
    System.out.println(solution("(()(())())"));
    System.out.println(solution("())"));
  }

  public static int solution(String S) {
    if(S == null || S.isEmpty()) {
      return 1;
    }
    int n = S.length();
    int openBraces = 0;
    boolean properlyNested = true;
    for(int i=0; i < n; i++) {
      char c = S.charAt(i);
      if(c == '(') {
        openBraces ++;
      }else {
        openBraces --;
        if(openBraces < 0) {
          properlyNested = false;
          break;
        }
      }
    }
    if(properlyNested) {
//      There should not be any open braces left
      properlyNested = openBraces == 0;
    }
    return properlyNested ? 1 : 0;
  }
}
