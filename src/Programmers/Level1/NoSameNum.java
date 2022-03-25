package Programmers.Level1;

import java.util.ArrayList;
import java.util.List;

public class NoSameNum {
    private static List<Integer> solution(int[] arr) {
        List<Integer> answer = new ArrayList<>();

        int pre = arr[0];
        for(int i = 1; i < arr.length; i++) {
            if (pre != arr[i]) {
                answer.add(pre);
                pre = arr[i];
            }
        }
        answer.add(pre);
        return answer;
    }
    public static void main(String[] args) {
        int[] arr = {4, 4, 4, 3, 3};
        solution(arr);
    }
}
