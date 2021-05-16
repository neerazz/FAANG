package biweekly.biweekly22;

import java.util.*;

class PizzaWith3nSlices {
    public static void main(String[] args) {
        System.out.println(maxSizeSlices(new int[]{1, 2, 3, 4, 5, 6}));
        System.out.println(maxSizeSlices(new int[]{4, 1, 2, 5, 8, 3, 1, 9, 7}));
        System.out.println(maxSizeSlices(new int[]{6, 3, 1, 2, 6, 2, 4, 3, 10, 4, 1, 4, 6, 5, 5, 3, 4, 7, 6, 5, 8, 7, 3, 8, 8, 1, 7, 1, 7, 8}));
    }

    // Below is a naive solution.
    static int max = Integer.MIN_VALUE;

    public static int maxSizeSlices(int[] slices) {
        LinkedList<Integer> list = new LinkedList<>();
        for(int i : slices){
            list.add(i);
        }
        performCheck(list,0);
        return max;
    }

    private static void performCheck(LinkedList<Integer> list, int sum){
        if(list.isEmpty()){
            max = Math.max(max,sum);
        }
        for(int i =0; i < list.size(); i++){
//             Take the slice i and the neibhours and place a recursive call.
            LinkedList<Integer> temp = takeIthSlice(i,list);
            int cur = list.get(i);
            performCheck(temp,sum+cur);
        }
    }

    private static LinkedList<Integer> takeIthSlice(int index, LinkedList<Integer> list){
        int pre = index-1 < 0 ? list.size()-1 : index-1;
        int next= index+1 >= list.size() ? 0 : index+1;
        LinkedList<Integer> op = new LinkedList<>();
        for(int i = 0 ; i < list.size() ; i ++){
            if(i != pre && i != index && i != next){
                op.add(list.get(i));
            }
        }
        return op;
    }
}
