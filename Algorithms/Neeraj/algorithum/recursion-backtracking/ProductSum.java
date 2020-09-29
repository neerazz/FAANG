import java.util.List;

/**
 * Created on:  Sep 28, 2020
 * Questions: https://www.algoexpert.io/questions/Product%20Sum
 */
public class ProductSum {
    public static void main(String[] args) {

    }

    public static int productSum(List<Object> array) {
        return productSum(array, 1);
    }

    private static int productSum(List<Object> array, int level) {
        int sum = 0;
        for (Object obj : array) {
            if (obj instanceof List) {
                sum += productSum((List<Object>) obj, level + 1);
            } else {
                sum += (int) obj;
            }
        }
        return sum * level;
    }
}
