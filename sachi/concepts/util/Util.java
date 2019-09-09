import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Util {

    /**
     * Generate array of size less than 100
     * @return
     */
    public static int[] generateRandomArray() {
        Random rand = new Random();
        int size = rand.nextInt(100);
        return generateRandomArray(size);
    }

    private static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(10000);
        }
        print(arr);
        return arr;
    }

    public static void print(int[] array) {
        System.out.println("\n---------- PRINTING Array-------------");
        Arrays.stream(array).forEach(e -> System.out.print(e + " "));
        System.out.println("\n---------- FInished Printing Array-------------");
    }

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
