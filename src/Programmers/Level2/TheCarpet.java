package Programmers.Level2;

import java.util.ArrayList;
import java.util.List;

public class TheCarpet {
    private static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        int area = brown + yellow;
        List<Integer> divisor = new ArrayList<>();

        // 약수 구하기
        for(int i = 1; i <= area; i++) {
            if (area % i == 0) divisor.add(i);
        }

        int yellow_area;
        while (!divisor.isEmpty()) {
            int yellow_h = divisor.get(0) - 2;
            int yellow_w = divisor.get(divisor.size() - 1) - 2;
            yellow_area = yellow_h * yellow_w;

            if (yellow_area == yellow) {
                answer[0] = divisor.get(divisor.size() - 1);
                answer[1] = divisor.get(0);
                break;
            }

            divisor.remove(0);
            divisor.remove(divisor.size() - 1);
        }
        return answer;
    }
    public static void main(String[] args) {
        int brown = 8;
        int yellow = 1;
        System.out.println(solution(brown, yellow));
    }
}
