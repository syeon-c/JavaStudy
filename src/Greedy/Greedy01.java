package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Greedy01 {
    private static int N;
    private static int[] W, H;
    private static int answer;

    private static void Solution() {
        for(int i = 0; i < N; i++) {
            boolean flag = true;
            int nh = H[i];
            int nw = W[i];
            for(int j = 0; j < N; j++) {
                if (j == i) continue;
                if (H[j] > nh && W[j] > nw) {
                    flag = false;
                    break;
                }
            }
            if (flag) answer++;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        W = new int[N];
        H = new int[N];
        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            H[i] = Integer.parseInt(input[0]);
            W[i] = Integer.parseInt(input[1]);
        }
        br.close();
        Solution();
        System.out.println(answer);
    }
}
