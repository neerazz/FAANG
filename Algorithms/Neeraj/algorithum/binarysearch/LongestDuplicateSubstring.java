import java.util.HashSet;
import java.util.Set;

/**
 * Created on:  Jun 19, 2020
 * Questions: https://leetcode.com/problems/longest-duplicate-substring/
 */
public class LongestDuplicateSubstring {
    public static void main(String[] args) {
        System.out.println(longestDupSubstring("moplvidmaagmsiyyrkchbyhivlqwqsjcgtumqscmxrxrvwsnjjvygrelcbjgbpounhuyealllginkitfaiviraqcycjmskrozcdqylbuejrgfnquercvghppljmojfvylcxakyjxnampmakyjbqgwbyokaybcuklkaqzawageypfqhhasetugatdaxpvtevrigynxbqodiyioapgxqkndujeranxgebnpgsukybyowbxhgpkwjfdywfkpufcxzzqiuglkakibbkobonunnzwbjktykebfcbobxdflnyzngheatpcvnhdwkkhnlwnjdnrmjaevqopvinnzgacjkbhvsdsvuuwwhwesgtdzuctshytyfugdqswvxisyxcxoihfgzxnidnfadphwumtgdfmhjkaryjxvfquucltmuoosamjwqqzeleaiplwcbbxjxxvgsnonoivbnmiwbnijkzgoenohqncjqnckxbhpvreasdyvffrolobxzrmrbvwkpdbfvbwwyibydhndmpvqyfmqjwosclwxhgxmwjiksjvsnwupraojuatksjfqkvvfroqxsraskbdbgtppjrnzpfzabmcczlwynwomebvrihxugvjmtrkzdwuafozjcfqacenabmmxzcueyqwvbtslhjeiopgbrbvfbnpmvlnyexopoahgmwplwxnxqzhucdieyvbgtkfmdeocamzenecqlbhqmdfrvpsqyxvkkyfrbyolzvcpcbkdprttijkzcrgciidavsmrczbollxbkytqjwbiupvsorvkorfriajdtsowenhpmdtvamkoqacwwlkqfdzorjtepwlemunyrghwlvjgaxbzawmikfhtaniwviqiaeinbsqidetfsdbgsydkxgwoqyztaqmyeefaihmgrbxzyheoegawthcsyyrpyvnhysynoaikwtvmwathsomddhltxpeuxettpbeftmmyrqclnzwljlpxazrzzdosemwmthcvgwtxtinffopqxbufjwsvhqamxpydcnpekqhsovvqugqhbgweaiheeicmkdtxltkalexbeftuxvwnxmqqjeyourvbdfikqnzdipmmmiltjapovlhkpunxljeutwhenrxyfeufmzipqvergdkwptkilwzdxlydxbjoxjzxwcfmznfqgoaemrrxuwpfkftwejubxkgjlizljoynvidqwxnvhngqakmmehtvykbjwrrrjvwnrteeoxmtygiiygynedvfzwkvmffghuduspyyrnftyvsvjstfohwwyxhmlfmwguxxzgwdzwlnnltpjvnzswhmbzgdwzhvbgkiddhirgljbflgvyksxgnsvztcywpvutqryzdeerlildbzmtsgnebvsjetdnfgikrbsktbrdamfccvcptfaaklmcaqmglneebpdxkvcwwpndrjqnpqgbgihsfeotgggkdbvcdwfjanvafvxsvvhzyncwlmqqsmledzfnxxfyvcmhtjreykqlrfiqlsqzraqgtmocijejneeezqxbtomkwugapwesrinfiaxwxradnuvbyssqkznwwpsbgatlsxfhpcidfgzrc"));
    }

    public static String longestDupSubstring(String S) {
//        set = new HashSet<>();
        int start = 0, end = S.length() - 1;
        String op = "";
        while (start < end) {
            int mid = start + (end - start) / 2;
            String duplicate = getDuplicate(S, mid);
            if (duplicate != null) {
                if (duplicate.length() > op.length()) {
                    op = duplicate;
                }
                start = mid;
            } else {
                end = mid - 1;
            }
        }
        return op;
    }

    //    static final long CONST = 256;
//    static final long MAX = (1 << 31) -1;
//    static Set<Long> set;
//    private static String getDuplicate_rollingHash(String input, int len) {
//        long cur = 1;
//        for(int i=0; i<len; i++) {
//            cur = ((CONST * cur) % MAX) + input.charAt(i);
//        }
//        int start =0;
//        for (int i = len; i < input.length(); i++) {
//            cur = ((CONST * cur) % MAX) + input.charAt(i);
//            if(!set.add(cur)){
//                return input.substring(start, i+1);
//            }
//            cur = (cur + CONST - )
//        }
//    }
    private static String getDuplicate(String input, int len) {
        Set<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder(input.substring(0, len));
        for (int i = len; i < input.length(); i++) {
            sb.append(input.charAt(i));
            if (!set.add(sb.toString())) {
                return sb.toString();
            }
            sb.deleteCharAt(0);
        }
        return null;
    }
}
