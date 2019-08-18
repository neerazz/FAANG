import java.util.*;

/*
https://www.hackerrank.com/challenges/java-string-tokens/problem?h_r=next-challenge&h_v=zen
 */
public class JavaStringTokens {
    private static final Set<String> CS = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(" ", "?", "\'", "!", ",", ".", "_", "@", "")));

    public static void main(String[] args) {
        splitIntoTokens("He is a very very good boy, isn't he?");
        splitIntoTokens("YES leading spaces are valid, problemsetters are evillllll");
    }

    private static void splitIntoTokens(String s) {
        List<String> tokens = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isBreaker(c)) {
                String substring = s.substring(index, i);
                if (!isBreaker(substring)) tokens.add(substring);
                index = i + 1;
            }
        }
        String substring = s.substring(index);
        if (!isBreaker(substring)) tokens.add(substring);
        System.out.println(tokens.size());
        tokens.forEach(System.out::println);
    }

    private static boolean isBreaker(char c) {
        return CS.contains(String.valueOf(c));
    }

    private static boolean isBreaker(String c) {
        return CS.contains(c);
    }
}
