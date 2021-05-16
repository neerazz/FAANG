package biweekly.biweekly22;

import java.util.*;

class SortIntegersByThePowerValue {
    public static void main(String[] args) {
        System.out.println(getKth(12, 15, 2) + " should be [13]");
        System.out.println(getKth(10, 20, 5) + " should be [13]");
        System.out.println(getKth(7, 11, 4) + " should be [7]");
        System.out.println(getKth(1, 1000, 777) + " should be [570]");
    }

    public static int getKth(int lo, int hi, int k) {
        PriorityQueue<Values> queue = new PriorityQueue<>(
                (v1, v2) -> v1.pow == v2.pow ? v2.num -v1.num : v2.pow - v1.pow);
//         Sort it in desending order.
        while(lo <= hi){
            int pow = getDistance(lo);
            queue.add(new Values(lo,pow));
            if(queue.size() > k){
                queue.poll();
            }
            lo++;
        }
        return queue.peek().num;
    }

    private static int getDistance(int num){
        //System.out.println("num =" + num);
        if(num == 1) return 1;
        if(num %2 ==0){
//             n is even
            return 1 + getDistance(num/2);
        }else{
//             n is odd
            return 1 + getDistance(3 * num +1);
        }
    }

    static class Values{
        int num;
        int pow;

        Values(int i, int j){
            num = i;
            pow = j;
        }
    }
}
