package Programmers.Level2;

public class MinMax {
    private static String solution(String s) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        String[] nums = s.split(" ");
        for(String num : nums) {
            int n = Integer.parseInt(num);
            if (n < min) min = n;
            if (n > max) max = n;
        }
        return min + " " + max;
    }
    public static void main(String[] args) {
        String s = "1 2 3 4";
        System.out.println(solution(s));
    }
}
