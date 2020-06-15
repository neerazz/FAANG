public class ReverseInteger {

    public static int reverse(int x) {
        long sol = 0;
        while (x != 0) {
            sol = (sol * 10) + (x % 10);
            if (sol < Integer.MIN_VALUE || sol > Integer.MAX_VALUE) return 0;
            x = x / 10;
        }
        return (int) sol;
    }

    public static void main(String[] args) {
        System.out.println(reverse(-321));
    }
}
