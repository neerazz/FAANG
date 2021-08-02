package RealAndMockInterview.twilio;

public class FourthBit {

    public static void main(String[] args) {
        int n = 23;
        System.out.println(Integer.toBinaryString(n));
        System.out.println(fourthBit(n));
    }

    private static int fourthBit(int n) {
        n = n >> 3;
        return n & 1;
    }
}
