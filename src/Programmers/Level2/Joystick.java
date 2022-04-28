package Programmers.Level2;

/**
 * https://velog.io/@jeeseob5761/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%A1%B0%EC%9D%B4%EC%8A%A4%ED%8B%B1
 */

public class Joystick {
    private static int solution(String name) {
        int answer = 0;
        int len = name.length();
        int index;
        int move = len - 1;

        for(int i = 0; i < len; i++) {
            // 상하로 움직여야 하는 횟수
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);

            index = i + 1;
            // 연속되는 A의 수 체크 -> A기준 뒷부분의 길이와, A기준 앞부분의 길이를 판단
            while (index < len && name.charAt(index) == 'A') {
                index++;
            }
            // 왼쪽으로 탐색, 오른쪽으로 탐색 중 이동 횟수가 적은 것 선
            move = Math.min(move, i * 2 + len - index);
            // 처음부터 뒷부분을 먼저 입력하는 것이 더 빠른 경우까지 고려
            move = Math.min(move, (len - index) * 2 + i);
        }
        return answer + move;
    }
    public static void main(String[] args) {
        String name = "JAZ";
        System.out.println(solution(name));
    }
}
