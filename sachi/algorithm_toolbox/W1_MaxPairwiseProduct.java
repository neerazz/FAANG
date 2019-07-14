import java.util.*;
import java.io.*;

public class W1_MaxPairwiseProduct {
    static long getMaxPairwiseProduct(int[] numbers) {
        long max_product = 0;
        int n = numbers.length;

        for (int first = 0; first < n; ++first) {
            for (int second = first + 1; second < n; ++second) {
                max_product = max(max_product, (long) numbers[first] * (long) numbers[second]);
            }
        }
        return max_product;
    }

    private static long max(long num1, long num2){
       return num1 > num2 ? num1 : num2;
    }

    static long getMaxPairwiseProductFast(int[] numbers){
        long firstMax = Long.MIN_VALUE, secondMax = Long.MIN_VALUE, result = 0;
        for(int i=0; i<numbers.length; i++){
            if(numbers[i] > firstMax){
                secondMax = firstMax;
                firstMax = numbers[i];
            }else if (numbers[i] > secondMax){
                secondMax = numbers[i];
            }
        }
        return firstMax * secondMax;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        //System.out.println(getMaxPairwiseProduct(numbers));
        System.out.println(getMaxPairwiseProductFast(numbers));
        //testProgram();
    }

    static void testProgram(){
        while(true){
            int rand =  getRandomNumber(2,100);
            int[] myTestArray = new int[rand];
            for(int i=0; i<myTestArray.length; i++){
                myTestArray[i] =  getRandomNumber(20000,500000);
                System.out.print(myTestArray[i] + " ");
            }
            System.out.print("\n");
            long sol1 = getMaxPairwiseProduct(myTestArray);
            long sol2 = getMaxPairwiseProductFast(myTestArray);
            if(sol1 != sol2){
                System.out.println("Failed -- Test: " + sol1 + " Fast Sol: " + sol2);
                break;
            }else {
                System.out.println("Ok");
            }
        }
    }

    static int getRandomNumber(int max, int min){
        return (int) (Math.random() *  ((max - min) + 1)) + min;
    }

     static long getRandomNumber(long max, long min){
        return (long) (Math.random() *  ((max - min) + 1)) + min;
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new
                    InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

}
