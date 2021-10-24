import java.util.*;

/**
 * Created on:  Jan 15, 2021
 * Questions: https://aonecode.com/aplusplus/interviewctrl/getInterview/2286238496239
 */

public class FindCountriesWithTheLargestDeficit {

    public static void main(String[] args) {
        System.out.println(minimumDebtMembers(Arrays.asList(
                new debtRecord("Alex", "Blake", 2),
                new debtRecord("Alex", "Blake", 4),
                new debtRecord("Alex", "Casey", 4),
                new debtRecord("Blake", "Alex", 2),
                new debtRecord("Blake", "Casey", 7),
                new debtRecord("Casey", "Alex", 5)
        )));
    }

    static List<String> minimumDebtMembers(List<debtRecord> records) {
        if (records.isEmpty()) return Arrays.asList("None");
        Map<String, Integer> map = new HashMap<>();
        for (debtRecord record : records) {
            int borrower = map.getOrDefault(record.borrower, 0);
            int lender = map.getOrDefault(record.lender, 0);
            borrower -= record.amount;
            lender += record.amount;
            map.put(record.borrower, borrower);
            map.put(record.lender, lender);
        }
        int min = map.values().stream().mapToInt(i -> i).min().getAsInt();
        if (min >= 0) return Arrays.asList("Nobody has a negative balance");
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == min) {
                result.add(entry.getKey());
            }
        }
        Collections.sort(result);
        return result;
    }

    static class debtRecord {
        String borrower = ""; // importer
        String lender = ""; //exporter
        int amount = 0;

        public debtRecord(String borrower, String lender, int amount) {
            this.borrower = borrower;
            this.lender = lender;
            this.amount = amount;
        }
    }
}
