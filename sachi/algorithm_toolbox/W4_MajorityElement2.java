import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class W4_MajorityElement2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = scanner.nextInt();
        }
        System.out.println(majorityElement(input));
        scanner.close();
    }

    private static int majorityElement(int[] input) {
        int n = input.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int count = map.get(input[i]) == null ? 0 : map.get(input[i]);
            map.put(input[i], count + 1);
        }
        for (int val : map.values()) {
            if (val > n / 2)
                return 1;
        }
        return 0;
    }
}