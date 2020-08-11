import java.util.*;

// Do not edit the class below except for the buildHeap,
// siftDown, siftUp, peek, remove, and insert methods.
// Feel free to add new properties and methods to the class.
class MinHeapConstruction {
  public static void main(String[] args) {
    MinHeap minHeap = new MinHeap(Arrays.asList(48,12,24,7,8,-5,24,391,24,56,2,6,8,41));
    System.out.println(minHeap.heap);
    System.out.println("Removing element");
    System.out.println(minHeap.remove());
    System.out.println(minHeap.heap);
  }
  static class MinHeap {
    List<Integer> heap = new ArrayList<Integer>();

    public MinHeap(List<Integer> array) {
      heap = buildHeap(array);
    }

    public List<Integer> buildHeap(List<Integer> array) {
      heap.add(null);
      for(int value : array){
        insert(value);
      }
      return heap;
    }

    public void siftDown(int currentIdx, int endIdx, List<Integer> heap) {
      // Write your code here.
      System.out.println("Before swapping :\t" + this.heap);
      int temp = heap.get(endIdx);
      int current = heap.get(currentIdx);
      this.heap.set(currentIdx,temp);
      this.heap.set(endIdx,current);
      System.out.println("After swapping :\t" + this.heap);
    }

    public void siftUp(int currentIdx, List<Integer> heap) {
      // System.out.println("Before Shifting: currentIdx = " + currentIdx + " heap=" + heap);
      // Swap with the parent.
      if(hasParent(currentIdx)){
        int parentIdx = currentIdx /2;
        int parentVal = this.heap.get(parentIdx);
        this.heap.set(parentIdx,heap.get(currentIdx));
        this.heap.set(currentIdx,parentVal);
      }else{
          // Throw exception.
          // throw new RunTimeException("Invalid Operation");
      }
      // System.out.println("After Shifting: currentIdx = " + currentIdx + " heap=" + heap);
    }

    public int peek() {
      return heap.size() >= 2 ? heap.get(1) : -1;
    }

    public int remove() {
      // Swap the first index with last index and delete the last index. And perform hepify.
      int firstElement = peek();
      int lastIdx = heap.size()-1;
      int lastElement = heap.get(lastIdx);
      heap.set(1,lastElement);
      heap.remove((Integer)lastIdx);
      int index = 1, left = getLeft(index), right = getRight(index);
      while(index < heap.size() && (heap.get(index) >left || heap.get(index) > right)){
        // Check if The value should be kepth in left or right.
        if(heap.get(index) > right){
          // Then swap Right side.
          siftDown(index,right,this.heap);
          index = index * 2+1;
        }else{
          // Swap on left side.
          siftDown(index,left,this.heap);
          index = index * 2;
        }
      }
      return -1;
    }
    private boolean hasParent(int index){
      // Check if you are at top most level. Then the parent value wull be same as current index.
      return index/2 != index;
    }
    private boolean hasLeft(int index){
      return index * 2 < heap.size();
    }
    private boolean hasRigt(int index){
      return index * 2 +1 < heap.size();
    }
    private int getParent(int index){
      return index/2 >= 1 ? heap.get(index/2) : -1;
    }

    private int getLeft(int index){
      return index*2 < heap.size() ? heap.get(index*2) : Integer.MAX_VALUE;
    }
    private int getRight(int index){
      return index*2+1 < heap.size() ? heap.get(index*2+1) : Integer.MAX_VALUE;
    }
    public void insert(int value) {
      // System.out.println("Value =" + value);
      // Always insert at the end. And then perform min head.
      int index = heap.size();
      heap.add(index, value);
      // Check with your parent if the parent is greater then move up.
      while(hasParent(index) && index > 1 && getParent(index) > value){
        // Swap with parent if parent is greater
        siftUp(index,this.heap);
        // Change the index to parent.
        index /=2;
      }
    }
  }
}
