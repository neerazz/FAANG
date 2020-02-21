package ds.revision;

import java.util.*;
import java.util.stream.Collectors;

public class HashTable {
    public static void main(String[] args) {
//        System.out.println(containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 3));
//        System.out.println(containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1));
//        System.out.println(containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));
//        System.out.println(groupAnagrams(new String[]{"cab", "tin", "pew", "duh", "may", "ill", "buy", "bar", "max", "doc"}));
//        System.out.println(groupAnagrams(new String[]{"put","tag","nap","fit","who","ilk","mac","bus","fez","yum","nix","bud","inc","fed","col","yea","cur","lit","pym","lam","ark","non","ohm","pug","nay","nib","end","all","wad","mon","jed","jed","ice","ate","fax","sun","den","joy","are","wed","wed","gay","pat","pal","dab","cob","pal","ila","ifs","flo","ike"}));
//        System.out.println(groupAnagrams(new String[]{"cab","pug","pei","nay","ron","rae","ems","ida","mes"}));
//        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
//        System.out.println(isValidSudoku(new char[][]{
//                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
//                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
//                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
//                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
//                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
//                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
//                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
//                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
//                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
//        }) + " should be [true]");
//        System.out.println(isValidSudoku(new char[][]{
//                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
//                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
//                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
//                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
//                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
//                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
//                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
//                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
//                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
//        }) + " should be [false]");

//        TreeNode one = new TreeNode(1);
//        TreeNode two = new TreeNode(2);
//        TreeNode three = new TreeNode(3);
//        TreeNode four = new TreeNode(4);
//        one.left = two;
//        one.right = three;
//        two.left = four;
//        three.left = two;
//        three.right = four;
//        System.out.println(findDuplicateSubtrees(one));

//        Logger logger = new Logger();

// logging string "foo" at timestamp 1
//        System.out.println(logger.shouldPrintMessage(1, "foo") + " returns true");

// logging string "bar" at timestamp 2
//        System.out.println(logger.shouldPrintMessage(2, "bar") + " returns true");

// logging string "foo" at timestamp 3
//        System.out.println(logger.shouldPrintMessage(3, "foo") + " returns false");

// logging string "bar" at timestamp 8
//        System.out.println(logger.shouldPrintMessage(8, "bar") + " returns false");

// logging string "foo" at timestamp 10
//        System.out.println(logger.shouldPrintMessage(10, "foo") + " returns false");

// logging string "foo" at timestamp 11
//        System.out.println(logger.shouldPrintMessage(11, "foo") + " returns true");
//        System.out.println(groupStrings(new String[]{"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"}));
//
//        TwoSum obj = new TwoSum();
//        obj.add(1);
//        obj.add(3);
//        obj.add(5);
//        System.out.println(obj.find(4) + " -> true");
//        System.out.println(obj.find(7) + " -> false");
//        System.out.println("================================");
//        TwoSum obj1 = new TwoSum();
//        obj1.add(1);
//        obj1.add(3);
//        obj1.add(2);
//        System.out.println(obj1.find(3) + " -> true");
//        System.out.println(obj1.find(6) + " -> false");
//        System.out.println("================================");
//        TwoSum obj2 = new TwoSum();
//        obj2.add(0);
//        obj2.add(0);
//        System.out.println(obj2.find(0) + " -> true");
//        System.out.println(numJewelsInStones("aA", "aAAbbbb") + " should be [3].");
//        System.out.println(numJewelsInStones("z", "ZZ") + " should be [0].");
//        System.out.println(lengthOfLongestSubstring("au"));
//        System.out.println(lengthOfLongestSubstring(" "));
//        System.out.println(lengthOfLongestSubstring("abcabcbb"));
//        System.out.println(lengthOfLongestSubstring("bbbbb"));
//        System.out.println(lengthOfLongestSubstring("pwwkew"));
//        System.out.println(fourSumCount(new int[]{1, 2}, new int[]{-2, -1}, new int[]{-1, 2}, new int[]{0, 2}) + " should be [2].");
//        System.out.println(topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2) + " should be [1,2].");
//        System.out.println(topKFrequent(new int[]{1}, 1) + " should be [1].");
//        System.out.println(topKFrequent(new int[]{4, 1, -1, 2, -1, 2, 3}, 2) + " should be [-1,2].");
        ValidWordAbbr obj = new ValidWordAbbr(new String[]{"deer", "door", "cake", "card"});
        System.out.println(obj.isUnique("dear") + " -> false");
        System.out.println(obj.isUnique("cart") + " -> true");
        System.out.println(obj.isUnique("cane") + " -> false");
        System.out.println(obj.isUnique("make") + " -> true");
        System.out.println("===============================================");
        System.out.println(obj.isUnique("dear") + " -> false");
        System.out.println(obj.isUnique("door") + " -> false");
        System.out.println(obj.isUnique("cart") + " -> true");
        System.out.println(obj.isUnique("cake") + " -> true");
        System.out.println("===============================================");
        obj = new ValidWordAbbr(new String[]{"hello"});
        System.out.println(obj.isUnique("hello") + " -> true");
        System.out.println("===============================================");
        obj = new ValidWordAbbr(new String[]{"a","a"});
        System.out.println(obj.isUnique("a") + " -> true");
    }

    public static List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> integerMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            integerMap.put(nums[i], integerMap.getOrDefault(nums[i], 0) + 1);
        }
        return integerMap.entrySet().parallelStream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue())).map(Map.Entry::getKey).limit(k).collect(Collectors.toList());
    }

    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> set = new HashMap();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int sum = A[i] + B[j];
                set.put(sum, set.getOrDefault(sum, 0) + 1);
            }
        }
        int counter = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int cur = C[i] + D[j];
                if (set.containsKey(cur * -1)) {
                    counter += set.get(cur * -1);
                }
            }
        }
        return counter;
    }

    public static int lengthOfLongestSubstring(String s) {
        LinkedList<Character> characters = new LinkedList<>();
        int longest = 0;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (characters.contains(cur)) {
                longest = Math.max(longest, characters.size());
                while (characters.removeFirst() != cur) {
//                    Just loop through it till we reach the dublicate point.
                }
            }
            characters.add(cur);
        }
        return Math.max(longest, characters.size());
    }

    public static int numJewelsInStones(String J, String S) {
        int count = 0;
        for (int i = 0; i < S.length(); i++) {
            if (J.indexOf(S.charAt(i)) != -1) {
                count++;
            }
        }
        return count;
    }

    public static List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> stringListMap = new HashMap<>();
        for (String str : strings) {
            String seq = getSequence(str);
            List<String> stringList = stringListMap.getOrDefault(seq, new ArrayList<>());
            stringList.add(str);
            stringListMap.put(seq, stringList);
        }
        return new ArrayList<>(stringListMap.values());
    }

    private static String getSequence(String str) {
        if (str.length() == 1) {
            return "SINGLE";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length() - 1; i++) {
            char cur = str.charAt(i);
            char next = str.charAt(i + 1);
            if (cur - next > 0) {
                sb.append(cur - next - 26);
            } else {
                sb.append(cur - next);
            }
        }
        return sb.toString();
    }

    static List<TreeNode> output = new ArrayList<>();

    public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        if (root != null) {
            HashSet<TreeNode> visited = new HashSet<>();
            checkForDublicate(root, visited);
        }
        return output;
    }

    private static void checkForDublicate(TreeNode root, HashSet<TreeNode> visited) {
        if (root == null) return;
        checkForDublicate(root.left, visited);
        checkForDublicate(root.right, visited);
        if (visited.contains(root)) {
            if (!output.contains(root)) {
                output.add(root);
            }
        } else {
            visited.add(root);
        }
    }

    public static boolean isValidSudoku(char[][] board) {
        HashSet[] rowHash = new HashSet[9];
        HashSet[] colHash = new HashSet[9];
        HashSet[] innerHash = new HashSet[9];
        Arrays.fill(rowHash, new HashSet<Integer>());
        Arrays.fill(colHash, new HashSet<Integer>());
        Arrays.fill(innerHash, new HashSet<Integer>());

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                char cur = board[row][col];
                if (Character.isDigit(cur) && !isAtValidPosition(Character.getNumericValue(cur), row, col, rowHash, colHash, innerHash)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isAtValidPosition(int numericValue, int row, int col, HashSet[] rowHash, HashSet[] colHash, HashSet[] innerHash) {
//        Check row hash
        if (rowHash[row].contains(numericValue)) {
            return false;
        } else {
            HashSet<Integer> newHash = new HashSet<>(rowHash[row]);
            newHash.add(numericValue);
            rowHash[row] = newHash;
        }

//        Check col hash
        if (colHash[col].contains(numericValue)) {
            return false;
        } else {
            HashSet<Integer> newHash = new HashSet<>(colHash[col]);
            newHash.add(numericValue);
            colHash[col] = newHash;
        }

//        Check inner row
        int boxNumber = getBoxNumber(row, col);
        if (innerHash[boxNumber].contains(numericValue)) {
            return false;
        } else {
            HashSet<Integer> newHash = new HashSet<>(innerHash[boxNumber]);
            newHash.add(numericValue);
            innerHash[boxNumber] = newHash;
        }
        return true;
    }

    private static int getBoxNumber(int i, int j) {
        if (i >= 0 && i <= 2 && j >= 0 && j <= 2) return 0;
        if (i >= 3 && i <= 5 && j >= 0 && j <= 2) return 1;
        if (i >= 6 && i <= 8 && j >= 0 && j <= 2) return 2;
        if (i >= 0 && i <= 2 && j >= 3 && j <= 5) return 3;
        if (i >= 3 && i <= 5 && j >= 3 && j <= 5) return 4;
        if (i >= 6 && i <= 8 && j >= 3 && j <= 5) return 5;
        if (i >= 0 && i <= 2 && j >= 6 && j <= 8) return 6;
        if (i >= 3 && i <= 5 && j >= 6 && j <= 8) return 7;
        else return 8;
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> output = new ArrayList<>();
        if (strs == null || strs.length < 1) {
            return output;
        }
//        Keep a map of string to set a unique value for each character.
        String allchars = "abcdefghijklmnopqrstuvwxyz";
//        Map<Character, Integer> characterIntegerMap = new HashMap<>();
//        Random random = new Random();
//        for (int i = 0; i < allchars.length(); i++) {
//            characterIntegerMap.put(allchars.charAt(i), 26 * (i) + random.nextInt(999));
//        }
//        Map<Integer, List<String>> map = new HashMap<>();
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
//            int hash = getHash(strs[i], characterIntegerMap);
//            List<String> mapOrDefault = map.getOrDefault(hash, new ArrayList<>());
//            map.put(hash, mapOrDefault);
            String sorted = getSortedValue(strs[i]);
            List<String> mapOrDefault = map.getOrDefault(sorted, new ArrayList<>());
            mapOrDefault.add(strs[i]);
            map.put(sorted, mapOrDefault);
        }
        return new ArrayList<>(map.values());
    }

    private static String getSortedValue(String input) {
        char[] chars = input.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }

    private static int getHash(String str, Map<Character, Integer> characterIntegerMap) {
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            char cur = str.charAt(i);
            sum += characterIntegerMap.get(cur);
        }
        System.out.println("str = " + str + "\tsum = " + sum);
        return sum;
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length <= 1) return false;
        int pointer1 = 0;
        for (int i = 1; i < nums.length; i++) {
            if (i - pointer1 <= k && nums[pointer1] == nums[i]) {
                return true;
            }
            if (i - pointer1 > k) {
                while (pointer1 < i) {
                    if (i - pointer1 <= k && nums[pointer1] == nums[i]) {
                        return true;
                    }
                    pointer1++;
                }
            }
        }
        return false;
    }
}

class Logger {

    HashMap<String, Integer> map;

    /**
     * Initialize your data structure here.
     */
    public Logger() {
        map = new HashMap<>();
    }

    /**
     * Returns true if the message should be printed in the given timestamp, otherwise returns false.
     * If this method returns false, the message will not be printed.
     * The timestamp is in seconds granularity.
     */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (map.containsKey(message)) {
            Integer pastTimeStamp = map.get(message);
            if (timestamp - pastTimeStamp > 9) {
                map.put(message, timestamp);
                return true;
            }
            return false;
        } else {
            map.put(message, timestamp);
            return true;
        }
    }
}

class TwoSum {
    List<Integer> integerList;

    /**
     * Initialize your data structure here.
     */
    public TwoSum() {
        integerList = new ArrayList<>();
    }

    /**
     * Add the number to an internal data structure..
     */
    public void add(int number) {
        integerList.add(number);
    }

    /**
     * Find if there exists any pair of numbers which sum is equal to the value.
     */
    public boolean find(int value) {
        HashSet<Integer> integers = new HashSet<>();
        for (int i = 0; i < integerList.size(); i++) {
            int remaining = value - integerList.get(i);
            if (integers.contains(remaining)) {
                return true;
            }
            integers.add(integerList.get(i));
        }
        return false;
    }
}

class ValidWordAbbr {
    Map<String, Boolean> map;
    HashSet<String> strings;

    public ValidWordAbbr(String[] dictionary) {
        strings = new HashSet<>(Arrays.asList(dictionary));
        map = new HashMap<>();
        for (String str : strings) {
            String abbreviation = getAbbrivations(str);
            map.put(abbreviation,!map.containsKey(abbreviation));
        }
    }

    private String getAbbrivations(String str) {
        if (str.length() < 2) return str;
        return String.valueOf(str.charAt(0)) + (str.length() - 2) + str.charAt(str.length() - 1);
    }

    public boolean isUnique(String word) {
        String abbrivations = getAbbrivations(word);
        Boolean hasAbbr = map.get(abbrivations);
        return hasAbbr == null || (hasAbbr && strings.contains(word));
    }
}