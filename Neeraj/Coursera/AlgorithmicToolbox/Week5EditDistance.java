import java.util.Scanner;

/*
https://towardsdatascience.com/course-1-algorithmic-toolbox-part-4-dynamic-programming-223ffc01984a

Sample 1.
Input:
ab
ab
Output:
0
Sample 2.
Input:
short
ports
Output:
3
Sample 3.
Input:
editing
distance
Output:
5
An alignment of total cost 5:
 */
public class Week5EditDistance {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String fromWord = scanner.next();
        String toWord = scanner.next();

        System.out.println(getEditDistance(fromWord, toWord));
    }

    private static int getEditDistance(String fromWord, String toWord) {
        char[] fromChars = fromWord.toCharArray();
        char[] toChars = toWord.toCharArray();

        int[][] costs = new int[toChars.length + 1][fromChars.length + 1];

        for (int i = 1; i <= toChars.length; i++) costs[i][0] = i;
        for (int i = 1; i <= fromChars.length; i++) costs[0][i] = i;

        for (int i = 1; i <= toChars.length; i++) {
            for (int j = 1; j <= fromChars.length; j++) {
                if (toChars[i - 1] == fromChars[j - 1]) {
                    costs[i][j] = costs[i - 1][j - 1];
                } else {
                    costs[i][j] = minimumValue(costs[i - 1][j], costs[i][j - 1], costs[i - 1][j - 1]) + 1;
                }
//                System.out.println("T["+i+"]["+j+"] =" + costs[i][j]);
            }
        }
        return costs[toChars.length][fromChars.length];
    }

    private static int minimumValue(int a, int b, int c) {
        if (a <= b && a <= c) return a;
        else if (b <= a && b <= c) return b;
        else return c;
    }
}
