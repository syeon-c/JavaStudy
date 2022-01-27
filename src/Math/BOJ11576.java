package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ11576 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        int A = Integer.parseInt(info[0]);
        int B = Integer.parseInt(info[1]);
        // A진법으로 나타낸 숫자의 자리수의 개수
        int m = Integer.parseInt(br.readLine());
        String[] nums = br.readLine().split(" ");
        br.close();
        Stack<Integer> answer = new Stack<>();
        // A진법 -> 10진법
        int decimalValue = 0;
        int cnt = 0;        // 자릿수
        for(int i = m-1; i >= 0; i--) {
            decimalValue += Integer.parseInt(nums[i]) * Math.pow(A, cnt++);
        }
        // 10진법 -> B진법
        while (decimalValue > 0) {
            answer.push(decimalValue % B);
            decimalValue /= B;
        }
        while (!answer.isEmpty()) System.out.print(answer.pop() + " ");
    }
}
