package Programmers.Level2;

/** https://taehoung0102.tistory.com/160
 * 1. 라이언과 어피치가 동점일 경우, 어피치의 승리입니다.
 * 2. 어피치가 승리할 경우 -1을 반환
 * 3. 만약, 과녁 점수가 동일한 기록이 여러 개 존재할 경우, 낮은 점수를 많이 맞힌 것을 정답으로 합니다.
 *
 * >> 완전탐색, 백트래킹(DFS)
 */

public class AnArcheryCompetition {
    private static boolean visited[] = new boolean[11]; // 점수를 획득했는지 안 했는지 확인
    private static int apeach = 0;                       // 어피치 점수
    private static int max = 0;                         // 라이언 - 어피치 점수의 최대 점수차
    static int[] answer = new int[11];                  // 최종 반환 답
    static int[] ryan = new int[11];                    // 점수 획득을 위해 필요한 화살의 수 저장 배열

    private static int[] solution(int n, int[] info) {
        for(int i = 0; i < 11; i++) {
            // 어피치가 맞춘 화살 수 + 1 > 득점!
            ryan[i] = info[i] + 1;
            if (info[i] != 0) {
                apeach += 10 - i;
            }
        }
        // 10번째 과녁은 맞추지 않아도 0점 획득 가능 .. 0처리
        ryan[10] = 0;
        getScore_dfs(0, 11, n);
        // 어피치와 라이언의 점수가 동일할 경우 -1 반환
        if (max == 0) {
            return new int[]{-1};
        }
        return answer;
    }

    private static void getScore_dfs(int start, int depth, int n) {
        // 탈출 조건 1: 화살을 모두 소진했을 경우
        // 탈출 조건 2: 남은 화살을 0점에 쏠 때
        if (n == 0 || depth == 0) {
            // 라이언의 점수 계산
            int sum = 0;
            int[] arr = new int[11];
            for (int i = 0; i < 11; i++) {
                if (visited[i]) {
                    arr[i] = ryan[i];
                    if (arr[i] == 1) {
                        sum += 10-i;
                    }
                    else {
                        sum += (10-i) * 2;
                    }
                }
            }
            // 남은 화살 n개를 0점에 쏘기
            if (depth == 0) arr[10] = n;
            // 점수가 같을 때 0점 화살부터 비교하여 낮은 점수가 많은 것이 우승 후보
            if (max == sum - apeach) {
                for (int i = 10; i >= 0; i--) {
                    if (answer[i] > arr[i]) {
                        break;
                    } else if (answer[i] == arr[i]) {
                        continue;
                    } else {
                        answer = arr;
                    }
                }
            // 점수 차이 비교 후 max값 변경
            } else if (max < sum - apeach) {
                max = sum - apeach;
                answer = arr;
            }
            return;
        }
        for(int i = start; i < 11; i++) {
            // 해당 점수를 얻기 위한 화살이 충분한지 체크
            if (n >= ryan[i]) {
                // 방문 체크 후 사용한 화살 개수 빼기
                visited[i] = true;
                n -= ryan[i];
                getScore_dfs(start + 1, depth - 1, n);
                visited[i] = false;
                n += ryan[i];
            }
        }
    }

    public static void main(String[] args) {
        int n = 5;
        int[] info = {2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0};
        for(int a : solution(n, info)) {
            System.out.print(a + ", ");
        }
    }
}
