import java.util.*;
import java.io.*;

/**
 * Created on:  Jan 16, 2021
 * Questions: https://aonecode.com/amazon-online-assessment-secret-fruits
 */

public class SecretFruitList {

    public static void main(String[] args) {
        System.out.println(matchSecretLists(Arrays.asList(
                Arrays.asList("apple", "apple")),
                Arrays.asList("apple", "apple")));
        System.out.println(matchSecretLists(Arrays.asList(
                Arrays.asList("anything")),
                Arrays.asList("apple", "apple", "apple", "banana")));
    }

    public static boolean matchSecretLists(List<List<String>> codeList, List<String> shoppingCart) {
//        Start at 0 index for both the code list and shopping cart.
        int cartIdx = 0, codeIdx = 0, totalCart = shoppingCart.size(), totalCodes = codeList.size();
        while (cartIdx < totalCart && codeIdx < totalCodes) {
            String cur = shoppingCart.get(cartIdx);
//            If the first fruit of the codeList is anything or if it matches the current fruit at the cart idx.
            if ((codeList.get(codeIdx).get(0).equals("anything") || codeList.get(codeIdx).get(0).equals(cur)) &&
                    hasOrder(shoppingCart, cartIdx, codeList.get(codeIdx))) {
                cartIdx += codeList.get(codeIdx++).size();
            } else {
                cartIdx++;
            }
        }
//        If the all the codeList is present then return 1, else 0.
        return codeIdx == codeList.size();
    }

    private static boolean hasOrder(List<String> shoppingCart, int idx, List<String> order) {
//        Loop through the codeList to check if the fruits are in order.
        for (String s : order) {
            if (idx < shoppingCart.size() && (s.equals("anything") || shoppingCart.get(idx).equals(s))) {
                idx++;
            } else {
                return false;
            }
        }
        return true;
    }
}
