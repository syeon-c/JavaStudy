package Programmers.Level1;

public class HarshadNumber {
    public static void main(String[] args) {
        int arr = 10;
        System.out.println(Solution(arr));
    }
    public static boolean Solution(int x) {
        int sum = 0;
        int n = x;

        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }

        if(x % sum != 0)
            return false;

        return true;
    }
}
