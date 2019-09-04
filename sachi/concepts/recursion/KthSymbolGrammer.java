import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KthSymbolGrammer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int k = scanner.nextInt();
        System.out.println(kthGrammar(N,k));
        scanner.close();
    }

    private static int kthGrammar(int N, int K){
        if(N<=1){
            return 0;
        }
        int indices = (int) Math.pow(2, N-1);
        List<Integer> cache = new ArrayList<>(indices);
        cache.add(0);
        cache.add(1);
        for(int i=1; i<indices; i++){
            if(cache.get(i) == 0){
                cache.add(0);
                cache.add(1);
            }else{
                cache.add(1);
                cache.add(0);
            }
        }
        return cache.get(K-1);
    }

}