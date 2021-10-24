import java.util.Stack;

/**
 * Created on:  Sep 21, 2020
 * Questions: https://leetcode.com/problems/tag-validator/
 */
public class TagValidator {
    public static void main(String[] args) {
        System.out.println("*********************************** Solution 1 **********************************");
        System.out.println(isValid("<A><A></A></A>") + " true");
        System.out.println(isValid("<A></A>") + " true");
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

        System.out.println("*********************************** Solution 2 **********************************");
        System.out.println(isValid_rev1("<A><A></A></A>") + " true");
        System.out.println(isValid_rev1("<A></A>") + " true");
        System.out.println(isValid_rev1("<DIV>This is the first line <![CDATA[<div>]]></DIV>") + " true");
        System.out.println(isValid_rev1("<DIV>>>  ![cdata[]] <![CDATA[<div>]>]]>]]>>]</DIV>") + " true");
        System.out.println(isValid_rev1("<TRUE><![CDATA[wahaha]]]><![CDATA[]> wahaha]]></TRUE>") + " true");
        System.out.println(isValid_rev1("123456") + " false");
        System.out.println(isValid_rev1("<A>  <B> </A>   </B>") + " false");
        System.out.println(isValid_rev1("<A></A><B></B>") + " false");
        System.out.println(isValid_rev1("<![CDATA[wahaha]]]><![CDATA[]> wahaha]]>") + " false");
        System.out.println(isValid_rev1("<DIV>  div tag is not closed  <DIV>") + " false");
        System.out.println(isValid_rev1("<DIV>  unmatched <  </DIV>") + " false");
        System.out.println(isValid_rev1("<DIV> closed tags with invalid tag name  <b>123</b> </DIV>") + " false");
        System.out.println(isValid_rev1("<DIV> unmatched tags with invalid tag name  </1234567890> and <CDATA[[]]>  </DIV>") + " false");
        System.out.println(isValid_rev1("<DIV>  unmatched start tag <B>  and unmatched end tag </C>  </DIV>") + " false");
    }

    public static boolean isValid_rev1(String code) {
        int len = code.length(), i = 0, tagsCount = 0, content = 0;
        Stack<String> stack = new Stack<>();
        while (i < len) {
            char cur = code.charAt(i);
            if (cur == '<') {
                if (i + 1 >= len) return false;
                if (code.charAt(i + 1) == '/') {
//                     Start of ending tag.
                    int idx = code.indexOf(">", i + 2);
                    if (idx == -1) return false;
                    String tagName = code.substring(i + 2, idx);
                    if (stack.isEmpty() || !stack.pop().equals(tagName)) return false;
                    if (tagName.length() > 9 || tagName.length() < 1 || !tagName.toUpperCase().equals(tagName))
                        return false;
                    content += stack.isEmpty() ? 0 : 1;
                    i = idx + 1;
                } else if (code.substring(i).startsWith("<![CDATA[")) {
//                     This is cdata, It should always be followed with a tag.
                    if (stack.isEmpty()) return false;
                    int idx = code.indexOf("]]>", i);
                    if (idx == -1) return false;
                    content++;
                    i = idx + 3;
                } else if (Character.isUpperCase(code.charAt(i + 1))) {
//                     This is start of tag
                    int idx = code.indexOf(">", i + 1);
                    if (idx == -1) return false;
                    String tagName = code.substring(i + 1, idx);
                    if (tagName.length() > 9 || tagName.length() < 1 || !tagName.toUpperCase().equals(tagName))
                        return false;
                    stack.add(tagName);
                    tagsCount++;
                    i = idx + 1;
                } else {
//                    Having a random < is not allowed.
                    return false;
                }
            } else {
                content++;
                i++;
            }
        }
        return stack.isEmpty() && tagsCount > 0 && content > 0;
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
