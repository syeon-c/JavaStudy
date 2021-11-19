package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class WordChainGame {
    private static void Solution(int n, String[] words) {
        int[] answer = new int[2];
        answer[0] = 0; answer[1] = 0;
        List<String> wordList = new ArrayList<>();
        int count = 2, round = 1;
        wordList.add(words[0]);
        char last = words[0].charAt(words[0].length() - 1);
        for(int i = 1; i < words.length; i++) {
            if (wordList.contains(words[i]) || words[i].charAt(0) != last) {
                answer[0] = count;
                answer[1] = round;
                break;
            }
            wordList.add(words[i]);
            last = words[i].charAt(words[i].length() - 1);

            if (count == n) {
                count = 1;
                round++;
            } else count++;
        }
        System.out.println(answer[0] + "," + answer[1]);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        br.close();
        Solution(n, input);
    }
}
