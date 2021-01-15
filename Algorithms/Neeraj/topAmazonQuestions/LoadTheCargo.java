import java.util.*;
import java.io.*;

/**
 * Created on:  Jan 14, 2021
 * Questions: https://aonecode.com/aplusplus/interviewctrl/getInterview/118748234179
 */

public class LoadTheCargo {

    public static void main(String[] args) {
//        System.out.println(loadTheCargo(3, new int[]{1, 2, 3}, 3, new int[]{3, 2, 1}, 3) + " = 7");
        System.out.println(loadTheCargo(3, new int[]{3, 1, 2}, 3, new int[]{1,2,3}, 4) + " = 9");
    }

    public static int loadTheCargo(int num, int[] containers, int itemSize, int[] itemsPerContainer, long cargoSize) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((c1, c2) -> Integer.compare(c2[1], c1[1]));
//        0: counts, 1: items
        for (int i = 0; i < num; i++) {
            pq.add(new int[]{containers[i], itemsPerContainer[i]});
        }
        long totalItems = 0, totalCargos = 0;
        while (totalCargos < cargoSize && !pq.isEmpty()) {
            int[] poll = pq.poll();
            if (totalCargos + poll[0] <= cargoSize) {
//                Then take all the items
                totalItems += poll[0] * poll[1];
                totalCargos += poll[0];
            } else {
                long canLoad = cargoSize - totalCargos;
                totalItems += canLoad * poll[1];
                totalCargos += canLoad;
            }
        }
        return (int) totalItems;
    }
}
