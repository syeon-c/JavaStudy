package String;

import java.io.*;

public class BOJ11655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        for(char c : input.toCharArray()) {
            if (Character.isLowerCase(c)) {
                if ('z' < c + 13) bw.write(('a' - 1) + (c + 13) - 'z');
                else bw.write(c + 13);
            } else if (Character.isUpperCase(c)) {
                if ('Z' < c + 13) bw.write(('A' - 1) + (c + 13) - 'Z');
                else bw.write(c + 13);
            }
            else bw.write(c);
        }
        br.close();
        bw.flush();
    }
}