package DataStructure.Heap.Programmers;

import java.util.Arrays;
import java.util.PriorityQueue;

public class DiskController {
    private static int solution(int[][] jobs) {
        int answer = 0;
        // jobs 배열 도착 시간 순으로 정렬
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        // 우선순위큐 처리 시간 순으로 오름차순으로 정렬
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        int timeLog = 0;        // 시간 경과
        int indexOfJobs = 0;    // jobs 배열의 인덱스
        int count = 0;          // 수행 완료된 작업의 개수
        while (count < jobs.length) {
            // 작업이 완료된 시점까지 요청된 작업 큐에 삽입
            while (indexOfJobs < jobs.length && jobs[indexOfJobs][0] <= timeLog) {
                queue.add(jobs[indexOfJobs++]);
            }
            // 작업 완료 이후 요청이 들어옴, 현재 시간을 요청의 가장 처음으로 설정
            if (queue.isEmpty()) {
                timeLog = jobs[count][0];
            // 작업 완료 전 들어온 요청 중 가장 수행 시간이 짧은 요청부터 수행
            } else {
                int[] task = queue.poll();
                answer += task[1] + timeLog - task[0];
                timeLog += task[1];
                count++;
            }
        }

        return (int) Math.floor(answer / jobs.length);
    }
    public static void main(String[] args) {
        int[][] jobs = {{0, 3}, {1, 6}, {3, 4}, {5, 12}, {8, 2}};
        System.out.println(solution(jobs));
    }
}
