class SquareRoot {
    public static void main(String[] args) {

    }

    public int mySqrt(int x) {
        if (x < 2) return x;
        int start = 1, end = x / 2;
        long prod = 0;

        while (start <= end) {
            int mid = (start + end) / 2;
            prod = (long) mid * mid;
            if (prod == x) return mid;
            else if (prod > x) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return end;
    }


}