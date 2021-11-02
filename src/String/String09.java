package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class String09 {
    private static void ASCII(String str) {
        int answer = 0;
        for(char c : str.toCharArray()) {
            if (c >= 48 && c <= 57)
                answer = answer * 10 + (c - 48);
        }
        System.out.println(answer);
    }
    private static void Solution(String str) {
        String answer = "";
        for(char c : str.toCharArray()) {
            if (Character.isDigit(c))
                answer += c;
        }
        System.out.println(Integer.parseInt(answer));
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        br.close();
        Solution(input);
        ASCII(input);
    }
}
