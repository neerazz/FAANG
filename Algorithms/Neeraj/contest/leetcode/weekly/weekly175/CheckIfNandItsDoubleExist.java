package weekly.weekly175;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CheckIfNandItsDoubleExist {
    public static void main(String[] args) {
        System.out.println(checkIfExist(new int[]{10,2,5,3}));
        System.out.println(checkIfExist(new int[]{7,1,14,11}));
        System.out.println(checkIfExist(new int[]{3,1,7,11}));
        System.out.println(checkIfExist(new int[]{-10,12,-20,-8,15}));
        System.out.println(checkIfExist(new int[]{-2,0,10,-19,4,6,-8}));
    }
    public static boolean checkIfExist(int[] arr) {
        List<Integer> integers = Arrays.stream(arr).boxed().collect(Collectors.toList());
        for (int i = 0; i < arr.length; i++) {
            int cur = arr[i] *2;
            if (integers.contains(cur) && integers.indexOf(cur) != i){
                return true;
            }
        }
        return false;
    }
}
