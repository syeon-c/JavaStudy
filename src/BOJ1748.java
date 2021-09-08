import java.util.Scanner;

public class BOJ1748 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int answer = 0;
        int add = 1;
        int powTen = 10;

        for(int i = 1; i <= n; i++) {
           if(i % powTen < powTen - 1) answer += add;
           else {
               answer += add;
               add += 1;
               powTen *= 10;
           }
        }

        System.out.println(answer);
        sc.close();
    }
}
