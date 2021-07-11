package CodingTest;

/**
 * 1차원 Integer 배열이 주어 졌을때
 * 배열의 숫자를 이어 붙혔을때 만들 수 있는 가장 큰 숫자를 출력 하는 프로그램을 작성 하세요.
 * EX : {3,30,34,5,9} -> return : 9534330
 *
 */
public class SortExam {

    public static void main(String[] args) {
        int [] array = {3,30,34,5,9};

        solution(array);

        for (int n : array) {
            System.out.print(n);
        }

    }

    public static void solution(int[] array) {
        for(int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (compareNum(array[j], array[j + 1]) == array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    public static int compareNum(int a, int b) {
        int tmp1 = Integer.parseInt(Integer.toString(a) + Integer.toString(b));
        int tmp2 = Integer.parseInt(Integer.toString(b) + Integer.toString(a));

        if (tmp1 > tmp2) {
            return a;
        } else {
            return b;
        }
    }

    public static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}

