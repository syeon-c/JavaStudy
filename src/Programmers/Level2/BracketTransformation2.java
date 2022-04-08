package Programmers.Level2;

public class BracketTransformation2 {
    private static boolean isCorrect(String balanced) {
        while (balanced.indexOf("()") >= 0) {
            balanced = balanced.replace("()", "");
        }
        return balanced.length() == 0;
    }
    private static String getCorrect(String balanced) {
        // 1. 빈 문자열일 경우 빈 문자열 반환
        if (balanced.length() == 0) return balanced;

        // 2. 문자열 w를 두 "균형 잡힌 괄호 문자열" u, v로 분리
        int open = 0;
        int close = 0;

        for(char c : balanced.toCharArray()) {
            if (c == '(') open++;
            else close++;
            if (open == close) break;
        }
        int uLen = open + close;
        String u = balanced.substring(0, uLen);
        String v = balanced.substring(uLen);

        // 3. 문자열 u가 "올바른 괄호 문자열"이면 문자열 v에 대해 1~2 다시 실행
        if (isCorrect(u)) return u + getCorrect(v);

        // 4. 문자열 u가 "올바른 괄호 문자열"이 아닌 경우
        else {
            String str = "(" + getCorrect(v) + ")";
            for(int i = 1; i < uLen - 1; i++) {
                if (u.charAt(i) == '(') str += ")";
                else str += "(";
            }
            return str;
        }
    }
    private static String solution(String p) {
        return getCorrect(p);
    }
    public static void main(String[] args) {

    }
}