package RealAndMockInterview.amazon;

import java.util.*;
import java.util.stream.Collectors;

public class OptimizingBoxWeights {

    public static List<Integer> optimizingBoxWeights(List<Integer> arr) {
        int target = arr.stream().reduce(0, Integer::sum) / 2;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            return b - a;
        });
        pq.addAll(arr);
        int curSum = 0;
        List<Integer> res = new ArrayList<>();
        while (curSum <= target) {
            int val = pq.poll();
            curSum += val;
            res.add(val);
        }
        Collections.reverse(res);
        return res;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> arr = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
        scanner.close();
        List<Integer> res = optimizingBoxWeights(arr);
        System.out.println(res.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }

}
