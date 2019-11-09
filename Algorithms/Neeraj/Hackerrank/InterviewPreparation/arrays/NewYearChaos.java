package InterviewPreparation.arrays;

public class NewYearChaos {
    public static void main(String[] args) {
        minimumBribes(new int[]{2, 4, 1, 3, 6, 7, 5, 8});
        System.out.println("\tShould be : 5");
        minimumBribes(new int[]{2, 1, 5, 3, 4});
        System.out.println("\tShould be : 3");
        minimumBribes(new int[]{5, 1, 2, 3, 7, 8, 6, 4});
        System.out.println("\tShould be : Too chaotic");
        minimumBribes(new int[]{1, 2, 5, 3, 7, 8, 6, 4});
        System.out.println("\tShould be : 7");

        System.out.println("*************** Shorter Version ***************");
        minimumBribes_simple(new int[]{2, 4, 1, 3, 6, 7, 5, 8});
        System.out.println("\tShould be : 5");
        minimumBribes_simple(new int[]{2, 1, 5, 3, 4});
        System.out.println("\tShould be : 3");
        minimumBribes_simple(new int[]{5, 1, 2, 3, 7, 8, 6, 4});
        System.out.println("\tShould be : Too chaotic");
        minimumBribes_simple(new int[]{1, 2, 5, 3, 7, 8, 6, 4});
        System.out.println("\tShould be : 7");
    }

    static void minimumBribes_simple(int[] q) {
        int totalBribes = 0;
        int expectedFirst = 1;
        int expectedSecond = 2;
        int expectedThird = 3;

        for (int i = 0; i < q.length; ++i) {
            if (q[i] == expectedFirst) {
                expectedFirst = expectedSecond;
                expectedSecond = expectedThird;
                ++expectedThird;
            } else if (q[i] == expectedSecond) {
                ++totalBribes;
                expectedSecond = expectedThird;
                ++expectedThird;
            } else if (q[i] == expectedThird) {
                totalBribes += 2;
                ++expectedThird;
            } else {
                System.out.println("Too chaotic");
                return;
            }
        }
        System.out.println(totalBribes);
    }

    static void minimumBribes(int[] q) {
        int swaps = 0;
        int min = q.length;
        for (int i = q.length - 1; i >= 0; i--) {
            if (q[i] - i > 3) {
                System.out.println("Too chaotic");
                return;
            }
            if (q[i] > i + 1) {
                swaps += (q[i] - (i + 1));
            } else {
                if (min > q[i]) {
                    min = q[i];
                } else if (q[i] != min) {
                    swaps++;
                }
            }
        }
        System.out.println(swaps);
    }
}
