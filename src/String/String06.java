package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class String06 {
    private static void Solution(String str) {
        ArrayList<Character> answer = new ArrayList<>();

        for(char c : str.toCharArray()) {
            if (!answer.contains(c)) {
                answer.add(c);
            }
        }
        for(char c : answer) System.out.print(c);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        br.close();
        Solution(input);
    }
}
