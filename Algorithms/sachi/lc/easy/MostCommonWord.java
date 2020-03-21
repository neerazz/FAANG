import java.util.Arrays;

public class MostCommonWord {

    static int[] absSort(int[] arr) {

        Integer[] temp = Arrays.stream(arr)
                .boxed()
                .sorted((o1, o2) -> Math.abs(o1) == Math.abs(o2) ? o1 - o2 : Math.abs(o1) - Math.abs(o2)
                ).toArray(Integer[]::new);

        for (int i = 0; i < temp.length; i++) {
            arr[i] = temp[i];
        }
        return arr;
    }

    public static void main(String[] args) {

    }
}
