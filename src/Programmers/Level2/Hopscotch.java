package Programmers.Level2;

public class Hopscotch {
    private static int solution(int[][] land) {
        int answer = 0;
        int n = land.length;
        int[][] dp = land;
        for(int i = 1; i < n; i++) {
            dp[i][0] += Math.max(dp[i - 1][1], Math.max(dp[i - 1][2], dp[i - 1][3]));
            dp[i][1] += Math.max(dp[i - 1][0], Math.max(dp[i - 1][2], dp[i - 1][3]));
            dp[i][2] += Math.max(dp[i - 1][0], Math.max(dp[i - 1][1], dp[i - 1][3]));
            dp[i][3] += Math.max(dp[i - 1][0], Math.max(dp[i - 1][1], dp[i - 1][2]));
        }
        for(int sum : dp[n-1]) {
            if (answer < sum) answer = sum;
        }
        return answer;
    }
    public static void main(String[] args) {
        int[][] land = {
            {1, 2, 3, 5},
            {5, 6, 7, 8},
            {4, 3, 2, 1}
        };
        System.out.println(solution(land));
    }
}
