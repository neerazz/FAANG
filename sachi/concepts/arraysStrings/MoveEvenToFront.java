/*
Move all even elements to first and odd elements to end
*/

public class MoveEvenToFront {
    public static void main(String[] args) {
        int[] input = new int[] { 1, 3, 5 };
        Util.print(input);
        moveEven(input);
        Util.print(input);
    }

    private static void moveEven(int[] input) {
        if (input == null || input.length < 2)
            return;
        int i = 0, j = input.length - 1;
        while (j > i) {
            if (input[i] % 2 != 0) {
                // Swap
                int temp = input[i];
                input[i] = input[j];
                input[j] = temp;
                // Collections.swap(input,i,j--);
                j--;
            } else {
                i++;
            }
        }
    }
}