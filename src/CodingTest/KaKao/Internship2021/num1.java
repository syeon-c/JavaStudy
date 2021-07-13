package CodingTest.KaKao.Internship2021;

public class num1 {
    public static void main(String[] args) {
        int money = 12345678;
        int minratio = 10;
        int maxratio = 20;
        int ranksize = 250000;
        int threshold = 10000000;
        int months = 4;
        System.out.println(solution(money, minratio, maxratio, ranksize, threshold, months));
    }

    public static int solution(int money, int minratio, int maxratio, int ranksize, int threshold, int months) {
        int answer = -1;
        money -= (money % 100);

        if (money < threshold) {
            answer = 0;
        } else {
            for (int i = 1; i <= months; i++) {
                // 세율 구하기
                int tmp = minratio + ((money - threshold) / ranksize - 1);
                if (tmp > maxratio) {
                    tmp = minratio;
                }
                money -= (money * ((minratio + (tmp-1)) * 0.01));
            }
            answer = money;
        }
        return answer;
    }
}
