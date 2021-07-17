package concepts.arraysStrings;

public class BasicStringClass {

    public static void main(String[] args) {
        System.out.println("\"abc\".charAt(0) = " +  "abc".charAt(0));
        //lexicographically comapred
        System.out.println("\"abc\".compareTo(\"foo\") = " +  "abc".compareTo("abcd"));
        System.out.println("\"abc\".concat(\"def\") = " + "abc".concat("def"));
        System.out.println("\"abcdef\".contains(\"bcd\") = " + "abcdef".contains("bcd"));
        System.out.println("\"abc\".endsWith(\"bc\") = " + "abc".endsWith("bc"));
        System.out.println("\"abc\".indexOf(\"c\") = " + "abc".indexOf("c"));
        System.out.println("\"abcdefc\".indexOf(\"c\",3) = " + "abcdefc".indexOf("c",3));
        System.out.printf("abc".substring(2));
    }
}
