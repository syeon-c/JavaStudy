package Programmers.Level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DivisibleNumberArray {
    private static int[] solution2(int[] array, int divisor) {
        return Arrays.stream(array).filter(factor -> factor % divisor == 0).toArray();
    }
    private static List<Integer> solution(int[] arr, int divisor) {
        List<Integer> answer = new ArrayList<>();
        for(int a : arr) {
            if (a % divisor == 0) answer.add(a);
        }
        if (answer.isEmpty()) {
          answer.add(-1);
        } else Collections.sort(answer);
        return answer;
    }
    public static void main(String[] args) {
        int[] arr = {2, 36, 1, 3};
        int div = 1;
        for(int n : solution2(arr, div)) {
            System.out.print(n + " ");
        }
    }
}
