import java.util.*;

class KMessedArraySort{
  public static void main(String[] args) {

  }

  static int[] sortKMessedArray(int[] arr, int k) {
    int len = arr.length;
    // min heap
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

    // add first k items to the min heap
    for(int i = 0; i < k + 1; i++) {
        priorityQueue.add(arr[i]);
    }

    int index = 0;
    for(int i = k + 1; i < len; i++)  {
      // extract the top element from the min-heap and assign it to the next available array index
        arr[index++] = priorityQueue.poll();
        // push the next array element into the min-heap
        priorityQueue.add(arr[i]);
    }

    // extract all remaining elements from the min-heap and assign them to the next available array index
    while(!priorityQueue.isEmpty()) {
        arr[index++] = priorityQueue.poll();
    }
    return arr;
  }
}
