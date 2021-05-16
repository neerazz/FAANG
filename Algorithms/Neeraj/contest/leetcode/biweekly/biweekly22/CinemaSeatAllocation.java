package biweekly.biweekly22;

import java.util.*;

class CinemaSeatAllocation {
    public static void main(String[] args) {
        System.out.println(maxNumberOfFamilies(2, new int[][]{{2, 1}, {1, 8}, {2, 6}}) + " should be [2].");
        System.out.println(maxNumberOfFamilies(3, new int[][]{{2, 3}}) + " should be [5].");
        System.out.println(maxNumberOfFamilies(3, new int[][]{{1, 2}, {1, 3}, {1, 8}, {2, 6}, {3, 1}, {3, 10}}) + " should be [4].");
        System.out.println(maxNumberOfFamilies(4, new int[][]{{4, 3}, {1, 4}, {4, 6}, {1, 7}}) + " should be [4].");
        System.out.println(maxNumberOfFamilies_elegent(2, new int[][]{{2, 1}, {1, 8}, {2, 6}}) + " should be [2].");
        System.out.println(maxNumberOfFamilies_elegent(3,new int[][]{{2,3}}) + " should be [5].");
        System.out.println(maxNumberOfFamilies_elegent(3,new int[][]{{1,2},{1,3},{1,8},{2,6},{3,1},{3,10}}) + " should be [4].");
        System.out.println(maxNumberOfFamilies_elegent(4,new int[][]{{4,3},{1,4},{4,6},{1,7}}) + " should be [4].");
    }

    public static int maxNumberOfFamilies_elegent(int n, int[][] reservedSeats) {
        Map<Integer, Set<Integer>> hall = new HashMap<>();
        for(int[] i : reservedSeats){
            int row = i[0]-1, col = i[1]-1;
            Set<Integer> occupied = hall.getOrDefault(row,new HashSet<>());
            occupied.add(col);
            hall.put(row,occupied);
        }
        int count =0;
        // Find empty rows and assign families to it.
        // Each empty row can accomidate only two such families.
        count += (n - hall.size()) * 2;
        for(Set<Integer> col : hall.values()){
            // At each row check if possible to fit a family.
            if(!col.contains(1) && !col.contains(2) && !col.contains(3) && !col.contains(4)){
                count++;
                col.addAll(Arrays.asList(1,2,3,4));
            }
            if(!col.contains(3) && !col.contains(4) && !col.contains(5) && !col.contains(6)){
                count++;
                col.addAll(Arrays.asList(3,4,5,6));
            }
            if(!col.contains(5) && !col.contains(6) && !col.contains(7) && !col.contains(8)){
                count++;
                col.addAll(Arrays.asList(5,6,7,8));
            }
        }
        return count;
    }

    public static int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Set<Integer> occupied = new HashSet<>();
        for(int[] i : reservedSeats){
            int row = i[0];
            int col = i[1];
            occupied.add(getHash(row-1,col-1));
        }
        int count =0;
        for(int j =0; j < n; j++){
            // At each row check if possible to fit into row.
            LinkedList<Integer> queue = new LinkedList<>();
            for(int k=0; k < 10; k++){
                if(!occupied.contains(getHash(j,k))){
                    if(!queue.isEmpty() && queue.getLast()+1 != k){
                        // Then the previous added value is not continues, so reinitilize the queue.
                        queue = new LinkedList<>();
                    }
                    queue.add(k);
                    // Then check if you have selected four seats.
                    if(queue.size() == 4){
                        // Check if the the seaths selection is valid or not, only bolow are valid.
                        // when all of them are in middle column group (4 continues seats), or
                        // when the seats are in continues and 2+2 in each column group
                        int one =0, two =0, three = 0;
                        List<Integer> temp = new ArrayList<>(queue);
                        for(int seat : temp){
                            if(seat >= 0 && seat <= 2) one++;
                            else if(seat >= 3 && seat <= 6) two++;
                            else three++;
                        }
                        if(two ==4 || (one ==2 && two ==2) || (two ==2 && three==2)){
                            count++;
                            markSeatsAsSelected(j,n,temp, occupied);
                            queue.clear();
                        }else{
                            // Remove the first element from the seat selection.
                            queue.removeFirst();
                        }
                    }
                }
            }
        }
        return count;
    }

    private static int getHash(int row, int col){
        return row * 10000 + col;
    }

    private static void markSeatsAsSelected(int row, int n, List<Integer> cols, Set<Integer> occupied){
        for(int col : cols){
            occupied.add(getHash(row,col));
        }
    }
}
