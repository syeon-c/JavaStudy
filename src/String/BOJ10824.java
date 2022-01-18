package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10824 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        br.close();
        String num1 = input[0] + input[1];
        String num2 = input[2] + input[3];
        System.out.println(Long.parseLong(num1) + Long.parseLong(num2));
    }
}
