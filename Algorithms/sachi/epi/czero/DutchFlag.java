package epi.czero;


import java.util.ArrayList;
import java.util.List;

public class DutchFlag {

    public static void dutchFlagPartition(int pivotIndex, List<Color> A) {
        // TODO - you fill in here.
        Color pivotColor = A.get(pivotIndex);
        List<Color> small = new ArrayList<>();
        List<Color> equal = new ArrayList<>();
        List<Color> large = new ArrayList<>();

        for (Color c : A) {
            if (c.ordinal() < pivotColor.ordinal()) {
                small.add(c);
            } else if (c.ordinal() == pivotColor.ordinal()) {
                equal.add(c);
            } else {
                large.add(c);
            }
        }

        A = new ArrayList<>(small);
        A.addAll(equal);
        A.addAll(large);

        return;
    }

    public enum Color {RED, WHITE, BLUE}

}
