import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ9613 {
    private static int getGCD(int a, int b) {
        while(b > 0) {
            int tmp = a;
            a = b;
            b = tmp % b;
        }
        return a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            String[] input = br.readLine().split(" ");
            int size = Integer.parseInt(input[0]);

            int[] arr = new int[size];
            for(int i = 0; i < size; i++)
                arr[i] = Integer.parseInt(input[i + 1]);
            Arrays.sort(arr);

            long sum = 0;
            for(int i = 0; i < size-1; i++) {
                for(int j = i+1; j < size; j++) {
                    sum += getGCD(arr[i], arr[j]);
                }
            }
            System.out.println(sum);
        }
        br.close();
    }
}
