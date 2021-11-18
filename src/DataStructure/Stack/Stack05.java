package DataStructure.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Stack05 {
    private static void Solution(String str) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        for(Character c : str.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                Character tmp = stack.pop();
                // 레이저
                if (tmp == '(') {
                    answer += stack.size();
                // 쇠막대기
                } else {
                    answer += 1;
                }
            }
        }
        System.out.println(answer);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        br.close();
        Solution(input);
    }
}
