import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created on:  Nov 12, 2020
 * Questions: https://leetcode.com/discuss/interview-question/928825/Microsoft-or-OA-2020-or-Benchmark-Matching
 */

public class BenchmarkMatching {

    public static void main(String[] args) {
        System.out.println(getBenchMark("Vodafone,STOCK,10|Google,STOCK,15|Microsoft,BOND,15:Vodafone,STOCK,15|Google,STOCK,10|Microsoft,BOND,15"));
        System.out.println(getBenchMark("Vodafone,STOCK,10|Google,STOCK,15:Vodafone,STOCK,15|Vodafone,BOND,10|Google,STOCK,10"));
    }

    public static List<String> getBenchMark(String input) {
        String[] vals = input.split(":", 2);
        Map<String, Stock> portfolio = new HashMap<>(), benchMark = new HashMap<>();
        for (String stock : vals[0].split("\\|")) {
            Stock cur = new Stock(stock);
            portfolio.put(cur.name + cur.assetType, cur);
        }
        for (String stock : vals[1].split("\\|")) {
            Stock cur = new Stock(stock);
            benchMark.put(cur.name + cur.assetType, cur);
        }
        System.out.println("portfolio = " + portfolio);
        System.out.println("benchMark = " + benchMark);
        List<Transaction> transactions = new ArrayList<>();
//        Loop through all the expected stocks and remove it from portfolio when the matching is done.
        for (Stock expected : benchMark.values()) {
            Stock actual = portfolio.remove(expected.name + expected.assetType);
            if (actual == null) {
                transactions.add(new Transaction("BUY", expected.name, expected.assetType, expected.shares));
            } else if (actual.shares < expected.shares) {
                transactions.add(new Transaction("BUY", expected.name, expected.assetType, expected.shares - actual.shares));
            } else if (actual.shares > expected.shares) {
                transactions.add(new Transaction("SELL", expected.name, expected.assetType, actual.shares - expected.shares));
            }
        }
//        Now loop through the remaining portfolio stocks, and sell those as well.
        for (Stock remaining : portfolio.values()) {
            transactions.add(new Transaction("SELL", remaining.name, remaining.assetType, remaining.shares));
        }
        return transactions.parallelStream()
                .map(tran -> String.format("%s,%s,%s,%d", tran.transactionType, tran.name, tran.assetType, tran.shares))
                .collect(Collectors.toList());
    }

    static class Transaction {
        String transactionType;
        String name;
        String assetType;
        int shares;

        public Transaction(String transactionType, String name, String assetType, int shares) {
            this.transactionType = transactionType;
            this.name = name;
            this.assetType = assetType;
            this.shares = shares;
        }
    }

    static class Stock {
        String name;
        String assetType;
        int shares;

        public Stock(String input) {
            String[] vals = input.split(",");
            name = vals[0];
            assetType = vals[1];
            shares = Integer.parseInt(vals[2]);
        }
    }
}
