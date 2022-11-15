import java.util.*;

/**
 * Created on:  Nov 13, 2020
 * Questions: https://leetcode.com/problems/text-justification/
 */

class TextJustification {
    public static void main(String[] args) {
        System.out.println("********************************** Soultion 1 **********************************");
        System.out.println(fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16));
        System.out.println(fullJustify(new String[]{"What", "must", "be", "acknowledgment", "shall", "be"}, 16));
        System.out.println(fullJustify(new String[]{"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"}, 20));
        System.out.println(fullJustify(new String[]{"Science", "is", "what", "w", "understand", "well", "enough", "to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"}, 20));

        System.out.println("********************************** Solution 2 **********************************");
        System.out.println(fullJustify_rev(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16));
        System.out.println(fullJustify_rev(new String[]{"What", "must", "be", "acknowledgment", "shall", "be"}, 16));
        System.out.println(fullJustify_rev(new String[]{"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"}, 20));
        System.out.println(fullJustify_rev(new String[]{"Science", "is", "what", "w", "understand", "well", "enough", "to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"}, 20));

        System.out.println("********************************** Solution 3 **********************************");
        System.out.println(fullJustify_rev2(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16));
        System.out.println(fullJustify_rev2(new String[]{"What", "must", "be", "acknowledgment", "shall", "be"}, 16));
        System.out.println(fullJustify_rev2(new String[]{"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"}, 20));
        System.out.println(fullJustify_rev2(new String[]{"Science", "is", "what", "w", "understand", "well", "enough", "to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"}, 20));

        System.out.println("********************************** Solution 4 **********************************");
//        System.out.println(fullJustify_rev3(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16));
        System.out.println(fullJustify_rev3(new String[]{"What", "must", "be", "acknowledgment", "shall", "be"}, 16));
        System.out.println(fullJustify_rev3(new String[]{"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"}, 20));
        System.out.println(fullJustify_rev3(new String[]{"Science", "is", "what", "w", "understand", "well", "enough", "to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"}, 20));

        System.out.println("********************************** Solution 5 **********************************");
        System.out.println(fullJustify_rev4(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16));
        System.out.println(fullJustify_rev4(new String[]{"What", "must", "be", "acknowledgment", "shall", "be"}, 16));
        System.out.println(fullJustify_rev4(new String[]{"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"}, 20));
        System.out.println(fullJustify_rev4(new String[]{"Science", "is", "what", "w", "understand", "well", "enough", "to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"}, 20));

    }

    public static List<String> fullJustify_rev4(String[] words, int max) {
        int len = words.length;
        List<TextRow> rows = new ArrayList<>();
        int i = 0;
        while (i < len) {
            TextRow curRow = new TextRow(max);
            while (i < len && curRow.canInsert(words[i])) {
                curRow.insert(words[i++]);
            }
            rows.add(curRow);
        }
        List<String> result = new ArrayList<>();
        for (int j = 0; j < rows.size(); j++) {
            TextRow row = rows.get(j);
            if (j == rows.size() - 1) {
                String curRow = String.join(" ", row.words);
                result.add(curRow + " ".repeat(max - curRow.length()));
            } else {
                result.add(row.flat());
            }
        }
        return result;
    }

    static class TextRow {
        List<String> words;
        int chars, spaces, max;

        TextRow(int max) {
            words = new ArrayList<>();
            this.max = max;
        }

        boolean canInsert(String word) {
            int curLen = chars + spaces + (chars > 0 ? 1 : 0);
            return curLen + word.length() <= max;
        }

        void insert(String word) {
            words.add(word);
            spaces += chars > 0 ? 1 : 0;
            chars += word.length();
        }

        String flat() {
            int wordsCount = words.size();
            int spaces = max - chars;
            if (wordsCount == 1) {
                return words.get(0) + " ".repeat(spaces);
            }
            int split = wordsCount - 1;
            int each = spaces / split, rem = spaces % split;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < wordsCount - 1; i++) {
                sb.append(words.get(i));
                sb.append(" ".repeat(each));
                if (rem-- > 0) {
                    sb.append(" ");
                }
            }
            sb.append(words.get(wordsCount - 1));
            return sb.toString();
        }
    }

    public static List<String> fullJustify_rev3(String[] words, int max) {
        List<Line> lines = new ArrayList<>();
        Line pre = new Line();
        for (String word : words) {
            if (pre.canAdd(word, max)) {
                pre.add(word);
            } else {
                lines.add(pre);
                pre = new Line();
                pre.add(word);
            }
        }
        lines.add(pre);
        List<String> result = new ArrayList<>();
        int len = lines.size();
        for (int i = 0; i < len; i++) {
            StringBuilder sb = new StringBuilder();
            if (i < len - 1) {
                buildString(lines.get(i), max, sb);
            } else {
                for (String word : lines.get(i).words) {
                    if (sb.length() > 0) sb.append(" ");
                    sb.append(word);
                }
                int rem = max - sb.length();
                sb.append(empty(rem));
            }
            result.add(sb.toString());
        }
        return result;
    }

    static void buildString(Line line, int max, StringBuilder sb) {
//         0: spaces between each word, 1: un divided spaces, 2: gaps
        int[] spaces = line.spaces(max);
        int len = line.words.size();
        for (int i = 0; i < len; i++) {
            sb.append(line.words.get(i));
            if (i == len - 1) continue;
            int empty = spaces[0];
            if (spaces[1] > 0) {
                empty++;
                spaces[1]--;
            }
            sb.append(empty(empty));
        }
        sb.append(empty(max - sb.length()));
    }

    static String empty(int count) {
        char[] chars = new char[count];
        Arrays.fill(chars, ' ');
        return String.valueOf(chars);
    }

    public static List<String> fullJustify_rev2(String[] words, int maxWidth) {
        int len = words.length, i = 0;
        List<String> result = new ArrayList<>();
        while (i < len) {
            int chars = 0, spaces = 0;
            List<String> line = new ArrayList<>();
            while (i < len && chars + spaces + words[i].length() <= maxWidth) {
                String word = words[i++];
                chars += word.length();
                spaces++;
                line.add(word);
            }
//            We don't need an extra space for teh last word in line.
            spaces--;
            StringBuilder sb = new StringBuilder();
            if (i == len) {
                String lastLine = String.join(" ", line);
                sb.append(lastLine).append(fill(maxWidth - lastLine.length()));
            } else {
                int remaining = maxWidth - chars - spaces;
                int wordCount = line.size();
                if (wordCount == 1) {
                    String word = line.get(0);
                    sb.append(word);
                    sb.append(fill(spaces + remaining));
                } else {
                    int perWordSpace = (spaces + remaining) / (wordCount - 1), remainder = (spaces + remaining) % (wordCount - 1);
                    for (String word : line) {
                        sb.append(word);
                        if (wordCount-- > 1) {
                            sb.append(fill(perWordSpace + (remainder-- > 0 ? 1 : 0)));
                        }
                    }
                }
            }
            result.add(sb.toString());
        }
        return result;
    }

    private static char[] fill(int count) {
        char[] chars = new char[count];
        Arrays.fill(chars, ' ');
        return chars;
    }

    public static List<String> fullJustify_rev(String[] words, int maxWidth) {
        List<List<String>> lines = new ArrayList<>();
        List<int[]> meta = new ArrayList<>();
        int i = 0, chars = 0, spaces = 0;
        List<String> line = new ArrayList<>();
        while (i < words.length) {
            if (words[i].length() + chars + spaces <= maxWidth) {
                line.add(words[i]);
//                spaces += chars > 0 ? 1 : 0;
                spaces++;
                chars += words[i].length();
                i++;
            } else {
                lines.add(line);
                meta.add(new int[]{chars, maxWidth - chars});
                line = new ArrayList<>();
                chars = spaces = 0;
            }
        }
        lines.add(line);
        meta.add(new int[]{chars, maxWidth - chars});
        List<String> result = new ArrayList<>();
        for (i = 0; i < lines.size() - 1; i++) {
            result.add(buildString(lines.get(i), meta.get(i)));
        }
//        Left justify the last line
        String lastLine = String.format("%-" + maxWidth + "s", String.join(" ", lines.get(lines.size() - 1)));
        result.add(lastLine);
        return result;
    }

    private static String buildString(List<String> strings, int[] meta) {
        int words = strings.size();
        StringBuilder sb = new StringBuilder();
        if (words == 1) {
            sb.append(strings.get(0));
            sb.append(fill(meta[1]));
        } else {
            int dist = meta[1] / (words - 1), rem = meta[1] % (words - 1);
            for (int i = 0; i < strings.size() - 1; i++) {
                sb.append(strings.get(i)).append(fill(dist));
                if (rem > 0) {
                    sb.append(" ");
                    rem--;
                }
            }
            sb.append(strings.get(words - 1));
        }
        return sb.toString();
    }

    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> output = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        int currStringLength = 0, space = 0, lineCounter = 0;
        Map<Integer, List<String>> map = new HashMap<>();
        Map<Integer, Integer> lineCounterMap = new HashMap<>();
        for (String word : words) {
            // System.out.println("currStringLength=" + currStringLength + "space = " + space + " word=" + word);
            if (currStringLength + space + word.length() > maxWidth) {
                map.put(lineCounter, new ArrayList<>(temp));
                lineCounterMap.put(lineCounter, currStringLength);
                // Then reset the temp list, currStringLength, space.
                temp.clear();
                currStringLength = space = 0;
                lineCounter++;
            }
            temp.add(word);
            currStringLength += word.length();
            space++;
        }
        if (temp.size() > 0) {
            map.put(lineCounter, new ArrayList<>(temp));
            lineCounterMap.put(lineCounter, currStringLength);
        }
        // System.out.println("map = "+ map);
        // System.out.println("lineCounterMap = " + lineCounterMap);
        int lines = map.size();
        for (int i = 0; i < lines; i++) {
            if (map.containsKey(i)) {
                output.add(padListOfStrings(map.get(i), lineCounterMap.get(i), maxWidth, i, lineCounter));
            }
        }
        return output;
    }

    private static String padListOfStrings(List<String> words, int count, int maxCount, int currLine, int totalLine) {
        int totalSpaces = maxCount - count;
        int size = words.size();
        StringBuilder sb = new StringBuilder();
        if (size == 1) {
            sb.append(words.get(0));
            sb.append(fill(totalSpaces));
        } else if (currLine == totalLine) {
            int spaceCount = 0;
            for (int i = 0; i < size - 1; i++) {
                sb.append(words.get(i));
                sb.append(" ");
                spaceCount++;
            }
            sb.append(words.get(size - 1));
            sb.append(fill(totalSpaces - spaceCount));
        } else {
            int perWordCount = totalSpaces / (size - 1);
            int rem = totalSpaces % (size - 1);
            for (int i = 0; i < size - 1; i++) {
                sb.append(words.get(i));
                if (rem > 0) {
                    sb.append(fill(perWordCount + 1));
                    rem--;
                } else {
                    sb.append(fill(perWordCount));
                }
            }
            sb.append(words.get(size - 1));
        }
        return sb.toString();
    }

    static class Line {
        int chars, spaces;
        List<String> words = new ArrayList<>();

        boolean canAdd(String word, int max) {
            int curLen = chars + spaces + (chars > 0 ? 1 : 0);
            return curLen + word.length() <= max;
        }

        void add(String word) {
            if (chars > 0) spaces++;
            chars += word.length();
            words.add(word);
        }

        int[] spaces(int max) {
            int blank = max - chars;
            int gaps = words.size() - 1;
            if (gaps == 0) gaps = 1;
            return new int[]{blank / gaps, blank % gaps};
        }
    }
}
