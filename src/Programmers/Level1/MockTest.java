package Programmers.Level1;

import java.util.*;

public class MockTest {
    private static int[] student1 = {1, 2, 3, 4, 5};
    private static int[] student2 = {2, 1, 2, 3, 2, 4, 2, 5};
    private static int[] student3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

    private static List<Integer> solution(int[] answers) {
        List<Integer> answer = new ArrayList<>();
        int[] score = new int[3];

        for(int i = 0; i < answers.length; i++) {
            if (student1[i % 5] == answers[i]) {
                score[0]++;
            }
            if (student2[i % 8] == answers[i]) {
                score[1]++;
            }
            if (student3[i % 10] == answers[i]) {
                score[2]++;
            }
        }

        int maxScore = 0;
        for(int i = 0; i < 3; i++) {
            if (score[i] > maxScore) maxScore = score[i];
        }
        for(int i = 0; i < 3; i++) {
            if (score[i] == maxScore) answer.add(i + 1);
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] answers = {1, 2, 3, 4, 5};
        for(int s : solution(answers)) System.out.println(s);
    }
}
