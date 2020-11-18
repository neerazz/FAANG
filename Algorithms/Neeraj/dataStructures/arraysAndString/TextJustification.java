import java.util.*;

class TextJustification {
    public static void main(String[] args) {
        System.out.println("********************************** Soultion 1 **********************************");
        System.out.println(fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16));
        System.out.println(fullJustify(new String[]{"What", "must", "be", "acknowledgment", "shall", "be"}, 16));
        System.out.println(fullJustify(new String[]{"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain",
                "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"}, 20));
        System.out.println("********************************** Soultion 2 **********************************");
//        System.out.println(fullJustify_rev(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16));
//        System.out.println(fullJustify_rev(new String[]{"What", "must", "be", "acknowledgment", "shall", "be"}, 16));
        System.out.println(fullJustify_rev(new String[]{"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain",
                "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"}, 20));
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
            sb.append(getSpaces(meta[1]));
        } else {
            int dist = meta[1] / (words - 1), rem = meta[1] % (words - 1);
            for (int i = 0; i < strings.size() - 1; i++) {
                sb.append(strings.get(i)).append(getSpaces(dist));
                if (rem > 0) {
                    sb.append(" ");
                    rem--;
                }
            }
            sb.append(strings.get(words - 1));
        }
        return sb.toString();
    }

    private static String getSpaces(int len) {
        char[] chars = new char[len];
        Arrays.fill(chars, ' ');
        return String.valueOf(chars);
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
            sb.append(getSpaceString(totalSpaces));
        } else if (currLine == totalLine) {
            int spaceCount = 0;
            for (int i = 0; i < size - 1; i++) {
                sb.append(words.get(i));
                sb.append(" ");
                spaceCount++;
            }
            sb.append(words.get(size - 1));
            sb.append(getSpaceString(totalSpaces - spaceCount));
        } else {
            int perWordCount = totalSpaces / (size - 1);
            int rem = totalSpaces % (size - 1);
            for (int i = 0; i < size - 1; i++) {
                sb.append(words.get(i));
                if (rem > 0) {
                    sb.append(getSpaceString(perWordCount + 1));
                    rem--;
                } else {
                    sb.append(getSpaceString(perWordCount));
                }
            }
            sb.append(words.get(size - 1));
        }
        return sb.toString();
    }

    private static String getSpaceString(int count) {
        char[] chars = new char[count];
        Arrays.fill(chars, ' ');
        return new String(chars);
    }
}
