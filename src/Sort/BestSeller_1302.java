package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BestSeller_1302 {
    public static void main(String[] args) throws IOException {
        String bestSeller = "";
        Map<String, Integer> sales = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            String book = br.readLine();
            if(sales.containsKey(book)) {
                sales.put(book, sales.get(book) + 1);
            } else {
                sales.put(book, 1);
            }
        }

        br.close();

        int max = 0;
        for(String key: sales.keySet()) {
            int value = sales.get(key);

            if(max == value && bestSeller.compareTo(key) > 0) {
                bestSeller = key;
                max = value;
            } else if(max < value) {
                bestSeller = key;
                max = value;
            }
        }
        System.out.println(bestSeller);
    }
}
