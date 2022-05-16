package Programmers.Level2;

import java.util.*;

public class ParkingFeeCalculaiton {
    private static int[] solution(int[] fees, String[] records) {
        int default_time = fees[0];
        int default_fee = fees[1];
        int per_time = fees[2];
        int per_fee = fees[3];
        HashMap<String, Integer> parkingIn = new HashMap<>();
        HashMap<String, Integer> parkingOut = new HashMap<>();
        HashMap<String, Integer> parkingTime = new HashMap<>();

        for(String record : records) {
            String[] info = record.split(" ");
            String time = info[0];
            int hh = Integer.parseInt(time.split(":")[0]) * 60;
            int mm = Integer.parseInt(time.split(":")[1]);
            int total_time = hh + mm;
            String carId = info[1];
            String inout = info[2];

            if (inout.equals("IN")) {
                parkingIn.put(carId, total_time);
            } else {
                parkingOut.put(carId, total_time);
                // 누적 주차 시간 계산
                int sum = parkingOut.get(carId) - parkingIn.get(carId);
                parkingTime.put(carId, parkingTime.getOrDefault(carId, 0) + sum);
                // 입출차 기록 삭제
                parkingIn.remove(carId);
                parkingOut.remove(carId);
            }
        }
        // 출차 기록이 없으면 23:59 출차 처리
        if (!parkingIn.isEmpty()) {
            int outTime = 23 * 60 + 59;
            for(String key : parkingIn.keySet()) {
                int sum = outTime - parkingIn.get(key);
                if (parkingTime.containsKey(key)) {
                    parkingTime.replace(key, parkingTime.get(key) + sum);
                } else {
                    parkingTime.put(key, sum);
                }
            }
        }
        // 차량 번호순 정렬
        Object[] carIdArr = parkingTime.keySet().toArray();
        Arrays.sort(carIdArr);

        int[] answer = new int[parkingTime.size()];
        int index = 0;
        for(Object id : carIdArr) {
            // 주차 요금 계산
            if (parkingTime.get(id.toString()) > default_time) {
                double useTime = parkingTime.get(id.toString());
                answer[index++] = default_fee + (int) Math.ceil((useTime - default_time) / per_time) * per_fee;
            } else {
                answer[index++] = default_fee;
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        solution(fees, records);
    }
}
