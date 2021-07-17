package concepts.primitives;/* Given a number - Convert into Binary and swap i th and jth node.

Sol:
Hint: Swap when they are only different
- Extract and check
- If diff - Create a maskbit with 1s
- XOR with bitmask
*/


public class SwapBits {
    public static void main(String[] args) {
        long x = 73;
        int i = 1, j = 6;
        System.out.println(swapBits(x, i, j));
    }

    private static long swapBits(long x, int i, int j) {
        // Get the ith bit and jth bit and compare.
        // If they are same - Nothing to do
        if (((x >>> i) & 1) != ((x >>> j) & 1)) {
            // Bits are not equal - Swap them
            // Create a mask
            long bitMask = (1L << i) | (1L << j);
            //XOR with 1 (bit mask has 1 at those values) will reverse the bits
            x ^= bitMask;
        }
        return x;
    }
}