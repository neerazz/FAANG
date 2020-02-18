package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.Deque;
import java.util.LinkedList;

public class ConvertBase {
    @EpiTest(testDataFile = "convert_base.tsv")

    public static String convertBase(String numAsString, int b1, int b2) {
        // TODO - you fill in here.
        
        return "";
    }

    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "ConvertBase.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }
}
