package DataStructure.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ1918 {
    private static int priority(char op) {
        if (op == '(' || op == ')') return 0;
        else if (op == '+' || op == '-') return 1;
        else if (op == '*' || op == '/') return 2;
        else return -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();
        StringBuilder answer = new StringBuilder();
        for(char c : input) {
            if (Character.isAlphabetic(c)) {
                answer.append(c);
            } else if(c == '+' || c == '-' || c == '*'|| c == '/') {
                // 연산자 우선순위에 따라 표기식 추가
                while (!stack.isEmpty() && priority(c) <= priority(stack.peek())) {
                    answer.append(stack.pop());
                }
                stack.push(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    answer.append(stack.pop());
                }
                stack.pop();
            } else answer.append(c);
        }
        while (!stack.isEmpty()) answer.append(stack.pop());
        System.out.println(answer);
    }
}
