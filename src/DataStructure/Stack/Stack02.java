package DataStructure.Stack;

/**
 * 입력된 문자열에서 소괄호 ( ) 사이에 존재하는 모든 문자를 제거하고 남은 문자만 출력하는 프로그램을 작성하세요.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Stack02 {
    private static void Solution(String str) {
        Stack<Character> stack = new Stack<>();
        String answer = "";
        boolean remove = false;
        for(Character c : str.toCharArray()) {
            if(c == '(') {
                stack.push(c);
                remove = true;
            } else if (Character.isAlphabetic(c)) {
                if (!remove) answer += c;
            } else if (c == ')') {
                stack.pop();
                if (stack.empty()) remove = false;
            }
        }
        System.out.println(answer);
    }
    private static void Solution2(String str) {
        Stack<Character> stack = new Stack<>();
        String answer = "";
        for(Character c : str.toCharArray()) {
            if(c == ')') {
                while (stack.pop() != '(');
            } else stack.push(c);
        }

        for(int i = 0; i < stack.size(); i++) {
            answer += stack.get(i);
        }
        System.out.println(answer);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        br.close();
        Solution(input);
        Solution2(input);
    }
}
