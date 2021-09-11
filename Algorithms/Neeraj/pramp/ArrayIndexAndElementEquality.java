class ArrayIndexAndElementEquality {
    static int indexEqualsValueSearch(int[] arr) {
        int start = 0, end = arr.length - 1;
        int res = -1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] < mid) {
                // Go right
                start = mid + 1;
            } else {
                // Go left
                if (arr[mid] == mid)
                    res = mid;
                end = mid - 1;
            }
        }
        if (start == end && arr[start] == start) return start;
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(indexEqualsValueSearch(new int[]{-8, 0, 2, 5}));
        System.out.println(indexEqualsValueSearch(new int[]{-5, 0, 2, 3, 4, 5}));
    }
}
