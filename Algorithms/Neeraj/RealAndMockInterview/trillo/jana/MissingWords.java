package jana;

import java.util.*;
import java.io.*;

/**
 * Created on:  Feb 25, 2021
 * Questions:
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MissingWords {
    public static void main(String[] args) {
        String s = "i like cheese";
        String t = "like";
        System.out.println(Arrays.toString(missingwords(s, t)));
        System.out.println(missingWords(s, t));
    }

    public static List<String> missingWords(String s, String t) {
        String[] parts = s.split(" ");
        String[] otherparts = t.split(" ");
        List<String> missing = new ArrayList<>();
        for (int i = 0, j = 0; i < parts.length; i++) {
            if (j < otherparts.length && parts[i].equals(otherparts[j])) {
                j++;
            } else {
                missing.add(parts[i]);
            }
        }
        return missing;
    }

    public static String[] missingwords(String t, String s) {
        for (String word : s.split(" ")) {
            String[] a = t.split(word, 2);
            t = a[0].trim() + a[1];
        }
        return t.split(" ");
    }

}
