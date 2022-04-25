package Programmers.Level2;

public class RotateBrackets {
    private static int solution(String s) {
        int answer = 0;
        int len = s.length();
        for(int i = 0; i < len; i++) {
            s = s.substring(1, len) + s.substring(0, 1);
            if (isBalanced(s)) answer++;
        }
        return answer;
    }

    private static boolean isBalanced(String s) {
        while (s.indexOf("()") >= 0 || s.indexOf("{}") >= 0 || s.indexOf("[]") >= 0) {
            s = s.replace("()", "");
            s = s.replace("{}", "");
            s = s.replace("[]", "");
        }
        return s.length() == 0;
    }

    public static void main(String[] args) {
        String s = "[](){}";
        System.out.println(solution(s));
    }
}
