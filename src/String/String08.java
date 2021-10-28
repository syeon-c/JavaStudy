package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class String08 {
    private static void Solution(String[] str) {
       boolean isPalindrome = true;
       int len = str.length;
       for(int i = 0; i < len/2; i++) {
           String str1 = str[i].toUpperCase().replaceAll("[^A-Z]", "");
           String str2 = str[len - i - 1].toUpperCase().replaceAll("[^A-Z]", "");
           str2 = new StringBuilder(str2).reverse().toString();

           if (!str2.equals(str1)) isPalindrome = false;
       }
       if (isPalindrome) System.out.println("YES");
       else System.out.println("NO");
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        Solution(input);
    }
}
