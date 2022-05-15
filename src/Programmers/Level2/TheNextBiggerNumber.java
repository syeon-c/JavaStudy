package Programmers.Level2;

public class TheNextBiggerNumber {
    private static int solution(int n) {
        int answer;
        int count = binaryCount(n);
        int plus = 1;
        while (true) {
            int bigNum = n + plus;
            if (count == binaryCount(bigNum)) {
                answer = bigNum;
                break;
            }
            plus++;
        }
        return answer;
    }

    private static int binaryCount(int n) {
        int count = 0;
        for(char c : Integer.toBinaryString(n).toCharArray()) {
            if (c == '1') count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 78;
        System.out.println(solution(n));
    }
}
