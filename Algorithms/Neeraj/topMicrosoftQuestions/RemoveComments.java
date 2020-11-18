import java.util.*;
import java.io.*;

/**
 * Created on:  Nov 18, 2020
 * Questions: https://leetcode.com/problems/remove-comments/
 */

public class RemoveComments {

    public static void main(String[] args) {
        System.out.println(removeComments(new String[]{"class test{", "public: ", "   int x = 1;", "   /*double y = 1;*/", "   char c;", "};"}));
        System.out.println(removeComments(new String[]{"struct Node{", "    /*/ declare members;/**/", "    int size;", "    /**/int val;", "};"}));
        System.out.println(removeComments(new String[]{"/*comment", "line", "more_comment*/b"}));
        System.out.println(removeComments(new String[]{"a/*comment", "line", "more_comment*/b"}));
        System.out.println(removeComments(new String[]{"int a, b /* start", "line2", "*/", "//", "a//", "//"}));
        System.out.println(removeComments(new String[]{"/*Test program */", "int main()", "{ ", "  // variable declaration ", "int a, b, c;", "/* This is a test", "   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}"}));
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
