package DataStructure.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ10799 {
    private static int solution(String str) {
        int answer = 0;
        str = str.replace("()", "R");
        Stack<Character> stack = new Stack<>();
        for(char c : str.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c ==  'R') {
                answer += stack.size();
            } else {
                answer += 1;
                stack.pop();
            }
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println(solution(str));
    }
}
