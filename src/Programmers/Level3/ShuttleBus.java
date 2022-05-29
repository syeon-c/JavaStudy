package Programmers.Level3;

import java.util.PriorityQueue;

public class ShuttleBus {
    private static String solution(int n, int t, int m, String[] timetable) {
        PriorityQueue<Integer> crewArrived = new PriorityQueue<>();
        for(String time : timetable) {
            int tmp = (Integer.parseInt(time.substring(0, 2)) * 60) + Integer.parseInt(time.substring(3));
            crewArrived.add(tmp);
        }

        int busArrived = 540;
        int conArrived = 0;
        int cnt = m;
        for(int i = 0; i < n; i++) {
            cnt = m;
            while (!crewArrived.isEmpty()) {
                int cur = crewArrived.peek();
                if (cur <= busArrived && cnt > 0) {
                    cnt--;
                    crewArrived.poll();
                } else break;
                conArrived = cur - 1;
            }
            busArrived += t;
        }
        if (cnt > 0) conArrived = busArrived - t;

        String hh = String.format("%02d", conArrived / 60);
        String mm = String.format("%02d", conArrived % 60);
        return hh + ":" + mm;
    }
    public static void main(String[] args) {
        int n = 2;
        int t = 10;
        int m = 2;
        String[] timetable = {"09:10", "09:09", "08:00"};
        System.out.println(solution(n, t, m, timetable));
    }
}
