package Programmers.Level2;

import java.util.ArrayList;
import java.util.List;

public class WordChainGame {
    private static int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        answer[0] = 0;
        answer[1] = 0;

        String word = words[0];
        List<String> wordList = new ArrayList<>();
        wordList.add(words[0]);

        for(int i = 1; i < words.length; i++) {
            if (words[i].charAt(0) != word.charAt(word.length()-1) || wordList.contains(words[i]) || words[i].length() <= 1) {
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                break;
            } else {
                word = words[i];
                wordList.add(words[i]);
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        int n = 3;
        String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        System.out.println(solution(n, words));
    }
}
