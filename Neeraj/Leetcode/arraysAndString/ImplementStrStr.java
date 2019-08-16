package arraysAndString;

/*
https://leetcode.com/explore/learn/card/array-and-string/203/introduction-to-string/1161/
 */
public class ImplementStrStr {
    public static void main(String[] args) {
        System.out.println("Answer is: " + strStr("hello","ll") + " should be 2");
        System.out.println("Answer is: " + strStr("aaaaa","bba") + " should be -1");
        System.out.println("Answer is: " + strStr("mississippi","issi") + " should be 1");
        System.out.println("Answer is: " + strStr("bbaa","aab") + " should be -1");
        System.out.println("Answer is: " + strStr("mississippi","issip") + " should be 4");
        System.out.println("Answer is: " + strStr("aaa","a") + " should be 0");
    }
    public static int strStr(String haystack, String needle) {
        int hayLength = haystack.length();
        int needleLength = needle.length();
        if (hayLength == needleLength) return haystack.equals(needle)?0:-1;
        if (needleLength == 0) return 0;
        if (hayLength < needleLength) return -1;
        if (needleLength ==1){
            return haystack.indexOf(needle);
        }

        char[] hayChars = haystack.toCharArray();
        char[] needleChars = needle.toCharArray();

        int index =0, index2 =1;
        while (index<hayLength){
            if (hayChars[index] == needleChars[0] && index+needleLength <= hayLength){
                int index3 = index+1;
                while (index2 < needleLength){
                    if (hayChars[index3] != needleChars[index2]){
                        break;
                    }
                    if (index2 == needleLength-1) return index;
                    index2++;
                    index3++;
                }
            }
            index2 =1;
            index++;
        }
        return -1;
    }
}
