package CodingTest;

import java.util.Arrays;

/**
 * 1차원 Integer 배열이 주어 졌을때 배열의 숫자를 이어 붙혔을때 만들 수 있는 가장 큰 숫자를 출력 하는 프로그램을 작성 하세요. EX : {3,30,34,5,9} ->
 * return : 9534330
 */
public class AdvancedSortExam {

//  public static void main(String[] args) {
//    int [] array = {3,30,34,5,9};
//    System.out.println(solution(array));
//
//  }
//
//  public static int solution(int[] array) {
//
//    return 9534330;
//  }

  public static void main(String[] args) throws Exception {
    final Integer[] array = {3, 30, 34, 5, 9};
    System.out.println(solution(array));
  }


  public static int solution2(Integer[] array) {
    Arrays.sort(array, (Integer a, Integer b) -> {
      return Integer.parseInt(a + String.valueOf(b))
          < Integer.parseInt(b + String.valueOf(a)) ? 1 : -1;
    });

    StringBuilder stringBuilder = new StringBuilder();
    for (Integer n : array) {
      stringBuilder.append(n);
    }

    return Integer.parseInt(stringBuilder.toString());
  }



  public static int solution(Integer[] array) {
    int temp = 0;
    for (int i = 0; i < array.length; i++) {
      for (int j = i + 1; j < array.length; j++) {
        if (Integer.parseInt(array[i] + String.valueOf(array[j]))
            < Integer.parseInt(array[j] + String.valueOf(array[i]))) {
          temp = array[i];
          array[i] = array[j];
          array[j] = temp;
        }
      }
    }

    StringBuilder stringBuilder = new StringBuilder();
    for (int num : array) {
      stringBuilder.append(num);
    }
    return Integer.parseInt(stringBuilder.toString());

  }



}
