package revision;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ArraysAndString {
    public static void main(String[] args) {
//        System.out.println(pivotIndex(new int[]{1, 7, 3, 6, 5, 6}) + " should be [3].");
//        System.out.println(dominantIndex(new int[]{3, 6, 1, 0}) + " shopuld be [6]");
//        System.out.println(dominantIndex(new int[]{0,0,1,2}) + " shopuld be [3]");
//        System.out.println(Arrays.toString(plusOne(new int[]{9})));
//        System.out.println(Arrays.toString(findDiagonalOrder(new int[][]{
//                {1, 2, 3},
//                {4, 5, 6},
//                {7, 8, 9}})));
//        System.out.println(spiralOrder(new int[][]{
//                {1, 2, 3},
//                {4, 5, 6},
//                {7, 8, 9}}));
//        System.out.println(spiralOrder(new int[][]
//                {
//                        {1, 2, 3, 4},
//                        {5, 6, 7, 8},
//                        {9, 10, 11, 12}
//                }
//        ));
//        System.out.println(generate(5));
//        System.out.println(addBinary("11", "1"));
////        System.out.println(addBinary("1010", "1011"));
//        System.out.println(addBinary("1111", "1111"));
//        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
//        char[] chars = {'h', 'e', 'l', 'l', 'o'};
//        reverseString(chars);
//        System.out.println(Arrays.toString(chars));
//        System.out.println(arrayPairSum(new int[]{1, 4, 3, 2}));
//        System.out.println(arrayPairSum(new int[]{1, 1}));
//        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
//        int[] input = {0, 1, 2, 2, 3, 0, 4, 2};
//        System.out.println(removeElement(input,2) + " Array value is :" + Arrays.toString(input));
//        input = new int[]{3,2,2,3};
//        System.out.println(removeElement(input,3) + " Array value is :" + Arrays.toString(input));
//        System.out.println(findMaxConsecutiveOnes(new int[]{1,1,0,1,1,1}));
//        System.out.println(minSubArrayLen(7,new int[]{2,3,1,2,4,3}));
//        System.out.println(minSubArrayLen(4,new int[]{1,4,4}));
//        System.out.println(minSubArrayLen(11,new int[]{1,2,3,4,5}));
//        int[] input = {1,2,3,4,5,6,7};
//        rotate(input,3);
//        System.out.println(Arrays.toString(input));
//        System.out.println(getRow(3));
//        int[] input = new int[]{0,0,1,1,1,2,2,3,3,4};
//        System.out.println(removeDuplicates(input) + ".\t" + Arrays.toString(input));
//        input = new int[]{1,1,2};
//        System.out.println(removeDuplicates(input) + ".\t" + Arrays.toString(input));
        int[] input = {0,1,0,3,12};
        moveZeroes(input);
        System.out.println(Arrays.toString(input));
    }

    public static void moveZeroes(int[] nums) {
        int length = nums.length-1, zeroPointer = 0, index =0;
        while (index <= length){
            if (nums[index] != 0){
                nums[zeroPointer] = nums[index];
                zeroPointer++;
            }
            index++;
        }
        for (int i = zeroPointer; i <= length; i++) {
            nums[i] = 0;
        }
    }

    private static void swap(int[] nums, int src, int dest) {

    }

    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int count = 1, prev = nums[0], nonDuplicate = 1;
        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            if (prev != cur){
                nums[nonDuplicate++] = cur;
                count++;
            }
            prev = cur;
        }
        return count;
    }

    public static List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0){
            return Collections.singletonList(1);
        }
        if (rowIndex == 1){
            return Arrays.asList(1,1);
        }
        List<Integer> integers = getRow(rowIndex - 1);
        List<Integer> newList = new ArrayList<>();
        newList.add(1);
        for (int i = 0; i < integers.size()-1; i++) {
            newList.add(integers.get(i) + integers.get(i+1));
        }
        newList.add(1);
        return newList;
    }

    public static void rotate(int[] nums, int k) {
        int size = nums.length, noOfRotations = k % size;
        int[] newarray = new int[noOfRotations];
        System.arraycopy(nums,size-noOfRotations,newarray,0,noOfRotations);
        int start = size-noOfRotations-1;
        for (int i = size-1; i >= noOfRotations; i--) {
            nums[i] = nums[start--];
        }
        System.arraycopy(newarray, 0, nums, 0, noOfRotations);
    }

    public static int minSubArrayLen(int s, int[] nums) {
        int minSubArrayValue = Integer.MAX_VALUE, sum =0, left =0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= s) {
                minSubArrayValue = Math.min(minSubArrayValue, i + 1 - left);
                sum -= nums[left++];
            }
        }
        return minSubArrayValue== Integer.MAX_VALUE ? 0 : minSubArrayValue;
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, pointer1 = Integer.MIN_VALUE , currentSum = 0;
        for (int pointer2 = 0; pointer2 < nums.length; pointer2++) {
            if (nums[pointer2] == 1){
                currentSum++;
                pointer1 = pointer1 == Integer.MIN_VALUE ? pointer2 : pointer1;
            }else {
                max = Math.max(currentSum, max);
                currentSum = 0;
                pointer1 = Integer.MIN_VALUE;
            }
        }
        return Math.max(currentSum, max);
    }

    public static int removeElement(int[] nums, int val) {
        int elements = 0, index = 0, size = nums.length-1, swapIndex = size;
        while (index < size && index < swapIndex){
            if (nums[index] == val){
//                swap the current with the swapindex.
                if (nums[swapIndex] == val){
                    nums[swapIndex] = 0;
                    swapIndex--;
                }
                nums[index] = nums[swapIndex];
                nums[swapIndex] = 0;
            }else {
                elements++;
            }
            index++;
        }
        return elements;
    }

    public static int[] twoSum(int[] numbers, int target) {
        int low = 0, high = numbers.length-1;
        while (low < high){
            int sum = numbers[low] + numbers[high];
            if (sum < target){
                low++;
            }else if (sum > target){
                high--;
            }else {
                return new int[]{low+1, high+1};
            }
        }
        return new int[]{-1, -1};
    }

    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int index = 0;
        int size = nums.length;
        if (size == 0) return 0;
        int result = 0;
        while (index < size) {
            result += Math.min(nums[index], nums[index + 1]);
            index += 2;
        }
        return result;
    }

    public static void reverseString(char[] s) {
        int start = 0, end = s.length - 1;
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
//        Sort the current string.
        List<String> stringList = Arrays.stream(strs).sorted((s1, s2) -> {
            if (s1.length() > s2.length()) {
                return -1;
            } else if (s1.length() < s2.length()) {
                return 1;
            } else {
                return s1.compareTo(s2);
            }
        }).collect(Collectors.toList());
        String previousMatch = stringList.get(0);
        for (int i = 1; i < strs.length; i++) {
//            Loop through all the characters fo the firstString and find the largestCommonPrefix.
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < stringList.size(); j++) {
                if (previousMatch.charAt(j) == stringList.get(i).charAt(j)) {
                    stringBuilder.append(previousMatch.charAt(j));
                }
            }
            if (previousMatch.length() > stringBuilder.length()) {
                previousMatch = stringBuilder.toString();
            }
        }
        return previousMatch;
    }

    public static String addBinary(String a, String b) {
        if ((a == null || a.length() == 0) && (b == null || b.length() == 0)) {
            return "";
        } else if (b == null || b.length() == 0) {
            return a;
        } else if (a == null || a.length() == 0) {
            return b;
        } else {
            StringBuilder sb = new StringBuilder();
            char[] aToChars = a.toCharArray();
            char[] bToChars = b.toCharArray();
            int i = aToChars.length - 1, j = bToChars.length - 1, carry = 0;
            while (i >= 0 && j >= 0) {
                int aValue = aToChars[i--] == '1' ? 1 : 0;
                int bValue = bToChars[j--] == '1' ? 1 : 0;
                sb.append(processString(aValue, bValue, carry));
            }
//            Copy the remaining A string value into the string buffer.
            while (i >= 0) {
                int aValue = aToChars[i--] == '1' ? 1 : 0;
                sb.append(processString(aValue, 0, carry));
            }

//            Copy the remaining B string value into the string buffer.
            while (j >= 0) {
                int bValue = bToChars[j--] == '1' ? 1 : 0;
                int sum = bValue + carry;
                if (sum > 1) {
                    carry = 1;
                    sb.append(0);
                } else {
                    sb.append(sum);
                    carry = 0;
                }
            }
            if (carry == 1) {
                sb.append(1);
            }
            return sb.reverse().toString();
        }
    }

    private static String processString(int aValue, int bValue, int carry) {
        StringBuilder sb = new StringBuilder();
        int sum = aValue + bValue + carry;
        if (sum >= 3) {
            carry = 1;
            sb.append(1);
        } else if (sum >= 2) {
            carry = 1;
            sb.append(0);
        } else if (sum == 1) {
            carry = 0;
            sb.append(1);
        } else {
            sb.append(sum);
            carry = 0;
        }
        return sb.toString();
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows >= 1) {
            result.add(Collections.singletonList(1));
        }
        if (numRows >= 2) {
            result.add(Arrays.asList(1, 1));
        }
        if (numRows >= 3) {
            for (int i = 2; i < numRows; i++) {
                List<Integer> current = new ArrayList<>();
                List<Integer> previous = result.get(i - 1);
                current.add(1);
                for (int j = 0; j < previous.size() - 1; j++) {
                    current.add(previous.get(j) + previous.get(j + 1));
                }
                current.add(1);
                result.add(current);
            }
        }
        return result;
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> output = new ArrayList<>();

        int rows = matrix.length;
        int column = rows > 0 ? matrix[0].length : 0;
        if (column == 0) return output;
        int startingRow = 0, startingColumn = 0;

        while (startingRow < rows && startingColumn < column) {

//            Loop through the first Rows.
            for (int i = startingColumn; i < column; i++) {
                output.add(matrix[startingRow][i]);
            }
            startingRow++;
//            Loop through the last columns.
            for (int i = startingRow; i < rows; i++) {
                output.add(matrix[i][column - 1]);
            }
            column--;
//            Loop through the last row.
            if (startingRow < rows) {
                for (int i = column - 1; i >= startingColumn; i--) {
                    output.add(matrix[rows - 1][i]);
                }
                rows--;
            }
//            Loop through the first column.
            if (startingColumn < column) {
                for (int i = rows - 1; i >= startingRow; --i) {
                    output.add(matrix[i][startingColumn]);
                }
                startingColumn++;
            }
        }
        return output;
    }

    public static int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length <= 0) {
            return new int[0];
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] result = new int[rows * cols];
        int resultIndex = 0;
        ArrayList<Integer> digits = new ArrayList<>();

        for (int i = 0; i < rows + cols - 1; i++) {
//            Find the starting row.
            int row = i < cols ? 0 : i - cols + 1;
            int col = i < cols ? i : cols - 1;

            while (row >= 0 && row < rows && col >= 0 && col < cols) {
                digits.add(matrix[row][col]);
                row++;
                col--;
            }

            if (i % 2 == 0) {
//                All even diagonal should travel up.
                Collections.reverse(digits);
            }
            for (int num : digits) {
                result[resultIndex++] = num;
            }
            digits.clear();
        }
        return result;
    }

    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            int cur = digits[i];
            if (cur < 9) {
                digits[i] += 1;
                return digits;
            } else {
                digits[i] = 0;
            }
        }
        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 1;
        return newDigits;
    }

    public static int dominantIndex(int[] nums) {
        int[] twoArray = new int[nums.length];
        int maxValue = Integer.MIN_VALUE;
        int maxValueIndex = -1;

        for (int i = 0; i < nums.length; i++) {
            twoArray[i] = nums[i] * 2;
            if (nums[i] > maxValue) {
                maxValue = nums[i];
                maxValueIndex = i;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (i != maxValueIndex && maxValue < twoArray[i]) {
                return -1;
            }
        }
        return maxValueIndex;
    }

    public static int pivotIndex(int[] nums) {
        int[] sums = new int[nums.length];
        int sum = 0;
//        Keep the sum of all values till now into an sum array.
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sums[i] = sum;
        }

//        Loop through the array and
//        subract current value from sum array that will give the left side sum &
//        total - current sum value will give sum of right side.
        for (int i = 0; i < nums.length; i++) {
            int leftside = sums[i] - nums[i];
            int rightside = sum - sums[i];
            if (leftside == rightside) {
                return i;
            }
        }
        return -1;
    }
}
