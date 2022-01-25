package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1212 {
    static final String[] binary = {"000", "001", "010", "011", "100", "101", "110", "111"};
    private static String solution1 (String octal) {
        String answer = "";
        if (octal.length() == 1 && octal.charAt(0) == '0') {
            answer = "0";
        }
        else {
            for (char n : octal.toCharArray()) {
                answer += binary[Integer.parseInt(String.valueOf(n))];
            }
            // 2진수 앞에 위치한 0 제거
            while (answer.charAt(0) == '0') {
                answer = answer.substring(1);
            }
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        String octal = br.readLine();
        br.close();

        for(int i = 0; i < octal.length(); i++) {
            int n = octal.charAt(i) - '0';
            // 첫번째 8진수 자릿수 문제 처리
            if (i == 0 && n < 4) {
                if (n < 2) answer.append(binary[n].substring(2));
                else answer.append(binary[n].substring(1));
            } else answer.append(binary[n]);
        }
        System.out.println(answer);
    }
}
