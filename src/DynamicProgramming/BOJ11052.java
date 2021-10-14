package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 카드는 카드팩의 형태로만 구매할 수 있고, 카드팩의 종류는 카드 1개가 포함된 카드팩, 카드 2개가 포함된 카드팩, ... 카드 N개가 포함된 카드팩과 같이 총 N가지가 존재한다.
 * 민규는 카드의 개수가 적은 팩이더라도 가격이 비싸면 높은 등급의 카드가 많이 들어있을 것이라는 미신을 믿고 있다.
 * 따라서, 민규는 돈을 최대한 많이 지불해서 카드 N개 구매하려고 한다.
 * 카드가 i개 포함된 카드팩의 가격은 Pi원이다.
 *
 * 카드 팩의 가격이 주어졌을 때, N개의 카드를 구매하기 위해 민규가 지불해야 하는 금액의 최댓값을 구하는 프로그램을 작성하시오.
 * N개보다 많은 개수의 카드를 산 다음, 나머지 카드를 버려서 N개를 만드는 것은 불가능하다.
 * 즉, 구매한 카드팩에 포함되어 있는 카드 개수의 합은 N과 같아야 한다.
 */

public class BOJ11052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        int[] dp = new int[n + 1];
        int[] p = new int[n + 1];
        for(int i = 0; i < n; i++) {
            p[i + 1] = Integer.parseInt(input[i]);
        }

        br.close();

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i - j] + p[j], dp[i]);
            }
        }
        System.out.println(dp[n]);
    }
}