import java.util.Scanner;

/*
Problem: (https://www.udemy.com/learn-data-structure-algorithms-with-java-interview/learn/lecture/13729300#overview)
We need to select the maximum number of activities that can be performed by a single person.
Assuming that a person can only work on a single activity at a time.

Sample:
Input:
6
0 6
3 4
1 2
5 8
5 7
8 9
Output:4
 */
class ActivitySelection{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberActivities = Integer.parseInt(scanner.next());
        int[] left = new int[numberActivities];
        int[] right = new int[numberActivities];

        for (int i = 0; i < numberActivities; i++) {
            left[i] = Integer.parseInt(scanner.next());
            right[i] = Integer.parseInt(scanner.next());
        }

        performQuickSort(left, right, numberActivities);
        System.out.println(findTotalNumberOfActivities(left,right));
    }

    private static int findTotalNumberOfActivities(int[] left, int[] right) {
        int result = 1;
        int lastSuccessfulRight = right[0];
        for (int i = 0; i < left.length-1; i++) {
            if (lastSuccessfulRight <= left[i+1]) {
                result++;
                lastSuccessfulRight = right[i];
            }
        }
        return result;
    }

    private static void performQuickSort(int[] left, int[] right, int numberActivities) {
        if (numberActivities<2) return;
        int mid = numberActivities/2;
        int pivotal = partition(left,right,0,numberActivities);
        performQuickSort(left, right, mid);
        performQuickSort(left, right, numberActivities - mid);
    }

    private static int partition(int[] left, int[] right, int leftCount, int rightCount) {
        int pivotalValue = right[leftCount];
        int pivotal = leftCount;
        for (int i = leftCount+1 ; i < rightCount; i++) {
            if (right[i] < pivotalValue){
                pivotal++;
                int t = right[i];
                right[i] = right[pivotal];
                right[pivotal] = t;
                int t1 = left[i];
                left[i] = left[pivotal];
                left[pivotal] = t1;
            }
        }
        int t = right[leftCount];
        right[leftCount] = right[pivotal];
        right[pivotal] = t;
        int t1 = left[leftCount];
        left[leftCount] = left[pivotal];
        left[pivotal] = t1;
        return pivotal;
    }
}