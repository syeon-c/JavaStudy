package DynamicProgramming.Knapsack;

import java.util.ArrayList;
import java.util.List;

public class MaxScore {
    static class Problem {
        int score; int time;

        public Problem(int score, int time) {
            this.score = score;
            this.time = time;
        }
    }
    public static void main(String[] args) {
        int n = 5;
        int m = 20;
        int[] dy = new int[m + 1];
        dy[0] = 0;

        List<Problem> problemList = new ArrayList<>();
        problemList.add(new Problem(10, 5));
        problemList.add(new Problem(25, 12));
        problemList.add(new Problem(15, 8));
        problemList.add(new Problem(6, 3));
        problemList.add(new Problem(7, 4));

        for(int i = 0; i < n; i++) {
            int score = problemList.get(i).score;
            int time = problemList.get(i).time;
            for(int j = m; j >= time; j--) {
                // dy[j - time] + score
                dy[j] = Math.max(dy[j], dy[j - time] + score);
            }
        }
        System.out.println(dy[m]);
    }
}
