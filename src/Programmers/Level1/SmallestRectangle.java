package Programmers.Level1;

public class SmallestRectangle {
    private static int solution(int[][] sizes) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        for(int i = 0; i < sizes.length; i++) {
            if (sizes[i][1] > sizes[i][0]) {
                int tmp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = tmp;
            }
            max1 = Math.max(sizes[i][0], max1);
            max2 = Math.max(sizes[i][1], max2);
        }
        return max1 * max2;
    }
    public static void main(String[] args) {
        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        System.out.println(solution(sizes));
    }
}
