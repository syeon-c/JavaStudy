package Programmers.Level3;

/** https://geunzrial.tistory.com/26
 * 특정 로그의 끝나는 기간에 +1의 값과 나머지 로그값들의 시작값을 비교.
 * 그리고 특정 로그의 끝나는 값의 +1안에 들어가는 시작값이 몇개인지를 찾고, 그 안에서의 최대값 반환.
 */

public class ChuseokTraffic1 {
    private static int solution(String[] lines) {
        int answer = 0;
        // 한 로그의 끝나는 시간 + 1 동안 몇 개의 로그 시작되는지 카운트
        int[] cnt = new int[lines.length];
        double complete;
        // 날짜 데이터 제거 및 시간 단위 변환
        for(int i = 0; i < lines.length; i++) {
            lines[i] = lines[i].substring(11).replace(":", "").replace("s", "");
            // 시간 값을 초 단위로 변환
            int sec = Integer.parseInt(lines[i].substring(0, 2)) * 3600 +
                    Integer.parseInt(lines[i].substring(2, 4)) * 60 +
                    Integer.parseInt(lines[i].substring(4, 6));

            lines[i] = sec + lines[i].substring(6) + "";
        }

        for(int i = 0; i < lines.length; i++) {
            String[] ST = lines[i].split(" ");

            complete = Double.parseDouble(ST[0]);
            double term = complete + 1;

            for(int j = i; j < lines.length; j++) {
                String[] line_split = lines[j].split(" ");
                // 시작 시간 구하기
                double start = Double.parseDouble(line_split[0]) - Double.parseDouble(line_split[1]) + 0.001;
                if(start < term){
                    cnt[i]++;
                }
            }
        }
        for(int i = 0; i< cnt.length; i++) {
            if (answer < cnt[i]) answer = cnt[i];
        }
        return answer;
    }
    public static void main(String[] args) {
        String[] lines = {
                "2016-09-15 01:00:04.002 2.0s",
                "2016-09-15 01:00:07.000 2s"
        };
        System.out.println(solution(lines));
    }
}
