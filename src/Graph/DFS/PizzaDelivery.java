package Graph.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PizzaDelivery {
    static int N, M, count;
    static int[] pizza_cnt;
    static ArrayList<int[]> house, pizza;
    static int answer = Integer.MAX_VALUE;
    static int[][] board;

    private static void dfs(int l, int s) {
          if (l == M) {
              int sum = 0;
              for(int[] h : house) {
                  int dis = Integer.MAX_VALUE;
                  for(int p : pizza_cnt) {
                      // 피자배달 거리 구하기
                      dis = Math.min(dis, Math.abs(h[0] - pizza.get(p)[0]) + Math.abs(h[1] - pizza.get(p)[1]));
                  }
                  // 도시의 피자배달 거리 구하기
                  sum += dis;
              }
              answer = Math.min(answer, sum);

          } else {
              for(int i = 0; i < count; i ++) {
                  pizza_cnt[l] = i;
                  dfs(l + 1, i + 1);
              }
          }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        N = Integer.parseInt(info[0]);
        M = Integer.parseInt(info[1]);
        board = new int[N+1][N+1];
        house = new ArrayList<>();
        pizza = new ArrayList<>();
        for(int i = 1; i <= N; i++) {
            String[] input = br.readLine().split(" ");
            for(int j = 1; j <= N; j++) {
                int value = Integer.parseInt(input[j-1]);
                if (value == 1) house.add(new int[]{i, j});
                else if (value == 2) pizza.add(new int[]{i, j});
                board[i][j] = value;
            }
        }
        br.close();
        // 피자 가게의 총 수
        count = pizza.size();
        // 선택 받은 피자 가게
        pizza_cnt = new int[M];
        dfs(0, 0);
        System.out.println(answer);
    }
}
