import java.util.*;

/**
 * @author :  bnira
 * Created :  7/28/2025
 * Problem : https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/description/?envType=study-plan-v2&envId=leetcode-75
 */

public class KidsWithTheGreatestNumberOfCandies {


    public static void main(String[] args) {
        KidsWithTheGreatestNumberOfCandies sol = new KidsWithTheGreatestNumberOfCandies();
    }

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int len = candies.length, max = Integer.MIN_VALUE;
        List<Boolean> result = new ArrayList<>();
        for(int i=0; i<len; i++){
            max = Math.max(max, candies[i]);
        }
        for(int num: candies){
            result.add(num+extraCandies >= max);
        }
        return result;
    }

}
