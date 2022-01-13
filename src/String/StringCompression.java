package String;

public class StringCompression {
    private static int solution(String s) {
        int answer = s.length();

        if (s.length() == 1) return 1;

        for(int c = 1; c <= s.length()/2 + 1; c++) {
            String pattern = s.substring(0, c);
            String str = "";
            String last = "";
            int cnt = 1;            // 연속되는 문자열의 개수

            // 문자열 비교
            for(int i = c; i < s.length(); i += c) {
                if (i + c > s.length()) {
                    last = s.substring(i);
                    continue;
                }
                String subStr = s.substring(i, i + c);
                // 연속되는 문자열 카운트
                if(pattern.equals(subStr)) { cnt++; }
                // 연속이 끊기면 현재까지 카운트된 문자열 압축
                else {
                    str += pattern;
                    if (cnt > 1) str = cnt + str;
                    pattern = subStr;
                    cnt = 1;
                }
            }
            str += pattern + last;
            if (cnt > 1) str += cnt + str;
            answer = Math.min(answer, str.length());
        }
        return answer;
    }
    public static void main(String[] args) {
        String s = "abcabcdede";
        System.out.println(solution(s));
    }
}
