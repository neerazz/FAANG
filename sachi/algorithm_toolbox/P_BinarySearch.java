import java.util.Scanner;

public class P_BinarySearch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int p = scanner.nextInt();
        System.out.println(linearSearch(a, p));
        System.out.println(binarySearch(a, 0, n - 1, p));
        System.out.println(binarySearchIterative(a, p));
        scanner.close();
    }

    private static int linearSearch(int[] a, int p) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == p)
                return i;
        }
        return -1;
    }

    /**
     * Recursive Iterative approach
     *
     * @param a - Array
     * @param l - left
     * @param r - right
     * @param p - to find
     * @return -1 when not found, index when found
     */
    private static int binarySearch(int[] a, int l, int r, int p) {
        if (r >= l) {
            int m = (l + r) / 2;
            if (p == a[m]) {
                return m;
            } else if (p < a[m]) {
                return binarySearch(a, l, m - 1, p);
            } else if (p > a[m]) {
                return binarySearch(a, m + 1, r, p);
            }
        }
        return -1;
    }

    private static int binarySearchIterative(int[] a, int x) {
        int l = 0, r = a.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (x == a[m])
                return m;
            else if (x > a[m]) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return -1;
    }

}