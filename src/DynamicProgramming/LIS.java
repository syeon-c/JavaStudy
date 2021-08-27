package DynamicProgramming;

/**
 * N개의 자연수로 이루어진 수열이 주어졌을 때, 그 중에서 가장 길게 증가하는(작은 수에서 큰 수로) 원소들의 집합을 찾는 프로그램을 작성하라.
 * 예를 들어, 원소가 2, 7, 5, 8, 6, 4, 7, 12, 3 이면 가장 길게 증가하도록 원소들을 차례대로 뽑아내면 2, 5, 6, 7, 12를 뽑아내어 길이가 5인 최대 부분 증가수열을 만들 수 있다.
 */

public class LIS {
    public static void main(String[] args) {
        int n = 8;
        int[] array = {5, 3, 7, 8, 6, 2, 9, 4};
        System.out.println(solution(n, array));

    }

    public static int solution(int n, int[] arr) {
        int answer = 0;
        int[] dy = new int[n+1];

        // 1번째 원소를 마지막 항으로 하는 최대 부분 증가수열
        dy[0] = 1;

        for(int i=1; i<arr.length; i++){
            int max=0;
            // i 앞의 원소들 탐색
            for(int j=i-1; j>=0; j--){
                // j번째 원소가 i번째 원소 보다 작고, j번째 원소가 최댓값보다 클 때 최댓값 변경
                if(arr[j] < arr[i] && dy[j] > max) max=dy[j];
            }
            // i번째 원소 하나
            dy[i]=max+1;
            // 최댓값 answer에 입력
            answer=Math.max(answer, dy[i]);
        }
        return answer;
    }
}
