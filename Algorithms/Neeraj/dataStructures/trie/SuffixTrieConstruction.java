import java.util.*;

class SuffixTrieConstruction{
  public static void main(String[] args) {

  }
  static class TrieNode {
    Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
  }

  static class SuffixTrie {
    TrieNode root = new TrieNode();
    char endSymbol = '*';

    public SuffixTrie(String str) {
      populateSuffixTrieFrom(str);
    }

    public void populateSuffixTrieFrom(String str) {
      TrieNode rootref = root;
      int index =0;
      while(index < str.length()){
        char cur = str.charAt(index);
        TrieNode newNode = new TrieNode();
        rootref.children.put(cur,newNode);
        rootref = newNode;
        index++;
      }
      // At the end append *
      TrieNode newNode = new TrieNode();
      rootref.children.put('*',newNode);
    }

    public boolean contains(String str) {
      // Write your code here.
      return false;
    }
  }
}
