package concepts.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> sol = new ArrayList<>();
        generate(n, 0, 0, "", sol);
        return sol;
    }

    public void generate(int n, int open, int close, String s, List<String> sol) {
        if (s.length() == n * 2) {
            sol.add(s);
            return;
        }
        if (open < n) {
            generate(n, open + 1, close, s + "(", sol);
        }
        if (close < open) {
            generate(n, open, close + 1, s + ")", sol);
        }
    }

}
