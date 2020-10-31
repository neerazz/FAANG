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
