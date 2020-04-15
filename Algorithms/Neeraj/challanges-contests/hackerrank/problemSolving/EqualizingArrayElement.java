package problemSolving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EqualizingArrayElement{
    public static void main(String[] args) {
//        System.out.println(minOperations(new ArrayList<>(Arrays.asList(1,2,3,4)),3,2));
//        System.out.println(minOperations(new ArrayList<>(Arrays.asList(1,2,3,4)),4,3));
        System.out.println(minOperations(new ArrayList<>(Arrays.asList(64,30,25,33)),2,2) + " should be [3].");
    }
    //TODO This is wrong approach
    public static int minOperations(List<Integer> arr, int threshold, int d) {
        Collections.sort(arr);
        int output = Integer.MAX_VALUE;
        for(int i=0; i< arr.size(); i++){
            int operation =0, count =1, cur = arr.get(i);
            for(int j = i+1; j < arr.size(); j++){
                int innerOP = 0;
                int innerval = arr.get(j);
                while(innerval/d >= cur){
                    innerOP++;
                    innerval = innerval/d;
                    if(innerval == cur){
                        operation += innerOP;
                        count++;
                        break;
                    }
                }
                if(count == threshold){
                    output = Math.min(output, operation);
                    break;
                }
            }
        }
        if(output == Integer.MAX_VALUE){
//            Then start checking for possibility to make it zero.
            int cur =0;
            int operation =0, count = 0;
            for(int j = 0; j < arr.size(); j++){
                int innerOP = 0;
                int innerval = arr.get(j);
                while(innerval/d >= cur){
                    innerOP++;
                    innerval = innerval/d;
                    if(innerval == cur){
                        operation += innerOP;
                        count++;
                        break;
                    }
                }
                if(count == threshold){
                    output = Math.min(output, operation);
                    break;
                }
            }
        }
        return output;
    }
}