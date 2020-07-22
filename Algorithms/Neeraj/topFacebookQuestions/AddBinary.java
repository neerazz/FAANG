/**
 * Created on:  Jul 20, 2020
 * Questions:
 */
public class AddBinary {
    public static void main(String[] args) {

    }

    public String addBinary(String a, String b) {
        int p1 = a.length() - 1, p2 = b.length() - 1, carry = 0;
        StringBuilder op = new StringBuilder();
        while (p1 >= 0 || p2 >= 0) {
            int v1 = p1 >= 0 ? a.charAt(p1--) - '0' : 0;
            int v2 = p2 >= 0 ? b.charAt(p2--) - '0' : 0;
            op.insert(0, (v1 + v2 + carry) % 2);
            carry = (v1 + v2 + carry) / 2;
        }
        if (carry > 0) op.insert(0, carry);
        return op.toString();
    }
}
