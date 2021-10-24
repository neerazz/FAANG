import java.util.Scanner;
import java.util.Stack;

/*
Task. Implement a stack supporting the operations Push(), Pop(), and Max().
Input Format. The first line of the input contains the number 𝑞 of queries. Each of the following 𝑞 lines
specifies a query of one of the following formats: push v, pop, or max.
Constraints. 1 ≤ 𝑞 ≤ 400 000, 0 ≤ 𝑣 ≤ 105.
Output Format. For each max query, output (on a separate line) the maximum value of the stack

Solution: Implement PriorityQueue.
 */
public class W1ExtendingStackInterface {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int queries = Integer.parseInt(scanner.next());

        ExtendedStack extendedStack = new ExtendedStack();

        while (scanner.hasNext()) {
            String input = scanner.next();
            if (input.startsWith("push")) {
//                int value = Integer.parseInt(input.replace("push ",""));
                int value = Integer.parseInt(scanner.next());
                extendedStack.push(value);
            } else if (input.startsWith("pop")) {
                extendedStack.pop();
            } else if (input.startsWith("max")) {
                System.out.println(extendedStack.peek());
            }
        }
    }

    static class ExtendedStack extends Stack<Integer> {

        @Override
        public Integer push(Integer item) {

            int prev = Integer.MIN_VALUE;
            for (int i = elementData.length - 1; i >= 0; i--) {
                if (item > (int) elementData[i]) {
                    prev = (int) elementData[i];
                    elementData[i] = item;
                }
                if (prev != Integer.MIN_VALUE) {
                    int temp = (int) elementData[i];
                    elementData[i] = prev;
                    prev = temp;
                }
            }
            return super.push(prev);
        }
    }
}
