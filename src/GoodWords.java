import java.util.Scanner;

public class GoodWords {
    public static void main(String[] args) {
        String a = "AA";
        String b = "BB";
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        int answer = 0;

        for(int i = 0; i < n; i++) {
            String word = sc.nextLine();

            while (true) {
                if(!word.contains(a) && !word.contains(b)) break;
                if (word.contains(a)) {
                    word = word.replaceAll(a, "");
                }

                if (word.contains(b)) {
                    word = word.replaceAll(b, "");
                }
            }
            if(word.length() == 0) answer++;
        }

        System.out.println(answer);
    }
}
