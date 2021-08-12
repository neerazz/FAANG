import java.util.ArrayList;
import java.util.List;

/**
 * Created on:  Aug 11, 2021
 * Ref : https://leetcode.com/problems/my-calendar-i/
 */
public class MyCalendarI {
    public static void main(String[] args) {

    }
    static class MyCalendar {
        List<int[]> list = new ArrayList<>();

        public boolean book(int start, int end) {
            int i=0, len = list.size();
            while(i < len && list.get(i)[1] < start) i++;
//         Check for overlap
            while(i < len && list.get(i)[0] < end){
                int[] cur = list.get(i);
                int v1 = Math.max(cur[0], start), v2 = Math.min(cur[1], end);
                if(v1 < v2) return false;
                i++;
            }
//         Add at the index.
            list.add(i, new int[]{start, end});
            return true;
        }
    }
}
