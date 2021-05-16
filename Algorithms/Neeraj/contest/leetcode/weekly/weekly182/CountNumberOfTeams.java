package weekly.weekly182;

/*
There are n soldiers standing in a line. Each soldier is assigned a unique rating value.
You have to form a team of 3 soldiers amongst them under the following rules:
Choose 3 soldiers with index (i, j, k) with rating (rating[i], rating[j], rating[k]).
A team is valid if:  (rating[i] < rating[j] < rating[k]) or (rating[i] > rating[j] > rating[k]) where (0 <= i < j < k < n).
Return the number of teams you can form given the conditions. (soldiers can be part of multiple teams).

Example 1:
Input: rating = [2,5,3,4,1]
Output: 3
Explanation: We can form three teams given the conditions. (2,3,4), (5,4,1), (5,3,1).
Example 2:
Input: rating = [2,1,3]
Output: 0
Explanation: We can't form any team given the conditions.
Example 3:
Input: rating = [1,2,3,4]
Output: 4
 */
public class CountNumberOfTeams {
    public static void main(String[] args) {
        System.out.println(numTeams(new int[]{2,5,3,4,1}));
        System.out.println(numTeams(new int[]{1,2,3,4}));
        System.out.println(numTeams_copied(new int[]{2,5,3,4,1}));
        System.out.println(numTeams_copied(new int[]{1,2,3,4}));
    }

    public static int numTeams(int[] rating) {
        if(rating == null || rating.length < 3) return 0;
        int len = rating.length;
        int count =0;
        for (int i = 0; i < len-2; i++) {
            for (int j = i+1; j < len - 1; j++) {
                for (int k = j+1; k < len; k++) {
                    int a = rating[i], b = rating[j], c = rating[k];
                    if(a > b && b > c) count++;
                    if(a < b && b < c) count++;
                }
            }
        }
        return count;
    }

    public static int numTeams_copied(int[] rating) {
//        Find all the greater then the current value at a given instance
        int len = rating.length;
        int[] largest = new int[len];
//        Find all the smallest value than the current value at a given instance.
        int[] smallest = new int[len];

//        The first pointer start at 0 and end at n-1.
//        The second pointer start at i+1 and end at n.
        for (int i = 0; i < len-1; i++) {
            int smaller =0, greater =0;
            for (int j = i+1; j < len; j++) {
                int iValue = rating[i], jValue = rating[j];
//                At every point check if j is less than i. Then you found a smallest item then i, increment smallest.
                if(iValue > jValue) smaller++;
//                At every point
                if(iValue < jValue) greater++;
            }
            largest[i] = greater;
            smallest[i]= smaller;
        }

//        Then perform an another loop,
//        loop 1: starting from 0 to n-2,
//        loop 2: starting from i+1 ro n-1,
        int result =0;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i+1; j < len; j++) {
                int iValue = rating[i], jValue = rating[j];
                if(iValue > jValue){
//                    If jValue is larger then iValue then, there can there can be a group formed will all the smallest values at that point.
                    result += smallest[j];
                }
                if(iValue < jValue){
                    result += largest[j];
                }
            }
        }
        return result;
    }
}
