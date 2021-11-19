package DataStructure.Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Queue02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String mandatory = br.readLine();
        String subjects = br.readLine();
        br.close();
        Solution(mandatory, subjects);
    }

    private static void Solution(String mandatory, String subjects) {
        String answer = "YES";
        Queue<Character> q = new LinkedList<>();
        for(char m : mandatory.toCharArray())
            q.offer(m);
        for(char subject : subjects.toCharArray()) {
            if (q.contains(subject)) {
                if (subject != q.poll()) {
                    answer = "NO";
                    break;
                }
            }
        }
        if (!q.isEmpty()) answer = "NO";
        System.out.println(answer);
    }
}
