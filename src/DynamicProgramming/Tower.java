package DynamicProgramming;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Tower {
    static class Brick implements Comparable<Brick> {
        int s; int h; int w;

        public Brick(int s, int h, int w) {
            this.s = s;
            this.h = h;
            this.w = w;
        }
        // 넓이 순으로 정렬
        @Override
        public int compareTo(Brick b) {
            return b.s - this.s;
        }
    }

    static int solution(int n , List<Brick> bricks) {
        int answer = 0;
        int[] dy = new int[n];
        Collections.sort(bricks);
        dy[0] = bricks.get(0).h;

        for(int i = 0; i < bricks.size(); i++) {
            int max_h = 0;
            for(int j = i-1; j >= 0; j--) {
                // 벽돌 쌓기 조건에 만족하면서 가장 높게 쌓은 아랫 벽돌의 높이 max_h 정의
                if(bricks.get(j).w > bricks.get(i).w && dy[j] > max_h)
                    max_h = dy[j];
            }
            dy[i] = bricks.get(i).h + max_h;
        }
        // dy 배열의 최댓값 = 가장 높은 탑의 높이
        answer = Arrays.stream(dy).max().getAsInt();

        return answer;
    }

    public static void main(String[] args) throws IOException {
        int n = 5;
        List<Brick> bricks = new ArrayList<>();
        bricks.add(new Brick(25, 3, 4));
        bricks.add(new Brick(4, 4, 6));
        bricks.add(new Brick(9, 2, 3));
        bricks.add(new Brick(16, 2, 5));
        bricks.add(new Brick(1, 5, 2));

        System.out.println(solution(n, bricks));
    }
}
