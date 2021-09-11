import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;
import java.util.stream.Collectors;

public class FrequencyQueries {
    public static void main(String[] args) throws IOException {
        List<List<Integer>> readInput = TestCase.readInput();
        List<List<Integer>> readInput3 = readInput.parallelStream().filter(que -> que.get(0) == 3).collect(Collectors.toList());
        System.out.println(readInput);
//        List<Integer> integers = freqQuery(readInput);
        List<Integer> integers = freqQuery1(readInput);
        System.out.println(integers);
        List<Integer> readOutput = TestCase.readOutput();
        System.out.println(readOutput);
        System.out.println(readOutput.equals(integers));
        for (int i = 0; i < readOutput.size(); i++) {
            if (!integers.get(i).equals(readOutput.get(i))) {
                System.out.println("Error at " + i + " for the query:" + readInput3.get(i) + " Expected : " + readOutput.get(i) + " Output:" + integers.get(i));
            }
        }
        System.out.println(freqQuery(Arrays.asList(
                Arrays.asList(1, 3),
                Arrays.asList(2, 3),
                Arrays.asList(3, 2),
                Arrays.asList(1, 4),
                Arrays.asList(1, 5),
                Arrays.asList(1, 5),
                Arrays.asList(1, 4),
                Arrays.asList(3, 2),
                Arrays.asList(2, 4),
                Arrays.asList(3, 2)
        )));
    }

    static List<Integer> freqQuery1(List<List<Integer>> queries) {
        Map<Integer, Integer> operationMap = new HashMap<>();
        Map<Integer, Set<Integer>> frequencyMap = new HashMap<>();
        List<Integer> output = new ArrayList<>();
        for (List<Integer> query : queries) {
            int operation = query.get(0);
            int element = query.get(1);
            if (operation == 1) {
                if (operationMap.containsKey(element)) {
//                    Get the count of element from the operation map
                    Integer count = operationMap.get(element);
//                    Remove the element from frequency map from count and set it back tot eh incremented count+1.
                    frequencyMap.get(count).remove(element);
                    frequencyMap.putIfAbsent(count + 1, new HashSet<>());
                    frequencyMap.get(count + 1).add(element);
//                    Increase the count of the element
                    operationMap.put(element, count + 1);
                } else {
//                    Add the element to operation map, with count 1.
                    operationMap.put(element, 1);
//                    Add the element into the frequency map under 1 count.
                    frequencyMap.putIfAbsent(1, new HashSet<>());
                    frequencyMap.get(1).add(element);
                }
            } else if (operation == 2) {
                if (operationMap.containsKey(element)) {
//                    Reduce the count from operation map.
                    Integer count = operationMap.get(element);
                    if (count == 1) {
                        operationMap.remove(element);
                        frequencyMap.get(count).remove(element);
                    } else {
                        operationMap.put(element, count - 1);
//                    Also reduce the element counter from frequency.
//                    To reduce the element counter, remove the element from frequency with current counter and set it back to the counter-1;
                        frequencyMap.get(count).remove(element);
                        frequencyMap.putIfAbsent(count - 1, new HashSet<>());
                        frequencyMap.get(count - 1).add(element);
                    }
                }
            } else if (operation == 3) {
//                If the frequency map have the counter\element and the value at that counter\element is not empty, then there is value in it.
                output.add(!frequencyMap.containsKey(element) || frequencyMap.get(element).isEmpty() ? 0 : 1);
            }
        }
        return output;
    }

    static List<Integer> freqQuery(List<List<Integer>> queries) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> output = new ArrayList<>();
        for (List<Integer> query : queries) {
            int operation = query.get(0);
            int element = query.get(1);
            if (operation == 1) {
                map.put(element, map.getOrDefault(element, 0) + 1);
            } else if (operation == 2 && map.containsKey(element)) {
                map.put(element, map.get(element) - 1);
            } else if (operation == 3) {
                output.add(map.containsValue(element) ? 1 : 0);
            }
        }
        return output;
    }

    static class TestCase {
        static String inputURL = "https://hr-testcases-us-east-1.s3.amazonaws.com/71636/input08.txt?AWSAccessKeyId=AKIAJ4WZFDFQTZRGO3QA&Expires=1585776779&Signature=b3o1mA2x5AHwaWiw6NylN4iaMAs%3D&response-content-type=text%2Fplain";
        static String outputURL = "https://hr-testcases-us-east-1.s3.amazonaws.com/71636/output08.txt?AWSAccessKeyId=AKIAJ4WZFDFQTZRGO3QA&Expires=1585776897&Signature=RCtjx8oL%2FA2jTbvpcDnBvIIROOU%3D&response-content-type=text%2Fplain";

        static List<List<Integer>> readInput() throws IOException {
            URL url = new URL(inputURL);
            URLConnection connections = url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connections.getInputStream()));
            String line = "";
            List<List<Integer>> output = new ArrayList<>();
            line = bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
                String[] vals = line.split("\\s+");
                output.add(Arrays.asList(Integer.parseInt(vals[0]), Integer.parseInt(vals[1])));
            }
            return output;
        }

        static List<Integer> readOutput() throws IOException {
            URL url = new URL(outputURL);
            URLConnection connections = url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connections.getInputStream()));
            String line = "";
            List<Integer> output = new ArrayList<>();
//            line = bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
                output.add(Integer.parseInt(line.trim()));
            }
            return output;
        }
    }
}
