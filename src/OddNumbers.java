import java.util.*;

public class OddNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> array = new ArrayList<>();
        int sum = 0;

        for(int i = 0; i < 7; i++) {
            int n = sc.nextInt();
            if(n % 2 == 1) {
                array.add(n);
                sum += n;
            }
        }

        sc.close();
        Collections.sort(array);

        if(array.isEmpty()) System.out.println(-1);
        else {
            System.out.println(sum);
            System.out.println(array.get(0));
        }
    }
}
