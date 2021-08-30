import java.util.Scanner;

public class TenSystem {
    public static void main(String[] args) {
        int n = 3;
        int[] nums = {1, 2, 3, 5, 3};
        System.out.println(solution(n, nums));
    }

    public static int solution(int n, int[] nums) {
        int answer = 0;
        for(int num : nums) {
            if(num == n) {
                answer++;
            }
        }
        return answer;
    }
}
