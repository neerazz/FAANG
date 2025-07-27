
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created on:  May 25, 2020
 */
public class MyTool {

    public static void main(String[] args) {
        System.out.println("************************* Contest ***********************************");
        var names = getContest("Distribute Elements Into Two Arrays I3\n" + "Count Submatrices with Top-Left Element and Sum Less Than k4\n" + "Minimum Operations to Write the Letter Y on a Grid5\n" + "Distribute Elements Into Two Arrays II");
//        createFiles("biweekly", 124, names);
        createFiles("weekly", 387, names);
//        printCamelCase(
//                "Number of Sub-arrays of Size K and Average Greater than or Equal to Threshold"
////                "Product of Array Except Self",
//        );
//        getReplaced(
//                Arrays.asList("[[\"+\",\"+\",\"+\"],[\".\",\".\",\".\"],[\"+\",\"+\",\"+\"]]"),
//                Arrays.asList("[", "{"),
//                Arrays.asList("\"", "'"),
//                Arrays.asList("]", "}")
//        ).forEach(System.out::println);
    }

    private static List<String> getContest(String input) {
        String[] strings = input.split("\n");
        List<String> names = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            names.add(getCamelCase(i != strings.length - 1 ? strings[i].substring(0, strings[i].length() - 1) : strings[i]));
        }
        names.forEach(System.out::println);
        return names;
    }

    private static void createFiles(String frequency, int number, List<String> names) {
        Path path = Path.of("leetcode", "niraj", frequency, frequency + number);
        File file = path.toFile();
        if (!file.exists()) file.mkdirs();
        System.out.println("Creating file at Directory: " + path);
        for (String name : names) {
            try (FileWriter writer = new FileWriter(Path.of(path.toAbsolutePath().toString(), name + ".java").toFile())) {
                writer.write(getFileTemplate(frequency, number, name));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static String getCamelCase(String input) {
        StringBuilder sb = new StringBuilder();
        boolean capitalize = true;
        for (char c : input.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                if (sb.length() == 0 && Character.isDigit(c)) {
                    continue;
                } else if (capitalize) {
                    sb.append(Character.toUpperCase(c));
                    capitalize = false;
                } else {
                    sb.append(c);
                }
            } else {
                capitalize = true;
            }
        }
        return sb.toString();
    }

    static String getFileTemplate(String type, int number, String className) {
        String template = """
                package %{packageName};
                                
                import java.util.*;
                import java.io.*;
                                
                /**
                 * Created on:  %{time}
                 * Ref: <a href="%{reference}">%{className}</a>
                 */
                                
                public class %{className} {
                                
                    public static void main(String[] args) {
                                
                    }
                                
                }
                """;
        String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG, FormatStyle.SHORT));
        Map<String, String> mapping = Map.of("packageName", String.format("%s.%s", type, type + number), "reference", String.format("https://leetcode.com/contest/%s-contest-%d", type, number), "time", dateTime, "className", className);
        String finalString = template;
        for (Map.Entry<String, String> entry : mapping.entrySet()) {
            finalString = finalString.replace("%{" + entry.getKey() + "}", entry.getValue());
        }
        return finalString;
    }

    static int getMax(int[] counts) {
        return Arrays.stream(counts).max().getAsInt();
    }

    private static void printCamelCase(String... input) {
        Arrays.stream(input).map(MyTool::getCamelCase).forEach(System.out::println);
    }

    private static List<String> getReplaced(List<String> input, List<String>... replaces) {
        return input.parallelStream().map(val -> getReplaced(val, replaces)).collect(Collectors.toList());
    }

    private static String getReplaced(String input, List<String>... replaces) {
        for (List<String> replace : replaces) {
            input = input.replace(replace.get(0), replace.get(1));
        }
        return input;
    }

    private static String getReplaced(String input) {
        return input.replace("[", "{").replace("]", "}").replace("\"", "'");
    }
}
