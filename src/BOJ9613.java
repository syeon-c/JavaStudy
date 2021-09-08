import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9613 {
    public static int getGCD(int a, int b) {
        while (b > 0) {
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            String[] numList = br.readLine().split(" ");
            int size = Integer.parseInt(numList[0]);
            int[] arr = new int[size];

            for(int j = 0; j < size; j++) {
                arr[j] = Integer.parseInt(numList[j + 1]);
            }

            long sum = 0;
            for(int z = 0; z < size - 1; z++) {
                for(int x = z+1; x < size; x++) {
                    sum += getGCD(arr[z], arr[x]);
                }
            }
            System.out.println(sum);
        }
    }
}
