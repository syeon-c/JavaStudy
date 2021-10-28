package String;

/**
 * 영어 알파벳과 특수문자로 구성된 문자열이 주어지면 영어 알파벳만 뒤집고,
 * 특수문자는 자기 자리에 그대로 있는 문자열을 만들어 출력하는 프로그램을 작성하세요.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class String05 {
    private static void Solution(String str) {
        String answer;
        char[] arr = str.toCharArray();
        int lt = 0, rt = arr.length - 1;

        while (lt < rt) {
            // 특수문자일 경우 교환 없이 인덱스 이동
            if (!Character.isAlphabetic(arr[lt])) lt++;
            else if (!Character.isAlphabetic(arr[rt])) rt--;
            // 알파벳일 경우 각각의 인덱스 값 교환
            else {
                char tmp = arr[lt];
                arr[lt] = arr[rt];
                arr[rt] = tmp;
                lt++; rt--;
            }
        }
        answer = String.valueOf(arr);
        System.out.println(answer);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        br.close();
        Solution(input);
    }
}
