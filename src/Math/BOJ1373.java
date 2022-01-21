package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1373 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        String binaryNum = br.readLine();
        br.close();
        if (binaryNum.length() % 3 == 1) { binaryNum = "00" + binaryNum; }
        else if (binaryNum.length() % 3 == 2) { binaryNum = "0" + binaryNum; }

        for(int i = 0; i <= binaryNum.length() - 3; i+=3) {
            int tmp = 0;
            if (binaryNum.charAt(i) == '1') tmp += 4;
            if (binaryNum.charAt(i+1) =='1') tmp += 2;
            if (binaryNum.charAt(i+2) == '1') tmp += 1;
            answer.append(tmp);
        }
        System.out.println(answer);
    }
}