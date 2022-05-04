package Programmers.Level2;

public class Stock {
    private static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for(int i = 0; i < prices.length; i++) {
            int price = prices[i];
            int cnt = 0;
            for(int j = i+1; j < prices.length; j++) {
                cnt++;
                if (price > prices[j]) break;
            }
            answer[i] = cnt;
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};
        System.out.println(solution(prices));
    }
}
