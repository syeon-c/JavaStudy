package Programmers.Level1;

/**
 * 순서대로 누를 번호가 담긴 배열 numbers, 왼손잡이인지 오른손잡이인 지를 나타내는 문자열 hand가 매개변수로 주어질 때
 * 각 번호를 누른 엄지손가락이 왼손인 지 오른손인 지를 나타내는 연속된 문자열 형태로 return
 * 처음 왼손 엄지손가락은 *, 키패드에 오른손 엄지손가락은 # 키패드 위치에서 시작
 * rule1 : 엄지손가락은 상하좌우 4가지 방향으로만 이동 가능하고, 키패드 이동 한 칸은 거리로 1에 해당
 *
 * rule2 : 왼쪽 열의 3개의 숫자 1, 4, 7을 입력할 때는 왼손 엄지손가락을 사용
 *
 * rule3 : 오른쪽 열의 3개의 숫자 3, 6, 9를 입력할 때는 오른손 엄지손가락을 사용
 *
 * rule4 : 가운데 열의 4개의 숫자 2, 5, 8, 0을 입력할 때는 두 엄지손가락의 현재 키패드의 위치에서 더 가까운 엄지손가락을 사용
 *         만약 두 엄지손가락의 거리가 같다면, 오른손잡이는 오른손 엄지손가락, 왼손잡이는 왼손 엄지손가락을 사용
 */

public class Keypad {
    //0-9
    static int[][] keypad = {{3, 1}, {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}};

    public static void main(String[] args) {
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";
        System.out.println(solution(numbers, hand));
    }
    public static String solution(int[] numbers, String hand) {
        // 처음 위치
        int[] lnow = {3, 0};
        int[] rnow = {3, 2};
        String answer = "";

        for(int num : numbers) {
            if(num == 1 || num == 4 || num == 7) {
                answer += 'L';
                lnow = keypad[num];

            } else if(num == 3 || num == 6 || num == 9) {
                answer += 'R';
                rnow = keypad[num];
            } else {
                if(getDistance(lnow, num) < getDistance(rnow, num)) {
                    answer += 'L';
                    lnow = keypad[num];

                } else if (getDistance(lnow, num) > getDistance(rnow, num)) {
                    answer += 'R';
                    rnow = keypad[num];

                } else {
                    if(hand.equals("right")) {
                        answer += 'R';
                        rnow = keypad[num];
                    } else {
                        answer += 'L';
                        lnow = keypad[num];
                    }
                }
            }
        }
        return answer;
    }
    public static int getDistance(int[] now, int target) {
        int[] targetP = keypad[target];
        return (Math.abs(now[0] - targetP[0])) + (Math.abs(now[1] - targetP[1]));
    }
}
