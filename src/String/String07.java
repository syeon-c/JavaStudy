package String;

/**
 * 앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 회문 문자열이라고 합니다.
 * 문자열이 입력되면 해당 문자열이 회문 문자열이면 "YES", 회문 문자열이 아니면 “NO"를 출력 하는 프로그램을 작성하세요.
 * 단 회문을 검사할 때 대소문자를 구분하지 않습니다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class String07 {
    // StringBuilder 클래스를 사용한 방법
    private static void Solution_StringBuilder(String str) {
        str = str.toLowerCase();
        String reversed = new StringBuilder(str).reverse().toString();
        if(str.equals(reversed))
            System.out.println("YES");
        else System.out.println("NO");
    }
    private static void Solution(String str) {
        str = str.toUpperCase();
        int len = str.length();
        // 문자열을 반으로 나눠서 대응되는 위치의 값이 서로 같은지 비교
        for(int i = 0; i < len/2; i++) {
            if (str.charAt(i) != str.charAt(len - i - 1)) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Solution(input);
        Solution_StringBuilder(input);
    }
}
