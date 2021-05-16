package weekly.weekly176;

import java.util.*;

public class MaximumNumberofEventsThatCanBeAttended {
    public static void main(String[] args) {
        System.out.println(maxEvents(new int[][]{{1,2},{2,3},{3,4},{1,2}}) + " should be [4]");
        System.out.println(maxEvents(new int[][]{{1,2},{2,2},{3,3},{3,4},{3,4}}) + " should be [4]");
        System.out.println(maxEvents(new int[][]{{1,4},{4,4},{2,2},{3,4},{1,1}}) + " should be [4]");
        System.out.println(maxEvents(new int[][]{{1,10000}}) + " should be [1]");
        System.out.println(maxEvents(new int[][]{{1,1},{1,2},{1,3},{1,4},{1,5},{1,6},{1,7}}) + " should be [7]");
    }
    public static int maxEvents(int[][] events) {
        // greedy thinking: sort the events based on finish time, then grab the first finish event to do in 1 day
        // if there are multiple days can be used, use the earliest.
        Arrays.sort(events, (a, b) -> a[1] != b[1]? a[1] - b[1]: a[0] - b[0]);
        Set<Integer> integers = new HashSet<>();
        for(int[] e: events) {
            if(e[1] == e[0]) {
                integers.add(e[0]);
            } else {
                // if there are many days can be used grab the earliest day
                for(int i = e[0]; i <= e[1]; i++) {
                    if(integers.add(i)) {
                        break;
                    }
                }
            }
        }
        return integers.size();
    }
    public static int maxEvents_wrong2(int[][] events) {
        int output =0;
        int totalEvents = events.length, startingEvent = Integer.MAX_VALUE, endingEvent = Integer.MIN_VALUE;
        Map<Integer, List<Event>> eventMap = new HashMap<>();
        Map<String, Integer> eventCount = new HashMap<>();
        for (int i = 0; i < totalEvents; i++) {
            int start = events[i][0];
            int end = events[i][1];
            startingEvent = Math.min(startingEvent,start);
            endingEvent = Math.max(endingEvent,end);
            List<Event> orDefault = eventMap.getOrDefault(start, new ArrayList<>());
            orDefault.add(new Event(start,end));
            eventMap.put(start,orDefault);
            String key = start + "-" + end;
            eventCount.put(key,eventCount.getOrDefault(key,0) + 1);
        }
        while (startingEvent < endingEvent){
            List<Event> eventList = eventMap.get(startingEvent);
            if (eventList != null && !eventList.isEmpty()){
                eventList.sort((e1,e2) -> e1.start.compareTo(e2.start) == 0 ? e1.end.compareTo(e2.end) : e1.start.compareTo(e2.start));
                Event event = eventList.get(0);
                String key = event.start + "-" + event.end;
                if (startingEvent == event.end){
                    List<Event> eventList2 = eventMap.get(startingEvent);
                    eventList2.remove(event);
                    eventMap.put(startingEvent,eventList2);
                }else {
                    startingEvent = event.end;
                }
                output += eventCount.get(key);
            }else {
                startingEvent++;
            }
            if (startingEvent == endingEvent) break;
        }
        return output;
    }
    public static int maxEvents_wrong(int[][] events) {
        int output =0;
        int totalEvents = events.length, startingEvent = Integer.MAX_VALUE, endingEvent = Integer.MIN_VALUE;
        Map<Integer, List<Event>> eventMap = new HashMap<>();
        for (int i = 0; i < totalEvents; i++) {
            int start = events[i][0];
            int end = events[i][1];
            startingEvent = Math.min(startingEvent,start);
            endingEvent = Math.max(endingEvent,end);
            List<Event> orDefault = eventMap.getOrDefault(start, new ArrayList<>());
            orDefault.add(new Event(start,end));
            eventMap.put(start,orDefault);
        }
        while (startingEvent < endingEvent){
            List<Event> eventList = eventMap.get(startingEvent);
            if (!eventList.isEmpty()){
                eventList.sort((e1,e2) -> e1.start.compareTo(e2.start) == 0 ? e1.end.compareTo(e2.end) : e1.start.compareTo(e2.start));
                startingEvent = eventList.get(0).end;
                output++;
            }
            if (startingEvent == endingEvent) break;
        }
        return output;
    }
    static class Event{
        Integer start;
        Integer end;

        public Event(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}