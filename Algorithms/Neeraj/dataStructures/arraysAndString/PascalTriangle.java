import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PascalTriangle {
    public static void main(String[] args) {
        System.out.println(generate(5));
        System.out.println(getRow(5));
    }

    public static List<Integer> getRow_elegent(int rowIndex) {
        if (rowIndex < 0)
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

    public static List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0){
            return Collections.singletonList(1);
        }
        if (rowIndex == 1){
            return Arrays.asList(1,1);
        }
        List<Integer> integers = getRow(rowIndex - 1);
        List<Integer> newList = new ArrayList<>();
        newList.add(1);
        for (int i = 0; i < integers.size()-1; i++) {
            newList.add(integers.get(i) + integers.get(i+1));
        }
        newList.add(1);
        return newList;
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows >= 1) {
            result.add(Collections.singletonList(1));
        }
        if (numRows >= 2) {
            result.add(Arrays.asList(1, 1));
        }
        if (numRows >= 3) {
            for (int i = 2; i < numRows; i++) {
                List<Integer> current = new ArrayList<>();
                List<Integer> previous = result.get(i - 1);
                current.add(1);
                for (int j = 0; j < previous.size() - 1; j++) {
                    current.add(previous.get(j) + previous.get(j + 1));
                }
                current.add(1);
                result.add(current);
            }
        }
        return result;
    }
}
