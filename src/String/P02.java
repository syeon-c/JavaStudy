package String;

public class P02 {
    private static int solution(int time, int gold, int[][] upgrade) {
        int answer = (time / upgrade[0][1]) * gold;

        for(int i = 1; i < upgrade.length; i++) {
            int level = 0;
            int profit = 0;
            int n_time = time;
            while (level < i) {
                int t = (int) Math.ceil((double) upgrade[level + 1][0] / gold);
                profit += (t * gold);
                n_time -= upgrade[level][1] * t;
                profit -= upgrade[++level][0];
            }
            profit += ((n_time / upgrade[level][1]) * gold);
            answer = Math.max(profit, answer);
        }
        return answer;
    }

    public static void main(String[] args) {
        int time = 11;
        int gold = 1000;
        int[][] upgrade = {{0, 5}, {100, 4}, {200, 3}};
        System.out.println(solution(time, gold, upgrade));
    }
}
