package DynamicProgramming;

/**
 * 개울은 N개의 돌로 다리를 만들어 놓았습니다.
 * 철수는 돌 다리를 건널 때 한 번에 한 칸 또는 두 칸씩 건너뛰면서 돌다리를 건널 수 있습니다.
 * 철수가 개울을 건너는 방법은 몇 가지일까요?
 */

public class StoneBirdge {
    public static void main(String[] args) {
        int n = 7;
        System.out.println(solution(n));

    }

    public static int solution(int n) {
        int answer = 0;
        int[] dy = new int[n+1];

        dy[0] = 1;
        dy[1] = 2;

        for(int i = 2; i <= n; i++) {
            dy[i] = dy[i-2] + dy[i-1];
        }

        answer = dy[n];
        return answer;
    }
}
