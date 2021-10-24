import java.util.ArrayList;
import java.util.List;

class DeletionDistance {

    static int deletionDistance_wrong(String str1, String str2) {
        if (str1 == null && str2 == null) return 0;
        if (str1 != null && str2 == null) return str1.length();
        if (str2 != null && str1 == null) return str2.length();
        List<Character> list = new ArrayList<>();
        for (char c : str1.toCharArray()) {
            list.add(c);
        }
        int del = 0;
        for (char c : str2.toCharArray()) {
            if (list.contains(c)) {
                list.remove((Character) c);
            } else {
                del++;
            }
        }
        return del + list.size();
    }

    // O(m*n), O(m*n)
    static int deletionDistance(String str1, String str2) {
        if (str1 == null && str2 == null) return 0;
        if (str1 != null && str2 == null) return str1.length();
        if (str2 != null && str1 == null) return str2.length();
        int m = str1.length(), n = str2.length();
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= str1.length(); i++) {
            dp[i][0] = i;
        }

        for (int j = 1; j <= str2.length(); j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + 1;
                }
            }
        }
        return dp[str1.length()][str2.length()];
    }

    public static void main(String[] args) {
        System.out.println(deletionDistance("dogggg", "frog"));
        System.out.println(deletionDistance("some", "thing"));
        System.out.println(deletionDistance("", ""));
    }

}


/*

   a  b
   0 1
b0
a1

s = "ab"
t = "ba"

dp[i][j] : the min num deletion to make the previous i of "ab" and previous j of "ba" teh same

if s[i-1] == t[j-1] :
  dp[i][j] = dp[i-1][j-1];
else{
dp[i][j] = min(dp[i][j-1]+1, dp[i-1][j]+1)
}

 dp[i][j] = min(dp)
/*

Set<Character> set;

int dels
Loop thorough first string.

Loop though second:
if(!present){
dels++;
}else{
set.delete(cur)
}

return dels + set.size();

Ex:
set = [d,o,g]

loop though frog:
f not in set , d=1
r not in set, d=2
0 in set, delete 0 , set =[d,g]
g in set , delet g, set = [d]

*/
