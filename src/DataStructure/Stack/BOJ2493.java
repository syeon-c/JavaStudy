package DataStructure.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
            //  현재 탑보다 스택 맨 위 탑의 값이 더 크면
            if(peek.value > now.value) {
                // 스택에 넣어주고, 꼭대기의 인덱스 반환
                stack.push(peek);
                stack.push(now);
                return peek.index;
            }
        }
        stack.push(now);
        // 더 높은 꼭대기 없을 경우 0 반환
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
    }
}