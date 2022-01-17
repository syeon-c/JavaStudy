package DataStructure.Stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BOJ17299 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] A = new int[N];
        for(int i = 0; i < N; i++)
            A[i] = Integer.parseInt(input[i]);
        br.close();

        Map<Integer, Integer> map = new HashMap<>();
        for(int a : A) map.put(a, map.getOrDefault(a, 0) + 1);
        int[] answer = new int[N];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(int i = 1; i < N; i++) {
            if (stack.isEmpty()) stack.push(i);
            while (!stack.isEmpty() && map.get(A[stack.peek()]) < map.get(A[i])) {
                answer[stack.pop()] = A[i];
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) answer[stack.pop()] = -1;
        for(int a : answer) System.out.print(a + " ");
    }
}
