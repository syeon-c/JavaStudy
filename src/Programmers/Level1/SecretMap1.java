package Programmers.Level1;

/**
 * 원래의 비밀지도를 해독하여 '#', 공백으로 구성된 문자열 배열로 출력
 * 1. 지도는 한 변의 길이가 n인 정사각형 배열 형태로, 각 칸은 "공백"(" ") 또는 "벽"("#") 두 종류로 이루어져 있다.
 *
 * 2. 전체 지도는 두 장의 지도를 겹쳐서 얻을 수 있다. 각각 "지도 1"과 "지도 2"라고 하자.
 *    지도 1 또는 지도 2 중 어느 하나라도 벽인 부분은 전체 지도에서도 벽이다.
 *    지도 1과 지도 2에서 모두 공백인 부분은 전체 지도에서도 공백이다.
 *
 * 3. "지도 1"과 "지도 2"는 각각 정수 배열로 암호화되어 있다.
 *
 * 4. 암호화된 배열은 지도의 각 가로줄에서 벽 부분을 1, 공백 부분을 0으로 부호화했을 때 얻어지는 이진수에 해당하는 값의 배열이다.
 */

public class SecretMap1 {
    public static void main(String[] args) {
        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};
        for(String s : solution(n, arr1, arr2)) {
            System.out.println(s);
        }
    }
    private static String combineMap(int n, String b1, String b2) {
        // n만큼의 자릿수 채우기
        String[] tmp1 = new String[n];
        String[] tmp2 = new String[n];
        for(int i = n; i > 0; i--) {
            if (i > b1.length()) tmp1[n - i] = "0";
            else tmp1[n - i] = Character.toString(b1.charAt(b1.length()-i));
            if (i > b2.length()) tmp2[n - i] = "0";
            else tmp2[n - i] = Character.toString(b2.charAt(b2.length()-i));
        }
        String result = "";
        for(int i = 0; i < n; i++) {
            if (tmp1[i].equals("0") && tmp2[i].equals("0")) {
                result += " ";
            } else result += "#";
        }
        return result;
    }

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for(int i = 0; i < n; i++) {
            String binary1 = Integer.toBinaryString(arr1[i]);
            String binary2 = Integer.toBinaryString(arr2[i]);
            answer[i] = combineMap(n, binary1, binary2);
        }

        return answer;
    }
}
