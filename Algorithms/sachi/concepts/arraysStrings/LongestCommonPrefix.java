import java.util.Scanner;

//TODO: Can you check binary solution - It might be faster.
public class LongestCommonPrefix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = scanner.nextLine();
        }
        System.out.println(longestCommonPrefix(strs));
        scanner.close();
    }

    private static String longestCommonPrefix(String[] strs) {
        StringBuffer lcp = new StringBuffer();
        if (strs == null || strs.length == 0) {
            return lcp.toString();
        }
        if (strs.length == 1) {
            return strs[0];
        }
        int index = 0;
        for (char c : strs[0].toCharArray()) {
            for (int i = 1; i < strs.length; i++) {
                if (index >= strs[i].length() || c != strs[i].charAt(index)) {
                    return lcp.toString();
                }
            }
            index++;
            lcp.append(c);
        }
        return lcp.toString();
    }
}