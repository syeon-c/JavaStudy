package Programmers.Level1;

public class FlipTernaryScale {
    private static StringBuilder toTenary(int n) {
        StringBuilder result = new StringBuilder();
        while (n > 0) {
            result.append(n % 3);
            n /= 3;
        }
        result = result.reverse();
        return result;
    }

    private static int toDecimal(StringBuilder n) {
        int result = 0;
        for(int i = 0; i < n.length(); i++) {
            result += Math.pow(3, i) * Integer.parseInt(String.valueOf(n.charAt(i)));
        }

        return result;
    }
    private static int solution(int n) {
        StringBuilder tenary = toTenary(n);
        int answer = toDecimal(tenary);
        return answer;
    }

    private static int solution2(int n) {
        String answer = "";
        while (n > 0) {
            answer = answer + (n % 3);
            n /= 3;

        }
        return Integer.parseInt(answer, 3);
    }
    public static void main(String[] args) {
        int n = 45;
        System.out.println(solution2(n));
    }
}
