package arraysAndString;

/*
https://leetcode.com/explore/learn/card/array-and-string/205/array-two-pointer-technique/1151/
 */
public class RemoveElement {
    public static void main(String[] args) {
        System.out.println("Answer is: " + removeElement(new int[]{3, 2, 2, 3}, 3) + " should be 2.");
        System.out.println("Answer is: " + removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2) + " should be 5.");
    }

    public static int removeElement(int[] nums, int val) {

        int counter = 0;
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            if (current != val) {
                nums[counter] = current;
                counter++;
            }
        }
        return counter;
    }
}
