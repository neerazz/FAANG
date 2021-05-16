package weekly.weekly186;
/*
    Created on:  Apr 26, 2020
 */

/**
 * Questions: https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
 */
public class MaximumPointsYouCanObtainFromCards {
    public static void main(String[] args) {

    }
    private static int getPoints(int[] cards, int k){
        int len = cards.length, sum =0, max = Integer.MIN_VALUE;
//        Sum all the first k values.
        for(int i=0; i<k; i++){
            sum += cards[i];
        }
        max = Math.max(max,sum);
//        Remove last element from the list of k elements. And add the last element.
//        Take the first two from array and last element.
//          That can be achieved by removing the (k-i)th element and adding (len-i)th element.
//        Ex: (k =3, vi = value at i, length =7)
//            sum = (v0+v1+v2)+v[len-i]-v[k-i]
        for(int i=1; i<=k; i++){
            sum+= cards[len-i] - cards[k-i];
        }
        return max;
    }
}
