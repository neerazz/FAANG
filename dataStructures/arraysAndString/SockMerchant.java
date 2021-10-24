import java.util.HashMap;
import java.util.Map;

/*
Problem: https://www.hackerrank.com/challenges/sock-merchant/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup
Sample Input
9
10 20 20 10 10 30 50 10 20
Sample Output
3
 */
public class SockMerchant {
    public static void main(String[] args) {
        int stocks = 9;
        int[] colours = {10, 20, 20, 10, 10, 30, 50, 10, 20};
        System.out.println(sockMerchant(stocks, colours));
    }

    static int sockMerchant(int n, int[] ar) {
        int pairs = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int current = ar[i];
            if (map.containsKey(current)) {
                pairs++;
                map.remove(current);
            } else {
                map.put(current, 1);
            }
        }
        return pairs;
    }
}
