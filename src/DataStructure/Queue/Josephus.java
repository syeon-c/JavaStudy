package DataStructure.Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Josephus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        Queue<Integer> q = new LinkedList<>();
        int[] answer = new int[n];
        int cnt = 0;
        int idx = 0;

        for(int i=1; i <= n; i++) {
            q.offer(i);
        }

        while (!q.isEmpty()) {
            cnt++;
            if(cnt == k) {
                answer[idx] = q.poll();
                idx++;
                cnt = 0;
            } else q.offer(q.poll());

        }

        System.out.print("<");
        for(int i : answer) {
            if(i == answer[answer.length - 1])
                System.out.println(i + ">");
            else System.out.print(i + ", ");
        }
    }
}
