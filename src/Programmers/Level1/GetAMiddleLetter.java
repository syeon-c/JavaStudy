package Programmers.Level1;

public class GetAMiddleLetter {
    private static String solution2(String s) {
        return s.length() % 2 == 0 ?
                s.substring(s.length() / 2 - 1, s.length() / 2 + 1) : s.substring(s.length() / 2, s.length() / 2 + 1);
    }
    private static String solution(String s) {
        String answer = "";
        if (s.length() % 2 == 0) {
            answer += s.substring(s.length() / 2 - 1, s.length() / 2 + 1);
        } else {
            answer += s.substring(s.length() / 2, s.length() / 2 + 1);
        }
        return answer;
    }
    public static void main(String[] args) {
        String s = "qwer";
        System.out.println(solution2(s));
    }
}
