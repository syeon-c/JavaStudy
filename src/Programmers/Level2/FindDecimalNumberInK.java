package Programmers.Level2;

public class FindDecimalNumberInK {
    private static boolean isPrime(long num) {
        if (num == 1 || num == 0) return false;
        else {
            for(int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) return false;
            }
        }
        return true;
    }
    private static int solution(int n, int k) {
        int answer = 0;
        // 진법 변환
        String conversion = "";
        while (n > 0) {
            conversion = n % k + conversion;
            n /= k;
        }
        // 소수 개수 찾기
        String[] nums = conversion.split("0");
        for(String num : nums) {
            if (num.length() == 0) continue;
            if (isPrime(Long.parseLong(num))) answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        int n = 437674;
        int k = 3;
        System.out.println(solution(n, k));
    }
}
