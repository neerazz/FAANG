package ds.trie;

import java.util.Arrays;
import java.util.List;

public class ReplaceWords {
    public static void main(String[] args) {
        System.out.println("Input   : the cattle was rattled by the battery");
        System.out.print("Output 1: ");
        System.out.println(replaceWords(Arrays.asList("cat", "bat", "rat"), "the cattle was rattled by the battery"));
        System.out.print("Output 2: ");
        Solution solution = new Solution();
        System.out.println(solution.replaceWords(Arrays.asList("cat", "bat", "rat"), "the cattle was rattled by the battery"));
    }

    public static String replaceWords(List<String> dict, String sentence) {
        String[] strings = sentence.split(" ");
        for (int i = 0; i < strings.length; i++) {
            strings[i] = findTheprefixAndReplace(dict, strings[i]);
        }
        return String.join(" ", strings);
    }

    private static String findTheprefixAndReplace(List<String> dict, String string) {
        return dict.stream().filter(string::startsWith).findFirst().orElse(string);
    }

    //    Tier node.
    static class Solution {
        TrieNode root = new TrieNode();

        public String replaceWords(List<String> dict, String sentence) {
            dict.forEach(this::insert);
            String[] strings = sentence.split(" ");
            TrieNode trieNode = root;
            for (int i = 0; i < strings.length; i++) {
                strings[i] = findSuffix(trieNode, strings[i]);
            }
            return String.join(" ", strings);
        }

        private String findSuffix(TrieNode cur, String word) {
            StringBuilder stringBuilder = new StringBuilder();
            for (char c : word.toCharArray()) {
                stringBuilder.append(c);
                if (cur.children[c - 'a'] != null) {
                    if (cur.children[c - 'a'].isEnd) return stringBuilder.toString();
                    cur = cur.children[c - 'a'];
                } else break;
            }
            return word;
        }

        public void insert(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }
            node.item = word;
            node.isEnd = true;
        }

        class TrieNode {
            String item = "";
            TrieNode[] children = new TrieNode[26];
            boolean isEnd = false;
        }
    }
}