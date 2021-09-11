import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created on:  Jan 15, 2021
 * Questions: https://aonecode.com/aplusplus/interviewctrl/getInterview/84657973411
 */

public class RankingProducts {

    public static void main(String[] args) {
        System.out.println(rankingProducts(6, Map.of(
                "product1", List.of(10, 5),
                "product2", List.of(3, 3),
                "product3", List.of(17, 4),
                "product4", List.of(9, 4),
                "product5", List.of(1, 5),
                "product6", List.of(1, 5)
        ), 1, false, 3, 1));
    }

    private static List<String> rankingProducts(int n, Map<String, List<Integer>> products, int sortKey, boolean sortOrder, int perRow, int row) {
        int start = perRow * row, end = Math.min((row + 1) * perRow, n);
        List<String> result = products.entrySet().stream()
                .sorted(getComparator(sortKey, sortOrder))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        return result.subList(start, end);
    }

    private static Comparator<Map.Entry<String, List<Integer>>> getComparator(int sortKey, boolean sortOrder) {
        if (sortKey == 0) {
            return sortOrder ?
                    (e1, e2) -> e1.getKey().compareTo(e2.getKey()) :
                    (e1, e2) -> e2.getKey().compareTo(e1.getKey());
        }
        if (sortOrder) {
            return Comparator.comparingInt(e -> e.getValue().get(sortKey - 1));
        } else {
            return (e1, e2) -> Integer.compare(e2.getValue().get(sortKey - 1), e1.getValue().get(sortKey - 1));
        }
    }
}
