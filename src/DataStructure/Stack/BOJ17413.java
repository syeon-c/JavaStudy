package DataStructure.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class BOJ17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] s = br.readLine().toCharArray();
        Deque<Character> deque = new ArrayDeque<>();
        ArrayList<Character> answer = new ArrayList<>();
        boolean isTag = false;
        for(Character c : s) {
            // 태그일 때
            if (isTag) {
                deque.add(c);
                if (c == '>') {
                    while (!deque.isEmpty())
                        answer.add(deque.pollFirst());
                    isTag = false;
                }
            // 태그가 아닐 때
            } else {
                if (c == ' ') {
                    while (!deque.isEmpty())
                        answer.add(deque.pollLast());
                    answer.add(c);
                } else if (c == '<') {
                    if (!deque.isEmpty()) {
                        while (!deque.isEmpty())
                            answer.add(deque.pollLast());
                    }
                    isTag = true;
                    deque.add(c);
                } else deque.add(c);
            }
        }
        while (!deque.isEmpty())
            answer.add(deque.pollLast());

        for(Character c : answer)
            System.out.print(c);
    }
}
