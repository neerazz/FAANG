package weekly.weekly203;

import java.util.TreeSet;

/**
 * Created on:  Aug 22, 2020
 * Questions: https://leetcode.com/problems/find-latest-group-of-size-m/
 */
public class FindLatestGroupOfSizeM {
    public static void main(String[] args) {

    }

    /*
     *   Do it from normal way, it will drop into merging inervals. But If we think it in another, we will get rid of merging invervals.
     *   From end to start, it looks like set bit to 0, starts with all bit set to 1. Set a bit to 0, split the interval to two interval
     *   We can easily discard interval with length less than m.
     *   Use TreeSet to improve the efficiency of finding the interval contains the bit that we will set to 0.
     * */
    public static int findLatestStep(int[] arr, int m) {
        if (m == arr.length) return arr.length;
//        Sort the tree set based on the group that starting indexes.
        TreeSet<int[]> set = new TreeSet<>((a, b) -> a[0] - b[0]);
//        Assume initially that all the bits are set.
        set.add(new int[]{1, arr.length});
        for (int i = arr.length - 1; i >= 0; i--) {
//            Get the group with current index or above as starting index.
            int[] cur = set.floor(new int[]{arr[i]});
//            If there are no any groups, or the group end index is less then the starting index. Then then ignore this index and continue.
            if (cur == null || cur[1] < arr[i]) continue;
//            Remove the group from the set and split into two, as we will convert the one from that group to zero.
            set.remove(cur);
            if (arr[i] - cur[0] == m || cur[1] - arr[i] == m) {
//                If the length from cur number to start or end of the group is same as expected then that will be result.
                return i;
            }
//            As we will convert the cur number index from 1 to zero. We split the group into two.
//              Validate and insert the sub-group into set only if the size is great than m. If smaller it cannot form any subgroup.
            if (arr[i] - cur[0] > m) set.add(new int[]{cur[0], arr[i] - 1});
            if (cur[1] - arr[i] > m) set.add(new int[]{arr[i] + 1, cur[1]});
        }
        return -1;
    }
}
