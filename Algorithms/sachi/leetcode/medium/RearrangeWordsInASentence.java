import java.util.*;

public class RearrangeWordsInASentence {

    public static String arrangeWords(String text) {
        String[] words = text.split(" ");
        List<Integer> lengths = new ArrayList<>();
        Map<Integer, List<String>> map = new HashMap<>();
        int counter = 0;
        for (String word : words) {
            int wl = word.length();
            if (!map.containsKey(wl)) {
                lengths.add(wl);
            }
            map.putIfAbsent(wl, new ArrayList<String>());
            List<String> innerList;
            innerList = map.get(wl);
            innerList.add(word);
            map.put(wl, innerList);
        }

        Collections.sort(lengths);

        //Rearrange
        StringBuilder sb = new StringBuilder();
        for (Integer num : lengths) {
            List<String> list = map.get(num);
            for (String s : list) {
                if (sb.length() == 0) {
                    //convert forst char to big
                    String first = "" + s.charAt(0);
                    sb.append(first.toUpperCase());
                } else {
                    //convert first char to small
                    String first = "" + s.charAt(0);
                    sb.append(first.toLowerCase());
                }
                if (s.length() > 1) {
                    sb.append(s.substring(1, s.length()));
                }
                sb.append(" ");
            }
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(arrangeWords("Leetcode is cool"));
    }
}
