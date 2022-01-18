package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10820 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        int[] answer;

        while ((input = br.readLine()) != null) {
            answer = new int[4];
            for(char c : input.toCharArray()) {
                if (Character.isLowerCase(c)) {
                    answer[0]++;
                } else if (Character.isUpperCase(c)) {
                    answer[1]++;
                } else if (Character.isDigit(c)) {
                    answer[2]++;
                } else if (c == ' ') {
                    answer[3]++;
                } else continue;
            }
            for(int a : answer) System.out.print(a + " ");
        }
        br.close();
    }
}
