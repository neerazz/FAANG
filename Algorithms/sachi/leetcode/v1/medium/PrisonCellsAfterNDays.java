package leetcode.v1.medium;

import java.util.Arrays;

public class PrisonCellsAfterNDays {

    public static void main(String[] args) {
        PrisonCellsAfterNDays prisonCellsAfterNDays = new PrisonCellsAfterNDays();
        System.out.println(Arrays.toString(prisonCellsAfterNDays.prisonAfterNDays(new int[]{0, 1, 0, 1, 1, 0, 0, 1}, 7)));
    }

    public int[] prisonAfterNDays(int[] cells, int N) {
        for (int i = 0; i < N; i++) {
            int prev = 0;
            for (int j = 0; j < cells.length; j++) {
                if (j == 0 || j == cells.length - 1) {
                    cells[j] = 0;
                } else {
                    int temp = prev ^ cells[j + 1];
                    temp = 1 - temp;
                    prev = cells[j];
                    cells[j] = temp;
                }
            }
        }
        return cells;
    }

}
