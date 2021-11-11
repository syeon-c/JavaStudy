package Graph.BruteForce;

/**
 * 수빈이는 TV를 보고 있다. 수빈이는 채널을 돌리려고 했지만, 버튼을 너무 세게 누르는 바람에, 일부 숫자 버튼이 고장났다.
 * 리모컨에는 버튼이 0부터 9까지 숫자, +와 -가 있다. +를 누르면 현재 보고있는 채널에서 +1된 채널로 이동하고, -를 누르면 -1된 채널로 이동한다.
 * 채널 0에서 -를 누른 경우에는 채널이 변하지 않고, 채널은 무한대 만큼 있다.
 * 수빈이가 지금 이동하려고 하는 채널은 N이다. 어떤 버튼이 고장났는지 주어졌을 때, 채널 N으로 이동하기 위해서 버튼을 최소 몇 번 눌러야하는지 구하는 프로그램을 작성하시오.
 * 수빈이가 지금 보고 있는 채널은 100번이다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1107 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        boolean[] broken = new boolean[10];
        if (M != 0) {
            String[] input = br.readLine().split(" ");
            for(int i = 0; i < M; i++)
                broken[Integer.parseInt(input[i])] = true;
        }
        br.close();

        int result = Math.abs(N - 100); // 초기값 설정
        // 리모콘이 9를 제외하고 모두 고장났다면 999999를 눌러서 찾는 경우도 포함되어야 하므로 최대값을 999999으로 설정
        // 고장나지 않은 리모콘 버튼으로만 N과 가장 근사한 번호를 만든 후 +, - 로 이동하는 값 중의 최소값을 선택
        for(int i = 0; i <= 999999; i++) {
            String str = String.valueOf(i);
            int len = str.length();
            boolean isBroken = false;

            for(int j = 0; j < len; j++) {
                if(broken[str.charAt(j) - '0']) {
                    isBroken = true;
                    break;
                }
            }
            if(!isBroken) {
                int min = Math.abs(N - i) + len;
                result = Math.min(min, result);
            }
        }
        System.out.println(result);
    }
}