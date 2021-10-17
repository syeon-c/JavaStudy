package DynamicProgramming;

/**
 * 어떤 동물원에 가로로 두칸 세로로 N칸인 아래와 같은 우리가 있다.
 * 이 동물원에는 사자들이 살고 있는데 사자들을 우리에 가둘 때, 가로로도 세로로도 붙어 있게 배치할 수는 없다.
 * 이 동물원 조련사는 사자들의 배치 문제 때문에 골머리를 앓고 있다.
 * 동물원 조련사의 머리가 아프지 않도록 우리가 2*N 배열에 사자를 배치하는 경우의 수가 몇 가지인지를 알아내는 프로그램을 작성해 주도록 하자.
 * 사자를 한 마리도 배치하지 않는 경우도 하나의 경우의 수로 친다고 가정한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1309 {
    static final int DIV = 9901;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();

        /**
         * dp[i][j] : i번째 줄의 j번째 칸에 동물을 놓을 수 있는 경우의 수
         * j = 0 : 아무 동물도 놓지 않음
         * j = 1 : 첫 번째 칸에 동물을 놓음
         * j = 2 : 두 번째 칸에 동물을 놓음
         */

        long[][] dp = new long[n + 1][3];
        // n = 1) 아무 곳에도 놓지 않을 경우, 첫 번째 칸에 넣을 경우, 두 번째 칸에 넣을 경우 모두 경우의 수 1
        dp[1][0] = dp[1][1] = dp[1][2] = 1;

        for(int i = 2; i <= n; i++) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % DIV;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % DIV;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % DIV;
        }

        long answer = (dp[n][0] + dp[n][1] + dp[n][2]) % DIV;
        System.out.println(answer);


    }
}