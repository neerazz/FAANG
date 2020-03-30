import java.util.HashMap;

public class BusientTime {


    static int findBusiestPeriod(int[][] data) {
        // your code goes here

        HashMap<Integer, Integer> hm = new HashMap<>();
        int max = 0, timestamp = 0, persons = 0;
        for (int[] row : data) {


            persons += row[2] == 0 ? -row[1] : row[1];

            hm.put(row[0], persons);

            if (persons > max) {
                max = persons;
                timestamp = row[0];
            }

        }
        return timestamp;
    }

    public static void main(String[] args) {

    }


}
