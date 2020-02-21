import java.util.*;

/*
https://towardsdatascience.com/course-1-algorithmic-toolbox-part-4-dynamic-programming-223ffc01984a

Solution:
Loop from 1 to the number:
     if the number is divided by 3 then get the n/3 values and add 1.
else if the number is divided by 2 then get the n/2 value and add 1.
else get the n-1 values and add 1.

Loop from n to 0 to get the values.

 */
public class Week5PrimitiveCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputNumber = Integer.parseInt(scanner.next());
        List<Integer> integerList = greedyAlgorithm(inputNumber);
        int size = integerList.size() - 1;
        System.out.println(size);

        for (int i = size; i >= 0; i--) {
            System.out.print(integerList.get(i) + " ");
        }
    }

    private static List<Integer> greedyAlgorithm(int n) {
        List<Integer> sequence = new ArrayList<Integer>();
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        int i = 1;
        while (i <= n) {
            int valueDivide3 = i % 3 == 0 ? map.get(i / 3) : n;
            int valueDivide2 = i % 2 == 0 ? map.get(i / 2) : n;
            int valueMinusOne = map.get(i - 1);
            int value;
            if (valueDivide3 <= valueDivide2 && valueDivide3 <= valueMinusOne) {
                value = i / 3;
            } else if (valueDivide2 <= valueDivide3 && valueDivide2 <= valueMinusOne) {
                value = i / 2;
            } else {
                value = i - 1;
            }
            int min = map.get(value) + 1;
            map.put(i, min);
            i++;
        }

        while (n > 0) {
            int valueDivide3 = n % 3 == 0 ? map.get(n / 3) : n;
            int valueDivide2 = n % 2 == 0 ? map.get(n / 2) : n;
            int valueMinusOne = map.get(n - 1);
            int value;
            if (valueDivide3 <= valueDivide2 && valueDivide3 <= valueMinusOne) {
                value = n / 3;
            } else if (valueDivide2 <= valueDivide3 && valueDivide2 <= valueMinusOne) {
                value = n / 2;
            } else {
                value = n - 1;
            }
            sequence.add(n);
            n = value;
        }
//        Collections.reverse(sequence);
        return sequence;
    }
}
