package CodingTest;

import java.util.Stack;
/**
 * 입력이 다음과 같을때 Balanced 된 Bracket 인지 검사 하는 로직을 구현 하세요.
 * ex : "(()()()())" -> return = true
 * ex : "(()()()()))" -> return = false
 */
public class BalancedBracket {

    public static void main(String[] args) {
        String str = "()()";
        Stack<Character> stack = new Stack<>();
        System.out.println(isBalanced(str, stack));
    }

    public static boolean isBalanced(String str, Stack stack) {
        for (char ch : str.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } else {
                if (stack.empty()) {
                    return false;
                }
                stack.pop();
            }
        }
        if (stack.empty()) {
            return true;
        } else {
            return false;
        }
    }
}
