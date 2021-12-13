package Graph.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DFSBFS01 {
    static int N;
    static int total;
    static int[] arr;
    static String answer = "NO";

    private static void dfs(int index, int sum) {
        if(sum>total/2) return;
        if(index == N){
            if(sum == total - sum){
                answer="YES";
                return;
            }
        }
        else{
            dfs(index + 1, sum + arr[index]);
            dfs(index+1, sum);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        arr = new int[N];
        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(input[i]);
        br.close();
        total = Arrays.stream(arr).sum();
        dfs(0, 0);
        System.out.println(answer);
    }
}
