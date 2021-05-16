package weekly.weekly181;

class FourDivisors {
    public static void main(String[] args) {
        System.out.println(sumFourDivisors(new int[]{21, 4, 7}));
    }

    public static int sumFourDivisors(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            int divSum = findDivisors(i);
            System.out.println("i =" + i + " divSum=" + divSum);
            if(divSum != Integer.MAX_VALUE){
                sum += divSum;
            }
        }
        return sum;
    }

    private static int findDivisors(int num){
        int count = 2;
        int sum = 1 + num;
        int sqrt = (int) Math.sqrt(num);
        // If the sqrt is a whole number that will have more then 4 divisibles.
        if(sqrt*sqrt == num) return Integer.MAX_VALUE;
        // Loop only from 2 to sqrt of the number.
        for(int i = 2; i <= sqrt; i++){
            if(num % i == 0){
                // When divisible then, consider two the number.
                // Ex:  3*7, every time insead of considering only 3, considering both 3 and 7.
                count+=2;
                sum += i + (num/i);
            }
            if(count > 5){
                sum = Integer.MAX_VALUE;
                break;
            }
        }
        if(count != 4){
            sum = Integer.MAX_VALUE;
        }
        return sum;
    }
}
