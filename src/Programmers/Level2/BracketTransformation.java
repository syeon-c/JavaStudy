package Programmers.Level2;

public class BracketTransformation {
    private static boolean isCorrect(String balanced) {
        int open = 0;
        for (int i = 0; i < balanced.length(); i++) {
            if (balanced.charAt(i) == '(') {
                open++;
            } else {
                if (open == 0) return false;
                open--;
            }
        }
        return true;
    }
    private static String getCorrect(String balanced) {
        // 1.
        if (balanced.length() == 0) return balanced;
        // 2.
        int open = 0;
        int close = 0;
        // get u
        for (char c : balanced.toCharArray()) {
            if (c == '(') open++;
            else close++;
            if (open == close) break;
        }
        int uLen = open + close;
        String u = balanced.substring(0, uLen);
        String v = balanced.substring(uLen);
        // 3.
        if (isCorrect(u)) return u + getCorrect(v);
        // 4.
        else {
            //   4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다.
            //   4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.
            //   4-3. ')'를 다시 붙입니다.
            String str = "(" + getCorrect(v) + ")";
            //   4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
            for (int i = 1; i < uLen - 1; i++) {
                if (u.charAt(i) == '(') {
                    str += ")";
                } else {
                    str += "(";
                }
            }
            //   4-5. 생성된 문자열을 반환합니다.
            return str;
        }
    }
    private static String solution(String p) {
        return getCorrect(p);
    }
    public static void main(String[] args) {
        String p = "()))((()";
        System.out.println(solution(p));
    }
}
