package CodingTest.Programmers.Level2;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class RotatingBracket {
    public static void main(String[] args) {
        String s = "}]()[{";
        System.out.println(solution(s));
    }

    public static int solution(String s) {
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            s = s.substring(1, s.length()) + s.substring(0,1);
            if(isBalanced(s)) answer++;
        }
        return answer;
    }

    public static boolean isBalanced(String str) {
        while (str.indexOf("()") >= 0 || str.indexOf("{}") >= 0 || str.indexOf("[]") >= 0) {
            str = str.replace("{}", "");
            str = str.replace("()", "");
            str = str.replace("[]", "");
        }
        return str.length() == 0;
    }

}
