import java.util.Map;
import java.util.TreeMap;

public class StockSpanner {

    TreeMap<Integer, Integer> treeMap;
    int size;
    int prev;

    public StockSpanner() {
        treeMap = new TreeMap<>();
        size = -1;
    }

    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();

/*        System.out.println(stockSpanner.next(100));
        System.out.println(stockSpanner.next(80));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(70));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(75));
        System.out.println(stockSpanner.next(85));*/

/*       System.out.println(stockSpanner.next(31));
        System.out.println(stockSpanner.next(41));
        System.out.println(stockSpanner.next(48));
        System.out.println(stockSpanner.next(59));
        System.out.println(stockSpanner.next(79));*/

        System.out.println(stockSpanner.next(29));
        System.out.println(stockSpanner.next(91));
        System.out.println(stockSpanner.next(62));
        System.out.println(stockSpanner.next(76));
        System.out.println(stockSpanner.next(51));

    }

    public int next(int price) {
        size++;
        Map.Entry<Integer, Integer> entry = treeMap.higherEntry(price);
        treeMap.put(price, size);
        if (prev > price) return 1;
        if (entry == null) return size + 1;
        prev = price;
        return size - entry.getValue();
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */