import java.util.*;

/**
 * Created on:  Aug 11, 2021
 * Ref : https://leetcode.com/problems/design-excel-sum-formula/
 */
public class DesignExcelSumFormula {
    public static void main(String[] args) {
        Excel excel = new Excel(3, 'C');
        excel.set(1, 'A', 2);
        System.out.println(excel.sum(3, 'C', new String[]{"A1", "A1:B2"})); // return 4
        excel.set(2, 'B', 2);
        System.out.println(excel.get(3, 'C')); // return 6
        excel = new Excel(5, 'E');
        System.out.println(excel.get(1, 'A')); // return 0
        excel.set(1, 'A', 1);
        System.out.println(excel.get(1, 'A')); // return 1
        System.out.println(excel.sum(2, 'B', new String[]{"A1", "A1"})); // return 2
        excel.set(1, 'A', 2);
        System.out.println(excel.get(2, 'B')); // return 4
    }

//    https://leetcode.com/problems/design-excel-sum-formula/discuss/1363834/Java-two-matrices-solution%3A-98-faster-and-90-less-memory
    static class Excel {
        int[][] matrix;
        List<String>[][] labelsMatrix;

        public Excel(int height, char width) {
            matrix = new int[26][26];
            labelsMatrix = new List[26][26];
        }

        public void set(int row, char column, int val) {
            matrix[row - 1][column - 'A'] = val;
            labelsMatrix[row - 1][column - 'A'] = null;
        }

        public int get(int row, char column) {
            int val = matrix[row - 1][column - 'A'];
            List<String> labels = labelsMatrix[row - 1][column - 'A'];

            if (labels != null) {
                return calculateListSum(labels);
            }

            return val;
        }

        public int sum(int row, char column, String[] numbers) {
            labelsMatrix[row - 1][column - 'A'] = Arrays.asList(numbers);
            matrix[row - 1][column - 'A'] = 0;

            return calculateListSum(labelsMatrix[row - 1][column - 'A']);
        }

        public int calculateListSum(List<String> labels) {
            int sum = 0;

            for (String label : labels) {
                sum += label.length() >= 5 ? calculateRangeSum(label) : calculateVal(label);
            }

            return sum;
        }

        public int calculateRangeSum(String str) {
            String[] numbers = str.split(":");
            int rowFrom = getLabelRowIdx(numbers[0]);
            int rowTo = getLabelRowIdx(numbers[1]);
            int colFrom = numbers[0].charAt(0) - 'A';
            int colTo = numbers[1].charAt(0) - 'A';
            int sum = 0;

            for (int i = rowFrom; i <= rowTo; i++) {
                for (int j = colFrom; j <= colTo; j++) {
                    int val = matrix[i][j];
                    List<String> labels = labelsMatrix[i][j];
                    if (labels != null) {
                        sum += calculateListSum(labels);
                    } else {
                        sum += val;
                    }
                }
            }

            return sum;
        }

        public int calculateVal(String str) {
            int row = str.charAt(1) - '1';
            int col = str.charAt(0) - 'A';

            if (labelsMatrix[row][col] != null) {
                return calculateListSum(labelsMatrix[row][col]);
            }
            return matrix[row][col];
        }

        public int getLabelRowIdx(String label) {
            // Label has two characters, e.g., "B2"
            if (label.length() == 2) {
                return label.charAt(1) - '1';
            }

            // Label has three characters, e.g., "C12"
            return (label.charAt(1) - '0') * 10 + (label.charAt(2) - '0') - 1;
        }
    }
}
