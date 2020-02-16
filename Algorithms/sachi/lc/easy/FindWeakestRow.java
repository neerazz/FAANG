import java.util.Arrays;

public class FindWeakestRow {


    public static void main(String[] args) {
        int[][] mat =
                {
                        {1, 1, 0, 0, 0},
                        {1, 1, 1, 1, 0},
                        {1, 0, 0, 0, 0},
                        {1, 1, 0, 0, 0},
                        {1, 1, 1, 1, 1}
                };
        Util.print(kWeakestRows(mat, 3));
    }

    static int[] countArray;

    public static int[] kWeakestRows(int[][] mat, int k) {

        countArray = new int[mat.length];
        int[] countArray1 = new int[mat.length];

        for (int i = 0; i < mat.length; i++) {
            int counter = 0;
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    counter++;
                } else {
                    break;
                }
            }
            countArray[i] = counter;
            countArray1[i] = counter;
        }
        Arrays.sort(countArray1);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = getIndex(countArray1[i]);
        }
        return res;

    }

    public static int getIndex(int elem) {
        for (int i = 0; i < countArray.length; i++) {
            if (elem == countArray[i]) {
                countArray[i] = -1;
                return i;
            }
        }
        return -1;
    }
}
