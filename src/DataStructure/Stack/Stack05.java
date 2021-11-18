package DataStructure.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Stack05 {
    private static void Solution(String str) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') stack.push('(');
            else {
                stack.pop();
                // 레이저
                if(str.charAt(i - 1) == '(') answer += stack.size();
                // 쇠막대기
                else answer += 1;
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
