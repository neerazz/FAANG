package weekly.weekly179;

class BulbSwitcherIII {
    public static void main(String[] args) {
        System.out.println(numTimesAllBlue(new int[]{3, 2, 4, 1, 5}));
    }

    public static int numTimesAllBlue(int[] light) {
        // To turn bulb to blue is when the all the left side bulbs are turned on.
        // Keep teh sum of possitions in an array. And sum of movements into an array.
        // When both of them sum array value matches then the bulb will be blue at that movement.
        int len = light.length, result =0;
//        BigInteger sumSoFar = BigInteger.valueOf(0);
//        BigInteger movementsSum = BigInteger.valueOf(0);
        long sumSoFar =0, movementsSum =0;
        for (int i = 0; i < len ; i++ ) {
//            sumSoFar = sumSoFar.add(BigInteger.valueOf(i+1));
//            movementsSum = movementsSum.add(BigInteger.valueOf(light[i]));
            sumSoFar += i+1;
            movementsSum += light[i];
            if(sumSoFar == movementsSum) {
                result++;
            }
        }
        return result;
    }
}
