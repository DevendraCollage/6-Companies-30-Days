/*
 * LC638
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC638 {
    public static int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        Map<List<Integer>, Integer> memo = new HashMap<>();
        return dfs(price, special, needs, memo);
    }

    private static int dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs,
            Map<List<Integer>, Integer> memo) {
        if (memo.containsKey(needs)) {
            return memo.get(needs);
        }

        // Calculate the cost without any special offers
        int minCost = calculateTotal(price, needs);

        for (List<Integer> offer : special) {
            List<Integer> newNeeds = new ArrayList<>();
            boolean validOffer = true;

            // Check if offer can be applied
            for (int i = 0; i < needs.size(); i++) {
                if (offer.get(i) > needs.get(i)) {
                    validOffer = false;
                    break;
                }
                newNeeds.add(needs.get(i) - offer.get(i));
            }

            // If the offer is valid, recursively find the minimum cost with this offer
            if (validOffer) {
                minCost = Math.min(minCost, offer.get(offer.size() - 1) + dfs(price, special, newNeeds, memo));
            }
        }

        memo.put(needs, minCost);
        return minCost;
    }

    public static int calculateTotal(List<Integer> prices, List<Integer> needs) {
        int totalCost = 0;
        for (int i = 0; i < prices.size(); i++) {
            totalCost += prices.get(i) * needs.get(i);
        }
        return totalCost;
    }
}