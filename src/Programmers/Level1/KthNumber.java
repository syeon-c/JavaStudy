package Programmers.Level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class KthNumber {
    private static int[] solution2(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i = 0; i < commands.length; i++) {
            int[] arr = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            Arrays.sort(arr);
            answer[i] = arr[commands[i][2] - 1];
        }
        return answer;
    }
    private static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int x = 0; x < commands.length; x++) {
            int i = commands[x][0];
            int j = commands[x][1];
            int k = commands[x][2];
            List<Integer> list = new ArrayList<>();
            for(int y = i; y <= j; y++) {
                list.add(array[y-1]);
            }

            Collections.sort(list);
            answer[x] = list.get(k - 1);
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        for(int a : solution2(arr, commands)) {
            System.out.println(a);
        }
    }
}
