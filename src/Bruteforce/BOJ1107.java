package Bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1107 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        boolean[] broken = new boolean[10];
        if (M != 0) {
            for(String s : input) {
                broken[Integer.parseInt(s)] = true;
            }
        }
        br.close();

        int answer = Math.abs(N - 100);
        for(int i = 0; i <= 999999; i++) {
            String now = String.valueOf(i);
            int len = now.length();
            boolean isBroken = false;

            for(int j = 0; j < len; j++) {
                if (broken[now.charAt(j) - '0']) {
                    isBroken = true;
                    break;
                }
            }

            if (!isBroken) {
                int count = Math.abs(N - i) + len;
                answer = Math.min(count, answer);
            }
        }
        System.out.println(answer);
    }
}
