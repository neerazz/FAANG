package ds.revision;

import java.util.*;
import java.util.stream.Collectors;

public class Recursion {
    public static void main(String[] args) {
//        System.out.println(climbStairs(2) + " should be [2]");
//        System.out.println(climbStairs(3) + " should be [3]");
//        System.out.println(myPow(2.00000, -2));
//        System.out.println(myPow(2.00000, 10));
//        System.out.println(myPow(2.10000, 3));
//        System.out.println(kthGrammar_elegent(30, 434991989) + " should be [0]");
//        System.out.println(kthGrammar(1, 1) + " should be [0]");
//        System.out.println(kthGrammar(2, 1) + " should be [0]");
//        System.out.println(kthGrammar(2, 2) + " should be [1]");
//        System.out.println(kthGrammar(4, 5) + " should be [1]");
//        System.out.println(generateTrees(3));
//        System.out.println(sortArray(new int[]{12, 10, 5, 8, 9, 7, 19, 2, 3}));
//        System.out.println(isValidBST(createTreeNode(new Integer[]{2,1,3})));
//        System.out.println(isValidBST(createTreeNode(new Integer[]{Integer.MIN_VALUE,null,Integer.MAX_VALUE})));
//        System.out.println(searchMatrix(new int[][]{
//                {1, 4, 7, 11, 15},
//                {2, 5, 8, 12, 19},
//                {3, 6, 9, 16, 22},
//                {10, 13, 14, 17, 24},
//                {18, 21, 23, 26, 30}
//        }, 5) + " should be [true].");
//        System.out.println(searchMatrix(new int[][]{
//                {1, 4, 7, 11, 15},
//                {2, 5, 8, 12, 19},
//                {3, 6, 9, 16, 22},
//                {10, 13, 14, 17, 24},
//                {18, 21, 23, 26, 30}
//        }, 20) + " should be [false]");
//        System.out.println(searchMatrix(new int[][]{{1,1}},2));
//        System.out.println(totalNQueens(4));
//        char[][] board = {
//                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
//                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
//                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
//                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
//                {'4', '.', '.', '8', '.', '.', '.', '.', '1'},
//                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
//                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
//                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
//                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
//        };
//        solveSudoku(board);
//        Arrays.stream(board).forEach(i -> System.out.println(Arrays.toString(i)));
//        System.out.println(combine(4, 2));
//        System.out.println(generateParenthesis(3));
//        System.out.println(largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
//        System.out.println(largestRectangleArea_optimal(new int[]{2, 1, 5, 6, 2, 3}));
//        System.out.println(permute(new int[]{1,2,3}));
//        System.out.println(letterCombinations("23"));
        System.out.println(getSkyline(new int[][]{ {2,9,10}, {3,7,15}, {5,12,12}, {15,20,10}, {19,24,8} }));
        System.out.println(getSkyline(new int[][]{{0,2147483647,2147483647}}));
    }

    static List<List<Integer>> skyOutput;
    public static List<List<Integer>> getSkyline(int[][] buildings) {
        skyOutput = new ArrayList<>();
        if (buildings != null && buildings.length > 0){
            HashMap<Integer,Integer> heightAtPoint = new HashMap<>();
            int startingPoint = Integer.MAX_VALUE, endingPoint = Integer.MIN_VALUE;
            for (int i = 0; i < buildings.length; i++) {
                int start = buildings[i][0], end = buildings[i][1], height = buildings[i][2];
                startingPoint = Math.min(startingPoint,start);
                endingPoint = Math.max(endingPoint,end);
                for (int j = start; j < end; j++) {
                    Integer pastValue = heightAtPoint.getOrDefault(j, 0);
//                The new height of building is greater then the previous height. Then set teh new height.
                    if (height > pastValue){
                        heightAtPoint.put(j,height);
                    }
                }
            }

            List<Integer> points = heightAtPoint.keySet().stream().sorted().collect(Collectors.toList());
//            Loop from the starting point to teh ending point, and keep a note of height changes.
            Stack<Integer> stack = new Stack<>();
            for (int point : points) {
                Integer currentHeight = heightAtPoint.get(point);
                if (stack.isEmpty()){
                    stack.push(currentHeight);
                    skyOutput.add(Arrays.asList(point,currentHeight));
                    continue;
                }
                Integer previousHeight = stack.peek();
                if (!previousHeight.equals(currentHeight)){
                    stack.pop();
                    stack.push(currentHeight);
                    skyOutput.add(Arrays.asList(point,currentHeight));
                }
            }
//            for (int i = startingPoint; i < endingPoint; i++) {
//                Integer currentHeight = heightAtPoint.getOrDefault(i,0);
//                if (stack.isEmpty()){
//                    stack.push(currentHeight);
//                    skyOutput.add(Arrays.asList(i,currentHeight));
//                    continue;
//                }
//                Integer previousHeight = stack.peek();
//                if (!previousHeight.equals(currentHeight)){
//                    stack.pop();
//                    stack.push(currentHeight);
//                    skyOutput.add(Arrays.asList(i,currentHeight));
//                }
//            }

            if (!stack.isEmpty()){
                Integer pop = stack.pop();
                if (pop != 0){
                    skyOutput.add(Arrays.asList(endingPoint,0));
                }
            }
        }
        return skyOutput;
    }

    static List<String> letterCombinationsOutput;
    public static List<String> letterCombinations(String digits) {
        letterCombinationsOutput = new ArrayList<>();
        if (digits != null && digits.length() > 0){
            Map<Character, String> numberMap = new HashMap<>();
            numberMap.put('2',"abc");
            numberMap.put('3',"def");
            numberMap.put('4',"ghi");
            numberMap.put('5',"jkl");
            numberMap.put('6',"mno");
            numberMap.put('7',"pqrs");
            numberMap.put('8',"tuv");
            numberMap.put('9',"wxyz");
            backTraceCombinations(digits,numberMap,0,"");
        }
        return letterCombinationsOutput;
    }

    private static void backTraceCombinations(String digits, Map<Character, String> numberMap, int index, String current) {
        if (digits.length() == current.length()){
            letterCombinationsOutput.add(current);
            return;
        }
        String string = numberMap.get(digits.charAt(index));
        for (int i = 0; i < string.length(); i++) {
            backTraceCombinations(digits, numberMap, index+1, current+string.charAt(i));
        }
    }

    static List<List<Integer>> permuteOutput ;
    public static List<List<Integer>> permute(int[] nums) {
        permuteOutput = new ArrayList<>();
        LinkedList<Integer> visited = new LinkedList<>();
        backTracePerute(nums,visited);
        return permuteOutput;
    }

    private static void backTracePerute(int[] nums, LinkedList<Integer> visited) {
        if (visited.size() == nums.length){
            permuteOutput.add(new ArrayList<>(visited));
        }
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            if (!visited.contains(cur)){
                visited.add(cur);
                backTracePerute(nums, visited);
                visited.removeLast();
            }
        }
    }

    public static int largestRectangleArea_optimal(int[] heights) {
        Stack<Integer> s = new Stack<>();
        int max = 0, i = 0, top = 0, area = 0;
//        Keep pushing the building to stack.
        for (; i < heights.length; i++) {
//            when teh next building value is less than the previous value, then loop through all the existing buildings and find the max.
            while (!s.isEmpty() && heights[s.peek()] > heights[i]) {
                top = s.pop();
                if (s.isEmpty())
                    area = heights[top] * i;
                else
                    area = heights[top] * (i - s.peek() - 1);
                max = Math.max(max, area);
            }
            s.push(i);
        }
        while (!s.isEmpty()) {
            top = s.pop();
            if (s.isEmpty())
                area = heights[top] * i;
            else
                area = heights[top] * (i - s.peek() - 1);
            max = Math.max(max, area);
        }
        return max;
    }

    public static int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        int size = heights.length, pointer1 = 0, pointer2 = 0, minHeight = Integer.MAX_VALUE;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        while (pointer2 < size) {
            int i = pointer1;
            priorityQueue.add(heights[pointer2]);
            List<Integer> removedList = new ArrayList<>();
            while (i <= pointer2) {
                int current = heights[i];
                minHeight = priorityQueue.peek();
                int currentArea = minHeight * (pointer2 - i + 1);
                maxArea = Math.max(maxArea, currentArea);
                priorityQueue.remove(current);
                removedList.add(current);
                i++;
            }
            priorityQueue.addAll(removedList);
            pointer2++;
        }
        return maxArea;
    }

    static List<String> parenthesisOutput;

    public static List<String> generateParenthesis(int n) {
        parenthesisOutput = new ArrayList<>();
        backTraceParenthesis("", 0, 0, n);
        return parenthesisOutput;
    }

    private static void backTraceParenthesis(String cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            parenthesisOutput.add(cur);
            return;
        }
        if (open < max)
            backTraceParenthesis(cur + "(", open + 1, close, max);
        if (close < open)
            backTraceParenthesis(cur + ")", open, close + 1, max);
    }

    private static boolean isValidParenthesis(String input) {
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < input.length(); i++) {
            char cur = input.charAt(i);
            if (cur == '(') {
                queue.add(cur);
            } else if (queue.isEmpty() || queue.poll() != '(') {
                return false;
            }
        }
        return queue.isEmpty();
    }

    static List<List<Integer>> output = new LinkedList<>();

    public static List<List<Integer>> combine(int n, int k) {
        brackTrace(n, k, 1, new LinkedList<>());
        return output;
    }

    private static void brackTrace(int n, int k, int first, LinkedList<Integer> curr) {
        // if the combination is done
        if (curr.size() == k) {
            output.add(new LinkedList<>(curr));
            return;
        }

        for (int i = first; i < n + 1; ++i) {
            // add i into the current combination
            curr.add(i);
            // use next integers to complete the combination
            brackTrace(n, k, i + 1, curr);
            // backtrack
            curr.removeLast();
        }
    }

    public static void solveSudoku(char[][] board) {
        HashSet[] rowValue = new HashSet[9];
        HashSet[] colValue = new HashSet[9];
        HashSet[] innerValue = new HashSet[9];
        Arrays.fill(rowValue, new HashSet<Character>());
        Arrays.fill(colValue, new HashSet<Character>());
        Arrays.fill(innerValue, new HashSet<Character>());
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                char cur = board[row][col];
                if (Character.isDigit(cur)) {
                    setValue(rowValue, colValue, innerValue, row, col, '.', cur);
                }
            }
        }
        backTrack(board, 0, 0, rowValue, colValue, innerValue);
    }

    private static void setValue(HashSet[] rowValue, HashSet[] colValue, HashSet[] innerValue, int row, int col, char cur, char replace) {
        HashSet<Character> rowSet = new HashSet<>(rowValue[row]);
        rowSet.remove(cur);
        rowSet.add(replace);
        rowValue[row] = rowSet;

        HashSet<Character> colSet = new HashSet<>(colValue[col]);
        colSet.remove(cur);
        colSet.add(replace);
        colValue[col] = colSet;

        int innerBoxValue = getInnerBoxValue(row, col);
        HashSet<Character> innerSet = new HashSet<>(innerValue[innerBoxValue]);
        innerSet.remove(cur);
        innerSet.add(replace);
        innerValue[innerBoxValue] = innerSet;
    }

    private static boolean backTrack(char[][] board, int row, int col, HashSet[] rowValue, HashSet[] colValue, HashSet[] innerValue) {
        System.out.println("board = " + Arrays.deepToString(board));
        if (col == 9) {
            col = 0;
            row++;
        }
        if (row >= 9) {
            return true;
        }
        if (Character.isDigit(board[row][col])) {
            return backTrack(board, row, col + 1, rowValue, colValue, innerValue);
        }

        HashSet<Character> nextPossible = getNextPossibleValues(board, row, col, rowValue, colValue, innerValue);
        for (char cur : nextPossible) {
            board[row][col] = cur;
            setValue(rowValue, colValue, innerValue, row, col, '.', cur);
            if (backTrack(board, row, col + 1, rowValue, colValue, innerValue)) {
                return true;
            }
            setValue(rowValue, colValue, innerValue, row, col, cur, '.');
            board[row][col] = '.';
        }
        return false;
    }

    private static HashSet<Character> getNextPossibleValues(char[][] board, int row, int col, HashSet[] rowValue, HashSet[] colValue, HashSet[] innerValue) {
        HashSet<Character> output = new HashSet<>();
        String oneToNine = "123456789";
        for (int i = 0; i < 9; i++) {
            char cur = oneToNine.charAt(i);
            if (!rowValue[row].contains(cur) && !colValue[col].contains(cur) && !innerValue[getInnerBoxValue(row, col)].contains(cur)) {
                output.add(cur);
            }
        }
        return output;
    }

    private static int getInnerBoxValue(int row, int col) {
        if (row >= 0 && row <= 2 && col >= 0 && col <= 2) return 0;
        if (row >= 3 && row <= 5 && col >= 0 && col <= 2) return 1;
        if (row >= 6 && row <= 8 && col >= 0 && col <= 2) return 2;
        if (row >= 0 && row <= 2 && col >= 3 && col <= 5) return 3;
        if (row >= 3 && row <= 5 && col >= 3 && col <= 5) return 4;
        if (row >= 6 && row <= 8 && col >= 3 && col <= 5) return 5;
        if (row >= 0 && row <= 2 && col >= 6 && col <= 8) return 6;
        if (row >= 3 && row <= 5 && col >= 6 && col <= 8) return 7;
        else return 8;
    }

    public static void cleanRoom(Robot robot) {
//        Assume that you are starting at [0,0]
        HashSet<String> visited = new HashSet<>();
//        Lets assume 0 -> up, 90 -> right, 180 -> down, 270 -> left
        backTrace(robot, 0, 0, visited, 0);
    }

    private static void backTrace(Robot robot, int row, int col, HashSet<String> visited, int dir) {
        String currentHash = row + " -> " + col;
        if (visited.contains(currentHash)) return;
        robot.clean();
        visited.add(currentHash);
//        Try to go through all the directions.
        for (int i = 0; i < 4; i++) {
            if (robot.move()) {
                int x = row, y = col;
//                If robot can move then try to get the index of teh next position based on directions.
                if (dir == 0) {
//                    Travelling up.
                    x--;
                } else if (dir == 90) {
//                    Travel right
                    y++;
                } else if (dir == 180) {
//                    Travel down
                    x++;
                } else if (dir == 270) {
//                    Travel left
                    y--;
                }
                backTrace(robot, x, y, visited, dir);
//                Once done, come back to the normal position.
                robot.turnLeft();
                robot.turnLeft();
                robot.move();
                robot.turnRight();
                robot.turnRight();
            }
//            now turn towards your right.
            robot.turnRight();
            dir += 90;
            dir %= 360;
        }
    }

    interface Robot {
        // returns true if next cell is open and robot moves into the cell.
        // returns false if next cell is obstacle and robot stays on the current cell.
        boolean move();

        // Robot will stay on the same cell after calling turnLeft/turnRight.
        // Each turn will be 90 degrees.
        void turnLeft();

        void turnRight();

        // Clean the current cell.
        void clean();
    }

    static int count = 0;

    public static int totalNQueens(int n) {
        if (n < 2) return n;
        HashSet<Coordinates> queens = new HashSet<>();
        for (int i = 0; i < n; i++) {
            Coordinates coordinates = new Coordinates(0, i);
            queens.add(coordinates);
//            Check for all possible queens.
            checkQueenPossibilities(0, n, queens, 1);
            queens.remove(coordinates);
        }
        return count;
    }

    private static void checkQueenPossibilities(int row, int n, HashSet<Coordinates> queens, int total) {
        if (row >= n) return;
        if (total == n) {
//            N queens are on the board.
            count++;
            return;
        }
//        This is to loop throw all the below rows and get the possible position.
        List<Coordinates> possibleNext = getNexPossibleCoordinates(row + 1, n, queens);
//        Loop through all the possible positions.
        for (Coordinates c : possibleNext) {
            queens.add(c);
            checkQueenPossibilities(row + 1, n, queens, total + 1);
            queens.remove(c);
        }
    }

    private static List<Coordinates> getNexPossibleCoordinates(int row, int n, HashSet<Coordinates> queens) {
        List<Coordinates> output = new ArrayList<>();
        if (row < n) {
//            Loop thorough all the columns of the current row return the index's of queen can be placed.
            for (int i = 0; i < n; i++) {
                if (queenCanBePlaced(row, i, queens)) {
                    output.add(new Coordinates(row, i));
                }
            }
        }
        return output;
    }

    private static boolean queenCanBePlaced(int row, int col, HashSet<Coordinates> queens) {
        for (Coordinates c : queens) {
            if (c.row == row || c.col == col || Math.abs(c.row - row) == Math.abs(c.col - col)) return false;
        }
        return true;
    }

    static class Coordinates {
        int row;
        int col;

        public Coordinates(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Coordinates that = (Coordinates) o;

            if (row != that.row) return false;
            return col == that.col;
        }

        @Override
        public int hashCode() {
            int result = row;
            result = 31 * result + col;
            return result;
        }
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = rows > 0 ? matrix[0].length : 0;
        if (cols == 0) {
            return false;
        }
        int colIndex = cols - 1, rowIndex = 0;
//        Loop through the array from end to start column.
        while (colIndex >= 0 && rowIndex < rows) {
            int current = matrix[rowIndex][colIndex];
            if (current == target) return true;
            if (current < target) {
//                Keep incrementing the row index.
                while (rowIndex < rows) {
                    int innerCurrent = matrix[rowIndex][colIndex];
                    if (innerCurrent == target) return true;
                    if (innerCurrent > target) {
                        break;
                    }
                    rowIndex++;
                }
            }
            colIndex--;
        }
        return false;
    }

    public static boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return isValidBST(root.left, Long.MIN_VALUE, root.val) && isValidBST(root.right, root.val, Long.MAX_VALUE);
    }

    private static boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) return true;
        return root.val > min && root.val < max
                && isValidBST(root.left, min, root.val)
                && isValidBST(root.right, root.val, max);
    }

    public static List<Integer> sortArray(int[] nums) {
//        return performMergeSort(nums);
        quickSort(nums, 0, nums.length - 1);
        return Arrays.stream(nums).boxed().collect(Collectors.toList());
    }

    //    Solution: http://www.algolist.net/Algorithms/Sorting/Quicksort
    private static void quickSort(int[] nums, int start, int end) {
        int index = partition(nums, start, end);
        if (start < index - 1) {
            quickSort(nums, start, index - 1);
        }
        if (index < end) {
            quickSort(nums, index, end);
        }
    }

    private static int partition(int[] arr, int left, int right) {
        int i = left, j = right;
        int tmp;
        int pivot = arr[(left + right) / 2];
        while (i <= j) {
            while (arr[i] < pivot)
                i++;
            while (arr[j] > pivot)
                j--;
            if (i <= j) {
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        }
        return i;
    }

    private static List<Integer> performMergeSort(int[] nums) {
        return Arrays.stream(performMergeSort(nums, 0, nums.length - 1)).boxed().collect(Collectors.toList());
    }

    private static int[] performMergeSort(int[] nums, int start, int end) {
        if (start == end) return new int[]{nums[start]};
        int mid = (start + end) / 2;
        int[] left = performMergeSort(nums, start, mid);
        int[] right = performMergeSort(nums, mid + 1, end);
        return sortArray(left, right);
    }

    private static int[] sortArray(int[] left, int[] right) {
        int totalSize = left.length + right.length;
        int[] newArray = new int[totalSize];
        int index = 0, leftIndex = 0, rightIndex = 0;
        while (index < totalSize) {
            if (leftIndex < left.length && rightIndex < right.length) {
                if (left[leftIndex] <= right[rightIndex]) {
                    newArray[index++] = left[leftIndex++];
                } else {
                    newArray[index++] = right[rightIndex++];
                }
            } else if (leftIndex < left.length) {
                newArray[index++] = left[leftIndex++];
            } else {
                newArray[index++] = right[rightIndex++];
            }
        }
        return newArray;
    }

    public static List<TreeNode> generateTrees_wrong(int n) {
        List<TreeNode> output = new ArrayList<>();
        if (n > 1) {
            for (int i = 0; i < n; i++) {
                TreeNode newnode = new TreeNode(i + 1);
                for (int j = 0; j < n; j++) {
                    if (i != j) {
                        newnode = insertIntoBST(newnode, j + 1);
                    }
                }
                output.add(newnode);
            }
        }
        return output;
    }

    public static TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (root.left != null && root.val > val) root.left = insertIntoBST(root.left, val);
        if (root.right != null && root.val < val) root.right = insertIntoBST(root.right, val);
        if (root.left == null && root.val > val) root.left = new TreeNode(val);
        if (root.right == null && root.val < val) root.right = new TreeNode(val);
        return root;
    }

    public static int kthGrammar(int N, int K) {
        if (N == 0) return 0;
        String grammer = getGrammer(N);
        return Character.getNumericValue(grammer.charAt(K - 1));
    }

    public static int kthGrammar_elegent(int N, int K) {
        if (N == 1) return 0;
        int ans1 = kthGrammar_elegent(N - 1, (K + 1) / 2);
        return ans1 == 0 ? 1 - (K % 2) : K % 2;
    }

    private static String getGrammer(int n) {
        if (n == 1) return "0";
        String value = getGrammer(n - 1);
        return value.replace('0', 'Z')
                .replaceAll("[1]", "10")
                .replaceAll("[Z]", "01");
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newNode = new ListNode(0), newNodeRef = newNode;
        while (l1.next != null && l2.next != null) {
            if (l1.val <= l2.val) {
                newNodeRef.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                newNodeRef.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            newNodeRef = newNodeRef.next;
        }
        if (l1.next != null) {
            newNodeRef.next = l1;
        } else if (l2.next != null) {
            newNodeRef.next = l2;
        }
        return newNode.next;
    }

    public static double myPow(double x, int n) {
        if (n == Integer.MIN_VALUE && x > 1) return 0;
        if (n == 0) return 1;
        if (n < 0) {
            x = 1 / x;
            n *= -1;
        }
        return n % 2 != 0 ? myPow(x * x, n / 2) * x : myPow(x * x, n / 2);
    }

    public static int climbStairs(int n) {
        int[] mem = new int[n + 1];
        if (n < 2) return n;
        return climbStairs(n, 0, mem);
    }

    private static int climbStairs(int n, int curSum, int[] mem) {
        if (n < curSum) return 0;
        if (n == curSum) return 1;
        if (mem[curSum] > 0) return mem[curSum];
        mem[curSum] = climbStairs(n, curSum + 1, mem) + climbStairs(n, curSum + 2, mem);
        return mem[curSum];
    }
}
