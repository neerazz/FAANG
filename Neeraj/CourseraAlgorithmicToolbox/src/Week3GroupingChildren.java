import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
Given the below 2 Inputs
Number of children's and
the array of children's age in sorted order,

Find the minimum number of groups that can be formed. Where each group can have children's only with age difference of one.

Sample input 1:
7
2.5 3.2 3.5 4.0 4.8 5.2 6.0
Output 1:
3

Sample input 2:
3
2.1 4.5 6.7
Output 2:
3

 */

public class Week3GroupingChildren {

    public static void main(String[] args) {
        int numberOfChildrens = FastScan.nextInt();
        Double[] childrensAges = new Double[numberOfChildrens];
        for (int i = 0; i < numberOfChildrens; i++) {
            childrensAges[i] = FastScan.nextDouble();
        }
        System.out.println(numberOfGroups(numberOfChildrens, childrensAges));
    }

    private static int numberOfGroups(int numberOfChildrens, Double[] childrensAges) {
        int numberOFGroups = 0;
        Double groupStartingAtAge = 0.0;
        for (int i = 0; i < numberOfChildrens; i++) {

//            This is the start of the loop.
            if (groupStartingAtAge == 0 && numberOFGroups == 0) {
                groupStartingAtAge = childrensAges[i];
                numberOFGroups++;
            }

//            All other occurrence's
            else {

//                If the age of current kid is more that one year from the minimum age of the current group. Then create a new group.
                if (childrensAges[i] - groupStartingAtAge > 1) {
                    groupStartingAtAge = childrensAges[i];
                    numberOFGroups++;
                }
            }
        }
        return numberOFGroups;
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

        static double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}
