import java.util.*;

class SmallestDifference{
  public static void main(String[] args) {
    System.out.println(Arrays.toString(smallestDifference(new int[]{-1,5,10,20,28,3},new int[]{26,134,135,15,17})));
  }

  public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
   Arrays.sort(arrayOne);
   Arrays.sort(arrayTwo);
   int l1 = arrayOne.length, l2 = arrayTwo.length, i=0, j=0, diff = Integer.MAX_VALUE;
   int[] op = new int[2];
   while(i < l1 && j < l2){
     int v1 = arrayOne[i], v2 = arrayTwo[j];
     if(v1 == v2){
       op[0] = v1;
       op[1] = v2;
       return op;
     }
     if(Math.abs(v1-v2) < diff){
       op[0] = v1;
       op[1] = v2;
       diff = Math.abs(v1-v2);
     }
     if(v1 < v2) i++;
     else if(v1 > v2) j++;
   }
   return op;
  }
}
