import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PascalTriangle2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        print(getRow(n));
        scanner.close();    
    }

    public static List<Integer> getRow(int rowIndex) {
        Integer[] sol = new Integer[rowIndex+1];
        Arrays.fill(sol, 0);
        sol[0] = 1;
        for(int i=1; i<=rowIndex; i++){
            for(int j=i; j>0; j--){
                sol[j] = sol[j]+ sol[j-1];
            }
        }
        return Arrays.asList(sol);
    }

    public static void print(List<Integer> list){
        System.out.println("");
        list.stream().forEach(num -> System.out.print(num + " "));
    }
}