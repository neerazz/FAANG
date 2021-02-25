import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created on:  Jun 09, 2020
 * Questions: Implement below type of sorting.
 * 1. Merge Sort
 * 2. Quick Sort
 * 3. Insertion Sort
 * 4. Heap Sort
 * 5. Bubble Sort
 * 6. Selection Sort
 */
public class Sorting {
    public static void main(String[] args) {
        printAllSortResults(new int[]{12, -2, 10, -15});
        printAllSortResults(new int[]{60, 0, 60, 40, 20});
        printAllSortResults(new int[]{25, 17, 31, 13, 2});
    }

    private static void printAllSortResults(int[] nums) {
        System.out.println("*****************************************************");
        System.out.println("Input           \t" + Arrays.toString(nums));
        System.out.println("Merge     Sort: \t" + Arrays.toString(mergeSort(Arrays.copyOf(nums, nums.length))));
        System.out.println("Quick     Sort: \t" + Arrays.toString(quickSort(Arrays.copyOf(nums, nums.length))));
        System.out.println("Insertion Sort: \t" + Arrays.toString(insertionSort(Arrays.copyOf(nums, nums.length))));
        System.out.println("Heap      Sort: \t" + Arrays.toString(heapSort(Arrays.copyOf(nums, nums.length))));
        System.out.println("Bubble    Sort: \t" + Arrays.toString(bubbleSort(Arrays.copyOf(nums, nums.length))));
        System.out.println("Selection Sort: \t" + Arrays.toString(selectionSort(Arrays.copyOf(nums, nums.length))));
    }

    private static int[] selectionSort(int[] array) {
        int start = 0, len = array.length;
        while (start < len) {
            int smallest = Integer.MAX_VALUE, idx = start;
            for (int i = start; i < len; i++) {
                if (array[i] < smallest) {
                    smallest = array[i];
                    idx = i;
                }
            }
            swap(array, start++, idx);
        }
        return array;
    }

    /**
     * @param arr Input array that will be splitted.
     * @return The sorted array.
     * @implNote Splits the array into two parts, and merger the two parts.
     */
    private static int[] mergeSort(int[] arr) {
        int len = arr.length;
        if (len == 1) return arr;
        int mid = len / 2;
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));
        return merge(left, right);
    }

    private static int[] merge(int[] left, int[] right) {
        int l1 = left.length, l2 = right.length;
        int[] op = new int[l1 + l2];
        int p1 = 0, p2 = 0, index = 0;
        while (p1 < l1 && p2 < l2) {
            if (left[p1] <= right[p2]) {
                op[index++] = left[p1++];
            } else {
                op[index++] = right[p2++];
            }
        }
        while (p1 < l1) op[index++] = left[p1++];
        while (p2 < l2) op[index++] = right[p2++];
        return op;
    }

    /**
     * @implNote Pick a Pivot point (int this case the last element).
     */
    private static int[] quickSort(int[] arr) {
        pickPivot(arr, 0, arr.length - 1);
        return arr;
    }

    private static void pickPivot(int[] arr, int start, int end) {
        if (start < 0 || start >= end) return;
        int pivot = partition(arr, start, end);
        pickPivot(arr, start, pivot - 1);
        pickPivot(arr, pivot + 1, end);
    }

    private static int partition(int[] arr, int start, int end) {
        int pVal = arr[end];
        for (int i = start; i < end; i++) {
            if (arr[i] < pVal) {
                int temp = arr[start];
                arr[start++] = arr[i];
                arr[i] = temp;
            }
        }
        int temp = arr[start];
        arr[start] = pVal;
        arr[end] = temp;
        return start;
    }

    /**
     * @implNote Pick an element from 1st index to n-1 th index. And keep swapping with left if the left is greater.
     */
    private static int[] insertionSort(int[] arr) {
        int len = arr.length;
        if (len == 1) return arr;
        for (int i = 1; i < len; i++) {
            int cur = arr[i], preIndex = i;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > cur) {
//                    Then swap i and j and keep moving
                    int temp = arr[j];
                    arr[j] = arr[preIndex];
                    arr[preIndex] = temp;
                    preIndex = j;
                } else {
                    break;
                }
            }
        }
        return arr;
    }

    static class Node {
        int val;
        Node left, right;

        public Node(int val) {
            this.val = val;
        }
    }

    /**
     * @implNote This could be implemented in array representation as well as a node Implementation.
     */
    private static int[] heapSort(int[] arr) {
        Node node = null;
//        Build bst Tree.
        for (int val : arr) {
            node = add(val, node);
        }
        List<Integer> array = new ArrayList<>();
//        Perform an inorder traversal
        inOrderTraversal(node, array);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = array.get(i);
        }
        return arr;
    }

    private static void inOrderTraversal(Node node, List<Integer> array) {
        if (node == null) return;
        inOrderTraversal(node.left, array);
        array.add(node.val);
        inOrderTraversal(node.right, array);
    }

    private static Node add(int val, Node node) {
        if (node == null) {
            return new Node(val);
        } else if (node.val <= val) {
            node.right = add(val, node.right);
        } else {
            node.left = add(val, node.left);
        }
        return node;
    }

    /**
     * @implNote At each level loop start from first:
     * Compare with the one with right, and if right is smaller, then swap the number and keep moving. (At end reduce the end index)
     */
    public static int[] bubbleSort(int[] array) {
        boolean swapped = true;
        int end = array.length;
        while (swapped) {
            swapped = false;
            for (int i = 1; i < end; i++) {
                if (array[i - 1] > array[i]) {
                    swap(array, i - 1, i);
                    swapped = true;
                }
            }
            end--;
        }
        return array;
    }

    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

}
