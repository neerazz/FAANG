import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

/*
Problem Introduction
As the last question of a successful interview, your boss gives you a few pieces of paper
with numbers on it and asks you to compose a largest number from these numbers. The
resulting number is going to be your salary, so you are very much interested in maximizing
this number. How can you do this?
For example, for
an input consisting of two integers 23 and 3 (23 is not a single-digit number!) it returns 233, while the largest
number is in fact 323. In other words, using the largest number from the input as the first number is not a
safe move.
Your goal in this problem is to tweak the above algorithm so that it works not only for single-digit
numbers, but for arbitrary positive integers.

Input Format. The first line of the input contains an integer 𝑛. The second line contains integers
𝑎1, 𝑎2, . . . , 𝑎𝑛.
Constraints. 1 ≤ 𝑛 ≤ 100; 1 ≤ 𝑎𝑖 ≤ 103
for all 1 ≤ 𝑖 ≤ 𝑛.
Output Format. Output the largest number that can be composed out of 𝑎1, 𝑎2, . . . , 𝑎𝑛.
Sample 1.
Input: (2 21 2)
2
21 2
Output:
221 (Note that in this case the above algorithm also returns an incorrect answer 212).
Sample 2.
Input: (5 9 4 6 1 9)
5
9 4 6 1 9
Output:
99641
In this case, the input consists of single-digit numbers only, so the algorithm above computes the right
answer.
Sample 3.
Input: (3 23 39 92)
3
23 39 92
Output:
923923
As a coincidence, for this input the above algorithm produces the right result, though the input does
not have any single-digit numbers.
 */
public class Week3MaximumSalary {

    public static void main(String[] args) {
        int numberOfNumbers = FastScan.nextInt();

        List<Integer> listOfNumbers = new ArrayList<>();
        for (int i = 0; i < numberOfNumbers; i++) {
            String input = FastScan.next();
            char[] toCharArray = input.toCharArray();
            for (char c : toCharArray) {
                listOfNumbers.add(Integer.parseInt(String.valueOf(c)));
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        listOfNumbers.stream().sorted(Comparator.reverseOrder()).forEach(stringBuilder::append);
        System.out.println(stringBuilder.toString());
    }

    static class FastScan {
        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        static StringTokenizer st;

        static String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        static int nextInt() {
            return Integer.parseInt(next());
        }

        static long nextLong() {
            return Long.parseLong(next());
        }
    }
}
