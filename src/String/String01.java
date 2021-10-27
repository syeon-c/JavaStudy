package String;

/**
 * 한 개의 문자열을 입력받고, 특정 문자를 입력받아 해당 특정문자가 입력받은 문자열에 몇 개 존재하는지 알아내는 프로그램을 작성하세요.
 * 대소문자를 구분하지 않습니다. 문자열의 길이는 100을 넘지 않습니다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class String01 {
    public static int solution(String string, char character) {
        int answer = 0;
        // 대문자로 초기화
        string = string.toUpperCase();
        character = Character.toUpperCase(character);

        for(int i = 0; i < string.length(); i++) {
            if(string.charAt(i) == character)
                answer += 1;
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        char c = br.readLine().charAt(0);
        br.close();
        System.out.println(solution(input, c));
    }
}
