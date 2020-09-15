import java.util.Stack;

/**
 * Created on:  Sep 14, 2020
 * Questions: https://www.algoexpert.io/questions/Shorten%20Path
 */
public class ShortenPath {
    public static void main(String[] args) {
//        System.out.println(shortenPath("/foo/../test/../test/../foo//bar/./baz" + " = /foo/bar/baz"));
//        System.out.println(shortenPath("foo/bar/baz") + " = foo/bar/baz");
//        System.out.println(shortenPath("/../../foo/bar/baz") + " = /foo/bar/baz");
//        System.out.println(shortenPath("../../../this////one/./../../is/../../going/../../to/be/./././../../../just/eight/double/dots/../../../../../../foo") + " = ../../../../../../../../foo");
        System.out.println(shortenPath("/../../../this////one/./../../is/../../going/../../to/be/./././../../../just/a/forward/slash/../../../../../..") + " = /");
    }

    public static String shortenPath(String path) {
        if (path.length() == 0) return path;
        Stack<String> stack = new Stack<>();
        if (path.charAt(0) == '/') stack.add("");
        String[] split = path.split("/");
        for (String val : split) {
            if (val.length() == 0 || val.equals("/") || val.equals(".")) continue;
            if (val.equals("..")) {
                if (stack.isEmpty() || stack.peek().equals("..")) stack.add(val);
                else if (stack.peek().equals("")) continue;
                else stack.pop();
            } else {
                stack.add(val);
            }
        }
        if (stack.size() == 1 && stack.peek().equals("")) return "/";
        return String.join("/", stack);
    }
}
