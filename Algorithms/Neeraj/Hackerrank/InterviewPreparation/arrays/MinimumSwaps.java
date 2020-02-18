package InterviewPreparation.arrays;

/*
https://www.hackerrank.com/challenges/minimum-swaps-2/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
 */
public class MinimumSwaps {
    public static void main(String[] args) {
        System.out.println(minimumSwaps(new int[]{4,3,1,2}) + " should be [3]");
        System.out.println(minimumSwaps(new int[]{2,3,4,1,5}) + " should be [3]");
    }
    static int swapsCount;
    static int minimumSwaps(int[] arr) {
//        swapsCount = 0;
//        if(arr == null || arr.length < 2) return 0;
//        performQuickSort(arr,0,arr.length-1);
//        return swapsCount;
        int swap = 0;
        for (int i = 0; i < arr.length; i++) {
            while (i+1 != arr[i]) {
                int temp = arr[arr[i] - 1];
                arr[arr[i] - 1] = arr[i];
                arr[i] = temp;
                swap += 1;
            }
        }
        return swap;
    }

    static void performQuickSort(int[] arr, int start, int end){
        int index = partition(arr,start,end);
        if(start < index-1){
            partition(arr,start,index-1);
        }
        if (index < end) {
            partition(arr,index,end);
        }
    }

    private static int partition(int[] arr, int left, int right) {
        int i = left, j = right;
        int tmp;
        int pivot = arr[(left + right) / 2];
        while (i <= j) {
            while (arr[i] < pivot)
                i++;
            while (arr[j] > pivot)
                j--;
            if (i <= j) {
                if (i != j){
                    swapsCount++;
                }
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        }
        return i;
    }
}
