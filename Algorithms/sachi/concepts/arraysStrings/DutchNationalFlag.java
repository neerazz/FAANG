import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//EPI - 6.1
public class DutchNationalFlag {

    public static void dutchFlagPartition(int pivotIndex, List<Color> A) {

        // TODO - you fill in here.
        int pivot = A.get(pivotIndex).ordinal();
        int i = 0, a = 0, b = A.size();

        while (i < b) {
            int currColor = A.get(i).ordinal();
            if (currColor < pivot) {
                Collections.swap(A, a++, i++);
            } else if (currColor > pivot) {
                Collections.swap(A, i, --b);
            } else {
                i++;
            }
        }
    }

    public static void main(String[] args) {
        List<Color> colors = new ArrayList<>();
        colors.add(Color.BLUE);
        colors.add(Color.RED);
        colors.add(Color.BLUE);
        colors.add(Color.RED);
        colors.add(Color.WHITE);
        colors.add(Color.WHITE);
        colors.add(Color.RED);
        colors.forEach(color -> System.out.print(color + " "));
        dutchFlagPartition(2, colors);
        System.out.println("");
        colors.forEach(color -> System.out.print(color + " "));
    }

    public enum Color {RED, WHITE, BLUE}
}
