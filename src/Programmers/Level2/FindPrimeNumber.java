package Programmers.Level2;

import java.util.HashSet;
import java.util.Set;

public class FindPrimeNumber {
    private static Set<Integer> allNum = new HashSet<>();
    private static void combination(int len, String num, char[] numbers, boolean[] visited) {
        if (num.length() == len) {
            allNum.add(Integer.parseInt(num));
            return;
        }
        for(int i = 0; i < numbers.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                num += numbers[i];
                combination(len, num, numbers, visited);
                num = num.substring(0, num.length()-1);
                visited[i] = false;
            }
        }
    }
    private static boolean isPrime(int num) {
        if (num == 1 || num == 0) return false;
        else {
            for(int i = 2; i < num; i++)
                if (num % i == 0) return false;
        }
        return true;
    }
    private static int solution(String numbers) {
        int answer = 0;

        for(int len = 1; len <= numbers.length(); len++) {
            boolean[] visited = new boolean[numbers.length()];
            combination(len, "", numbers.toCharArray(), visited);
        }

        for(int num : allNum) {
            if (isPrime(num)) answer++;
        }
        return answer;
    }
    public static void main(String[] args) {
        String numbers = "011";
        System.out.println(solution(numbers));
    }
}
