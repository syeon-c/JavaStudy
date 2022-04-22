package Programmers.Level2;

import java.util.Arrays;
import java.util.Comparator;

public class TheBiggestNumber {
    private static int max = Integer.MIN_VALUE;
    private static void dfs(int index, String num, int[] numbers, boolean[] visited) {
        if (index == numbers.length) {
            int n = Integer.parseInt(num);
            if (n > max) max = n;
            return;
        }

        for(int i = 0; i < numbers.length; i++) {
            if (!visited[i]) {
                String n = String.valueOf(numbers[i]);
                num += n;
                visited[i] = true;
                dfs(index + 1, num, numbers, visited);
                num = num.substring(0, num.length() - n.length());
                visited[i] = false;
            }
        }
    }
    private static String solution_dfs(int[] numbers) {
        boolean[] visited = new boolean[numbers.length];
        dfs(0, "", numbers, visited);
        return String.valueOf(max);
    }
    private static String solution(int[] numbers) {
        String answer = "";
        int len = numbers.length;
        String[] strList = new String[len];
        for(int i = 0; i < len; i++) {
            strList[i] = Integer.toString(numbers[i]);
        }
        Arrays.sort(strList, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));
        if (strList[0].equals("0")) return "0";
        else {
            for(String s : strList) answer += s;
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] numbers = {3, 30, 34, 5, 9};
        System.out.println(solution(numbers));
    }
}
