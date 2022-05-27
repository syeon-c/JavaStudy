package Programmers.Level2;

public class StringCompression {
    private static int solution(String s) {
        int answer = s.length();

        if (s.length() == 1) return 1;

        for(int i = 1; i <= s.length()/2; i++) {
            // 비교 기준이 될 패턴
            String pattern = s.substring(0, i);
            // 압축된 문자열
            String compressed = "";
            // 압축 후 나머지 문자들
            String last = "";
            // 압축할 문자의 개수
            int cnt = 1;

            for(int j = i; j < s.length(); j += i) {
                if (s.length() < i + j) {
                    last = s.substring(j);
                    continue;
                }
                String comparison = s.substring(j, j + i);
                // 패턴과 비교할 문자열이 동일하면 cnt++
                if (pattern.equals(comparison)) cnt++;
                else {
                    // 압축되지 않는 문자열 그대로 붙이기
                    compressed += pattern;
                    // 전에 압축 가능한 문자열이 있다면 압축
                    if (cnt > 1) compressed = cnt + compressed;
                    // 다음 비교 문자열로 초기화
                    pattern = comparison;
                    cnt = 1;
                }
            }
            if (cnt > 1) compressed += cnt + pattern + last;
            else compressed += pattern + last;
            answer = Math.min(answer, compressed.length());
        }
        return answer;
    }

    public static void main(String[] args) {
        String s = "ababcdcdababcdcd";
        System.out.println(solution(s));
    }
}
