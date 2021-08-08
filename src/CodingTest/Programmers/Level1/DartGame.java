package CodingTest.Programmers.Level1;

import java.util.Stack;

/**
 * 다트 게임 후 최종 점수를 구하기
 * rule1 : 점수와 함께 Single(S), Double(D), Triple(T) 영역이 존재,
 *         각 영역 당첨 시 점수에서 1제곱, 2제곱, 3제곱 (점수1 , 점수2 , 점수3 )으로 계산
 *
 * rule2 : 옵션으로 스타상(*) , 아차상(#)이 존재,
 *         스타상(*) 당첨 시 해당 점수와 바로 전에 얻은 점수를 각 2배로 만듦
 *         아차상(#) 당첨 시 해당 점수는 마이너스
 *
 * rule3 : 스타상(*)은 첫 번째 기회에서도 나올 수 있음. 이 경우 첫 번째 스타상(*)의 점수만 2배가 됨
 *         스타상(*)의 효과는 다른 스타상(*)의 효과와 중첩 가능. 이 경우 중첩된 스타상(*) 점수는 4배가 됨
 *         스타상(*)의 효과는 아차상(#)의 효과와 중첩 가능. 이 경우 중첩된 아차상(#)의 점수는 -2배가 됨
 */

public class DartGame {
    public static void main(String[] args) {
        String dartResult = "1S2D*3T";
        System.out.println(solution(dartResult));
    }

    public static int solution(String dartResult) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < dartResult.length(); i++) {
            // 해당 점수 이전의 값을 음수 처리
            if(dartResult.charAt(i) == '#') {
                int num = stack.pop();
                stack.push(num * -1);

            // 해당 점수와 이전 점수 2배 처리
            } else if(dartResult.charAt(i) == '*') {
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(num2 * 2);
                stack.push(num1 * 2);

            } else if(dartResult.charAt(i) == 'S') {
                continue;

            } else if(dartResult.charAt(i) == 'D') {
                int num = stack.pop();
                stack.push(num * num);

            } else if(dartResult.charAt(i) == 'T') {
                int num = stack.pop();
                stack.push(num * num * num);

            } else {
                int num = Integer.parseInt(String.valueOf(dartResult.charAt(i)));
                char isTen = dartResult.charAt(i + 1);

                if(num == 1 && isTen == '0') {
                    stack.push(10);
                    i += 1;
                } else {
                    stack.push(num);
                }
            }

        }
        for (int s:stack) {
            answer += s;
        }
        return answer;
    }
}
