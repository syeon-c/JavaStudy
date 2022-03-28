package Programmers.Level2;

public class TargetNumber {
    static int answer = 0;
    private static void dfs(int[] num, int target, int sum, int i) {
        if (i == num.length) {
            if (sum == target) { answer++; }
            return;
        }
        dfs(num, target, sum + num[i], i + 1);
        dfs(num, target, sum - num[i], i + 1);
    }
    private static int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return answer;
    }
    public static void main(String[] args) {
        int[] num = {1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(solution(num, target));
    }
}
