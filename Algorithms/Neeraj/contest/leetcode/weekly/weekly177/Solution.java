package weekly.weekly177;

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public static void main(String[] args) {
//         System.out.println(daysBetweenDates("2019-06-29","2019-06-30"));
//         System.out.println(daysBetweenDates("1971-06-29","2010-09-23"));
//        System.out.println(largestMultipleOfThree(new int[]{8,1,9}));
        System.out.println(Arrays.toString(closestDivisors(8)));
        System.out.println(Arrays.toString(closestDivisors(123)));
        System.out.println(Arrays.toString(closestDivisors(999)));
    }

    /*
    https://leetcode.com/problems/validate-binary-tree-nodes/discuss/517571/Find-parent-Array(Java)
    Take a parent array. ANd keep assigning the value.
     */
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {

        int index = 1;
        while(index < n){
//            Get all teh Left side one's


//            Get all teh right side one's
            index++;
        }
        return true;
    }

    public static int[] closestDivisors(int num) {
        int[] op = new int[2];
        int gcd1 = getGCD(num+1,num);
        int gcd2 = getGCD(num-1,num);
        int gcd3 = getGCD(num-2,num);
        int gcd4 = getGCD(num+2,num);
        System.out.println(" gcd1 = " + gcd1);
        System.out.println(" gcd2 = " + gcd2);
        System.out.println(" gcd4 = " + gcd4);
        System.out.println(" gcd3 = " + gcd3);
        int min = Math.max(Math.max(gcd1,gcd2),Math.max(gcd3,gcd4));
        op[0] = min;
        op[1] = num/min;
        return op;
    }

    public static int getGCD( int a, int b ) {
        return (b==0) ? a : getGCD(b, a%b);
    }

    private static void closestDivisors_Helper(int num, int left, int right, int[] op) {
        if(left * right == num ||
                (left +1) * right == num || (left+2) * right == num || (left -1) * right == num || (left-2) * right == num ||
                (right +1) * left == num || (right +2) * left == num || (right -1) * left == num || (right -2) * left == num){
            op[0] = left;
            op[1] = right;
            return;
        }
        closestDivisors_Helper(num,left-1,right, op);
        closestDivisors_Helper(num,left-1,right, op);
        closestDivisors_Helper(num,left-1,right, op);
        closestDivisors_Helper(num,left-1,right, op);
    }

    public static int daysBetweenDates(String date1, String date2) {
        //Parsing the date
        java.time.LocalDate dateBefore = java.time.LocalDate.parse(date1);
        java.time.LocalDate dateAfter = java.time.LocalDate.parse(date2);

        //calculating number of days in between
        long noOfDaysBetween = java.time.temporal.ChronoUnit.DAYS.between(dateBefore, dateAfter);
        if(noOfDaysBetween < 0){
            noOfDaysBetween = java.time.temporal.ChronoUnit.DAYS.between(dateAfter,dateBefore);
        }
        return (int) noOfDaysBetween;
    }

    public static String largestMultipleOfThree(int[] digits) {
        long sum = 0;
        for(int i = 0; i< digits.length; i++){
            sum += digits[i];
        }
        if (sum %3 ==0) {
            return Arrays.stream(digits).boxed().sorted(Collections.reverseOrder()).map(String::valueOf).collect(Collectors.joining());
        }
        return "";
    }
}
