import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
Sample:
Input 1:
5-8+7*4-8+9
Output: 200
Refer: Rough explanation excel.
 */
public class Week6MaximumValueOfArithmeticExpression {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        char[] toCharArray = input.toCharArray();
        List<Integer> values = new ArrayList<>();
        List<String> operation = new ArrayList<>();

        for (int i = 0; i < toCharArray.length; i++) {
            String current = String.valueOf(toCharArray[i]);
            if (i % 2 == 0) {
                values.add(Integer.parseInt(current));
            } else {
                operation.add(String.valueOf(current));
            }
        }
        System.out.println(getMaximumValueOfArithmeticExpression(values, operation));
    }

    private static int getMaximumValueOfArithmeticExpression(List<Integer> values, List<String> operation) {
        int size = values.size();
        MaxMinValue[][] maxMinValue = new MaxMinValue[size][size];
        for (int i = 0; i < size; i++) {
            Integer current = values.get(i);
            maxMinValue[i][i] = new MaxMinValue(current, current);
        }

//        int i = 1;
//        while (maxMinValue[0][size-1] == null){
//            for (int j = 1; j < size-i; j++) {
//                maxMinValue[i][j] = getMaxMinValues(maxMinValue,operation,i,j);
//                i++;
//            }
//        }

        for (int s = 0; s < size; s++) {
            for (int i = 0; i < size - s; i++) {
                int j = i + s + 1;
                if (j <= size - 1) {
                    maxMinValue[i][j] = getMaxMinValues(maxMinValue, operation, i, j);
                }
            }
        }

        return maxMinValue[0][size - 1].min;
    }

    private static MaxMinValue getMaxMinValues(MaxMinValue[][] maxMinValues, List<String> operation, int i, int j) {
        Integer min = Integer.MAX_VALUE;
        Integer max = Integer.MIN_VALUE;
        Integer currentMin;
        Integer currentMax;
        for (int k = i; k < j; k++) {

            MaxMinValue maxMinValue1 = maxMinValues[i][k];
            MaxMinValue maxMinValue2 = maxMinValues[k + 1][j];
            Integer a = performOperation(maxMinValue1.min, operation.get(k), maxMinValue2.min);
            Integer b = performOperation(maxMinValue1.max, operation.get(k), maxMinValue2.max);
            Integer c = performOperation(maxMinValue1.min, operation.get(k), maxMinValue2.max);
            Integer d = performOperation(maxMinValue1.max, operation.get(k), maxMinValue2.min);

            List<Integer> values = Arrays.asList(a, b, c, d);

            currentMin = Math.min(Math.min(a, b), Math.min(c, d));
            currentMax = Math.max(Math.max(a, b), Math.max(c, d));
            if (currentMin < min) min = currentMin;
            if (currentMax > max) max = currentMax;
        }
        return new MaxMinValue(min, max);
    }

    private static Integer performOperation(int a, String s, int b) {
        switch (s.trim()) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            default:
                return null;
        }
    }

    static class MaxMinValue {
        int max;
        int min;

        public MaxMinValue(int max, int min) {
            this.max = max;
            this.min = min;
        }
    }
}
