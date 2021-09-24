package DynamicProgramming;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 밑면이 정사각형인 직육면체 벽돌들을 사용하여 탑을 쌓고자 한다. 탑은 벽돌을 한 개씩 아래 에서 위로 쌓으면서 만들어 간다.
 * 아래의 조건을 만족하면서 가장 높은 탑을 쌓을 수 있는 프 로그램을 작성하시오.
 *
 * rule1) 벽돌은 회전시킬 수 없다. 즉, 옆면을 밑면으로 사용할 수 없다.
 * rule2) 밑면의 넓이가 같은 벽돌은 없으며, 또한 무게가 같은 벽돌도 없다.
 * rule3) 벽돌들의 높이는 같을 수도 있다.
 * rule4) 탑을 쌓을 때 밑면이 좁은 벽돌 위에 밑면이 넓은 벽돌은 놓을 수 없다.
 * rule5) 무게가 무거운 벽돌을 무게가 가벼운 벽돌 위에 놓을 수 없다.
 */

public class HighestTower {
    public static void main(String[] args) {
        ArrayList<Bricks> bricks = new ArrayList<>();
        bricks.add(new Bricks(25, 3, 4));
        bricks.add(new Bricks(4, 4, 6));
        bricks.add(new Bricks(9, 2, 3));
        bricks.add(new Bricks(16, 2, 5));
        bricks.add(new Bricks(1, 5, 2));

        System.out.println(solution(bricks));
    }

    public static int solution(ArrayList<Bricks> bricks) {
        int answer = 0;
        int[] dy = new int[bricks.size()];
        Collections.sort(bricks);
        // 제일 넓이가 넓은 벽돌의 높이 맨앞에 위치 -> 1(본인 하나)
        dy[0] = bricks.get(0).h;
        answer = dy[0];

        for(int i = 0; i < bricks.size(); i++) {
            // 높이 최댓값 초기화
            int max = 0;
            for(int j = i-1; j >= 0; j--) {
                if(bricks.get(j).w > bricks.get(i).w && dy[j] > max) {
                    max = dy[j];
                }
            }
            dy[i] = max + bricks.get(i).h;
            answer = Math.max(answer, dy[i]);
        }

        return answer;
    }

    public static class Bricks implements Comparable<Bricks> {
        int s; int h; int w;

        public Bricks(int s, int h, int w) {
            this.s = s;
            this.h = h;
            this.w = w;
        }

        // 넓이 순으로 정렬
        @Override
        public int compareTo(Bricks b){
            return b.s - this.s;
        }
    }
}
