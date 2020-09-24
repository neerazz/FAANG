import java.util.Stack;

/**
 * Created on:  Sep 21, 2020
 * Questions: https://leetcode.com/problems/tag-validator/
 */
public class TagValidator {
    public static void main(String[] args) {

        System.out.println(isValid("<A><A></A></A>") + " true");
        System.out.println(isValid("<DIV>This is the first line <![CDATA[<div>]]></DIV>") + " true");
        System.out.println(isValid("<DIV>>>  ![cdata[]] <![CDATA[<div>]>]]>]]>>]</DIV>") + " true");
        System.out.println(isValid("<TRUE><![CDATA[wahaha]]]><![CDATA[]> wahaha]]></TRUE>") + " true");
        System.out.println(isValid("123456") + " false");
        System.out.println(isValid("<A>  <B> </A>   </B>") + " false");
        System.out.println(isValid("<A></A><B></B>") + " false");
        System.out.println(isValid("<![CDATA[wahaha]]]><![CDATA[]> wahaha]]>") + " false");
        System.out.println(isValid("<DIV>  div tag is not closed  <DIV>") + " false");
        System.out.println(isValid("<DIV>  unmatched <  </DIV>") + " false");
        System.out.println(isValid("<DIV> closed tags with invalid tag name  <b>123</b> </DIV>") + " false");
        System.out.println(isValid("<DIV> unmatched tags with invalid tag name  </1234567890> and <CDATA[[]]>  </DIV>") + " false");
        System.out.println(isValid("<DIV>  unmatched start tag <B>  and unmatched end tag </C>  </DIV>") + " false");
    }

    public static boolean isValid(String code) {
        int idx = 0, len = code.length();
        boolean containsData = false;
        Stack<String> stack = new Stack<>();
        while (idx < len) {
            if (code.charAt(idx) == '<') {
                if (idx++ >= len) return false;
                if (code.charAt(idx) == '/') {
//                    Then it is a closing tag
                    int[] idxs = {++idx, len};
                    String tag = getTagName(code, idxs);
                    if (tag == null || tag.length() < 1 || tag.length() > 9) return false;
                    if (stack.isEmpty() || !stack.pop().equals(tag)) return false;
                    idx = idxs[1];
                } else if (code.charAt(idx) == '!') {
//                    Then it is a cdata, and cdata should always be enclosed in a tag
                    if (stack.isEmpty()) return false;
                    containsData = true;
                    boolean repeat = true, completed = false;
                    while (repeat) {
                        while (idx < len && code.charAt(idx) != ']') {
                            idx++;
                        }
//                        cdata format is : <![CDATA[ and the first subsequent ]]>.
//                          Once you reach ']' character you have validate for the next two chars to be "]>" if so exit.
                        if (idx + 2 >= len) return false;
                        if (code.charAt(idx + 1) == ']' && code.charAt(idx + 2) == '>') {
                            completed = true;
                            repeat = false;
                            idx += 3;
                        } else {
                            idx++;
                            repeat = true;
                        }
                    }
                    if (!completed) return false;
                } else if (Character.isUpperCase(code.charAt(idx))) {
//                    It is an opening tag
                    int[] idxs = {idx, len};
                    String tag = getTagName(code, idxs);
                    if (tag == null || tag.length() < 1 || tag.length() > 9) return false;
                    stack.add(tag);
                    idx = idxs[1];
                } else return false;
            } else {
                containsData = containsData || !stack.isEmpty();
                idx++;
            }
        }
        return stack.isEmpty() && containsData;
    }

    private static String getTagName(String code, int[] idxs) {
        int i = idxs[0], len = idxs[1];
        while (i < len && code.charAt(i) != '>') {
            if (!Character.isUpperCase(code.charAt(i++))) return null;
        }
        idxs[1] = i + 1;
        return code.substring(idxs[0], i);
    }
}
