import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created on:  Mar 03, 2021
 * Questions:
 */

public class ShoppingOffers {

    Map<String, Integer> memo = new HashMap<>();
    List<Integer> price;
    List<List<Integer>> special;

    public static void main(String[] args) {

    }

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        this.price = price;
        this.special = special;
        return helper(needs);
    }

    private int helper(List<Integer> needs) {
        int withOutOffer = 0;
        for (int i = 0; i < needs.size(); i++) {
            withOutOffer += needs.get(i) * price.get(i);
        }
        if (withOutOffer == 0) return 0;
        String key = needs.toString();
        if (memo.containsKey(key)) return memo.get(key);
        int cur = withOutOffer;
        for (List<Integer> offer : special) {
            List<Integer> remaining = new ArrayList<>();
            if (canTakeOffer(offer, needs, remaining)) {
                int offerPrice = offer.get(offer.size() - 1);
                int next = helper(remaining);
                cur = Math.min(cur, offerPrice + next);
            }
        }
        // System.out.println("Requirment " + key + " price = " + cur);
        memo.put(key, cur);
        return cur;
    }

    private boolean canTakeOffer(List<Integer> offer, List<Integer> req, List<Integer> remaining) {
        int len = req.size();
        for (int i = 0; i < len; i++) {
            int required = req.get(i), fromOffer = offer.get(i);
            if (required >= fromOffer) {
                remaining.add(required - fromOffer);
            } else {
                return false;
            }
        }
        return true;
    }
}
