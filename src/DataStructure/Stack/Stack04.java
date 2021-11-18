package DataStructure.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Stack04 {
    private static void Solution(String str) {
        Stack<Integer> stack = new Stack<>();
        for(Character c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                stack.push(c - 48);
            } else {
                int t2 = stack.pop();
                int t1 = stack.pop();
                // 사칙연산
                if (c == '+') {
                    stack.push(t1 + t2);
                } else if (c == '-') {
                    stack.push(t1 - t2);
                } else if (c == '*') {
                    stack.push(t1 * t2);
                } else {
                    stack.push(t1 / t2);
                }
            }
        }
        System.out.println(stack.get(0));
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        br.close();
        Solution(input);
    }
}
