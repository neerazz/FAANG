public class KthGrammer {

    public static int kthGrammar(int N, int K) {
        return Integer.bitCount(K - 1) % 2;
    }

    public static void main(String[] args) {
        System.out.println(kthGrammar(2, 1));
    }
}
