package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2745 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        String N = input[0];
        int B = Integer.parseInt(input[1]);
        long answer = 0;
        for(char n : N.toCharArray()) {
            if (Character.isAlphabetic(n)) answer = answer * B + ((n - 'A') + 10);
            else answer = answer * B + (n - '0');
        }
        System.out.println(answer);
        br.close();
    }
}