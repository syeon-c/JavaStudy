package Programmers.Level2;

import java.util.Stack;

public class MakeLargestNumber {
    public static void main(String[] args) {
        String number = "98765432";
        int k = 4;
        System.out.println(solution(number, k));
    }

    private static String solution(String number, int k) {
        String answer = "";
        Stack<Character> stack = new Stack<>();

        for (int i=0; i<number.length(); i++) {
            char c = number.charAt(i);
            while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
                stack.pop();
            }
            stack.push(c);
        }

        int index = 0;
        for(char num : stack) {
            if (index == number.length() - k) break;
            answer += num;
            index++;
        }

        return answer;
    }
}
