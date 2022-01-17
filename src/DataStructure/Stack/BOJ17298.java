package DataStructure.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ17298 {
    private static void solution(int N, int[] A) {
        int[] answer = new int[N];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(int i = 1; i < N; i++) {
            if (stack.isEmpty()) stack.push(i);
            while (!stack.isEmpty() && A[stack.peek()] < A[i]) {
                answer[stack.pop()] = A[i];
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) answer[stack.pop()] = -1;
        for(int a : answer) System.out.print(a + " ");
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] A = new int[N];
        for(int i = 0; i < N; i++)
            A[i] = Integer.parseInt(input[i]);
        br.close();
        solution(N, A);
    }
}
