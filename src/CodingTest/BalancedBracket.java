package CodingTest;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
/**
 * 입력이 다음과 같을때 Balanced 된 Bracket 인지 검사 하는 로직을 구현 하세요.
 * ex : "(()()()())" -> return = true
 * ex : "(()()()()))" -> return = false
 */
public class BalancedBracket {

    public static void main(String[] args) {
        String str = "[{}()]";
        System.out.println(isBalanced2(str));
    }

    public static boolean isBalanced(String str) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        for (char ch : str.toCharArray()) {
            if (ch == '(' || ch == '{'|| ch == '[') {
                stack.push(ch);
            } else {
                if (stack.empty()) {
                    return false;
                }
                if (map.get(stack.pop()) != ch) {
                    return false;
                }

            }
        }
        return stack.empty();
    }

    public static boolean isBalanced2(String str) {
        while (str.indexOf("()") >= 0 || str.indexOf("{}") >= 0 || str.indexOf("[]") >= 0) {
            str = str.replace("{}", "");
            str = str.replace("()", "");
            str = str.replace("[]", "");
        }
        return str.length() == 0;
    }
}
