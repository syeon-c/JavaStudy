package DataStructure.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        char[] init = br.readLine().toCharArray();
        int M = Integer.parseInt(br.readLine());
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();
        for(char c : init)
            left.push(c);

        for(int i = 0; i < M; i++) {
            char[] order = br.readLine().toCharArray();
            switch (order[0]) {
                case 'L':
                    if (!left.isEmpty())
                        right.push(left.pop());
                    break;
                case 'D':
                    if (!right.isEmpty())
                        left.push(right.pop());
                    break;
                case 'B':
                    if(!left.isEmpty())
                        left.pop();
                    break;
                case 'P':
                    left.push(order[2]);
                    break;
            }
        }

        while (!left.isEmpty())
            right.push(left.pop());
        while (!right.isEmpty())
            answer.append(right.pop());
        System.out.println(answer.toString());

        br.close();
    }
}