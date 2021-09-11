import java.util.*;

class WordCountEngine {

    static String[][] wordCountEngine(String document) {
        Map<String, Integer> map = new LinkedHashMap<>();
        int max = Integer.MIN_VALUE;
        for (String str : document.split(" ")) {
            String modified = str.replaceAll("[,'!.;:?]", "").toLowerCase().trim();
            if (modified.length() > 0) {
                int count = map.getOrDefault(modified, 0) + 1;
                map.put(modified, count);
                max = Math.max(max, count);
            }
        }

        int size = map.size();
        List[] lists = new ArrayList[size];
        // Fill the list with default values.
        for (int i = 0; i < size; i++) {
            List<String> list = new ArrayList<>();
            lists[i] = list;
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int i = entry.getValue() - 1;
            List<String> temp = lists[i];
            temp.add(entry.getKey());
            lists[i] = temp;
        }

        String[][] op = new String[size][2];
        int index = 0;
        for (int i = size - 1; i >= 0; i--) {
            List<String> temp = lists[i];
            if (temp.size() > 0) {
                int j = i + 1;
                for (String str : temp) {
                    op[index][0] = str;
                    op[index][1] = "" + j;
                    index++;
                }
            }
        }
        return op;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(wordCountEngine("Practice makes perfect. you'll only get Perfect by practice. just practice!")));
    }

}
