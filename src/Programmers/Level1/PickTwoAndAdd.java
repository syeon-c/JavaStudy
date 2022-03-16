package Programmers.Level1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class PickTwoAndAdd {
    private static ArrayList<Integer> solution(int[] numbers) {
        HashSet<Integer> add = new HashSet<>();
        for(int i = 0; i < numbers.length - 1; i++) {
            for(int j = i + 1; j < numbers.length; j++) {
                int result = numbers[i] + numbers[j];
                add.add(result);
            }
        }
        add.stream().sorted();

        ArrayList<Integer> answer = new ArrayList<>();
        for(int a : add) answer.add(a);
        Collections.sort(answer);
        return answer;
    }
    public static void main(String[] args) {
        int[] num = {2, 1, 3, 4, 1};
        solution(num);
    }
}
