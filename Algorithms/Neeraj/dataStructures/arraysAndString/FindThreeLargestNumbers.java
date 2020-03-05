import java.util.*;

class FindThreeLargestNumbers {
  public static void main(String[] args) {
    System.out.println(Arrays.toString(findThreeLargestNumbers(new int[]{141,1,17,-7,-17,-27,18,541,8,7,7})));
  }
  public static int[] findThreeLargestNumbers(int[] array) {
// 		    int first=Integer.MIN_VALUE;
//         int second=Integer.MIN_VALUE;
//         int third = Integer.MIN_VALUE;

//         for (int i = 0; i <array.length ; i++) {
//             int current = array[i];
//             if(first<current){
//                 third = second;
//                 second = first;
//                 first = current;
//             }else if(second<current){
//                 third = second;
//                 second = current;
//             }else if(third<current){
//                 third=current;
//             }
//         }
// 		return new int[]{first,second,third};
    java.util.PriorityQueue<Integer> queue = new java.util.PriorityQueue<>();
		for(int i : array){
			queue.add(i);
// 			Always only store 3 rargest value.
			if(queue.size() > 3){
				queue.poll();
			}
		}
		int[] op = new int[3];
		if(queue.size() == 3){
			for(int i = 0; i < 3 ; i++){
				op[i] = queue.poll();
			}
			return op;
		}
    return op;
  }
}
