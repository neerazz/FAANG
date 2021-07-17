import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created on:  Jun 21, 2021
 * Ref: https://leetcode.com/problems/remove-comments/
 */

public class RemoveComments {

    public static void main(String[] args) {
        System.out.println(removeComments(new String[]{"class test{", "public: ", "   int x = 1;", "   /*double y = 1;*/", "   char c;", "};"}).stream().map(str -> "\"" + str + "\"").collect(Collectors.toList()));
        System.out.println(removeComments(new String[]{"struct Node{", "    /*/ declare members;/**/", "    int size;", "    /**/int val;", "};"}).stream().map(str -> "\"" + str + "\"").collect(Collectors.toList()));
        System.out.println(removeComments(new String[]{"/*comment", "line", "more_comment*/b"}).stream().map(str -> "\"" + str + "\"").collect(Collectors.toList()));
        System.out.println(removeComments(new String[]{"a/*comment", "line", "more_comment*/b"}).stream().map(str -> "\"" + str + "\"").collect(Collectors.toList()));
        System.out.println(removeComments(new String[]{"int a, b /* start", "line2", "*/", "//", "a//", "//"}).stream().map(str -> "\"" + str + "\"").collect(Collectors.toList()));
        System.out.println(removeComments(new String[]{"/*Test program */", "int main()", "{ ", "  // variable declaration ", "int a, b, c;", "/* This is a test", "   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}"}).stream().map(str -> "\"" + str + "\"").collect(Collectors.toList()));
    }

    private static List<String> removeComments_3(String[] source) {
//        Flatten the input source.
        String delimiter = "##";
        String flat = String.join(delimiter, source);
        int len = flat.length(), i = 0;
        StringBuilder sb = new StringBuilder();
        while (i < len) {
            if (i + 1 < len && flat.charAt(i) == '/') {
                if (flat.charAt(i + 1) == '/') {
//                    line comment has started, find the end of line and skip all the between current till the end of line.
                    while (i + 1 < len && !flat.substring(i, i + 2).equals(delimiter)) {
                        i++;
                    }
                    sb.append(delimiter);
                    i += 2;
                } else if (flat.charAt(i + 1) == '*') {
                    i += 2;
//                    block comment has started, find the end of block and skip all the characters.
                    while (i + 1 < len && !flat.substring(i, i + 2).equals("*/")) {
                        i++;
                    }
                    i += 2;
                } else {
                    sb.append(flat.charAt(i++));
                }
            } else {
                sb.append(flat.charAt(i++));
            }
        }
        String[] split = sb.toString().split(delimiter);
        System.out.println("split = " + Arrays.toString(split));
        return Arrays.stream(split).filter(string -> string.length() > 0).collect(Collectors.toList());
    }

    private static List<String> removeComments_2(String[] source) {
        List<String> result = new ArrayList<>();
        int len = source.length, i = 0;
        while (i < len) {
            StringBuilder sb = new StringBuilder();
            String cur = source[i];
            int[] comment = getCommentTypeAndIdx(cur);
//            0=no comments, 1 = //, 2 = /*
            if (comment[0] == 0) {
                sb.append(cur);
                i++;
            } else if (comment[0] == 1) {
                sb.append(cur, 0, comment[1]);
                i++;
            } else {
//                Its a block comment, Loop from cur till end and find the block comment ending.
                sb.append(cur, 0, comment[1]);
                int startBlockEnding = comment[1] + 2;
                while (i < len) {
                    String next = source[i++];
                    int blockEnding = getBlockEnding(next, startBlockEnding);
                    if (blockEnding == next.length()) {
//                        Block comment ending found at the end of the string.
                        break;
                    } else if (blockEnding >= 0) {
                        sb.append(next.substring(blockEnding + 1));
                        break;
                    }
                    startBlockEnding = 0;
                }
            }
            if (sb.length() > 0) result.add(sb.toString());
        }
        return result;
    }

    private static int getBlockEnding(String str, int startBlockEnding) {
        int len = str.length(), i = startBlockEnding;
        while (i < len - 1) {
            if (str.charAt(i) == '*' && str.charAt(i + 1) == '/') return i + 1;
            i++;
        }
        return -1;
    }

    private static int[] getCommentTypeAndIdx(String str) {
//            0=no comments, 1 = //, 2 = /*, 3 = */
        int type = 0, len = str.length(), idx = 0;
        for (int i = 0; i < len; i++) {
            char cur = str.charAt(i);
            if (i + 1 == len) continue;
            if (cur == '/') {
                char next = str.charAt(i + 1);
                if (next == '*') {
                    type = 2;
                    idx = i;
                    break;
                } else if (next == '/') {
                    type = 1;
                    idx = i;
                    break;
                }
            }
        }
        return new int[]{type, idx};
    }

    public static List<String> removeComments(String[] source) {
        List<String> result = new ArrayList<>();
        boolean inBlock = false;
        StringBuilder sb = new StringBuilder();
        for (String line : source) {
            for (int i = 0; i < line.length(); i++) {
                if (inBlock) {
//                    Check if there is a ending of teh block;
                    if (i + 1 < line.length() && line.charAt(i) == '*' && line.charAt(i + 1) == '/') {
                        inBlock = false;
//                        Increment the I, to ignore the '/'
                        i++;
                    }
                } else if (i + 1 < line.length() && line.charAt(i) == '/' && line.charAt(i + 1) == '/') {
                    break;
//                    Ignore the remaining chars.
                } else if (i + 1 < line.length() && line.charAt(i) == '/' && line.charAt(i + 1) == '*') {
                    inBlock = true;
//                        Increment the I, to ignore the '/'
                    i++;
                } else {
                    sb.append(line.charAt(i));
                }
            }
            if (!inBlock && sb.length() > 0) {
                result.add(sb.toString());
                sb = new StringBuilder();
            }
        }
        return result;
    }
}
