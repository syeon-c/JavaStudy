package Programmers.Level2;

public class RepeatBinaryTransformation {
    private static int[] solution(String s) {
        int[] answer = new int[2];
        int round = 0;
        int numOfRemovedZero = 0;
        while (!s.equals("1")) {
            round++;
            // 1. x의 모든 0 제거
            if (s.contains("0")) {
                for(char c : s.toCharArray()) {
                    if (c == '0') {
                        numOfRemovedZero++;
                    }
                }
                s = s.replace("0", "");
            }
            // 2. x의 길이를 2진법으로 표현한 문자열로 x 변환
            int len = s.length();
            s = Integer.toBinaryString(len);
        }
        answer[0] = round;
        answer[1] = numOfRemovedZero;
        return answer;
    }
    public static void main(String[] args) {
        String s = "110010101001";
        System.out.println(solution(s));
    }
}