import java.util.HashSet;
import java.util.Set;

import com.sun.prism.j2d.paint.MultipleGradientPaint.CycleMethod;

public class Util {

    public static void print(int[][] matrix) {
        System.out.println("\n---------- PRINTING MATRIX-------------");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("\n---------- END MATRIX-------------");
    }

    public static void print(ListNode head) {
        System.out.println("\n---------- PRINTING LinkedList-------------");
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println("\n---------- END LinkedList-------------");
    }

    public static void print(Node head) {
        System.out.println("\n---------- PRINTING LinkedList-------------");
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println("\n---------- END LinkedList-------------");
    }

    public static void print(Node head, boolean isCyclic) {
        System.out.println("\n---------- PRINTING LinkedList-------------");
        if (!isCyclic) {
            while (head != null) {
                System.out.print(head.val + " ");
                head = head.next;
            }
        } else {
            Set<Node> cache = new HashSet<>();
            while (true) {
                if (cache.contains(head))
                    return;
                System.out.print(head.val + " ");
                cache.add(head);
                head = head.next;
            }

        }
        System.out.println("\n---------- END LinkedList-------------");
    }

}
