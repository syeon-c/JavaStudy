package Programmers.Level2;

public class NormalSquare {
    private static long getGCD(long a, long b) {
        if (a > b) {
            long tmp = a;
            a = b;
            b = a;
        }
        long tmp = 0;
        while (a > 0) {
            tmp = b % a;
            b = a;
            a = tmp;
        }
        return b;
    }

    private static long solution(int w, int h) {
        long W = w;
        long H = h;

        if (w == h) return (W * H) - W;
        else {
            long gcd = getGCD(W, H);
            return (W * H) - (W + H - gcd);
        }
    }
    public static void main(String[] args) {
        int w = 8;
        int h = 12;
        System.out.println(solution(w, h));
    }
}
