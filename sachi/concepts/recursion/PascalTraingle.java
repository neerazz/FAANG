import java.util.Scanner;

import com.sun.javafx.print.PrintHelper.PrintAccessor;

import java.util.List;
import java.util.ArrayList;

public class PascalTraingle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        print(pascalIteration(n));
        print(pascalRecursion(n));
        scanner.close();
    }

    /**
     * Pascal Traingle - Iteration
     * @param n
     * @return
     */
    private static List<List<Integer>> pascalIteration(int n) {
        List<List<Integer>> sol = new ArrayList();
        List<Integer> prev;
        List<Integer> row;
        for (int i = 0; i < n; i++) {
            row = new ArrayList<Integer>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    prev = sol.get(i - 1);
                    row.add(prev.get(j - 1) + prev.get(j));
                }
            }
            sol.add(row);
        }
        return sol;
    }

    public static List<List<Integer>> pascalRecursion(int numRows) {
        List<List<Integer>> sol = new ArrayList();
        for(int i=0; i<numRows; i++){
            List<Integer> row = new ArrayList<>();
            for(int j=0; j<=i; j++){
                row.add(calculate(i,j));
            }
            sol.add(row);
        }
        return sol;
    }
    
    public static int calculate(int i, int j){
        if(i==0 || j==0 || j==i){
            return 1;
        }else{
            return calculate(i-1,j-1) + calculate(i-1,j);
        }
    }

    private static void print(List<List<Integer>> list) {
        System.out.print("\n");
        list.stream().forEach(r -> {
            r.stream().forEach(c -> System.out.print(c));
            System.out.print("\n");
        });
    }
}