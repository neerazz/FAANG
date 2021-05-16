package weekly.weekly194;

/**
 * Created on:  Jun 20, 2020
 * Questions: https://leetcode.com/problems/xor-operation-in-an-array/
 */
public class XOROperationInAnArray {
    public static void main(String[] args) {

    }

    public static int xorOperation(int n, int start) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int cur = start + 2 * i;
            sum = sum ^ cur;
        }
        return sum;
    }
}
