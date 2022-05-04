package Programmers.Level2;

public class DifferentBitsLessThanTwo {
    private static long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
            // 짝수면 +1
            if (numbers[i] % 2 == 0) answer[i] = numbers[i] + 1;
            // 0을 포함하는 경우 / 미포함하는 경우
            else {
                String numToBinary = Long.toBinaryString(numbers[i]);
                // 마지막 0을 1로 변환, 그 뒤 1을 0으로 변환
                if (numToBinary.contains("0")) {
                    StringBuilder newBinary = new StringBuilder(numToBinary);
                    int lastZero = numToBinary.lastIndexOf('0');
                    newBinary.replace(lastZero, lastZero+1, "1");
                    newBinary.replace(lastZero + 1, lastZero + 2, "0");
                    numToBinary = newBinary.toString();
                } else {
                    // 2번째 자리에 0을 삽입
                    numToBinary = "10" + numToBinary.substring(0, numToBinary.length() - 1);
                }
                answer[i] = Long.parseLong(numToBinary, 2);
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        long[] numbers = {7, 2, 11};
        System.out.println(solution(numbers));
    }
}
