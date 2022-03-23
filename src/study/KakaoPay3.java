package study;

import java.util.HashMap;
import java.util.Map;

/**
 * Two Pointers, Sliding Window 을 이용한 풀이
 * 중복된 값을 제거하기 위해 해당 포지션을 Map Key 로 구성함
 */
public class KakaoPay3 {

  public static void main(String[] args) {
//    String str = "abbbcbbb";
//    String tranStr = "bbb";

    String str = "abcabcabc";
    String tranStr = "abc";

    System.out.println(solution(str, tranStr));
  }

  public static int solution(String str, String tranStr) {
    Map<String, String> result = new HashMap<>();
    int tranCount = 0;
    String original = tranStr;

    while (str.length() >= tranStr.length()) {
      String[] array1 = str.split("");
      String[] array2 = tranStr.split("");

      for (int index = 0; str.length() >= index + tranStr.length(); index++) {
        int p1 = index;
        int p2 = 0;

        while (array1.length > p1) {
          if (array1[p1].equals(array2[p2]) || array2[p2].equals("_")) {
            p1++;
            p2++;
            if (p2 == array2.length) {
              p2 = 0;
              result.put(makeKey(p1, tranStr), tranStr);
            }

          } else {
            p1++;
            p2 = 0;
          }
        }
      }
      tranStr = makeTransString(original, ++tranCount);
    }
    System.out.println(result);
    return result.size();
  }

  public static String makeTransString(String original, int tranCount) {
    String[] split = original.split("");
    String returnStr = split[0];
    for (int i = 1; i < split.length; i++) {
      for (int j = 0; j < tranCount; j++) {
        returnStr += "_";
      }
      returnStr += split[i];
    }
    return returnStr;
  }

  public static String makeKey(int p1, String transStr) {
    String key = String.valueOf(--p1);
    for (int i = transStr.length() -2; i >= 0; i--) {
      if (transStr.charAt(i) != '_') {
        key += "," + String.valueOf(--p1);
      } else {
        --p1;
      }
    }
    return key;
  }


}
