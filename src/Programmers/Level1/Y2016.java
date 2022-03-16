package Programmers.Level1;

public class Y2016 {
    static String[] day = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
    static int[] numOfDays = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static String solution(int a, int b) {
        int count = 0;
        // 1월부터 a-1월까지 모든 일수 더하기
        for(int i = 0; i < a - 1; i++) {
            count += numOfDays[i];
        }
        // a월의 일수 더하기
        count += b - 1;
        return day[count % 7];
    }
    public static void main(String[] args) {
        int a = 5;
        int b = 24;
        System.out.println(solution(a, b));
    }
}
