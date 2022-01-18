package DataStructure.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BOJ1935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] expression = br.readLine().toCharArray();

        // 각 문자별 대응값 설정
        Map<Character, Double> map = new HashMap<>();
        char key = 'A';
        for(int i = 0; i < N; i++) {
            map.put(key, Double.parseDouble(br.readLine()));
            key++;
        }
        br.close();
        Stack<Double> stack = new Stack<>();
        for(char c : expression) {
            if (Character.isAlphabetic(c)) stack.push(map.get(c));
            else {
                double num1 = stack.pop();
                double num2 = stack.pop();

                switch (c) {
                    case '+':
                        stack.push(num2 + num1);
                        break;
                    case '-':
                        stack.push(num2 - num1);
                        break;
                    case '*':
                        stack.push(num2 * num1);
                        break;
                    case '/':
                        stack.push(num2 / num1);
                        break;
                }
            }
        }
        System.out.println(String.format("%.2f", stack.pop()));
    }
}
