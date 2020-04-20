/*
    Created on:  Apr 19, 2020
 */

import java.util.List;
import java.util.stream.Collectors;

/**
 * Questions:
 */
public class GradingStudents {
    public static void main(String[] args) {

    }

    public static List<Integer> gradingStudents(List<Integer> grades) {
        return grades.stream().map(val -> {
            int diff = val % 5;
            if (diff > 2 && val >= 38) {
                return ((val / 5) + 1) * 5;
            } else {
                return val;
            }
        }).collect(Collectors.toList());
    }
}
