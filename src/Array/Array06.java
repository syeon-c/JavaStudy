package Array;

/**
 * N개의 자연수가 입력되면 각 자연수를 뒤집은 후 그 뒤집은 수가 소수이면 그 소수를 출력하 는 프로그램을 작성하세요.
 * 예를 들어 32를 뒤집으면 23이고, 23은 소수이다. 그러면 23을 출 력한다.
 * 단 910를 뒤집으면 19로 숫자화 해야 한다. 첫 자리부터의 연속된 0은 무시한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Array06 {
    private static boolean isPrime(int n) {
        if (n == 1) return false;
        for(int i = 2; i < n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
    private static void Solution(int n, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        for(int  a : arr) {
            int tmp = a;
            int res = 0;
            // 숫자 뒤집기
            while(tmp > 0){
                int t = tmp % 10;
                res = res * 10 + t;
                tmp = tmp / 10;
            }
            if (isPrime(res)) answer.add(res);
        }
        for(int a : answer)
            System.out.print(a + " ");
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        br.close();

        int[] arr = new int[N];
        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(input[i]);

        Solution(N, arr);
    }
}
