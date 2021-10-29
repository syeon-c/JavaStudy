package Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * A, B 두 사람이 가위바위보 게임을 합니다.
 * 총 N번의 게임을 하여 A가 이기면 A를 출력하고, B가 이기면 B를 출력합니다. 비길 경우에는 D를 출력합니다.
 * 가위, 바위, 보의 정보는 1:가위, 2:바위, 3:보로 정하겠습니다.
 */

public class Array03 {
    private static void Solution(int N, int[] A, int[] B) {
        for(int i = 0; i < N; i++) {
            int a = A[i];
            int b = B[i];
            if(a == b) System.out.println("D");
            else if((a == 1 && b == 3) || (a == 2 && b == 1) || (a == 3 && b == 2))
                System.out.println("A");
            else
                System.out.println("B");
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] input_a = br.readLine().split(" ");
        String[] input_b = br.readLine().split(" ");
        br.close();

        int[] A = new int[N], B = new int[N];
        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(input_a[i]);
            B[i] = Integer.parseInt(input_b[i]);
        }
        Solution(N, A, B);
    }
}
