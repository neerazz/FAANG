package weekly.weekly243;

import java.util.*;

/**
 * Created on:  May 30, 2021
 * Questions: https://leetcode.com/contest/weekly-contest-243/problems/process-tasks-using-servers/
 */

public class ProcessTasksUsingServers {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(assignTasks(new int[]{3, 3, 2}, new int[]{1, 2, 3, 2, 1, 2})));
    }

    static Comparator<Server> order = (s1, s2) -> s1.freeTime == s2.freeTime ? Integer.compare(s1.idx, s2.idx) : Integer.compare(s1.freeTime, s2.freeTime);

    public static int[] assignTasks(int[] servers, int[] tasks) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Server>>> mapBySize = new TreeMap<>();
        List<Server> serversList = new ArrayList<>();
        for (int i = 0; i < servers.length; i++) {
            int size = servers[i];
            Server server = new Server(i, size);
            mapBySize.putIfAbsent(size, new TreeMap<>());
            TreeMap<Integer, PriorityQueue<Server>> mapByTime = mapBySize.get(size);
            mapByTime.putIfAbsent(0, new PriorityQueue<>(order));
            mapByTime.get(0).add(server);
            serversList.add(server);
        }
        int[] result = new int[tasks.length];
        for (int i = 0; i < tasks.length; i++) {
            int size = tasks[i];
            Map.Entry<Integer, TreeMap<Integer, PriorityQueue<Server>>> entryBySize = mapBySize.ceilingEntry(size);
            Map.Entry<Integer, PriorityQueue<Server>> entryAvailableBeforeTime = entryBySize.getValue().floorEntry(i);
            if (entryAvailableBeforeTime == null) {
//                All the servers are busy, get the possible server that can be used to process it ASAP.
                Map.Entry<Integer, PriorityQueue<Server>> entryAvailableAfterTime = entryBySize.getValue().ceilingEntry(i);
                processTask(result, i, tasks[i], entryAvailableAfterTime, entryBySize);
            } else {
                processTask(result, i, tasks[i], entryAvailableBeforeTime, entryBySize);
            }
        }
        return result;
    }

    private static void processTask(int[] result, int taskIdx, int taskTime, Map.Entry<Integer, PriorityQueue<Server>> entryByTime, Map.Entry<Integer, TreeMap<Integer, PriorityQueue<Server>>> entryBySize) {
        int time = entryByTime.getKey();
        PriorityQueue<Server> servers = entryByTime.getValue();
        Server processingServer = servers.poll();
        result[taskIdx] = processingServer.idx;
        processingServer.freeTime += taskTime;
//        If there are no servers at the given time, then remove the time mapping in the entryBySize.
        if (servers.isEmpty()) entryBySize.getValue().remove(time);
//        Add the current server at the next available time.
        entryBySize.getValue().putIfAbsent(processingServer.freeTime, new PriorityQueue<>(order));
        entryBySize.getValue().get(processingServer.freeTime).add(processingServer);
    }

    static class Server {
        int idx, size;
        int freeTime;

        public Server(int idx, int size) {
            this.idx = idx;
            this.size = size;
        }

        @Override
        public String toString() {
            return "Server{" +
                    "idx=" + idx +
                    ", size=" + size +
                    ", freeTime=" + freeTime +
                    '}';
        }
    }
}
