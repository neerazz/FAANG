import java.util.*;

/**
 * Created on:  Feb 24, 2021
 * Questions: https://www.algoexpert.io/questions/Calendar%20Matching
 */

public class CalenderMatching {

    public static void main(String[] args) {
//calendar1 = [['9:00', '10:30'], ['12:00', '13:00'], ['16:00', '18:00']]
//dailyBounds1 = ['9:00', '20:00']
//calendar2 = [['10:00', '11:30'], ['12:30', '14:30'], ['14:30', '15:00'], ['16:00', '17:00']]
//dailyBounds2 = ['10:00', '18:30']
//meetingDuration = 30
        System.out.println(calendarMatching(
                Arrays.asList(
                        new StringMeeting("9:00", "10:30"),
                        new StringMeeting("12:00", "13:00"),
                        new StringMeeting("16:00", "18:00")),
                new StringMeeting("9:00", "20:00"),
                Arrays.asList(
                        new StringMeeting("10:00", "11:30"),
                        new StringMeeting("12:30", "14:30"),
                        new StringMeeting("14:30", "15:00"),
                        new StringMeeting("16:00", "17:00")),
                new StringMeeting("10:00", "18:30"),
                30
        ));
    }

    public static List<StringMeeting> calendarMatching(
            List<StringMeeting> calendar1,
            StringMeeting dailyBounds1,
            List<StringMeeting> calendar2,
            StringMeeting dailyBounds2,
            int meetingDuration) {
        List<StringMeeting> result = new ArrayList<>();
        LinkedList<Meeting> booked = new LinkedList<>();
        addDailyBoundary(booked, new Meeting(dailyBounds1.start, dailyBounds1.end));
        addDailyBoundary(booked, new Meeting(dailyBounds2.start, dailyBounds2.end));
        int i1 = 0, l1 = calendar1.size(), i2 = 0, l2 = calendar2.size();
        List<Meeting> person1 = createMeeting(calendar1);
        List<Meeting> person2 = createMeeting(calendar2);
        while (i1 < l1 && i2 < l2) {
            Meeting m1 = person1.get(i1);
            Meeting m2 = person2.get(i2);
            if (hasOverLap(m1, m2)) {
                booked.add(getExpanded(m1, m2));
                i1++;
                i2++;
            } else {
                if (m1.compareTo(m2) <= 0) {
                    booked.add(person1.get(i1++));
                } else {
                    booked.add(person2.get(i2++));
                }
            }
        }
        while (i1 < l1) booked.add(person1.get(i1++));
        while (i2 < l2) booked.add(person2.get(i2++));
//        Add a beginning and an ending marker slots.
        booked.add(new Meeting("0:00", "0:00"));
        booked.add(new Meeting("23:59", "23:59"));
        LinkedList<Meeting> occupied = expendTheMeeting(booked);
//        Check for available lots
        Meeting pre = occupied.poll();
        while (!occupied.isEmpty()) {
            Meeting cur = occupied.poll();
            possibleMeetings(pre, cur, meetingDuration, result);
            pre = cur;
        }
        return result;
    }

    private static List<Meeting> createMeeting(List<StringMeeting> calendar) {
        List<Meeting> result = new ArrayList<>();
        for (StringMeeting meeting : calendar) {
            result.add(new Meeting(meeting.start, meeting.end));
        }
        return result;
    }

    private static void possibleMeetings(Meeting pre, Meeting cur, int meetingDuration, List<StringMeeting> result) {
        int startHour = pre.endHour, startMin = pre.endMin;
        int endHour = cur.startHour, endMin = cur.startMin;
        int meetingHour = meetingDuration / 60, meetingMin = meetingDuration % 60;
        int newHour = startHour + meetingHour, newMin = startMin + meetingMin;
        if (newMin >= 60) {
            newHour++;
            newMin %= 60;
        }
        if (newHour < endHour || (newHour == endHour && newMin <= endMin)) {
            result.add(new StringMeeting(pre.end, cur.start));
        }
    }

    private static LinkedList<Meeting> expendTheMeeting(LinkedList<Meeting> booked) {
        LinkedList<Meeting> occupied = new LinkedList<>();
        Collections.sort(booked);
        if (booked.isEmpty()) return occupied;
        Meeting pre = booked.poll();
        while (!booked.isEmpty()) {
            Meeting cur = booked.poll();
            if (hasOverLap(pre, cur)) {
                pre = getExpanded(pre, cur);
            } else {
                occupied.add(pre);
                pre = cur;
            }
        }
        occupied.add(pre);
        return occupied;
    }

    private static Meeting getExpanded(Meeting m1, Meeting m2) {
        String start = "", end = "";
        if (m1.compareTo(m2) <= 0) {
            start = m1.start;
        } else {
            start = m2.start;
        }
        if (m1.endHour > m2.endHour || (m1.endHour == m2.endHour && m1.endMin >= m2.endMin)) end = m1.end;
        else end = m2.end;
        return new Meeting(start, end);
    }

    private static boolean hasOverLap(Meeting m1, Meeting m2) {
//        Assuming that m1 always starts first.
        if (m1.compareTo(m2) > 0) return hasOverLap(m2, m1);
//        Check of m2 start is before m1 end.
        return m2.startHour < m1.endHour || (m2.startHour == m1.endHour && m2.startMin <= m1.endMin);
    }

    private static void addDailyBoundary(LinkedList<Meeting> booked, Meeting dailyBounds) {
        if (dailyBounds.startHour > dailyBounds.endHour || (dailyBounds.startHour == dailyBounds.endHour && dailyBounds.startMin > dailyBounds.endMin)) {
            booked.add(new Meeting(dailyBounds.end, dailyBounds.start));
        } else {
            booked.add(new Meeting("00:00", dailyBounds.start));
            booked.add(new Meeting(dailyBounds.end, "23:59"));
        }
    }

    static class Meeting implements Comparable<Meeting> {
        int startHour, startMin;
        int endHour, endMin;
        String start, end;

        Meeting(String start, String end) {
            setStarting(start);
            setEnding(end);
        }

        public void setStarting(String start) {
            this.start = start;
            String[] starts = start.split(":");
            startHour = Integer.parseInt(starts[0]);
            startMin = Integer.parseInt(starts[1]);
        }

        public void setEnding(String end) {
            this.end = end;
            String[] ends = end.split(":");
            endHour = Integer.parseInt(ends[0]);
            endMin = Integer.parseInt(ends[1]);
        }

        //        Return the ones that should be started first.
        public int compareTo(Meeting other) {
            if (this.startHour == other.startHour) {
                if (this.startMin == other.startMin) {
                    if (this.endHour == other.endHour) {
                        return Integer.compare(this.endMin, other.endMin);
                    }
                    return Integer.compare(this.endHour, other.endHour);
                }
                return Integer.compare(this.startMin, other.startMin);
            }
            return Integer.compare(this.startHour, other.startHour);
        }

        @Override
        public String toString() {
            return "start='" + start + '\'' +
                    ", end='" + end + '\'';
        }
    }

    static class StringMeeting {
        public String start;
        public String end;

        public StringMeeting(String start, String end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "[start='" + start + '\'' +
                    ", end='" + end + "]";
        }
    }
}
