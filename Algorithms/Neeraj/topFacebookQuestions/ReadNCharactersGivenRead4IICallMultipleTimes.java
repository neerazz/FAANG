/**
 * Created on:  Jul 22, 2020
 * Questions: https://leetcode.com/problems/read-n-characters-given-read4-ii-call-multiple-times/
 */
public class ReadNCharactersGivenRead4IICallMultipleTimes {

    public char[] buf4 = new char[4];
    private int buf4Pointer = 0;
    private int buf4Counter = 0;

    public static void main(String[] args) {

    }

    private static int read4(char[] buf4) {
//        This api is provided, this return the number of characters that was read.
        return 0;
    }

    public int read(char[] buf, int n) {
        int cur = 0;
        while (cur < n) {
//            Check if any char was left out from the previous read.
            if (buf4Pointer == 4) {
//                Read again only if no any char in previously read is left out.
                buf4Counter = read4(buf4);
            }
//            If the count after reading is zero then you can break.
            if (buf4Counter == 0) break;
            while (cur < n && buf4Pointer < buf4Counter) {
                buf[cur++] = buf4[buf4Pointer++];
            }
//            When the buffer pointer reaches the count then reset the buff pointer.
            if (buf4Pointer >= buf4Counter) buf4Pointer = 0;
        }
        return cur;
    }
}
