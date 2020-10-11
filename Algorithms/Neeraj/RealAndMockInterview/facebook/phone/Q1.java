package phone;
/*
I think two pointer
Keep writing
check lc

Put the code - Undo

//This is two fixed arrays though
*/

static int  findRight(int[] A, int key) {
  int start = 0, end = arr.length - 1;
  while (start < end) {
      int mid = start + (end - start) / 2;
      if (arr[mid] == key) {
          if (mid == arr.length - 1 || arr[mid + 1] != key) {
              result[1] = mid;
              return result;
          }
          start = mid + 1;
      }
      else if (arr[mid] < key) start = mid + 1;
      else end = mid;
  }
}

public int count(int[] arr, int target) {
  int start = 0, end = arr.length - 1;
  while (start < end) {
      int mid = start + (end - start) / 2;
      if (arr[mid] == key) {
          end = mid;
      } else if (arr[mid] > key) {
          end = mid;
      } else {
          start = mid + 1;
      }
  }
  return arr[start] == key ? start : -1;
}

private int binarySearch(int[] arr, int target, boolean leftmost) {
    int lo = 0;
    int hi = arr.length - 1;
    int idx = -1;
    while (lo <= hi) {
        int mid = (lo + hi) >>> 1; // avoid overflow. same as (lo + hi) / 2

        if (target > arr[mid]) {
            lo = mid + 1;
        } else if (target < arr[mid]) {
            hi = mid - 1;
        } else {
            idx = mid;
            if (leftmost) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
    }
    return idx;
}
