/**
 * Created on:  Jan 12, 2021
 * Questions: https://leetcode.com/discuss/interview-question/1002811/Amazon-or-OA-20201-or-Fresh-Promotion
 */

public class AmazonFreshPromotion {

    public static void main(String[] args) {

        System.out.println(freshPromotion(new String[][]{{"apple", "apple"}, {"banana", "anything", "banana"}},
                new String[]{"banana", "orange", "banana", "apple", "apple"})
                + " should be [0]");

        System.out.println(freshPromotion(new String[][]{{"apple", "apple"}, {"banana", "anything", "banana"}},
                new String[]{"apple", "apple", "orange", "orange", "banana", "apple", "banana", "banana"})
                + " should be [1]");

        System.out.println(freshPromotion(new String[][]{{"apple", "apple"}, {"banana", "anything", "banana"}},
                new String[]{"orange", "apple", "apple", "banana", "orange", "banana"})
                + " should be [1]");

        System.out.println(freshPromotion(new String[][]{{"apple", "apple"}, {"apple", "apple", "banana"}},
                new String[]{"apple", "apple", "apple", "banana"})
                + " should be [0]");

        System.out.println(freshPromotion(new String[][]{{"apple", "apple"}, {"banana", "anything", "banana"}},
                new String[]{"apple", "banana", "apple", "banana", "orange", "banana"})
                + " should be [0]");
    }

    private static int freshPromotion(String[][] codeList, String[] shoppingCart) {
//        Start at 0 index for both the code list and shopping cart.
        int cartIdx = 0, codeIdx = 0;
        while (cartIdx < shoppingCart.length && codeIdx < codeList.length) {
            String cur = shoppingCart[cartIdx];
//            If the first fruit of the codeList is anything or if it matches the current fruit at the cart idx.
            if((codeList[codeIdx][0].equals("anything") || codeList[codeIdx][0].equals(cur)) &&
                    hasOrder(shoppingCart, cartIdx, codeList[codeIdx])){
                cartIdx += codeList[codeIdx++].length;
            }else{
                cartIdx++;
            }
        }
//        If the all the codeList is present then return 1, else 0.
        return codeIdx == codeList.length ? 1 : 0;
    }

    private static boolean hasOrder(String[] shoppingCart, int idx, String[] order) {
//        Loop through the codeList to check if the fruits are in order.
        for (String s : order) {
            if (idx < shoppingCart.length && (s.equals("anything") || shoppingCart[idx].equals(s))){
                idx++;
            }else{
                return false;
            }
        }
        return true;
    }
}
