package leetcode;

import java.util.Scanner;
import java.util.Stack;
/**
 * Problem Description : https://leetcode.com/problems/valid-parentheses/description/
 * Status : Completed
 * 
 * @author kiran
 *
 */
public class Valid_Parentheses {

    public static void main(String[] args) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(System.in);
            String str = scanner.nextLine();
            Valid_Parentheses obj = new Valid_Parentheses();
            boolean valid = obj.isValid(str);
            System.out.println(valid);
        }finally {
            if(scanner != null)
                scanner.close();
        }
    }

    public boolean isValid(String s) {
        if(s == null || s.length() == 0)
            return true;
        Stack<Character> stack = new Stack<>();
        for(int i=0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '{' || c == '[' || c == '(') {
                stack.push(c);
            }
            else if(c == '}' || c == ']' || c == ')') {
                if(stack.isEmpty())
                    return false;
                char c1 = stack.pop();
                if((c == '}' && c1 != '{') ||
                        (c==']' && c1 != '[') ||
                        (c == ')' && c1 != '(')) {
                    return false;
                }
            }
        }
        if(stack.isEmpty())
            return true;
        return false;
    }
}
