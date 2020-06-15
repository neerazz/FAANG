public class Toeplitz {

    static boolean isToeplitzCool(int[][] arr) {

        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[i].length; j++) {
                if (arr[i - 1][j - 1] != arr[i][j]) return false;
            }
        }
        return true;

    }

    static boolean isToeplitz(int[][] arr) {

        for (int i = 0; i < arr.length; i++) {
            if (isNotToeplitz(arr, 0, i)) return false;
        }

        for (int j = 0; j < arr[0].length; j++) {
            if (isNotToeplitz(arr, j, 0)) return false;
        }
        return true;
    }

    static boolean isNotToeplitz(int[][] arr, int i, int j) {
        int res = arr[i][j];
        while (i < arr.length && j < arr[i].length) {
            if (arr[i][j] != res) {
                return true;
            }
            i++;
            j++;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{3, 1, 7}, {4, 1, 1}, {2, 4, 3}};
        System.out.println(isToeplitz(arr));
    }

}
