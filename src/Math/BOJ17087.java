package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ17087 {
    private static int getGCD(int a, int b) {
        while (b > 0) {
            int tmp = a;
            a = b;
            b = tmp % b;
        }
        return a;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        int N = Integer.parseInt(info[0]);
        int S = Integer.parseInt(info[1]);

        String[] info2 = br.readLine().split(" ");
        int[] pos = new int[N];
        for(int i = 0; i < N; i++)
            pos[i] = Math.abs(S - Integer.parseInt(info2[i]));
        br.close();
        int answer = pos[0];

        for(int i = 1; i < N; i++)
            answer = getGCD(Math.max(answer, pos[i]), Math.min(answer, pos[i]));

        System.out.println(answer);
    }
}