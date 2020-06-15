public class ContiguousArray {

    public static int findMaxLength(int[] nums) {
        int a = 0, b = 0; //a -> zero, b -> one
        for (int i : nums) {
            if (i == 0) a++;
            if (i == 1) b++;
        }

        int p1 = 0, p2 = nums.length - 1;
        while (p1 < p2) {
            if (a == b) return p2 - p1 + 1;
            if (nums[p1] == nums[p2]) {
                int val = nums[p1] == 0 ? --a : --b;
                p1++;
            } else if (a < b) { //More ones
                if (nums[p1] == 1) {
                    b--;
                    p1++;
                } else if (nums[p2] == 1) {
                    b--;
                    p2--;
                }
            } else { //More zeros
                if (nums[p1] == 0) {
                    a--;
                    p1++;
                } else if (nums[p2] == 0) {
                    a--;
                    p2--;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        //System.out.println(findMaxLength(new int[]{0, 1, 1}));
        System.out.println(findMaxLength(new int[]{0, 1, 1, 0, 1, 1, 1, 0}));
    }
}
