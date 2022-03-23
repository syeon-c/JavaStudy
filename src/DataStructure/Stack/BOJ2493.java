package DataStructure.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BOJ2493 {
    static Stack<top> stack = new Stack<>();

    public static class top {
        int value; int index;

        public top(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public static int solution(top now) {
        while (!stack.empty()) {
            top peek = stack.pop();
            if(peek.value > now.value) {
                stack.push(peek);
                stack.push(now);
                return peek.index;
            }
        }
        stack.push(now);
        return 0;
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] answer = new int[n];
        String[] topList = br.readLine().split(" ");

        for(int i = 0; i < n; i++) {
            int x = Integer.parseInt(topList[i]);
            answer[i] = solution(new top(x, i + 1));
        }
        for(int i = 0; i < answer.length; i++) {
            if(i == answer.length - 1) System.out.print(answer[i]);
            else System.out.print(answer[i] + " ");
        }
        br.close();
        Map<Integer, Integer> count = new HashMap<>();
    }
}