package Programmers.Level1;

import java.util.ArrayList;

/**
 * 프로그래머스/lv1/없는 숫자 더하기
 * 0부터 9까지의 숫자 중 일부가 들어있는 정수 배열 numbers가 매개변수로 주어집니다.
 * numbers에서 찾을 수 없는 0부터 9까지의 숫자를 모두 찾아 더한 수를 return 하도록 solution 함수를 완성해주세요.
 */

public class AddNotExistingNumber {
    private static int solution2(int[] numbers) {
        int sum = 0;
        for(int i = 0; i <= 9; i++) sum += i;
        for(int num : numbers) sum -= num;
        return sum;
    }
    private static int solution(int[] numbers) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i <= 9; i++) list.add(i);

        for(int num : numbers) {
            if (list.contains(num)) list.set(num, 0);
        }
        int answer = list.stream().mapToInt(Integer::intValue).sum();
        return answer;
    }
    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,6,7,8,0};
        System.out.println(solution2(numbers));
    }
}
