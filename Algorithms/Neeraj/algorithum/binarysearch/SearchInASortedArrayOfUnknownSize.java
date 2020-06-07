public class SearchInASortedArrayOfUnknownSize {

    public static void main(String[] args) {
        System.out.println("Answer is:" + search(new ArrayReader(new int[]{-1, 0, 3, 5, 9, 12}), 9) + " should be [4].");
        System.out.println("Answer is:" + search(new ArrayReader(new int[]{-1, 0, 3, 5, 9, 12}), 2) + " should be [-1].");
        System.out.println("Answer is:" + search(new ArrayReader(new int[]{-1, 0, 3, 5, 9, 12}), 12) + " should be [5].");
        System.out.println("Answer is:" + search(new ArrayReader(new int[]{2, 5}), 2) + " should be [0].");
    }

    public static int search(ArrayReader reader, int target) {
        int max = getArraySize(reader), min = 0;
        while (min < max) {
            int avg = min + (max - min) / 2;

            int cur = reader.get(avg);
            if (cur == target) return avg;
            if (cur > target) max = avg;
            else min = avg + 1;
            if (min == max && reader.get(min) == target) return min;
        }
        return -1;
    }

    private static int getArraySize(ArrayReader reader) {
        int min = 0, max = 10000;
        while (min < max) {
            int avg = min + (max - min) / 2;
            if (reader.get(avg) == Integer.MAX_VALUE) {
                max = avg;
            } else {
                min = avg + 1;
            }
        }
        return min;
    }
}

class ArrayReader {
    int[] array;

    public ArrayReader(int[] array) {
        this.array = array;
    }

    int get(int k) {
        if (k < array.length) return array[k];
        return Integer.MAX_VALUE;
    }
}
