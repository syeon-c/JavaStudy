package Graph.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1107 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int size = Integer.parseInt(br.readLine());

        boolean[] broken = new boolean[10];
        String[] input = br.readLine().split(" ");
        for(int i = 0; i < size; i++)
            broken[Integer.parseInt(input[i])] = true;

        int result = Math.abs(N - 100);
        // 리모콘이 9를 제외하고 모두 고장났다면 999999를 눌러서 찾는 경우도 포함되어야 하므로 최대값을 999999으로 설정
        // 고장나지 않은 리모콘 버튼으로만 N과 가장 근사한 번호를 만든 후 +, - 로 이동하는 값 중의 최소값을 선택
        for(int i = 0; i <= 999999; i++) {
            String str = String.valueOf(i);
            int len = str.length();
            boolean isBreak = false;

            for(int j = 0; j < len; j++) {
                if(broken[str.charAt(j) - '0']) {
                    isBreak = true;
                    break;
                }
            }
            if(!isBreak) {
                int min = Math.abs(N - i) + len;
                result = Math.min(min, result);
            }
        }
        System.out.println(result);
    }
}
