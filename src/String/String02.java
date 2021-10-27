package String;

/**
 * 대문자와 소문자가 같이 존재하는 문자열을 입력받아 대문자는 소문자로 소문자는 대문자로 변환하여 출력하는 프로그램을 작성하세요.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class String02 {
    private static void ASCII(String str) {
        String answer = "";
        for (char c : str.toCharArray()) {
            // 소문
//            if (c >= 97 && c <= 122)
            // 대문자
            if (c >= 65 && c <= 90) {
                answer += Character.toLowerCase(c);
            } else {
                answer += Character.toUpperCase(c);
            }
        }
        System.out.println(answer);
    }
    private static void Solution(String str) {
        String answer = "";
        for (char c : str.toCharArray()) {
            if (Character.isLowerCase(c)) {
                answer += Character.toUpperCase(c);
            } else {
                answer += Character.toLowerCase(c);
            }
        }
        System.out.println(answer);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        br.close();
        Solution(str);
    }
}
