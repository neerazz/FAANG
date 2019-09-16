public class ReverseBits {
    public static void main(String[] args) {
        long x = 13;
        System.out.println(reverseBitsBrute(x));
    }

    private static long reverseBits

    private static long reverseBitsBrute(long x) {
        StringBuilder sb = new StringBuilder(Long.toBinaryString(x));
        return Long.parseLong(sb.reverse().toString(), 2);
    }
}