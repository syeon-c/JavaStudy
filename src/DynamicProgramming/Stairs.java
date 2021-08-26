package DynamicProgramming;

/**
 * 철수는 계단을 오를 때 한 번에 한 계단, 혹은 두 계단씩 올라간다
 * 만약 총 4 계단을 오른다면...1+1+1+1, 1+1+2, 1+2+1, 2+1+1, 2+2 로 5가지
 * 그렇다면 철수가 총 N개의 계단을 올라갈 수 있는 모든 방법의 수는 몇 가지?
 */

public class Stairs {
    public static void main(String[] args) {
        int num = 7;
        System.out.println(solution(num));
    }

    public static int solution(int num) {
        int answer = 0;
        int[] dy = new int[num+1];

        dy[1] = 1;
        dy[2] = 2;

        for(int i = 3; i <= num; i++) {
            dy[i] = dy[i-2] + dy[i-1];
        }

        answer = dy[num];

        return answer;
    }
}
