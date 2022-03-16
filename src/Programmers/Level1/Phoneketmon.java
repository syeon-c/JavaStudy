package Programmers.Level1;

import java.util.HashSet;

public class Phoneketmon {
    private static int solution(int[] nums) {
        HashSet<Integer> sort = new HashSet<>();
        int chance = nums.length / 2;
        for(int n : nums) sort.add(n);
        return Math.min(chance, sort.size());
    }
    public static void main(String[] args) {

    }
}
