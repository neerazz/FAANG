package biweekly.biweekly51;

import java.util.*;

/**
 * Created on:  May 01, 2021
 * Questions: https://leetcode.com/contest/biweekly-contest-51/problems/closest-room/
 */

public class ClosestRoom {

    public static void main(String[] args) {

    }

    public static int[] closestRoom(int[][] rooms, int[][] queries) {
        Arrays.sort(rooms, (r1, r2) -> r1[1] == r2[1] ? Integer.compare(r1[0], r2[0]) : Integer.compare(r1[1], r2[1]));
        int len = queries.length, i = 0;
        int[] result = new int[len];
        for (int[] query : queries) {
            int idx = getIdx(rooms, query[1]);
            int roomId = getRoomById(rooms, idx, query[0]);
            result[i++] = roomId;
        }
        return result;
    }

    private static int getRoomById(int[][] rooms, int startIdx, int preferred) {
        if (startIdx == -1) return -1;
        int closetDist = Integer.MAX_VALUE, closestId = -1;
        for (int i = startIdx; i < rooms.length; i++) {
            int curId = rooms[i][0];
            int diff = Math.abs(preferred - curId);
            if (diff == 0) return curId;
            if (diff == closetDist) closestId = Math.min(closestId, curId);
            if (diff < closetDist) {
                closetDist = diff;
                closestId = curId;
            }
        }
        return closestId;
    }

    private static int getIdx(int[][] rooms, int target) {
//        Return index of room that has target greater or equal to target.
        int start = 0, end = rooms.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (rooms[mid][1] >= target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return rooms[start][1] < target ? -1 : start;
    }
}
