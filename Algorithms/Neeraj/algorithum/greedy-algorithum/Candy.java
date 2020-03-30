public class Candy {
    public static void main(String[] args) {
        System.out.println(candy(new int[]{1, 0, 2}) + " should be [5].");
        System.out.println(candy(new int[]{1, 2, 2}) + " should be [4].");
        System.out.println(candy(new int[]{1, 2, 87, 87, 87, 2, 1}) + " should be [13].");
        System.out.println(candy(new int[]{12,4,3,11,34,34,1,67}) + " should be [16].");
    }

    public static int candy(int[] ratings) {
        if (ratings == null || ratings.length < 1) return 0;
        int[] first = new int[ratings.length];
        first[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i-1]){
                first[i] = first[i-1] +1;
            }else {
                first[i] = 1;
            }
        }
        int[] second = new int[ratings.length];
        second[ratings.length-1] = 1;
        for (int i = ratings.length-2; i >= 0; i--) {
            if (ratings[i] > ratings[i+1]){
                second[i] = second[i+1] +1;
            }else {
                second[i] = 1;
            }
        }

        int output = 0;
        for (int i = 0; i < ratings.length; i++) {
            output += Math.max(first[i],second[i]);
        }
        return output;
    }
}
