package Programmers.Level2;

/**
 * https://velog.io/@delay/programmers17687
 */

public class NtoNConversionGame {
    private static String solution(int n, int t, int m, int p) {
        String answer = "";
        String str = "0";
        int num = 0;

        while (str.length() < (t * m + p)) {
            // num은 1부터 증가할 숫자, byNum은 주어진 진법에 맞게 num에 저장할 문자
            String byNum = "";
            num++;
            // 진법계산
            while (num != 0) {
                if (num % n >= 10) {
                    byNum += String.valueOf((char) (num % n + 55));
                } else {
                    byNum += String.valueOf(num % n);
                }
                num /= n;
            }
            // 거꾸로 저장된 문자 수정
            str += new StringBuilder(byNum).reverse().toString();
        }
        // 튜브 순서에 맞는 글자를 꺼내어 정답 문자열에 차례대로 저장
        for(int i = 0; i < t; i++) {
            answer += String.valueOf(str.charAt(m * i + p - 1));
        }
        return answer;
    }
    public static void main(String[] args) {

    }
}
