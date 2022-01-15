package DataStructure.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class BOJ1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Stack<Integer> stack = new Stack<>();
        ArrayList<String> result = new ArrayList<>();
        int index = 0;
        int num = 1;
        boolean flag = true;
        while (index < n) {
            if (!stack.isEmpty() && arr[index] == stack.peek()) {
                result.add("-");
                stack.pop();
                index++;
            } else {
                if (num > n) {
                    flag = false;
                    break;
                }
                stack.push(num++);
                result.add("+");
            }
        }
        if (flag) {
            for(String s : result)
                System.out.println(s);
        } else System.out.println("NO");
    }
}
