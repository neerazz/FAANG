import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PascalTraingle2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        getRow(n).stream().forEach(e -> System.out.print(e + " "));
        scanner.close();
    }

    private static List<Integer> getRow(int rowIndex) {
        if (rowIndex < 1)
            return new ArrayList<>();
        Integer[] sol = new Integer[rowIndex + 1];
        Arrays.fill(sol, 0);
        sol[0] = 1;
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i; j > 0; j--) {
                sol[j] = sol[j - 1] + sol[j];
            }
        }
        return Arrays.asList(sol);
    }
}