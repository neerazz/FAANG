import java.util.*;

class CountTriplets {
    public static void main(String[] args) {
        System.out.println("*****************************************************************");
        System.out.println(countTriplets(getLongList(Arrays.asList(1, 3, 9, 9, 27, 81)), 3) + " should be [6]");
        System.out.println(countTriplets(getLongList(Arrays.asList(1, 3, 3, 9, 9, 27, 81)), 3) + " should be [10]");
        System.out.println(countTriplets(getLongList(Arrays.asList(1, 5, 5, 25, 125)), 5) + " should be [0]");
        System.out.println(countTriplets(getLongList(Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1)), 1) +
                " should be [161700]");
        System.out.println("*****************************************************************");
        System.out.println(countTriplets_copy(getLongList(Arrays.asList(1, 3, 9, 9, 27, 81)), 3) + " should be [6]");
        System.out.println(countTriplets_copy(getLongList(Arrays.asList(1, 3, 3, 9, 9, 27, 81)), 3) + " should be [10]");
        System.out.println(countTriplets_copy(getLongList(Arrays.asList(1, 5, 5, 25, 125)), 5) + " should be [0]");
        System.out.println(countTriplets_copy(getLongList(Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1)), 1) +
                " should be [161700]");
    }

    private static long countTriplets_copy(List<Long> arr, long r) {
        Map<Long, Long> firstPair = new HashMap<>();
        Map<Long, Long> firstAndSecondPair = new HashMap<>();
        long count = 0;
        for (int i = 0; i < arr.size(); i++) {
            long a = arr.get(i);
            long key = a / r;
            if (firstAndSecondPair.containsKey(key) && a % r == 0) {
//                Check if the val/r is present in firstAndSecondPair map.
//                Value is the firstAndSecondPair will be added only after there is a firstPair combination.
                count += firstAndSecondPair.get(key);
            }
            if (firstPair.containsKey(key) && a % r == 0) {
//                Value is added to second pair only after the first pair of it is present.
                long c = firstPair.get(key);
                firstAndSecondPair.put(a, firstAndSecondPair.getOrDefault(a, 0L) + c);
            }
//            By default add all the values to the map.
            firstPair.put(a, firstPair.getOrDefault(a, 0L) + 1);
        }
        return count;
    }

    static List<Long> getLongList(List<Integer> list) {
        List<Long> op = new ArrayList<>();
        for (int val : list) {
            op.add((long) val);
        }
        return op;
    }

    // Ex: 1 3 9 9 27 81
    // map = {1:1}{3:1}{9:2}{27:1}{81:1}
    static long countTriplets(List<Long> arr, long r) {
        int size = arr.size();
        Map<Long, Integer> leftMap = new HashMap<>();
        Map<Long, Integer> rightMap = new HashMap<>();
        for (int i = 0; i < size; i++) {
            long cur = arr.get(i);
            rightMap.put(cur, rightMap.getOrDefault(cur, 0) + 1);
        }
        long output = 0;

        for (long val : arr) {
            long leftVal = val / r;
            long rightVal = val * r;
            long rightCounter = rightMap.getOrDefault(rightVal, 0), leftCounter = leftMap.getOrDefault(leftVal, 0);
            // Remove the current value from the map.
            rightMap.put(val, rightMap.get(val) - 1);
            output += rightCounter * leftCounter;
            // Then copy the right value to left map.
            leftMap.put(val, leftMap.getOrDefault(val, 0) + 1);
        }
    /*
    This is a naive approach
    for(int i =0; i < size ; i++){
      long l1 = arr.get(i), l2 = l1*r, l3 = l2*r;
      for (int j = i+1; j<size ; j++ ) {
        if(arr.get(j) == l2){
          for (int k =j+1;k<size ;k++) {
            if(arr.get(k) == l3){
              output++;
            }
          }
        }
      }
    }
    */
        return output;
    }
}
