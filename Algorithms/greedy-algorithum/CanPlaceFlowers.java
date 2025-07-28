import java.util.*;

/**
 * @author :  bnira
 * Created :  7/28/2025
 * Problem : https://leetcode.com/problems/can-place-flowers/description/?envType=study-plan-v2&envId=leetcode-75
 */

public class CanPlaceFlowers {


    public static void main(String[] args) {
        CanPlaceFlowers sol = new CanPlaceFlowers();
    }

    public boolean canPlaceFlowers(int[] bed, int n) {
        int plant = 0;
        for(int i=0; i<bed.length; i++){
            boolean left = (i-1 > 0 && bed[i-1] ==0) || (i ==0);
            boolean right = (i+1 < bed.length && bed[i+1] == 0) || (i+1 == bed.length);
            if(bed[i] ==0 && left && right){
                plant++;
                bed[i] = 1;
            }
        }
        return plant >= n;
    }

}
