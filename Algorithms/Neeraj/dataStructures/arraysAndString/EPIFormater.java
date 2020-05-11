/*
    Created on:  May 10, 2020
 */

import java.util.*;

/**
 * Questions:
 */
public class EPIFormater {
    public static void main(String[] args) {
        FastReader fr1 = new FastReader("C:\\Users\\bnira\\Downloads\\EPI.txt");
        FastReader fr2 = new FastReader("C:\\Users\\bnira\\Downloads\\EPI2.txt");
        Map<String, String> map = new LinkedHashMap<>();
        for (int i = 0; i < 226; i++) {
            String[] split = fr1.readLine().split("\\|");
            map.put(split[1].trim(), split[3].trim());
        }
        List<Problem> list = new ArrayList<>();
        for (int i = 0; i < 220; i++) {
            String[] split = fr2.readLine().split("\\|");
            String topic = split[1].trim();
            String QuestionNumber = split[2].trim();
            String QuestionDescription = split[3].trim();
            String Link = split[4].trim();
            String page = map.getOrDefault(QuestionNumber, "NA");
            list.add(new Problem(topic, QuestionNumber, QuestionDescription, Link, page));
        }
        list.forEach(System.out::println);
    }

    static class Problem {
        String Topic;
        String QuestionNumber;
        String QuestionDescription;
        String Link;
        String page;

        public Problem(String topic, String questionNumber, String questionDescription, String link, String page) {
            Topic = topic;
            QuestionNumber = questionNumber;
            QuestionDescription = questionDescription;
            Link = link;
            this.page = page;
        }

        @Override
        public String toString() {
            return "\t" + Topic +
                    "\t" + QuestionNumber +
                    "\t" + QuestionDescription +
                    "\t" + Link +
                    "\t" + page;
        }
    }
}
