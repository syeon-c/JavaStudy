package CodingTest;

public class Nation124 {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(solution(n));
    }

    public static String solution(int n) {
        String answer = "";

        if(n == 1) {
            return "1";
        }

        if(n == 2) {
            return "2";
        }

        while (n > 0) {
            int tmp = n % 3;
            n = n / 3;

            if(tmp == 0) {
                n -= 1;
                tmp = 4;
            }

            answer = String.valueOf(tmp) + answer;
            answer += String.valueOf(tmp);
        }


        return answer;
    }
}
4