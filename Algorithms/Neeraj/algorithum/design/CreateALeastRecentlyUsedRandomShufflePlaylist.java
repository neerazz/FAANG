import java.util.*;
import java.io.*;

/**
 * Created on:  Jan 22, 2021
 * Questions: https://leetcode.com/discuss/interview-question/1028359/google-create-a-least-recently-used-random-shuffle-playlist
 */

public class CreateALeastRecentlyUsedRandomShufflePlaylist {

    public static void main(String[] args) {
        System.out.println(shufflePlayList(
                Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J"),
                3) + " = [A, B, D, E, F, G, H, I, J, C]");

        System.out.println(shufflePlayList(
                Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J"),
                3, 5) + " = [A, B, D, E, G, H, I, J, C, F]");

        System.out.println(shufflePlayList(
                Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J"),
                3, 5, 2) + " = [A, D, E, G, H, I, J, C, F, B]");

        System.out.println(shufflePlayList(
                Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J"),
                3, 5, 2, 8) + " = [A, D, E, G, H, I, J, F, B, C]");

        System.out.println(shufflePlayList(
                Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J"),
                3, 5, 2, 8, 10) + " = [A, D, E, G, H, I, J, F, B, C]");
    }

    private static List<String> shufflePlayList(List<String> songs, int... ks) {
        LinkedList<String> list = new LinkedList<>(songs);
        for (int k : ks) {
//            Remove the list and add to the end, this is O(k)
            String playing = list.remove(k - 1);
//            Add to the list is O(1)
            list.addLast(playing);
        }
        return list;
    }

    private static List<String> shufflePlayList(List<String> songs, int k) {
        LinkedHashSet<String> orderedSet = new LinkedHashSet<>();
        String played = "";
        for (int i = 0; i < songs.size(); i++) {
//            Loop through all the songs, play the kth song and add all the rest of songs to the ordered set.
            if (i == k - 1) {
                played = songs.get(i);
            } else {
                orderedSet.add(songs.get(i));
            }
        }
//        Add the played song to the end.
        orderedSet.add(played);
        return new ArrayList<>(orderedSet);
    }
}
