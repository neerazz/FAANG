package weekly.weekly189;

import java.util.*;

/**
 * Created on:  May 16, 2020
 * Questions: https://leetcode.com/contest/weekly-contest-189/problems/people-whose-list-of-favorite-companies-is-not-a-subset-of-another-list/
 */
public class PeopleWhoseListofFavoriteCompaniesIsNotaSubsetofAnotherList {
    public static void main(String[] args) {
        System.out.println(peopleIndexes(Arrays.asList(
                Arrays.asList("leetcode", "google", "facebook"),
                Arrays.asList("google", "microsoft"),
                Arrays.asList("google", "facebook"),
                Arrays.asList("google"),
                Arrays.asList("amazon")
        )) + " should be [0,1,4]");
        System.out.println(peopleIndexes(Arrays.asList(
                Arrays.asList("leetcode", "google", "facebook"),
                Arrays.asList("leetcode", "amazon"),
                Arrays.asList("google", "facebook")
        )) + " should be [0,1]");
    }

    public static List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        List<Integer> op = new ArrayList<>();
        for(int i=0; i<favoriteCompanies.size(); i++){
            boolean foundSubSet = false;
            Set<String> first = new HashSet<>(favoriteCompanies.get(i));
            for(int j=0; j<favoriteCompanies.size(); j++){
                if(i != j && isSubSet(first, new HashSet<>(favoriteCompanies.get(j)))){
                    foundSubSet = true;
                    break;
                }
            }
            if(!foundSubSet) op.add(i);
        }
        return op;
    }

    private static boolean isSubSet(Set<String> set1, Set<String> set2) {
        if(set1.size() > set2.size()) return false;
        for(String sW : set1){
            if(!set2.contains(sW)){
                return false;
            }
        }
        return true;
    }
}
