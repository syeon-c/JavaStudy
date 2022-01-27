package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BOJ11005 {
    private static char[] list = {'0', '1', '2', '3', '4', '5',
                                  '6', '7', '8', '9', 'A', 'B',
                                  'C', 'D', 'E', 'F', 'G', 'H',
                                  'I', 'J', 'K', 'L', 'M', 'N',
                                  'O', 'P', 'Q', 'R', 'S', 'T',
                                  'U', 'V', 'W', 'X', 'Y', 'Z'};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Character, Integer> map = new HashMap<>();
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);
        br.close();
        StringBuilder answer = new StringBuilder();

        while (N > 0) {
            answer.append(list[N % B]);
            N /= B;
        }
        System.out.println(answer.reverse());
    }
}
