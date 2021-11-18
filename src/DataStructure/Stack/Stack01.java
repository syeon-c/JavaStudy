package DataStructure.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Stack01 {
    private static void Solution(String str) {
        Stack<Character> stack = new Stack<>();
        for (Character c : str.toCharArray()) {
           if (c == '(') {
               stack.add(c);
           } else {
               if (stack.empty()) {
                   System.out.println("NO");
                   return;
               }
               stack.pop();
           }
        }
        if (!stack.empty()) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        br.close();
        Solution(input);
    }
}
