package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class String03 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        String answer = "";
        int len = Integer.MIN_VALUE;
        for(String s : input) {
            if (s.length() > len) {
                len = s.length();
                answer = s;
            }
        }
        System.out.println(answer);
    }
}
