package Programmers.Level2;

public class CreateJadenCaseString {
    private static String solution(String s) {
        String answer = "";
        String[] strings = s.split(" ");
        for(String string : strings) {
            // 문자열 중간에 공백이 두 개 이상일 경우 처리
            if (string.equals("")) {
                answer += " ";
                continue;
            }
            answer += Character.toUpperCase(string.charAt(0));
            answer += string.substring(1).toLowerCase() + " ";
        }
        // 마지막 문자가 공백일 경우 처리
        if (s.charAt(s.length() - 1) == ' ') answer += " ";
        return answer.substring(0, answer.length()-1);
    }
    public static void main(String[] args) {
        String s = "for the last  week ";
        System.out.println(solution(s) + ".end");
    }
}
